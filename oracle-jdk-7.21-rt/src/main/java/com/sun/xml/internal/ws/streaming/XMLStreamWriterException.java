/*    */ package com.sun.xml.internal.ws.streaming;
/*    */ 
/*    */ import com.sun.xml.internal.ws.util.exception.JAXWSExceptionBase;
/*    */ import com.sun.xml.internal.ws.util.localization.Localizable;
/*    */ 
/*    */ public class XMLStreamWriterException extends JAXWSExceptionBase
/*    */ {
/*    */   public XMLStreamWriterException(String key, Object[] args)
/*    */   {
/* 42 */     super(key, args);
/*    */   }
/*    */ 
/*    */   public XMLStreamWriterException(Throwable throwable) {
/* 46 */     super(throwable);
/*    */   }
/*    */ 
/*    */   public XMLStreamWriterException(Localizable arg) {
/* 50 */     super("xmlwriter.nestedError", new Object[] { arg });
/*    */   }
/*    */ 
/*    */   public String getDefaultResourceBundleName() {
/* 54 */     return "com.sun.xml.internal.ws.resources.streaming";
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.ws.streaming.XMLStreamWriterException
 * JD-Core Version:    0.6.2
 */