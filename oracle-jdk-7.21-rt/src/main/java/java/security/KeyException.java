/*    */ package java.security;
/*    */ 
/*    */ public class KeyException extends GeneralSecurityException
/*    */ {
/*    */   private static final long serialVersionUID = -7483676942812432108L;
/*    */ 
/*    */   public KeyException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public KeyException(String paramString)
/*    */   {
/* 58 */     super(paramString);
/*    */   }
/*    */ 
/*    */   public KeyException(String paramString, Throwable paramThrowable)
/*    */   {
/* 73 */     super(paramString, paramThrowable);
/*    */   }
/*    */ 
/*    */   public KeyException(Throwable paramThrowable)
/*    */   {
/* 88 */     super(paramThrowable);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.security.KeyException
 * JD-Core Version:    0.6.2
 */