/*    */ package sun.net;
/*    */ 
/*    */ import java.net.SocketException;
/*    */ 
/*    */ public class ConnectionResetException extends SocketException
/*    */ {
/*    */   private static final long serialVersionUID = -7633185991801851556L;
/*    */ 
/*    */   public ConnectionResetException(String paramString)
/*    */   {
/* 40 */     super(paramString);
/*    */   }
/*    */ 
/*    */   public ConnectionResetException()
/*    */   {
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.net.ConnectionResetException
 * JD-Core Version:    0.6.2
 */