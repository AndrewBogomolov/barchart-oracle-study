/*    */ package java.rmi;
/*    */ 
/*    */ public class ConnectIOException extends RemoteException
/*    */ {
/*    */   private static final long serialVersionUID = -8087809532704668744L;
/*    */ 
/*    */   public ConnectIOException(String paramString)
/*    */   {
/* 49 */     super(paramString);
/*    */   }
/*    */ 
/*    */   public ConnectIOException(String paramString, Exception paramException)
/*    */   {
/* 62 */     super(paramString, paramException);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.rmi.ConnectIOException
 * JD-Core Version:    0.6.2
 */