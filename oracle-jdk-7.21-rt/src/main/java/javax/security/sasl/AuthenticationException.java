/*    */ package javax.security.sasl;
/*    */ 
/*    */ public class AuthenticationException extends SaslException
/*    */ {
/*    */   private static final long serialVersionUID = -3579708765071815007L;
/*    */ 
/*    */   public AuthenticationException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public AuthenticationException(String paramString)
/*    */   {
/* 64 */     super(paramString);
/*    */   }
/*    */ 
/*    */   public AuthenticationException(String paramString, Throwable paramThrowable)
/*    */   {
/* 78 */     super(paramString, paramThrowable);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.security.sasl.AuthenticationException
 * JD-Core Version:    0.6.2
 */