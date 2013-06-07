/*     */ package sun.security.provider.certpath;
/*     */ 
/*     */ import java.security.AccessController;
/*     */ import java.security.InvalidAlgorithmParameterException;
/*     */ import java.security.cert.CertPath;
/*     */ import java.security.cert.CertPathParameters;
/*     */ import java.security.cert.CertPathValidatorException;
/*     */ import java.security.cert.CertPathValidatorResult;
/*     */ import java.security.cert.CertPathValidatorSpi;
/*     */ import java.security.cert.PKIXCertPathChecker;
/*     */ import java.security.cert.PKIXCertPathValidatorResult;
/*     */ import java.security.cert.PKIXParameters;
/*     */ import java.security.cert.PKIXReason;
/*     */ import java.security.cert.PolicyNode;
/*     */ import java.security.cert.TrustAnchor;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import sun.security.action.GetBooleanSecurityPropertyAction;
/*     */ import sun.security.util.Debug;
/*     */ import sun.security.x509.X509CertImpl;
/*     */ 
/*     */ public class PKIXCertPathValidator extends CertPathValidatorSpi
/*     */ {
/*  67 */   private static final Debug debug = Debug.getInstance("certpath");
/*     */   private Date testDate;
/*     */   private List<PKIXCertPathChecker> userCheckers;
/*     */   private String sigProvider;
/*     */   private BasicChecker basicChecker;
/*  72 */   private boolean ocspEnabled = false;
/*  73 */   private boolean onlyEECert = false;
/*     */ 
/*     */   public CertPathValidatorResult engineValidate(CertPath paramCertPath, CertPathParameters paramCertPathParameters)
/*     */     throws CertPathValidatorException, InvalidAlgorithmParameterException
/*     */   {
/*  98 */     if (debug != null) {
/*  99 */       debug.println("PKIXCertPathValidator.engineValidate()...");
/*     */     }
/* 101 */     if (!(paramCertPathParameters instanceof PKIXParameters)) {
/* 102 */       throw new InvalidAlgorithmParameterException("inappropriate parameters, must be an instance of PKIXParameters");
/*     */     }
/*     */ 
/* 106 */     if ((!paramCertPath.getType().equals("X.509")) && (!paramCertPath.getType().equals("X509"))) {
/* 107 */       throw new InvalidAlgorithmParameterException("inappropriate certification path type specified, must be X.509 or X509");
/*     */     }
/*     */ 
/* 111 */     PKIXParameters localPKIXParameters = (PKIXParameters)paramCertPathParameters;
/*     */ 
/* 115 */     Set localSet = localPKIXParameters.getTrustAnchors();
/* 116 */     for (Object localObject1 = localSet.iterator(); ((Iterator)localObject1).hasNext(); ) { localObject2 = (TrustAnchor)((Iterator)localObject1).next();
/* 117 */       if (((TrustAnchor)localObject2).getNameConstraints() != null) {
/* 118 */         throw new InvalidAlgorithmParameterException("name constraints in trust anchor not supported");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 133 */     localObject1 = new ArrayList(paramCertPath.getCertificates());
/*     */ 
/* 135 */     if (debug != null) {
/* 136 */       if (((ArrayList)localObject1).isEmpty()) {
/* 137 */         debug.println("PKIXCertPathValidator.engineValidate() certList is empty");
/*     */       }
/*     */ 
/* 140 */       debug.println("PKIXCertPathValidator.engineValidate() reversing certpath...");
/*     */     }
/*     */ 
/* 143 */     Collections.reverse((List)localObject1);
/*     */ 
/* 148 */     populateVariables(localPKIXParameters);
/*     */ 
/* 152 */     Object localObject2 = null;
/* 153 */     if (!((ArrayList)localObject1).isEmpty()) {
/* 154 */       localObject2 = (X509Certificate)((ArrayList)localObject1).get(0);
/*     */     }
/*     */ 
/* 157 */     Object localObject3 = null;
/*     */ 
/* 161 */     for (TrustAnchor localTrustAnchor : localSet) {
/* 162 */       X509Certificate localX509Certificate = localTrustAnchor.getTrustedCert();
/* 163 */       if (localX509Certificate != null) {
/* 164 */         if (debug != null) {
/* 165 */           debug.println("PKIXCertPathValidator.engineValidate() anchor.getTrustedCert() != null");
/*     */         }
/*     */ 
/* 171 */         if (isWorthTrying(localX509Certificate, (X509Certificate)localObject2))
/*     */         {
/* 175 */           if (debug != null)
/* 176 */             debug.println("anchor.getTrustedCert().getSubjectX500Principal() = " + localX509Certificate.getSubjectX500Principal());
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 181 */         if (debug != null) {
/* 182 */           debug.println("PKIXCertPathValidator.engineValidate(): anchor.getTrustedCert() == null");
/*     */         }
/*     */ 
/*     */         try
/*     */         {
/* 188 */           PolicyNodeImpl localPolicyNodeImpl = new PolicyNodeImpl(null, "2.5.29.32.0", null, false, Collections.singleton("2.5.29.32.0"), false);
/*     */ 
/* 191 */           PolicyNode localPolicyNode = doValidate(localTrustAnchor, paramCertPath, (ArrayList)localObject1, localPKIXParameters, localPolicyNodeImpl);
/*     */ 
/* 194 */           return new PKIXCertPathValidatorResult(localTrustAnchor, localPolicyNode, this.basicChecker.getPublicKey());
/*     */         }
/*     */         catch (CertPathValidatorException localCertPathValidatorException)
/*     */         {
/* 198 */           localObject3 = localCertPathValidatorException;
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 204 */     if (localObject3 != null) {
/* 205 */       throw localObject3;
/*     */     }
/*     */ 
/* 208 */     throw new CertPathValidatorException("Path does not chain with any of the trust anchors", null, null, -1, PKIXReason.NO_TRUST_ANCHOR);
/*     */   }
/*     */ 
/*     */   private boolean isWorthTrying(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
/*     */   {
/* 220 */     boolean bool = false;
/*     */ 
/* 222 */     if (debug != null) {
/* 223 */       debug.println("PKIXCertPathValidator.isWorthTrying() checking if this trusted cert is worth trying ...");
/*     */     }
/*     */ 
/* 227 */     if (paramX509Certificate2 == null) {
/* 228 */       return true;
/*     */     }
/*     */ 
/* 231 */     AdaptableX509CertSelector localAdaptableX509CertSelector = new AdaptableX509CertSelector();
/*     */ 
/* 235 */     localAdaptableX509CertSelector.setSubject(paramX509Certificate2.getIssuerX500Principal());
/*     */ 
/* 238 */     localAdaptableX509CertSelector.setValidityPeriod(paramX509Certificate2.getNotBefore(), paramX509Certificate2.getNotAfter());
/*     */     try
/*     */     {
/* 246 */       X509CertImpl localX509CertImpl = X509CertImpl.toImpl(paramX509Certificate2);
/* 247 */       localAdaptableX509CertSelector.parseAuthorityKeyIdentifierExtension(localX509CertImpl.getAuthorityKeyIdentifierExtension());
/*     */ 
/* 250 */       bool = localAdaptableX509CertSelector.match(paramX509Certificate1);
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/* 255 */     if (debug != null) {
/* 256 */       if (bool)
/* 257 */         debug.println("YES - try this trustedCert");
/*     */       else {
/* 259 */         debug.println("NO - don't try this trustedCert");
/*     */       }
/*     */     }
/*     */ 
/* 263 */     return bool;
/*     */   }
/*     */ 
/*     */   private void populateVariables(PKIXParameters paramPKIXParameters)
/*     */   {
/* 272 */     this.testDate = paramPKIXParameters.getDate();
/* 273 */     if (this.testDate == null) {
/* 274 */       this.testDate = new Date(System.currentTimeMillis());
/*     */     }
/*     */ 
/* 277 */     this.userCheckers = paramPKIXParameters.getCertPathCheckers();
/* 278 */     this.sigProvider = paramPKIXParameters.getSigProvider();
/*     */ 
/* 280 */     if (paramPKIXParameters.isRevocationEnabled())
/*     */     {
/* 282 */       this.ocspEnabled = ((Boolean)AccessController.doPrivileged(new GetBooleanSecurityPropertyAction("ocsp.enable"))).booleanValue();
/*     */ 
/* 285 */       this.onlyEECert = ((Boolean)AccessController.doPrivileged(new GetBooleanSecurityPropertyAction("com.sun.security.onlyCheckRevocationOfEECert"))).booleanValue();
/*     */     }
/*     */   }
/*     */ 
/*     */   private PolicyNode doValidate(TrustAnchor paramTrustAnchor, CertPath paramCertPath, ArrayList<X509Certificate> paramArrayList, PKIXParameters paramPKIXParameters, PolicyNodeImpl paramPolicyNodeImpl)
/*     */     throws CertPathValidatorException
/*     */   {
/* 301 */     int i = paramArrayList.size();
/*     */ 
/* 303 */     this.basicChecker = new BasicChecker(paramTrustAnchor, this.testDate, this.sigProvider, false);
/* 304 */     AlgorithmChecker localAlgorithmChecker = new AlgorithmChecker(paramTrustAnchor);
/* 305 */     KeyChecker localKeyChecker = new KeyChecker(i, paramPKIXParameters.getTargetCertConstraints());
/*     */ 
/* 307 */     ConstraintsChecker localConstraintsChecker = new ConstraintsChecker(i);
/*     */ 
/* 310 */     PolicyChecker localPolicyChecker = new PolicyChecker(paramPKIXParameters.getInitialPolicies(), i, paramPKIXParameters.isExplicitPolicyRequired(), paramPKIXParameters.isPolicyMappingInhibited(), paramPKIXParameters.isAnyPolicyInhibited(), paramPKIXParameters.getPolicyQualifiersRejected(), paramPolicyNodeImpl);
/*     */ 
/* 317 */     UntrustedChecker localUntrustedChecker = new UntrustedChecker();
/*     */ 
/* 319 */     ArrayList localArrayList = new ArrayList();
/*     */ 
/* 322 */     localArrayList.add(localUntrustedChecker);
/* 323 */     localArrayList.add(localAlgorithmChecker);
/* 324 */     localArrayList.add(localKeyChecker);
/* 325 */     localArrayList.add(localConstraintsChecker);
/* 326 */     localArrayList.add(localPolicyChecker);
/* 327 */     localArrayList.add(this.basicChecker);
/*     */ 
/* 330 */     if (paramPKIXParameters.isRevocationEnabled())
/*     */     {
/* 333 */       if (this.ocspEnabled) {
/* 334 */         localObject = new OCSPChecker(paramCertPath, paramPKIXParameters, this.onlyEECert);
/*     */ 
/* 336 */         localArrayList.add(localObject);
/*     */       }
/*     */ 
/* 340 */       localObject = new CrlRevocationChecker(paramTrustAnchor, paramPKIXParameters, paramArrayList, this.onlyEECert);
/*     */ 
/* 342 */       localArrayList.add(localObject);
/*     */     }
/*     */ 
/* 346 */     localArrayList.addAll(this.userCheckers);
/*     */ 
/* 348 */     Object localObject = new PKIXMasterCertPathValidator(localArrayList);
/*     */ 
/* 351 */     ((PKIXMasterCertPathValidator)localObject).validate(paramCertPath, paramArrayList);
/*     */ 
/* 353 */     return localPolicyChecker.getPolicyTree();
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.security.provider.certpath.PKIXCertPathValidator
 * JD-Core Version:    0.6.2
 */