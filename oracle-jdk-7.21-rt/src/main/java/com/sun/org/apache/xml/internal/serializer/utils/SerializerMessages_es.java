/*     */ package com.sun.org.apache.xml.internal.serializer.utils;
/*     */ 
/*     */ import java.util.ListResourceBundle;
/*     */ 
/*     */ public class SerializerMessages_es extends ListResourceBundle
/*     */ {
/*     */   public Object[][] getContents()
/*     */   {
/*  30 */     Object[][] contents = { { "ER_SERIALIZER_NOT_CONTENTHANDLER", "La clase serializer ''{0}'' no implementa org.xml.sax.ContentHandler." }, { "ER_RESOURCE_COULD_NOT_FIND", "No se ha podido cargar el recurso [ {0} ].\n{1}" }, { "ER_RESOURCE_COULD_NOT_LOAD", "No se ha podido cargar el recurso [ {0} ]: {1} \n {2} \n {3}" }, { "ER_BUFFER_SIZE_LESSTHAN_ZERO", "Tamaño de almacenamiento intermedio <=0" }, { "ER_INVALID_UTF16_SURROGATE", "¿Se ha detectado un sustituto UTF-16 no válido: {0}?" }, { "ER_OIERROR", "Error de ES" }, { "ER_ILLEGAL_ATTRIBUTE_POSITION", "No se puede añadir el atributo {0} después de nodos hijo o antes de que se produzca un elemento. Se ignorará el atributo." }, { "ER_NAMESPACE_PREFIX", "No se ha declarado el espacio de nombres para el prefijo ''{0}''." }, { "ER_STRAY_NAMESPACE", "Declaración del espacio de nombres ''{0}''=''{1}'' fuera del elemento." }, { "ER_COULD_NOT_LOAD_RESOURCE", "No se ha podido cargar ''{0}'' (compruebe la CLASSPATH), ahora sólo se están utilizando los valores por omisión" }, { "ER_COULD_NOT_LOAD_METHOD_PROPERTY", "No se ha podido cargar el archivo de propiedades ''{0}'' para el método de salida ''{1}'' (compruebe la CLASSPATH)" }, { "ER_INVALID_PORT", "Número de puerto no válido" }, { "ER_PORT_WHEN_HOST_NULL", "No se puede establecer el puerto si el sistema principal es nulo" }, { "ER_HOST_ADDRESS_NOT_WELLFORMED", "El sistema principal no es una dirección bien formada" }, { "ER_SCHEME_NOT_CONFORMANT", "El esquema no es compatible." }, { "ER_SCHEME_FROM_NULL_STRING", "No se puede establecer un esquema de una serie nula" }, { "ER_PATH_CONTAINS_INVALID_ESCAPE_SEQUENCE", "La vía de acceso contiene una secuencia de escape no válida" }, { "ER_PATH_INVALID_CHAR", "La vía de acceso contiene un carácter no válido: {0}" }, { "ER_FRAG_INVALID_CHAR", "El fragmento contiene un carácter no válido" }, { "ER_FRAG_WHEN_PATH_NULL", "No se puede establecer el fragmento si la vía de acceso es nula" }, { "ER_FRAG_FOR_GENERIC_URI", "Sólo se puede establecer el fragmento para un URI genérico" }, { "ER_NO_SCHEME_IN_URI", "No se ha encontrado un esquema en el URI: {0}" }, { "ER_CANNOT_INIT_URI_EMPTY_PARMS", "No se puede inicializar el URI con parámetros vacíos" }, { "ER_NO_FRAGMENT_STRING_IN_PATH", "No se puede especificar el fragmento en la vía de acceso y en el fragmento" }, { "ER_NO_QUERY_STRING_IN_PATH", "No se puede especificar la serie de consulta en la vía de acceso y en la serie de consulta" }, { "ER_NO_PORT_IF_NO_HOST", "No se puede especificar el puerto si no se ha especificado el sistema principal" }, { "ER_NO_USERINFO_IF_NO_HOST", "No se puede especificar la información de usuario si no se ha especificado el sistema principal" }, { "ER_SCHEME_REQUIRED", "¡Se necesita un esquema!" } };
/*     */ 
/* 120 */     return contents;
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_es
 * JD-Core Version:    0.6.2
 */