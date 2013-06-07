/*    */ package com.sun.org.apache.xpath.internal.operations;
/*    */ 
/*    */ import com.sun.org.apache.xpath.internal.Expression;
/*    */ import com.sun.org.apache.xpath.internal.XPathContext;
/*    */ import com.sun.org.apache.xpath.internal.objects.XNumber;
/*    */ import com.sun.org.apache.xpath.internal.objects.XObject;
/*    */ import javax.xml.transform.TransformerException;
/*    */ 
/*    */ public class Plus extends Operation
/*    */ {
/*    */   static final long serialVersionUID = -4492072861616504256L;
/*    */ 
/*    */   public XObject operate(XObject left, XObject right)
/*    */     throws TransformerException
/*    */   {
/* 50 */     return new XNumber(left.num() + right.num());
/*    */   }
/*    */ 
/*    */   public double num(XPathContext xctxt)
/*    */     throws TransformerException
/*    */   {
/* 66 */     return this.m_right.num(xctxt) + this.m_left.num(xctxt);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xpath.internal.operations.Plus
 * JD-Core Version:    0.6.2
 */