/*    */ package java.io;
/*    */ 
/*    */ public class InterruptedIOException extends IOException
/*    */ {
/*    */   private static final long serialVersionUID = 4020568460727500567L;
/* 73 */   public int bytesTransferred = 0;
/*    */ 
/*    */   public InterruptedIOException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public InterruptedIOException(String paramString)
/*    */   {
/* 64 */     super(paramString);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.io.InterruptedIOException
 * JD-Core Version:    0.6.2
 */