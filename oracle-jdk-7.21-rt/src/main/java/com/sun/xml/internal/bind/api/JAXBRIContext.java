/*     */ package com.sun.xml.internal.bind.api;
/*     */ 
/*     */ import com.sun.istack.internal.NotNull;
/*     */ import com.sun.istack.internal.Nullable;
/*     */ import com.sun.xml.internal.bind.api.impl.NameConverter;
/*     */ import com.sun.xml.internal.bind.v2.ContextFactory;
/*     */ import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;
/*     */ import com.sun.xml.internal.bind.v2.model.nav.Navigator;
/*     */ import com.sun.xml.internal.bind.v2.model.nav.ReflectionNavigator;
/*     */ import com.sun.xml.internal.bind.v2.model.runtime.RuntimeTypeInfoSet;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.xml.bind.JAXBContext;
/*     */ import javax.xml.bind.JAXBException;
/*     */ import javax.xml.bind.SchemaOutputResolver;
/*     */ import javax.xml.namespace.QName;
/*     */ import javax.xml.transform.Result;
/*     */ 
/*     */ public abstract class JAXBRIContext extends JAXBContext
/*     */ {
/*     */   public static final String DEFAULT_NAMESPACE_REMAP = "com.sun.xml.internal.bind.defaultNamespaceRemap";
/*     */   public static final String TYPE_REFERENCES = "com.sun.xml.internal.bind.typeReferences";
/*     */   public static final String CANONICALIZATION_SUPPORT = "com.sun.xml.internal.bind.c14n";
/*     */   public static final String TREAT_EVERYTHING_NILLABLE = "com.sun.xml.internal.bind.treatEverythingNillable";
/* 464 */   public static final String ANNOTATION_READER = RuntimeAnnotationReader.class.getName();
/*     */   public static final String ENABLE_XOP = "com.sun.xml.internal.bind.XOP";
/*     */   public static final String SUBCLASS_REPLACEMENTS = "com.sun.xml.internal.bind.subclassReplacements";
/*     */   public static final String XMLACCESSORFACTORY_SUPPORT = "com.sun.xml.internal.bind.XmlAccessorFactory";
/*     */   public static final String RETAIN_REFERENCE_TO_INFO = "retainReferenceToInfo";
/*     */   public static final String SUPRESS_ACCESSOR_WARNINGS = "supressAccessorWarnings";
/*     */   public static final String IMPROVED_XSI_TYPE_HANDLING = "com.sun.xml.internal.bind.improvedXsiTypeHandling";
/*     */ 
/*     */   public static JAXBRIContext newInstance(@NotNull Class[] classes, @Nullable Collection<TypeReference> typeRefs, @Nullable Map<Class, Class> subclassReplacements, @Nullable String defaultNamespaceRemap, boolean c14nSupport, @Nullable RuntimeAnnotationReader ar)
/*     */     throws JAXBException
/*     */   {
/*  96 */     return ContextFactory.createContext(classes, typeRefs, subclassReplacements, defaultNamespaceRemap, c14nSupport, ar, false, false, false, false);
/*     */   }
/*     */ 
/*     */   public static JAXBRIContext newInstance(@NotNull Class[] classes, @Nullable Collection<TypeReference> typeRefs, @Nullable Map<Class, Class> subclassReplacements, @Nullable String defaultNamespaceRemap, boolean c14nSupport, @Nullable RuntimeAnnotationReader ar, boolean xmlAccessorFactorySupport, boolean allNillable, boolean retainPropertyInfo, boolean supressAccessorWarnings)
/*     */     throws JAXBException
/*     */   {
/* 139 */     return ContextFactory.createContext(classes, typeRefs, subclassReplacements, defaultNamespaceRemap, c14nSupport, ar, xmlAccessorFactorySupport, allNillable, retainPropertyInfo, supressAccessorWarnings);
/*     */   }
/*     */ 
/*     */   /** @deprecated */
/*     */   public static JAXBRIContext newInstance(@NotNull Class[] classes, @Nullable Collection<TypeReference> typeRefs, @Nullable String defaultNamespaceRemap, boolean c14nSupport)
/*     */     throws JAXBException
/*     */   {
/* 150 */     return newInstance(classes, typeRefs, Collections.emptyMap(), defaultNamespaceRemap, c14nSupport, null);
/*     */   }
/*     */ 
/*     */   public abstract boolean hasSwaRef();
/*     */ 
/*     */   @Nullable
/*     */   public abstract QName getElementName(@NotNull Object paramObject)
/*     */     throws JAXBException;
/*     */ 
/*     */   @Nullable
/*     */   public abstract QName getElementName(@NotNull Class paramClass)
/*     */     throws JAXBException;
/*     */ 
/*     */   public abstract Bridge createBridge(@NotNull TypeReference paramTypeReference);
/*     */ 
/*     */   @NotNull
/*     */   public abstract BridgeContext createBridgeContext();
/*     */ 
/*     */   public abstract <B, V> RawAccessor<B, V> getElementPropertyAccessor(Class<B> paramClass, String paramString1, String paramString2)
/*     */     throws JAXBException;
/*     */ 
/*     */   @NotNull
/*     */   public abstract List<String> getKnownNamespaceURIs();
/*     */ 
/*     */   public abstract void generateSchema(@NotNull SchemaOutputResolver paramSchemaOutputResolver)
/*     */     throws IOException;
/*     */ 
/*     */   public abstract QName getTypeName(@NotNull TypeReference paramTypeReference);
/*     */ 
/*     */   @NotNull
/*     */   public abstract String getBuildId();
/*     */ 
/*     */   public abstract void generateEpisode(Result paramResult);
/*     */ 
/*     */   public abstract RuntimeTypeInfoSet getRuntimeTypeInfoSet();
/*     */ 
/*     */   @NotNull
/*     */   public static String mangleNameToVariableName(@NotNull String localName)
/*     */   {
/* 349 */     return NameConverter.standard.toVariableName(localName);
/*     */   }
/*     */ 
/*     */   @NotNull
/*     */   public static String mangleNameToClassName(@NotNull String localName)
/*     */   {
/* 362 */     return NameConverter.standard.toClassName(localName);
/*     */   }
/*     */ 
/*     */   @NotNull
/*     */   public static String mangleNameToPropertyName(@NotNull String localName)
/*     */   {
/* 377 */     return NameConverter.standard.toPropertyName(localName);
/*     */   }
/*     */ 
/*     */   @Nullable
/*     */   public static Type getBaseType(@NotNull Type type, @NotNull Class baseType)
/*     */   {
/* 407 */     return Navigator.REFLECTION.getBaseClass(type, baseType);
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.bind.api.JAXBRIContext
 * JD-Core Version:    0.6.2
 */