/*    */ package com.sun.org.apache.xerces.internal.dom;
/*    */ 
/*    */ import org.w3c.dom.DOMImplementation;
/*    */ 
/*    */ public class DeferredDOMImplementationImpl extends DOMImplementationImpl
/*    */ {
/* 47 */   static DeferredDOMImplementationImpl singleton = new DeferredDOMImplementationImpl();
/*    */ 
/*    */   public static DOMImplementation getDOMImplementation()
/*    */   {
/* 56 */     return singleton;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xerces.internal.dom.DeferredDOMImplementationImpl
 * JD-Core Version:    0.6.2
 */