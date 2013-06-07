/*    */ package com.sun.org.apache.xerces.internal.impl.xpath.regex;
/*    */ 
/*    */ public class ParseException extends RuntimeException
/*    */ {
/*    */   static final long serialVersionUID = -7012400318097691370L;
/*    */   int location;
/*    */ 
/*    */   public ParseException(String mes, int location)
/*    */   {
/* 44 */     super(mes);
/* 45 */     this.location = location;
/*    */   }
/*    */ 
/*    */   public int getLocation()
/*    */   {
/* 53 */     return this.location;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException
 * JD-Core Version:    0.6.2
 */