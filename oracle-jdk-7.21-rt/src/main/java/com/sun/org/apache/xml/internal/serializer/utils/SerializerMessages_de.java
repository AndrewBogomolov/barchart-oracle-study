/*     */ package com.sun.org.apache.xml.internal.serializer.utils;
/*     */ 
/*     */ import java.util.ListResourceBundle;
/*     */ 
/*     */ public class SerializerMessages_de extends ListResourceBundle
/*     */ {
/*     */   public Object[][] getContents()
/*     */   {
/*  30 */     Object[][] contents = { { "ER_SERIALIZER_NOT_CONTENTHANDLER", "Die Parallel-Seriell-Umsetzerklasse ''{0}'' implementiert org.xml.sax.ContentHandler nicht." }, { "ER_RESOURCE_COULD_NOT_FIND", "Die Ressource [ {0} ] konnte nicht gefunden werden.\n {1}" }, { "ER_RESOURCE_COULD_NOT_LOAD", "Die Ressource [ {0} ] konnte nicht geladen werden: {1} \n {2} \n {3}" }, { "ER_BUFFER_SIZE_LESSTHAN_ZERO", "Puffergröße <=0" }, { "ER_INVALID_UTF16_SURROGATE", "Ungültige UTF-16-Ersetzung festgestellt: {0} ?" }, { "ER_OIERROR", "E/A-Fehler" }, { "ER_ILLEGAL_ATTRIBUTE_POSITION", "Attribut {0} kann nicht nach Kindknoten oder vor dem Erstellen eines Elements hinzugefügt werden.  Das Attribut wird ignoriert." }, { "ER_NAMESPACE_PREFIX", "Der Namensbereich für Präfix ''{0}'' wurde nicht deklariert." }, { "ER_STRAY_NAMESPACE", "Namensbereichsdeklaration ''{0}''=''{1}'' befindet sich nicht in einem Element." }, { "ER_COULD_NOT_LOAD_RESOURCE", "''{0}'' konnte nicht geladen werden (CLASSPATH prüfen); es werden die Standardwerte verwendet" }, { "ER_COULD_NOT_LOAD_METHOD_PROPERTY", "Merkmaldatei ''{0}'' konnte für Ausgabemethode ''{1}'' nicht geladen werden (CLASSPATH prüfen)" }, { "ER_INVALID_PORT", "Ungültige Portnummer" }, { "ER_PORT_WHEN_HOST_NULL", "Der Port kann nicht festgelegt werden, wenn der Host gleich Null ist." }, { "ER_HOST_ADDRESS_NOT_WELLFORMED", "Der Host ist keine syntaktisch korrekte Adresse." }, { "ER_SCHEME_NOT_CONFORMANT", "Das Schema ist nicht angepasst." }, { "ER_SCHEME_FROM_NULL_STRING", "Schema kann nicht von Nullzeichenfolge festgelegt werden." }, { "ER_PATH_CONTAINS_INVALID_ESCAPE_SEQUENCE", "Der Pfad enthält eine ungültige Escapezeichenfolge." }, { "ER_PATH_INVALID_CHAR", "Pfad enthält ungültiges Zeichen: {0}." }, { "ER_FRAG_INVALID_CHAR", "Fragment enthält ein ungültiges Zeichen." }, { "ER_FRAG_WHEN_PATH_NULL", "Fragment kann nicht festgelegt werden, wenn der Pfad gleich Null ist." }, { "ER_FRAG_FOR_GENERIC_URI", "Fragment kann nur für eine generische URI (Uniform Resource Identifier) festgelegt werden." }, { "ER_NO_SCHEME_IN_URI", "Kein Schema gefunden in URI: {0}." }, { "ER_CANNOT_INIT_URI_EMPTY_PARMS", "URI (Uniform Resource Identifier) kann nicht mit leeren Parametern initialisiert werden." }, { "ER_NO_FRAGMENT_STRING_IN_PATH", "Fragment kann nicht im Pfad und im Fragment angegeben werden." }, { "ER_NO_QUERY_STRING_IN_PATH", "Abfragezeichenfolge kann nicht im Pfad und in der Abfragezeichenfolge angegeben werden." }, { "ER_NO_PORT_IF_NO_HOST", "Der Port kann nicht angegeben werden, wenn der Host nicht angegeben wurde." }, { "ER_NO_USERINFO_IF_NO_HOST", "Benutzerinformationen können nicht angegeben werden, wenn der Host nicht angegeben wurde." }, { "ER_SCHEME_REQUIRED", "Schema ist erforderlich!" } };
/*     */ 
/* 120 */     return contents;
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_de
 * JD-Core Version:    0.6.2
 */