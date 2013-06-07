/*    */ package java.security.cert;
/*    */ 
/*    */ public abstract class CRL
/*    */ {
/*    */   private String type;
/*    */ 
/*    */   protected CRL(String paramString)
/*    */   {
/* 61 */     this.type = paramString;
/*    */   }
/*    */ 
/*    */   public final String getType()
/*    */   {
/* 70 */     return this.type;
/*    */   }
/*    */ 
/*    */   public abstract String toString();
/*    */ 
/*    */   public abstract boolean isRevoked(Certificate paramCertificate);
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.security.cert.CRL
 * JD-Core Version:    0.6.2
 */