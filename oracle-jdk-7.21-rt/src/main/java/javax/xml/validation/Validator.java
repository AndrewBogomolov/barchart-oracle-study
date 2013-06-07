/*     */ package javax.xml.validation;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import javax.xml.transform.Result;
/*     */ import javax.xml.transform.Source;
/*     */ import org.w3c.dom.ls.LSResourceResolver;
/*     */ import org.xml.sax.ErrorHandler;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.SAXNotRecognizedException;
/*     */ import org.xml.sax.SAXNotSupportedException;
/*     */ 
/*     */ public abstract class Validator
/*     */ {
/*     */   public abstract void reset();
/*     */ 
/*     */   public void validate(Source source)
/*     */     throws SAXException, IOException
/*     */   {
/* 124 */     validate(source, null);
/*     */   }
/*     */ 
/*     */   public abstract void validate(Source paramSource, Result paramResult)
/*     */     throws SAXException, IOException;
/*     */ 
/*     */   public abstract void setErrorHandler(ErrorHandler paramErrorHandler);
/*     */ 
/*     */   public abstract ErrorHandler getErrorHandler();
/*     */ 
/*     */   public abstract void setResourceResolver(LSResourceResolver paramLSResourceResolver);
/*     */ 
/*     */   public abstract LSResourceResolver getResourceResolver();
/*     */ 
/*     */   public boolean getFeature(String name)
/*     */     throws SAXNotRecognizedException, SAXNotSupportedException
/*     */   {
/* 388 */     if (name == null) {
/* 389 */       throw new NullPointerException("the name parameter is null");
/*     */     }
/*     */ 
/* 392 */     throw new SAXNotRecognizedException(name);
/*     */   }
/*     */ 
/*     */   public void setFeature(String name, boolean value)
/*     */     throws SAXNotRecognizedException, SAXNotSupportedException
/*     */   {
/* 426 */     if (name == null) {
/* 427 */       throw new NullPointerException("the name parameter is null");
/*     */     }
/*     */ 
/* 430 */     throw new SAXNotRecognizedException(name);
/*     */   }
/*     */ 
/*     */   public void setProperty(String name, Object object)
/*     */     throws SAXNotRecognizedException, SAXNotSupportedException
/*     */   {
/* 460 */     if (name == null) {
/* 461 */       throw new NullPointerException("the name parameter is null");
/*     */     }
/*     */ 
/* 464 */     throw new SAXNotRecognizedException(name);
/*     */   }
/*     */ 
/*     */   public Object getProperty(String name)
/*     */     throws SAXNotRecognizedException, SAXNotSupportedException
/*     */   {
/* 499 */     if (name == null) {
/* 500 */       throw new NullPointerException("the name parameter is null");
/*     */     }
/*     */ 
/* 503 */     throw new SAXNotRecognizedException(name);
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.validation.Validator
 * JD-Core Version:    0.6.2
 */