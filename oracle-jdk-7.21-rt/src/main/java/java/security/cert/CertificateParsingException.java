/*    */ package java.security.cert;
/*    */ 
/*    */ public class CertificateParsingException extends CertificateException
/*    */ {
/*    */   private static final long serialVersionUID = -7989222416793322029L;
/*    */ 
/*    */   public CertificateParsingException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public CertificateParsingException(String paramString)
/*    */   {
/* 56 */     super(paramString);
/*    */   }
/*    */ 
/*    */   public CertificateParsingException(String paramString, Throwable paramThrowable)
/*    */   {
/* 71 */     super(paramString, paramThrowable);
/*    */   }
/*    */ 
/*    */   public CertificateParsingException(Throwable paramThrowable)
/*    */   {
/* 87 */     super(paramThrowable);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.security.cert.CertificateParsingException
 * JD-Core Version:    0.6.2
 */