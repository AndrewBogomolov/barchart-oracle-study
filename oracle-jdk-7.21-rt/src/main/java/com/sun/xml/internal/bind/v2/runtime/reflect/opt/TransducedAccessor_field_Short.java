/*    */ package com.sun.xml.internal.bind.v2.runtime.reflect.opt;
/*    */ 
/*    */ import com.sun.xml.internal.bind.DatatypeConverterImpl;
/*    */ import com.sun.xml.internal.bind.v2.runtime.reflect.DefaultTransducedAccessor;
/*    */ 
/*    */ public final class TransducedAccessor_field_Short extends DefaultTransducedAccessor
/*    */ {
/*    */   public String print(Object o)
/*    */   {
/* 44 */     return DatatypeConverterImpl._printShort(((Bean)o).f_short);
/*    */   }
/*    */ 
/*    */   public void parse(Object o, CharSequence lexical) {
/* 48 */     ((Bean)o).f_short = DatatypeConverterImpl._parseShort(lexical);
/*    */   }
/*    */ 
/*    */   public boolean hasValue(Object o) {
/* 52 */     return true;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.bind.v2.runtime.reflect.opt.TransducedAccessor_field_Short
 * JD-Core Version:    0.6.2
 */