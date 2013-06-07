/*     */ package com.sun.org.apache.xml.internal.serializer.utils;
/*     */ 
/*     */ import java.util.ListResourceBundle;
/*     */ 
/*     */ public class SerializerMessages_it extends ListResourceBundle
/*     */ {
/*     */   public Object[][] getContents()
/*     */   {
/*  30 */     Object[][] contents = { { "ER_SERIALIZER_NOT_CONTENTHANDLER", "La classe serializer ''{0}'' non implementa org.xml.sax.ContentHandler." }, { "ER_RESOURCE_COULD_NOT_FIND", "Risorsa [ {0} ] non trovata.\n {1}" }, { "ER_RESOURCE_COULD_NOT_LOAD", "Impossibile caricare la risorsa [ {0} ]: {1} \n {2} \n {3}" }, { "ER_BUFFER_SIZE_LESSTHAN_ZERO", "Dimensione buffer <=0" }, { "ER_INVALID_UTF16_SURROGATE", "Rilevato surrogato UTF-16 non valido: {0} ?" }, { "ER_OIERROR", "Errore IO" }, { "ER_ILLEGAL_ATTRIBUTE_POSITION", "Impossibile aggiungere l''attributo {0} dopo i nodi secondari o prima che sia prodotto un elemento. L''attributo verrà ignorato. " }, { "ER_NAMESPACE_PREFIX", "Lo spazio nomi per il prefisso ''{0}'' non è stato dichiarato. " }, { "ER_STRAY_NAMESPACE", "Dichiarazione dello spazio nome ''{0}''=''{1}'' al di fuori dell''elemento. " }, { "ER_COULD_NOT_LOAD_RESOURCE", "Impossibile caricare ''{0}'' (verificare CLASSPATH); verranno utilizzati i valori predefiniti " }, { "ER_COULD_NOT_LOAD_METHOD_PROPERTY", "Impossibile caricare il file delle proprietà ''{0}'' per il metodo di emissione ''{1}'' (verificare CLASSPATH)" }, { "ER_INVALID_PORT", "Numero di porta non valido" }, { "ER_PORT_WHEN_HOST_NULL", "La porta non può essere impostata se l'host è nullo" }, { "ER_HOST_ADDRESS_NOT_WELLFORMED", "Host non è un'indirizzo corretto" }, { "ER_SCHEME_NOT_CONFORMANT", "Lo schema non è conforme." }, { "ER_SCHEME_FROM_NULL_STRING", "Impossibile impostare lo schema da una stringa nulla" }, { "ER_PATH_CONTAINS_INVALID_ESCAPE_SEQUENCE", "Il percorso contiene sequenza di escape non valida" }, { "ER_PATH_INVALID_CHAR", "Il percorso contiene un carattere non valido: {0}" }, { "ER_FRAG_INVALID_CHAR", "Il frammento contiene un carattere non valido" }, { "ER_FRAG_WHEN_PATH_NULL", "Il frammento non può essere impostato se il percorso è nullo" }, { "ER_FRAG_FOR_GENERIC_URI", "Il frammento può essere impostato solo per un URI generico" }, { "ER_NO_SCHEME_IN_URI", "Nessuno schema trovato nell''URI: {0}" }, { "ER_CANNOT_INIT_URI_EMPTY_PARMS", "Impossibile inizializzare l'URI con i parametri vuoti" }, { "ER_NO_FRAGMENT_STRING_IN_PATH", "Il frammento non può essere specificato sia nel percorso che nel frammento" }, { "ER_NO_QUERY_STRING_IN_PATH", "La stringa di interrogazione non può essere specificata nella stringa di interrogazione e percorso." }, { "ER_NO_PORT_IF_NO_HOST", "La porta non può essere specificata se l'host non è specificato" }, { "ER_NO_USERINFO_IF_NO_HOST", "Userinfo non può essere specificato se l'host non è specificato" }, { "ER_SCHEME_REQUIRED", "Lo schema è obbligatorio." } };
/*     */ 
/* 120 */     return contents;
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_it
 * JD-Core Version:    0.6.2
 */