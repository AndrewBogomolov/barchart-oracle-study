/*    */ package java.rmi;
/*    */ 
/*    */ public class UnmarshalException extends RemoteException
/*    */ {
/*    */   private static final long serialVersionUID = 594380845140740218L;
/*    */ 
/*    */   public UnmarshalException(String paramString)
/*    */   {
/* 62 */     super(paramString);
/*    */   }
/*    */ 
/*    */   public UnmarshalException(String paramString, Exception paramException)
/*    */   {
/* 74 */     super(paramString, paramException);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.rmi.UnmarshalException
 * JD-Core Version:    0.6.2
 */