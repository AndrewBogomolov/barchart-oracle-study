/*    */ package com.sun.xml.internal.fastinfoset.alphabet;
/*    */ 
/*    */ public final class BuiltInRestrictedAlphabets
/*    */ {
/* 34 */   public static final char[][] table = new char[2][];
/*    */ 
/*    */   static
/*    */   {
/* 38 */     table[0] = "0123456789-+.E ".toCharArray();
/* 39 */     table[1] = "0123456789-:TZ ".toCharArray();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets
 * JD-Core Version:    0.6.2
 */