/*    */ package java.rmi.server;
/*    */ 
/*    */ public abstract class RemoteStub extends RemoteObject
/*    */ {
/*    */   private static final long serialVersionUID = -1585587260594494182L;
/*    */ 
/*    */   protected RemoteStub()
/*    */   {
/*    */   }
/*    */ 
/*    */   protected RemoteStub(RemoteRef paramRemoteRef)
/*    */   {
/* 57 */     super(paramRemoteRef);
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   protected static void setRef(RemoteStub paramRemoteStub, RemoteRef paramRemoteRef)
/*    */   {
/* 72 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.rmi.server.RemoteStub
 * JD-Core Version:    0.6.2
 */