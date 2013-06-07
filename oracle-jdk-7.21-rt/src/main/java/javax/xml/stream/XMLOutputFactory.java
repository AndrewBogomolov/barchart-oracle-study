/*     */ package javax.xml.stream;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import java.io.Writer;
/*     */ import javax.xml.transform.Result;
/*     */ 
/*     */ public abstract class XMLOutputFactory
/*     */ {
/*     */   public static final String IS_REPAIRING_NAMESPACES = "javax.xml.stream.isRepairingNamespaces";
/*     */   static final String DEFAULIMPL = "com.sun.xml.internal.stream.XMLOutputFactoryImpl";
/*     */ 
/*     */   public static XMLOutputFactory newInstance()
/*     */     throws FactoryConfigurationError
/*     */   {
/* 129 */     return (XMLOutputFactory)FactoryFinder.find("javax.xml.stream.XMLOutputFactory", "com.sun.xml.internal.stream.XMLOutputFactoryImpl");
/*     */   }
/*     */ 
/*     */   public static XMLOutputFactory newFactory()
/*     */     throws FactoryConfigurationError
/*     */   {
/* 161 */     return (XMLOutputFactory)FactoryFinder.find("javax.xml.stream.XMLOutputFactory", "com.sun.xml.internal.stream.XMLOutputFactoryImpl");
/*     */   }
/*     */ 
/*     */   /** @deprecated */
/*     */   public static XMLInputFactory newInstance(String factoryId, ClassLoader classLoader)
/*     */     throws FactoryConfigurationError
/*     */   {
/*     */     try
/*     */     {
/* 184 */       return (XMLInputFactory)FactoryFinder.find(factoryId, classLoader, null);
/*     */     } catch (FactoryFinder.ConfigurationError e) {
/* 186 */       throw new FactoryConfigurationError(e.getException(), e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public static XMLOutputFactory newFactory(String factoryId, ClassLoader classLoader)
/*     */     throws FactoryConfigurationError
/*     */   {
/*     */     try
/*     */     {
/* 213 */       return (XMLOutputFactory)FactoryFinder.find(factoryId, classLoader, null);
/*     */     } catch (FactoryFinder.ConfigurationError e) {
/* 215 */       throw new FactoryConfigurationError(e.getException(), e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public abstract XMLStreamWriter createXMLStreamWriter(Writer paramWriter)
/*     */     throws XMLStreamException;
/*     */ 
/*     */   public abstract XMLStreamWriter createXMLStreamWriter(OutputStream paramOutputStream)
/*     */     throws XMLStreamException;
/*     */ 
/*     */   public abstract XMLStreamWriter createXMLStreamWriter(OutputStream paramOutputStream, String paramString)
/*     */     throws XMLStreamException;
/*     */ 
/*     */   public abstract XMLStreamWriter createXMLStreamWriter(Result paramResult)
/*     */     throws XMLStreamException;
/*     */ 
/*     */   public abstract XMLEventWriter createXMLEventWriter(Result paramResult)
/*     */     throws XMLStreamException;
/*     */ 
/*     */   public abstract XMLEventWriter createXMLEventWriter(OutputStream paramOutputStream)
/*     */     throws XMLStreamException;
/*     */ 
/*     */   public abstract XMLEventWriter createXMLEventWriter(OutputStream paramOutputStream, String paramString)
/*     */     throws XMLStreamException;
/*     */ 
/*     */   public abstract XMLEventWriter createXMLEventWriter(Writer paramWriter)
/*     */     throws XMLStreamException;
/*     */ 
/*     */   public abstract void setProperty(String paramString, Object paramObject)
/*     */     throws IllegalArgumentException;
/*     */ 
/*     */   public abstract Object getProperty(String paramString)
/*     */     throws IllegalArgumentException;
/*     */ 
/*     */   public abstract boolean isPropertySupported(String paramString);
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.stream.XMLOutputFactory
 * JD-Core Version:    0.6.2
 */