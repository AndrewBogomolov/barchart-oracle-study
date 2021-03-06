/*    */ package com.sun.xml.internal.bind.v2.runtime.reflect.opt;
/*    */ 
/*    */ import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;
/*    */ 
/*    */ public class FieldAccessor_Float extends Accessor
/*    */ {
/*    */   public FieldAccessor_Float()
/*    */   {
/* 40 */     super(Float.class);
/*    */   }
/*    */ 
/*    */   public Object get(Object bean) {
/* 44 */     return Float.valueOf(((Bean)bean).f_float);
/*    */   }
/*    */ 
/*    */   public void set(Object bean, Object value) {
/* 48 */     ((Bean)bean).f_float = (value == null ? Const.default_value_float : ((Float)value).floatValue());
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.bind.v2.runtime.reflect.opt.FieldAccessor_Float
 * JD-Core Version:    0.6.2
 */