/*    */ package org.jcp.xml.dsig.internal.dom;
/*    */ 
/*    */ import java.security.InvalidAlgorithmParameterException;
/*    */ import javax.xml.crypto.dsig.spec.TransformParameterSpec;
/*    */ 
/*    */ public final class DOMEnvelopedTransform extends ApacheTransform
/*    */ {
/*    */   public void init(TransformParameterSpec paramTransformParameterSpec)
/*    */     throws InvalidAlgorithmParameterException
/*    */   {
/* 42 */     if (paramTransformParameterSpec != null)
/* 43 */       throw new InvalidAlgorithmParameterException("params must be null");
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     org.jcp.xml.dsig.internal.dom.DOMEnvelopedTransform
 * JD-Core Version:    0.6.2
 */