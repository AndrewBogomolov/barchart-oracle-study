/*    */ package java.util;
/*    */ 
/*    */ public class IllegalFormatCodePointException extends IllegalFormatException
/*    */ {
/*    */   private static final long serialVersionUID = 19080630L;
/*    */   private int c;
/*    */ 
/*    */   public IllegalFormatCodePointException(int paramInt)
/*    */   {
/* 53 */     this.c = paramInt;
/*    */   }
/*    */ 
/*    */   public int getCodePoint()
/*    */   {
/* 63 */     return this.c;
/*    */   }
/*    */ 
/*    */   public String getMessage() {
/* 67 */     return String.format("Code point = %#x", new Object[] { Integer.valueOf(this.c) });
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.util.IllegalFormatCodePointException
 * JD-Core Version:    0.6.2
 */