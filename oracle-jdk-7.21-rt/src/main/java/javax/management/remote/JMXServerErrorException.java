/*    */ package javax.management.remote;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class JMXServerErrorException extends IOException
/*    */ {
/*    */   private static final long serialVersionUID = 3996732239558744666L;
/*    */   private final Error cause;
/*    */ 
/*    */   public JMXServerErrorException(String paramString, Error paramError)
/*    */   {
/* 58 */     super(paramString);
/* 59 */     this.cause = paramError;
/*    */   }
/*    */ 
/*    */   public Throwable getCause() {
/* 63 */     return this.cause;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.management.remote.JMXServerErrorException
 * JD-Core Version:    0.6.2
 */