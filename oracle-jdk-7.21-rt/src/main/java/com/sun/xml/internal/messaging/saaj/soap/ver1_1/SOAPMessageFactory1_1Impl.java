/*    */ package com.sun.xml.internal.messaging.saaj.soap.ver1_1;
/*    */ 
/*    */ import com.sun.xml.internal.messaging.saaj.SOAPExceptionImpl;
/*    */ import com.sun.xml.internal.messaging.saaj.soap.MessageFactoryImpl;
/*    */ import com.sun.xml.internal.messaging.saaj.soap.MessageImpl;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import javax.xml.soap.MimeHeaders;
/*    */ import javax.xml.soap.SOAPException;
/*    */ import javax.xml.soap.SOAPMessage;
/*    */ 
/*    */ public class SOAPMessageFactory1_1Impl extends MessageFactoryImpl
/*    */ {
/*    */   public SOAPMessage createMessage()
/*    */     throws SOAPException
/*    */   {
/* 44 */     return new Message1_1Impl();
/*    */   }
/*    */ 
/*    */   public SOAPMessage createMessage(boolean isFastInfoset, boolean acceptFastInfoset)
/*    */     throws SOAPException
/*    */   {
/* 50 */     return new Message1_1Impl(isFastInfoset, acceptFastInfoset);
/*    */   }
/*    */ 
/*    */   public SOAPMessage createMessage(MimeHeaders headers, InputStream in) throws IOException, SOAPExceptionImpl
/*    */   {
/* 55 */     if ((headers == null) || (getContentType(headers) == null)) {
/* 56 */       headers = new MimeHeaders();
/* 57 */       headers.setHeader("Content-Type", "text/xml");
/*    */     }
/* 59 */     MessageImpl msg = new Message1_1Impl(headers, in);
/* 60 */     msg.setLazyAttachments(this.lazyAttachments);
/* 61 */     return msg;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.messaging.saaj.soap.ver1_1.SOAPMessageFactory1_1Impl
 * JD-Core Version:    0.6.2
 */