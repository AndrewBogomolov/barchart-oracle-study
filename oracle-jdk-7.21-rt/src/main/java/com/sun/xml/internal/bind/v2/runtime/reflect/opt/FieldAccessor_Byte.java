/*    */ package com.sun.xml.internal.bind.v2.runtime.reflect.opt;
/*    */ 
/*    */ import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;
/*    */ 
/*    */ public class FieldAccessor_Byte extends Accessor
/*    */ {
/*    */   public FieldAccessor_Byte()
/*    */   {
/* 40 */     super(Byte.class);
/*    */   }
/*    */ 
/*    */   public Object get(Object bean) {
/* 44 */     return Byte.valueOf(((Bean)bean).f_byte);
/*    */   }
/*    */ 
/*    */   public void set(Object bean, Object value) {
/* 48 */     ((Bean)bean).f_byte = (value == null ? Const.default_value_byte : ((Byte)value).byteValue());
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.bind.v2.runtime.reflect.opt.FieldAccessor_Byte
 * JD-Core Version:    0.6.2
 */