/*    */ package com.sun.xml.internal.bind.v2.runtime.property;
/*    */ 
/*    */ import com.sun.xml.internal.bind.v2.runtime.JaxBeanInfo;
/*    */ import com.sun.xml.internal.bind.v2.runtime.Name;
/*    */ 
/*    */ class TagAndType
/*    */ {
/*    */   final Name tagName;
/*    */   final JaxBeanInfo beanInfo;
/*    */ 
/*    */   TagAndType(Name tagName, JaxBeanInfo beanInfo)
/*    */   {
/* 42 */     this.tagName = tagName;
/* 43 */     this.beanInfo = beanInfo;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.bind.v2.runtime.property.TagAndType
 * JD-Core Version:    0.6.2
 */