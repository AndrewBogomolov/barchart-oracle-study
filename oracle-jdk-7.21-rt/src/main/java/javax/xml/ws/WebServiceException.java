/*    */ package javax.xml.ws;
/*    */ 
/*    */ public class WebServiceException extends RuntimeException
/*    */ {
/*    */   public WebServiceException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public WebServiceException(String message)
/*    */   {
/* 49 */     super(message);
/*    */   }
/*    */ 
/*    */   public WebServiceException(String message, Throwable cause)
/*    */   {
/* 61 */     super(message, cause);
/*    */   }
/*    */ 
/*    */   public WebServiceException(Throwable cause)
/*    */   {
/* 76 */     super(cause);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.ws.WebServiceException
 * JD-Core Version:    0.6.2
 */