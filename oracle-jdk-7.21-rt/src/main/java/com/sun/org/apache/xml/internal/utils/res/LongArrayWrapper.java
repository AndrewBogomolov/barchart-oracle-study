/*    */ package com.sun.org.apache.xml.internal.utils.res;
/*    */ 
/*    */ public class LongArrayWrapper
/*    */ {
/*    */   private long[] m_long;
/*    */ 
/*    */   public LongArrayWrapper(long[] arg)
/*    */   {
/* 34 */     this.m_long = arg;
/*    */   }
/*    */ 
/*    */   public long getLong(int index) {
/* 38 */     return this.m_long[index];
/*    */   }
/*    */ 
/*    */   public int getLength() {
/* 42 */     return this.m_long.length;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xml.internal.utils.res.LongArrayWrapper
 * JD-Core Version:    0.6.2
 */