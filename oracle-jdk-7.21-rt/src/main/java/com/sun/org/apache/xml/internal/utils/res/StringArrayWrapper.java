/*    */ package com.sun.org.apache.xml.internal.utils.res;
/*    */ 
/*    */ public class StringArrayWrapper
/*    */ {
/*    */   private String[] m_string;
/*    */ 
/*    */   public StringArrayWrapper(String[] arg)
/*    */   {
/* 34 */     this.m_string = arg;
/*    */   }
/*    */ 
/*    */   public String getString(int index) {
/* 38 */     return this.m_string[index];
/*    */   }
/*    */ 
/*    */   public int getLength() {
/* 42 */     return this.m_string.length;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xml.internal.utils.res.StringArrayWrapper
 * JD-Core Version:    0.6.2
 */