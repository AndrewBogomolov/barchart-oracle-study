/*    */ package sun.io;
/*    */ 
/*    */ import sun.nio.cs.ISO_8859_9;
/*    */ 
/*    */ public class CharToByteISO8859_9 extends CharToByteSingleByte
/*    */ {
/* 38 */   private static final ISO_8859_9 nioCoder = new ISO_8859_9();
/*    */ 
/*    */   public String getCharacterEncoding() {
/* 41 */     return "ISO8859_9";
/*    */   }
/*    */ 
/*    */   public CharToByteISO8859_9() {
/* 45 */     this.mask1 = 65280;
/* 46 */     this.mask2 = 255;
/* 47 */     this.shift = 8;
/* 48 */     this.index1 = nioCoder.getEncoderIndex1();
/* 49 */     this.index2 = nioCoder.getEncoderIndex2();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.io.CharToByteISO8859_9
 * JD-Core Version:    0.6.2
 */