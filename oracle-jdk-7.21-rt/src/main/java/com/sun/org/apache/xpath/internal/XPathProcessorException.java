/*    */ package com.sun.org.apache.xpath.internal;
/*    */ 
/*    */ public class XPathProcessorException extends XPathException
/*    */ {
/*    */   static final long serialVersionUID = 1215509418326642603L;
/*    */ 
/*    */   public XPathProcessorException(String message)
/*    */   {
/* 41 */     super(message);
/*    */   }
/*    */ 
/*    */   public XPathProcessorException(String message, Exception e)
/*    */   {
/* 54 */     super(message, e);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xpath.internal.XPathProcessorException
 * JD-Core Version:    0.6.2
 */