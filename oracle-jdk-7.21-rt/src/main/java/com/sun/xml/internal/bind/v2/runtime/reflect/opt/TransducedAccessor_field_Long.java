/*    */ package com.sun.xml.internal.bind.v2.runtime.reflect.opt;
/*    */ 
/*    */ import com.sun.xml.internal.bind.DatatypeConverterImpl;
/*    */ import com.sun.xml.internal.bind.v2.runtime.reflect.DefaultTransducedAccessor;
/*    */ 
/*    */ public final class TransducedAccessor_field_Long extends DefaultTransducedAccessor
/*    */ {
/*    */   public String print(Object o)
/*    */   {
/* 44 */     return DatatypeConverterImpl._printLong(((Bean)o).f_long);
/*    */   }
/*    */ 
/*    */   public void parse(Object o, CharSequence lexical) {
/* 48 */     ((Bean)o).f_long = DatatypeConverterImpl._parseLong(lexical);
/*    */   }
/*    */ 
/*    */   public boolean hasValue(Object o) {
/* 52 */     return true;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.bind.v2.runtime.reflect.opt.TransducedAccessor_field_Long
 * JD-Core Version:    0.6.2
 */