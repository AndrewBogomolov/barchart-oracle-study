/*    */ package com.sun.beans.editors;
/*    */ 
/*    */ public class FloatEditor extends NumberEditor
/*    */ {
/*    */   public String getJavaInitializationString()
/*    */   {
/* 38 */     Object localObject = getValue();
/* 39 */     return localObject != null ? localObject + "F" : "null";
/*    */   }
/*    */ 
/*    */   public void setAsText(String paramString)
/*    */     throws IllegalArgumentException
/*    */   {
/* 45 */     setValue(paramString == null ? null : Float.valueOf(paramString));
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.beans.editors.FloatEditor
 * JD-Core Version:    0.6.2
 */