/*    */ package javax.xml.crypto.dsig.spec;
/*    */ 
/*    */ import javax.xml.crypto.XMLStructure;
/*    */ 
/*    */ public final class XSLTTransformParameterSpec
/*    */   implements TransformParameterSpec
/*    */ {
/*    */   private XMLStructure stylesheet;
/*    */ 
/*    */   public XSLTTransformParameterSpec(XMLStructure paramXMLStructure)
/*    */   {
/* 64 */     if (paramXMLStructure == null) {
/* 65 */       throw new NullPointerException();
/*    */     }
/* 67 */     this.stylesheet = paramXMLStructure;
/*    */   }
/*    */ 
/*    */   public XMLStructure getStylesheet()
/*    */   {
/* 76 */     return this.stylesheet;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec
 * JD-Core Version:    0.6.2
 */