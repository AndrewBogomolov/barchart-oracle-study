/*      */ package com.sun.org.apache.xalan.internal.xsltc.runtime;
/*      */ 
/*      */ import com.sun.org.apache.xalan.internal.utils.SecuritySupport;
/*      */ import com.sun.org.apache.xalan.internal.xsltc.DOM;
/*      */ import com.sun.org.apache.xalan.internal.xsltc.Translet;
/*      */ import com.sun.org.apache.xalan.internal.xsltc.dom.AbsoluteIterator;
/*      */ import com.sun.org.apache.xalan.internal.xsltc.dom.ArrayNodeListIterator;
/*      */ import com.sun.org.apache.xalan.internal.xsltc.dom.DOMAdapter;
/*      */ import com.sun.org.apache.xalan.internal.xsltc.dom.MultiDOM;
/*      */ import com.sun.org.apache.xalan.internal.xsltc.dom.SingletonIterator;
/*      */ import com.sun.org.apache.xalan.internal.xsltc.dom.StepIterator;
/*      */ import com.sun.org.apache.xml.internal.dtm.DTM;
/*      */ import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;
/*      */ import com.sun.org.apache.xml.internal.dtm.DTMManager;
/*      */ import com.sun.org.apache.xml.internal.dtm.ref.DTMNodeProxy;
/*      */ import com.sun.org.apache.xml.internal.serializer.NamespaceMappings;
/*      */ import com.sun.org.apache.xml.internal.serializer.SerializationHandler;
/*      */ import com.sun.org.apache.xml.internal.utils.XML11Char;
/*      */ import java.io.PrintStream;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.DecimalFormatSymbols;
/*      */ import java.text.FieldPosition;
/*      */ import java.text.MessageFormat;
/*      */ import java.text.NumberFormat;
/*      */ import java.util.Locale;
/*      */ import java.util.ResourceBundle;
/*      */ import javax.xml.parsers.ParserConfigurationException;
/*      */ import javax.xml.transform.dom.DOMSource;
/*      */ import org.w3c.dom.Attr;
/*      */ import org.w3c.dom.Document;
/*      */ import org.w3c.dom.Element;
/*      */ import org.w3c.dom.NodeList;
/*      */ import org.xml.sax.SAXException;
/*      */ 
/*      */ public final class BasisLibrary
/*      */ {
/*      */   private static final String EMPTYSTRING = "";
/*   73 */   private static final ThreadLocal<StringBuilder> threadLocalStringBuilder = new ThreadLocal()
/*      */   {
/*      */     protected StringBuilder initialValue() {
/*   76 */       return new StringBuilder();
/*      */     }
/*   73 */   };
/*      */ 
/*   83 */   private static final ThreadLocal<StringBuffer> threadLocalStringBuffer = new ThreadLocal()
/*      */   {
/*      */     protected StringBuffer initialValue() {
/*   86 */       return new StringBuffer(); }  } ;
/*      */   private static final int DOUBLE_FRACTION_DIGITS = 340;
/*      */   private static final double lowerBounds = 0.001D;
/*      */   private static final double upperBounds = 10000000.0D;
/*      */   private static DecimalFormat defaultFormatter;
/*      */   private static DecimalFormat xpathFormatter;
/*  913 */   private static String defaultPattern = "";
/*      */   private static FieldPosition _fieldPosition;
/*      */   private static char[] _characterArray;
/*      */   private static int prefixIndex;
/*      */   public static final String RUN_TIME_INTERNAL_ERR = "RUN_TIME_INTERNAL_ERR";
/*      */   public static final String RUN_TIME_COPY_ERR = "RUN_TIME_COPY_ERR";
/*      */   public static final String DATA_CONVERSION_ERR = "DATA_CONVERSION_ERR";
/*      */   public static final String EXTERNAL_FUNC_ERR = "EXTERNAL_FUNC_ERR";
/*      */   public static final String EQUALITY_EXPR_ERR = "EQUALITY_EXPR_ERR";
/*      */   public static final String INVALID_ARGUMENT_ERR = "INVALID_ARGUMENT_ERR";
/*      */   public static final String FORMAT_NUMBER_ERR = "FORMAT_NUMBER_ERR";
/*      */   public static final String ITERATOR_CLONE_ERR = "ITERATOR_CLONE_ERR";
/*      */   public static final String AXIS_SUPPORT_ERR = "AXIS_SUPPORT_ERR";
/*      */   public static final String TYPED_AXIS_SUPPORT_ERR = "TYPED_AXIS_SUPPORT_ERR";
/*      */   public static final String STRAY_ATTRIBUTE_ERR = "STRAY_ATTRIBUTE_ERR";
/*      */   public static final String STRAY_NAMESPACE_ERR = "STRAY_NAMESPACE_ERR";
/*      */   public static final String NAMESPACE_PREFIX_ERR = "NAMESPACE_PREFIX_ERR";
/*      */   public static final String DOM_ADAPTER_INIT_ERR = "DOM_ADAPTER_INIT_ERR";
/*      */   public static final String PARSER_DTD_SUPPORT_ERR = "PARSER_DTD_SUPPORT_ERR";
/*      */   public static final String NAMESPACES_SUPPORT_ERR = "NAMESPACES_SUPPORT_ERR";
/*      */   public static final String CANT_RESOLVE_RELATIVE_URI_ERR = "CANT_RESOLVE_RELATIVE_URI_ERR";
/*      */   public static final String UNSUPPORTED_XSL_ERR = "UNSUPPORTED_XSL_ERR";
/*      */   public static final String UNSUPPORTED_EXT_ERR = "UNSUPPORTED_EXT_ERR";
/*      */   public static final String UNKNOWN_TRANSLET_VERSION_ERR = "UNKNOWN_TRANSLET_VERSION_ERR";
/*      */   public static final String INVALID_QNAME_ERR = "INVALID_QNAME_ERR";
/*      */   public static final String INVALID_NCNAME_ERR = "INVALID_NCNAME_ERR";
/*      */   public static final String UNALLOWED_EXTENSION_FUNCTION_ERR = "UNALLOWED_EXTENSION_FUNCTION_ERR";
/*      */   public static final String UNALLOWED_EXTENSION_ELEMENT_ERR = "UNALLOWED_EXTENSION_ELEMENT_ERR";
/* 1587 */   private static ResourceBundle m_bundle = SecuritySupport.getResourceBundle(resource);
/*      */   public static final String ERROR_MESSAGES_KEY = "error-messages";
/*      */ 
/*   94 */   public static int countF(DTMAxisIterator iterator) { return iterator.getLast(); }
/*      */ 
/*      */ 
/*      */   /** @deprecated */
/*      */   public static int positionF(DTMAxisIterator iterator)
/*      */   {
/*  103 */     return iterator.isReverse() ? iterator.getLast() - iterator.getPosition() + 1 : iterator.getPosition();
/*      */   }
/*      */ 
/*      */   public static double sumF(DTMAxisIterator iterator, DOM dom)
/*      */   {
/*      */     try
/*      */     {
/*  114 */       double result = 0.0D;
/*      */       int node;
/*  116 */       while ((node = iterator.next()) != -1) {
/*  117 */         result += Double.parseDouble(dom.getStringValueX(node));
/*      */       }
/*  119 */       return result;
/*      */     } catch (NumberFormatException e) {
/*      */     }
/*  122 */     return (0.0D / 0.0D);
/*      */   }
/*      */ 
/*      */   public static String stringF(int node, DOM dom)
/*      */   {
/*  130 */     return dom.getStringValueX(node);
/*      */   }
/*      */ 
/*      */   public static String stringF(Object obj, DOM dom)
/*      */   {
/*  137 */     if ((obj instanceof DTMAxisIterator)) {
/*  138 */       return dom.getStringValueX(((DTMAxisIterator)obj).reset().next());
/*      */     }
/*  140 */     if ((obj instanceof Node)) {
/*  141 */       return dom.getStringValueX(((Node)obj).node);
/*      */     }
/*  143 */     if ((obj instanceof DOM)) {
/*  144 */       return ((DOM)obj).getStringValue();
/*      */     }
/*      */ 
/*  147 */     return obj.toString();
/*      */   }
/*      */ 
/*      */   public static String stringF(Object obj, int node, DOM dom)
/*      */   {
/*  155 */     if ((obj instanceof DTMAxisIterator)) {
/*  156 */       return dom.getStringValueX(((DTMAxisIterator)obj).reset().next());
/*      */     }
/*  158 */     if ((obj instanceof Node)) {
/*  159 */       return dom.getStringValueX(((Node)obj).node);
/*      */     }
/*  161 */     if ((obj instanceof DOM))
/*      */     {
/*  165 */       return ((DOM)obj).getStringValue();
/*      */     }
/*  167 */     if ((obj instanceof Double)) {
/*  168 */       Double d = (Double)obj;
/*  169 */       String result = d.toString();
/*  170 */       int length = result.length();
/*  171 */       if ((result.charAt(length - 2) == '.') && (result.charAt(length - 1) == '0'))
/*      */       {
/*  173 */         return result.substring(0, length - 2);
/*      */       }
/*  175 */       return result;
/*      */     }
/*      */ 
/*  178 */     return obj != null ? obj.toString() : "";
/*      */   }
/*      */ 
/*      */   public static double numberF(int node, DOM dom)
/*      */   {
/*  186 */     return stringToReal(dom.getStringValueX(node));
/*      */   }
/*      */ 
/*      */   public static double numberF(Object obj, DOM dom)
/*      */   {
/*  193 */     if ((obj instanceof Double)) {
/*  194 */       return ((Double)obj).doubleValue();
/*      */     }
/*  196 */     if ((obj instanceof Integer)) {
/*  197 */       return ((Integer)obj).doubleValue();
/*      */     }
/*  199 */     if ((obj instanceof Boolean)) {
/*  200 */       return ((Boolean)obj).booleanValue() ? 1.0D : 0.0D;
/*      */     }
/*  202 */     if ((obj instanceof String)) {
/*  203 */       return stringToReal((String)obj);
/*      */     }
/*  205 */     if ((obj instanceof DTMAxisIterator)) {
/*  206 */       DTMAxisIterator iter = (DTMAxisIterator)obj;
/*  207 */       return stringToReal(dom.getStringValueX(iter.reset().next()));
/*      */     }
/*  209 */     if ((obj instanceof Node)) {
/*  210 */       return stringToReal(dom.getStringValueX(((Node)obj).node));
/*      */     }
/*  212 */     if ((obj instanceof DOM)) {
/*  213 */       return stringToReal(((DOM)obj).getStringValue());
/*      */     }
/*      */ 
/*  216 */     String className = obj.getClass().getName();
/*  217 */     runTimeError("INVALID_ARGUMENT_ERR", className, "number()");
/*  218 */     return 0.0D;
/*      */   }
/*      */ 
/*      */   public static double roundF(double d)
/*      */   {
/*  226 */     return Double.isNaN(d) ? (0.0D / 0.0D) : d == 0.0D ? d : (d < -0.5D) || (d > 0.0D) ? Math.floor(d + 0.5D) : -0.0D;
/*      */   }
/*      */ 
/*      */   public static boolean booleanF(Object obj)
/*      */   {
/*  234 */     if ((obj instanceof Double)) {
/*  235 */       double temp = ((Double)obj).doubleValue();
/*  236 */       return (temp != 0.0D) && (!Double.isNaN(temp));
/*      */     }
/*  238 */     if ((obj instanceof Integer)) {
/*  239 */       return ((Integer)obj).doubleValue() != 0.0D;
/*      */     }
/*  241 */     if ((obj instanceof Boolean)) {
/*  242 */       return ((Boolean)obj).booleanValue();
/*      */     }
/*  244 */     if ((obj instanceof String)) {
/*  245 */       return !((String)obj).equals("");
/*      */     }
/*  247 */     if ((obj instanceof DTMAxisIterator)) {
/*  248 */       DTMAxisIterator iter = (DTMAxisIterator)obj;
/*  249 */       return iter.reset().next() != -1;
/*      */     }
/*  251 */     if ((obj instanceof Node)) {
/*  252 */       return true;
/*      */     }
/*  254 */     if ((obj instanceof DOM)) {
/*  255 */       String temp = ((DOM)obj).getStringValue();
/*  256 */       return !temp.equals("");
/*      */     }
/*      */ 
/*  259 */     String className = obj.getClass().getName();
/*  260 */     runTimeError("INVALID_ARGUMENT_ERR", className, "boolean()");
/*      */ 
/*  262 */     return false;
/*      */   }
/*      */ 
/*      */   public static String substringF(String value, double start)
/*      */   {
/*  270 */     if (Double.isNaN(start)) {
/*  271 */       return "";
/*      */     }
/*  273 */     int strlen = value.length();
/*  274 */     int istart = (int)Math.round(start) - 1;
/*      */ 
/*  276 */     if (istart > strlen)
/*  277 */       return "";
/*  278 */     if (istart < 1)
/*  279 */       istart = 0;
/*      */     try {
/*  281 */       return value.substring(istart);
/*      */     } catch (IndexOutOfBoundsException e) {
/*  283 */       runTimeError("RUN_TIME_INTERNAL_ERR", "substring()");
/*  284 */     }return null;
/*      */   }
/*      */ 
/*      */   public static String substringF(String value, double start, double length)
/*      */   {
/*  293 */     if ((Double.isInfinite(start)) || (Double.isNaN(start)) || (Double.isNaN(length)))
/*      */     {
/*  296 */       return "";
/*      */     }
/*  298 */     int istart = (int)Math.round(start) - 1;
/*      */     int isum;
/*      */     int isum;
/*  300 */     if (Double.isInfinite(length))
/*  301 */       isum = 2147483647;
/*      */     else {
/*  303 */       isum = istart + (int)Math.round(length);
/*      */     }
/*  305 */     int strlen = value.length();
/*  306 */     if ((isum < 0) || (istart > strlen)) {
/*  307 */       return "";
/*      */     }
/*  309 */     if (istart < 0)
/*  310 */       istart = 0;
/*      */     try
/*      */     {
/*  313 */       if (isum > strlen) {
/*  314 */         return value.substring(istart);
/*      */       }
/*  316 */       return value.substring(istart, isum);
/*      */     } catch (IndexOutOfBoundsException e) {
/*  318 */       runTimeError("RUN_TIME_INTERNAL_ERR", "substring()");
/*  319 */     }return null;
/*      */   }
/*      */ 
/*      */   public static String substring_afterF(String value, String substring)
/*      */   {
/*  327 */     int index = value.indexOf(substring);
/*  328 */     if (index >= 0) {
/*  329 */       return value.substring(index + substring.length());
/*      */     }
/*  331 */     return "";
/*      */   }
/*      */ 
/*      */   public static String substring_beforeF(String value, String substring)
/*      */   {
/*  338 */     int index = value.indexOf(substring);
/*  339 */     if (index >= 0) {
/*  340 */       return value.substring(0, index);
/*      */     }
/*  342 */     return "";
/*      */   }
/*      */ 
/*      */   public static String translateF(String value, String from, String to)
/*      */   {
/*  349 */     int tol = to.length();
/*  350 */     int froml = from.length();
/*  351 */     int valuel = value.length();
/*      */ 
/*  353 */     StringBuilder result = (StringBuilder)threadLocalStringBuilder.get();
/*  354 */     result.setLength(0);
/*  355 */     for (int i = 0; i < valuel; i++) {
/*  356 */       char ch = value.charAt(i);
/*  357 */       for (int j = 0; j < froml; j++) {
/*  358 */         if (ch == from.charAt(j)) {
/*  359 */           if (j >= tol) break;
/*  360 */           result.append(to.charAt(j)); break;
/*      */         }
/*      */       }
/*      */ 
/*  364 */       if (j == froml)
/*  365 */         result.append(ch);
/*      */     }
/*  367 */     return result.toString();
/*      */   }
/*      */ 
/*      */   public static String normalize_spaceF(int node, DOM dom)
/*      */   {
/*  374 */     return normalize_spaceF(dom.getStringValueX(node));
/*      */   }
/*      */ 
/*      */   public static String normalize_spaceF(String value)
/*      */   {
/*  381 */     int i = 0; int n = value.length();
/*  382 */     StringBuilder result = (StringBuilder)threadLocalStringBuilder.get();
/*  383 */     result.setLength(0);
/*      */ 
/*  385 */     while ((i < n) && (isWhiteSpace(value.charAt(i)))) {
/*  386 */       i++;
/*      */     }
/*      */     while (true)
/*  389 */       if ((i < n) && (!isWhiteSpace(value.charAt(i)))) {
/*  390 */         result.append(value.charAt(i++));
/*      */       } else {
/*  392 */         if (i == n)
/*      */           break;
/*  394 */         while ((i < n) && (isWhiteSpace(value.charAt(i)))) {
/*  395 */           i++;
/*      */         }
/*  397 */         if (i < n)
/*  398 */           result.append(' ');
/*      */       }
/*  400 */     return result.toString();
/*      */   }
/*      */ 
/*      */   public static String generate_idF(int node)
/*      */   {
/*  407 */     if (node > 0)
/*      */     {
/*  409 */       return "N" + node;
/*      */     }
/*      */ 
/*  412 */     return "";
/*      */   }
/*      */ 
/*      */   public static String getLocalName(String value)
/*      */   {
/*  419 */     int idx = value.lastIndexOf(':');
/*  420 */     if (idx >= 0) value = value.substring(idx + 1);
/*  421 */     idx = value.lastIndexOf('@');
/*  422 */     if (idx >= 0) value = value.substring(idx + 1);
/*  423 */     return value;
/*      */   }
/*      */ 
/*      */   public static void unresolved_externalF(String name)
/*      */   {
/*  436 */     runTimeError("EXTERNAL_FUNC_ERR", name);
/*      */   }
/*      */ 
/*      */   public static void unallowed_extension_functionF(String name)
/*      */   {
/*  444 */     runTimeError("UNALLOWED_EXTENSION_FUNCTION_ERR", name);
/*      */   }
/*      */ 
/*      */   public static void unallowed_extension_elementF(String name)
/*      */   {
/*  452 */     runTimeError("UNALLOWED_EXTENSION_ELEMENT_ERR", name);
/*      */   }
/*      */ 
/*      */   public static void unsupported_ElementF(String qname, boolean isExtension)
/*      */   {
/*  463 */     if (isExtension)
/*  464 */       runTimeError("UNSUPPORTED_EXT_ERR", qname);
/*      */     else
/*  466 */       runTimeError("UNSUPPORTED_XSL_ERR", qname);
/*      */   }
/*      */ 
/*      */   public static String namespace_uriF(DTMAxisIterator iter, DOM dom)
/*      */   {
/*  473 */     return namespace_uriF(iter.next(), dom);
/*      */   }
/*      */ 
/*      */   public static String system_propertyF(String name)
/*      */   {
/*  480 */     if (name.equals("xsl:version"))
/*  481 */       return "1.0";
/*  482 */     if (name.equals("xsl:vendor"))
/*  483 */       return "Apache Software Foundation (Xalan XSLTC)";
/*  484 */     if (name.equals("xsl:vendor-url")) {
/*  485 */       return "http://xml.apache.org/xalan-j";
/*      */     }
/*  487 */     runTimeError("INVALID_ARGUMENT_ERR", name, "system-property()");
/*  488 */     return "";
/*      */   }
/*      */ 
/*      */   public static String namespace_uriF(int node, DOM dom)
/*      */   {
/*  495 */     String value = dom.getNodeName(node);
/*  496 */     int colon = value.lastIndexOf(':');
/*  497 */     if (colon >= 0) {
/*  498 */       return value.substring(0, colon);
/*      */     }
/*  500 */     return "";
/*      */   }
/*      */ 
/*      */   public static String objectTypeF(Object obj)
/*      */   {
/*  510 */     if ((obj instanceof String))
/*  511 */       return "string";
/*  512 */     if ((obj instanceof Boolean))
/*  513 */       return "boolean";
/*  514 */     if ((obj instanceof Number))
/*  515 */       return "number";
/*  516 */     if ((obj instanceof DOM))
/*  517 */       return "RTF";
/*  518 */     if ((obj instanceof DTMAxisIterator)) {
/*  519 */       return "node-set";
/*      */     }
/*  521 */     return "unknown";
/*      */   }
/*      */ 
/*      */   public static DTMAxisIterator nodesetF(Object obj)
/*      */   {
/*  528 */     if ((obj instanceof DOM))
/*      */     {
/*  530 */       DOM dom = (DOM)obj;
/*  531 */       return new SingletonIterator(dom.getDocument(), true);
/*      */     }
/*  533 */     if ((obj instanceof DTMAxisIterator)) {
/*  534 */       return (DTMAxisIterator)obj;
/*      */     }
/*      */ 
/*  537 */     String className = obj.getClass().getName();
/*  538 */     runTimeError("DATA_CONVERSION_ERR", "node-set", className);
/*  539 */     return null;
/*      */   }
/*      */ 
/*      */   private static boolean isWhiteSpace(char ch)
/*      */   {
/*  546 */     return (ch == ' ') || (ch == '\t') || (ch == '\n') || (ch == '\r');
/*      */   }
/*      */ 
/*      */   private static boolean compareStrings(String lstring, String rstring, int op, DOM dom)
/*      */   {
/*  551 */     switch (op) {
/*      */     case 0:
/*  553 */       return lstring.equals(rstring);
/*      */     case 1:
/*  556 */       return !lstring.equals(rstring);
/*      */     case 2:
/*  559 */       return numberF(lstring, dom) > numberF(rstring, dom);
/*      */     case 3:
/*  562 */       return numberF(lstring, dom) < numberF(rstring, dom);
/*      */     case 4:
/*  565 */       return numberF(lstring, dom) >= numberF(rstring, dom);
/*      */     case 5:
/*  568 */       return numberF(lstring, dom) <= numberF(rstring, dom);
/*      */     }
/*      */ 
/*  571 */     runTimeError("RUN_TIME_INTERNAL_ERR", "compare()");
/*  572 */     return false;
/*      */   }
/*      */ 
/*      */   public static boolean compare(DTMAxisIterator left, DTMAxisIterator right, int op, DOM dom)
/*      */   {
/*  582 */     left.reset();
/*      */     int lnode;
/*  584 */     while ((lnode = left.next()) != -1) {
/*  585 */       String lvalue = dom.getStringValueX(lnode);
/*      */ 
/*  588 */       right.reset();
/*      */       int rnode;
/*  589 */       while ((rnode = right.next()) != -1)
/*      */       {
/*  591 */         if (lnode == rnode) {
/*  592 */           if (op == 0)
/*  593 */             return true;
/*  594 */           if (op == 1) {
/*      */             break;
/*      */           }
/*      */         }
/*  598 */         else if (compareStrings(lvalue, dom.getStringValueX(rnode), op, dom))
/*      */         {
/*  600 */           return true;
/*      */         }
/*      */       }
/*      */     }
/*  604 */     return false;
/*      */   }
/*      */ 
/*      */   public static boolean compare(int node, DTMAxisIterator iterator, int op, DOM dom)
/*      */   {
/*      */     int rnode;
/*      */     String value;
/*  614 */     switch (op) {
/*      */     case 0:
/*  616 */       rnode = iterator.next();
/*  617 */       if (rnode != -1) {
/*  618 */         value = dom.getStringValueX(node);
/*      */         do
/*  620 */           if ((node == rnode) || (value.equals(dom.getStringValueX(rnode))))
/*      */           {
/*  622 */             return true;
/*      */           }
/*  624 */         while ((rnode = iterator.next()) != -1); } break;
/*      */     case 1:
/*  628 */       rnode = iterator.next();
/*  629 */       if (rnode != -1) {
/*  630 */         value = dom.getStringValueX(node);
/*      */         do
/*  632 */           if ((node != rnode) && (!value.equals(dom.getStringValueX(rnode))))
/*      */           {
/*  634 */             return true;
/*      */           }
/*  636 */         while ((rnode = iterator.next()) != -1); } break;
/*      */     case 3:
/*      */     case 2:
/*  641 */       while ((rnode = iterator.next()) != -1) {
/*  642 */         if (rnode > node) { return true;
/*      */ 
/*  647 */           while ((rnode = iterator.next()) != -1)
/*  648 */             if (rnode < node) return true;
/*      */         }
/*      */       }
/*      */     }
/*  652 */     return false;
/*      */   }
/*      */ 
/*      */   public static boolean compare(DTMAxisIterator left, double rnumber, int op, DOM dom)
/*      */   {
/*  663 */     switch (op)
/*      */     {
/*      */     case 0:
/*      */     case 1:
/*      */     case 2:
/*      */     case 3:
/*      */     case 4:
/*      */     case 5:
/*      */     }
/*      */     int node;
/*  665 */     while ((node = left.next()) != -1)
/*  666 */       if (numberF(dom.getStringValueX(node), dom) == rnumber) {
/*  667 */         return true;
/*      */ 
/*  672 */         while ((node = left.next()) != -1)
/*  673 */           if (numberF(dom.getStringValueX(node), dom) != rnumber) {
/*  674 */             return true;
/*      */ 
/*  679 */             while ((node = left.next()) != -1)
/*  680 */               if (numberF(dom.getStringValueX(node), dom) > rnumber) {
/*  681 */                 return true;
/*      */ 
/*  686 */                 while ((node = left.next()) != -1)
/*  687 */                   if (numberF(dom.getStringValueX(node), dom) < rnumber) {
/*  688 */                     return true;
/*      */ 
/*  693 */                     while ((node = left.next()) != -1)
/*  694 */                       if (numberF(dom.getStringValueX(node), dom) >= rnumber) {
/*  695 */                         return true;
/*      */ 
/*  700 */                         while ((node = left.next()) != -1)
/*  701 */                           if (numberF(dom.getStringValueX(node), dom) <= rnumber) {
/*  702 */                             return true;
/*      */ 
/*  707 */                             runTimeError("RUN_TIME_INTERNAL_ERR", "compare()");
/*      */                           } 
/*      */                       } 
/*      */                   }
/*      */               }
/*      */           }
/*      */       }
/*  710 */     return false;
/*      */   }
/*      */ 
/*      */   public static boolean compare(DTMAxisIterator left, String rstring, int op, DOM dom)
/*      */   {
/*      */     int node;
/*  720 */     while ((node = left.next()) != -1) {
/*  721 */       if (compareStrings(dom.getStringValueX(node), rstring, op, dom)) {
/*  722 */         return true;
/*      */       }
/*      */     }
/*  725 */     return false;
/*      */   }
/*      */ 
/*      */   public static boolean compare(Object left, Object right, int op, DOM dom)
/*      */   {
/*  732 */     boolean result = false;
/*  733 */     boolean hasSimpleArgs = (hasSimpleType(left)) && (hasSimpleType(right));
/*      */ 
/*  735 */     if ((op != 0) && (op != 1))
/*      */     {
/*  737 */       if (((left instanceof Node)) || ((right instanceof Node))) {
/*  738 */         if ((left instanceof Boolean)) {
/*  739 */           right = new Boolean(booleanF(right));
/*  740 */           hasSimpleArgs = true;
/*      */         }
/*  742 */         if ((right instanceof Boolean)) {
/*  743 */           left = new Boolean(booleanF(left));
/*  744 */           hasSimpleArgs = true;
/*      */         }
/*      */       }
/*      */ 
/*  748 */       if (hasSimpleArgs) {
/*  749 */         switch (op) {
/*      */         case 2:
/*  751 */           return numberF(left, dom) > numberF(right, dom);
/*      */         case 3:
/*  754 */           return numberF(left, dom) < numberF(right, dom);
/*      */         case 4:
/*  757 */           return numberF(left, dom) >= numberF(right, dom);
/*      */         case 5:
/*  760 */           return numberF(left, dom) <= numberF(right, dom);
/*      */         }
/*      */ 
/*  763 */         runTimeError("RUN_TIME_INTERNAL_ERR", "compare()");
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  769 */     if (hasSimpleArgs) {
/*  770 */       if (((left instanceof Boolean)) || ((right instanceof Boolean))) {
/*  771 */         result = booleanF(left) == booleanF(right);
/*      */       }
/*  773 */       else if (((left instanceof Double)) || ((right instanceof Double)) || ((left instanceof Integer)) || ((right instanceof Integer)))
/*      */       {
/*  775 */         result = numberF(left, dom) == numberF(right, dom);
/*      */       }
/*      */       else {
/*  778 */         result = stringF(left, dom).equals(stringF(right, dom));
/*      */       }
/*      */ 
/*  781 */       if (op == 1)
/*  782 */         result = !result;
/*      */     }
/*      */     else
/*      */     {
/*  786 */       if ((left instanceof Node)) {
/*  787 */         left = new SingletonIterator(((Node)left).node);
/*      */       }
/*  789 */       if ((right instanceof Node)) {
/*  790 */         right = new SingletonIterator(((Node)right).node);
/*      */       }
/*      */ 
/*  793 */       if ((hasSimpleType(left)) || (((left instanceof DOM)) && ((right instanceof DTMAxisIterator))))
/*      */       {
/*  796 */         Object temp = right; right = left; left = temp;
/*  797 */         op = Operators.swapOp(op);
/*      */       }
/*      */ 
/*  800 */       if ((left instanceof DOM)) {
/*  801 */         if ((right instanceof Boolean)) {
/*  802 */           result = ((Boolean)right).booleanValue();
/*  803 */           return result == (op == 0);
/*      */         }
/*      */ 
/*  806 */         String sleft = ((DOM)left).getStringValue();
/*      */ 
/*  808 */         if ((right instanceof Number)) {
/*  809 */           result = ((Number)right).doubleValue() == stringToReal(sleft);
/*      */         }
/*  812 */         else if ((right instanceof String)) {
/*  813 */           result = sleft.equals((String)right);
/*      */         }
/*  815 */         else if ((right instanceof DOM)) {
/*  816 */           result = sleft.equals(((DOM)right).getStringValue());
/*      */         }
/*      */ 
/*  819 */         if (op == 1) {
/*  820 */           result = !result;
/*      */         }
/*  822 */         return result;
/*      */       }
/*      */ 
/*  827 */       DTMAxisIterator iter = ((DTMAxisIterator)left).reset();
/*      */ 
/*  829 */       if ((right instanceof DTMAxisIterator)) {
/*  830 */         result = compare(iter, (DTMAxisIterator)right, op, dom);
/*      */       }
/*  832 */       else if ((right instanceof String)) {
/*  833 */         result = compare(iter, (String)right, op, dom);
/*      */       }
/*  835 */       else if ((right instanceof Number)) {
/*  836 */         double temp = ((Number)right).doubleValue();
/*  837 */         result = compare(iter, temp, op, dom);
/*      */       }
/*  839 */       else if ((right instanceof Boolean)) {
/*  840 */         boolean temp = ((Boolean)right).booleanValue();
/*  841 */         result = (iter.reset().next() != -1) == temp;
/*      */       }
/*  843 */       else if ((right instanceof DOM)) {
/*  844 */         result = compare(iter, ((DOM)right).getStringValue(), op, dom);
/*      */       }
/*      */       else {
/*  847 */         if (right == null) {
/*  848 */           return false;
/*      */         }
/*      */ 
/*  851 */         String className = right.getClass().getName();
/*  852 */         runTimeError("INVALID_ARGUMENT_ERR", className, "compare()");
/*      */       }
/*      */     }
/*  855 */     return result;
/*      */   }
/*      */ 
/*      */   public static boolean testLanguage(String testLang, DOM dom, int node)
/*      */   {
/*  863 */     String nodeLang = dom.getLanguage(node);
/*  864 */     if (nodeLang == null) {
/*  865 */       return false;
/*      */     }
/*  867 */     nodeLang = nodeLang.toLowerCase();
/*      */ 
/*  870 */     testLang = testLang.toLowerCase();
/*  871 */     if (testLang.length() == 2) {
/*  872 */       return nodeLang.startsWith(testLang);
/*      */     }
/*      */ 
/*  875 */     return nodeLang.equals(testLang);
/*      */   }
/*      */ 
/*      */   private static boolean hasSimpleType(Object obj)
/*      */   {
/*  880 */     return ((obj instanceof Boolean)) || ((obj instanceof Double)) || ((obj instanceof Integer)) || ((obj instanceof String)) || ((obj instanceof Node)) || ((obj instanceof DOM));
/*      */   }
/*      */ 
/*      */   public static double stringToReal(String s)
/*      */   {
/*      */     try
/*      */     {
/*  890 */       return Double.valueOf(s).doubleValue();
/*      */     } catch (NumberFormatException e) {
/*      */     }
/*  893 */     return (0.0D / 0.0D);
/*      */   }
/*      */ 
/*      */   public static int stringToInt(String s)
/*      */   {
/*      */     try
/*      */     {
/*  902 */       return Integer.parseInt(s);
/*      */     } catch (NumberFormatException e) {
/*      */     }
/*  905 */     return -1;
/*      */   }
/*      */ 
/*      */   public static String realToString(double d)
/*      */   {
/*  943 */     double m = Math.abs(d);
/*  944 */     if ((m >= 0.001D) && (m < 10000000.0D)) {
/*  945 */       String result = Double.toString(d);
/*  946 */       int length = result.length();
/*      */ 
/*  948 */       if ((result.charAt(length - 2) == '.') && (result.charAt(length - 1) == '0'))
/*      */       {
/*  950 */         return result.substring(0, length - 2);
/*      */       }
/*  952 */       return result;
/*      */     }
/*      */ 
/*  955 */     if ((Double.isNaN(d)) || (Double.isInfinite(d))) {
/*  956 */       return Double.toString(d);
/*      */     }
/*      */ 
/*  959 */     StringBuffer result = (StringBuffer)threadLocalStringBuffer.get();
/*  960 */     result.setLength(0);
/*  961 */     xpathFormatter.format(d, result, _fieldPosition);
/*  962 */     return result.toString();
/*      */   }
/*      */ 
/*      */   public static int realToInt(double d)
/*      */   {
/*  970 */     return (int)d;
/*      */   }
/*      */ 
/*      */   public static String formatNumber(double number, String pattern, DecimalFormat formatter)
/*      */   {
/*  983 */     if (formatter == null)
/*  984 */       formatter = defaultFormatter;
/*      */     try
/*      */     {
/*  987 */       StringBuffer result = (StringBuffer)threadLocalStringBuffer.get();
/*  988 */       result.setLength(0);
/*  989 */       if (pattern != defaultPattern) {
/*  990 */         formatter.applyLocalizedPattern(pattern);
/*      */       }
/*  992 */       formatter.format(number, result, _fieldPosition);
/*  993 */       return result.toString();
/*      */     }
/*      */     catch (IllegalArgumentException e) {
/*  996 */       runTimeError("FORMAT_NUMBER_ERR", Double.toString(number), pattern);
/*  997 */     }return "";
/*      */   }
/*      */ 
/*      */   public static DTMAxisIterator referenceToNodeSet(Object obj)
/*      */   {
/* 1007 */     if ((obj instanceof Node)) {
/* 1008 */       return new SingletonIterator(((Node)obj).node);
/*      */     }
/*      */ 
/* 1011 */     if ((obj instanceof DTMAxisIterator)) {
/* 1012 */       return ((DTMAxisIterator)obj).cloneIterator().reset();
/*      */     }
/*      */ 
/* 1015 */     String className = obj.getClass().getName();
/* 1016 */     runTimeError("DATA_CONVERSION_ERR", className, "node-set");
/* 1017 */     return null;
/*      */   }
/*      */ 
/*      */   public static NodeList referenceToNodeList(Object obj, DOM dom)
/*      */   {
/* 1025 */     if (((obj instanceof Node)) || ((obj instanceof DTMAxisIterator))) {
/* 1026 */       DTMAxisIterator iter = referenceToNodeSet(obj);
/* 1027 */       return dom.makeNodeList(iter);
/*      */     }
/* 1029 */     if ((obj instanceof DOM)) {
/* 1030 */       dom = (DOM)obj;
/* 1031 */       return dom.makeNodeList(0);
/*      */     }
/*      */ 
/* 1034 */     String className = obj.getClass().getName();
/* 1035 */     runTimeError("DATA_CONVERSION_ERR", className, "org.w3c.dom.NodeList");
/*      */ 
/* 1037 */     return null;
/*      */   }
/*      */ 
/*      */   public static org.w3c.dom.Node referenceToNode(Object obj, DOM dom)
/*      */   {
/* 1045 */     if (((obj instanceof Node)) || ((obj instanceof DTMAxisIterator))) {
/* 1046 */       DTMAxisIterator iter = referenceToNodeSet(obj);
/* 1047 */       return dom.makeNode(iter);
/*      */     }
/* 1049 */     if ((obj instanceof DOM)) {
/* 1050 */       dom = (DOM)obj;
/* 1051 */       DTMAxisIterator iter = dom.getChildren(0);
/* 1052 */       return dom.makeNode(iter);
/*      */     }
/*      */ 
/* 1055 */     String className = obj.getClass().getName();
/* 1056 */     runTimeError("DATA_CONVERSION_ERR", className, "org.w3c.dom.Node");
/* 1057 */     return null;
/*      */   }
/*      */ 
/*      */   public static long referenceToLong(Object obj)
/*      */   {
/* 1065 */     if ((obj instanceof Number)) {
/* 1066 */       return ((Number)obj).longValue();
/*      */     }
/*      */ 
/* 1069 */     String className = obj.getClass().getName();
/* 1070 */     runTimeError("DATA_CONVERSION_ERR", className, Long.TYPE);
/* 1071 */     return 0L;
/*      */   }
/*      */ 
/*      */   public static double referenceToDouble(Object obj)
/*      */   {
/* 1079 */     if ((obj instanceof Number)) {
/* 1080 */       return ((Number)obj).doubleValue();
/*      */     }
/*      */ 
/* 1083 */     String className = obj.getClass().getName();
/* 1084 */     runTimeError("DATA_CONVERSION_ERR", className, Double.TYPE);
/* 1085 */     return 0.0D;
/*      */   }
/*      */ 
/*      */   public static boolean referenceToBoolean(Object obj)
/*      */   {
/* 1093 */     if ((obj instanceof Boolean)) {
/* 1094 */       return ((Boolean)obj).booleanValue();
/*      */     }
/*      */ 
/* 1097 */     String className = obj.getClass().getName();
/* 1098 */     runTimeError("DATA_CONVERSION_ERR", className, Boolean.TYPE);
/* 1099 */     return false;
/*      */   }
/*      */ 
/*      */   public static String referenceToString(Object obj, DOM dom)
/*      */   {
/* 1107 */     if ((obj instanceof String)) {
/* 1108 */       return (String)obj;
/*      */     }
/* 1110 */     if ((obj instanceof DTMAxisIterator)) {
/* 1111 */       return dom.getStringValueX(((DTMAxisIterator)obj).reset().next());
/*      */     }
/* 1113 */     if ((obj instanceof Node)) {
/* 1114 */       return dom.getStringValueX(((Node)obj).node);
/*      */     }
/* 1116 */     if ((obj instanceof DOM)) {
/* 1117 */       return ((DOM)obj).getStringValue();
/*      */     }
/*      */ 
/* 1120 */     String className = obj.getClass().getName();
/* 1121 */     runTimeError("DATA_CONVERSION_ERR", className, String.class);
/* 1122 */     return null;
/*      */   }
/*      */ 
/*      */   public static DTMAxisIterator node2Iterator(org.w3c.dom.Node node, Translet translet, DOM dom)
/*      */   {
/* 1132 */     org.w3c.dom.Node inNode = node;
/*      */ 
/* 1135 */     NodeList nodelist = new NodeList() {
/*      */       public int getLength() {
/* 1137 */         return 1;
/*      */       }
/*      */ 
/*      */       public org.w3c.dom.Node item(int index) {
/* 1141 */         if (index == 0) {
/* 1142 */           return this.val$inNode;
/*      */         }
/* 1144 */         return null;
/*      */       }
/*      */     };
/* 1148 */     return nodeList2Iterator(nodelist, translet, dom);
/*      */   }
/*      */ 
/*      */   private static DTMAxisIterator nodeList2IteratorUsingHandleFromNode(NodeList nodeList, Translet translet, DOM dom)
/*      */   {
/* 1164 */     int n = nodeList.getLength();
/* 1165 */     int[] dtmHandles = new int[n];
/* 1166 */     DTMManager dtmManager = null;
/* 1167 */     if ((dom instanceof MultiDOM))
/* 1168 */       dtmManager = ((MultiDOM)dom).getDTMManager();
/* 1169 */     for (int i = 0; i < n; i++) {
/* 1170 */       org.w3c.dom.Node node = nodeList.item(i);
/*      */       int handle;
/* 1172 */       if (dtmManager != null) {
/* 1173 */         handle = dtmManager.getDTMHandleFromNode(node);
/*      */       }
/*      */       else
/*      */       {
/*      */         int handle;
/* 1175 */         if (((node instanceof DTMNodeProxy)) && (((DTMNodeProxy)node).getDTM() == dom))
/*      */         {
/* 1177 */           handle = ((DTMNodeProxy)node).getDTMNodeNumber();
/*      */         }
/*      */         else {
/* 1180 */           runTimeError("RUN_TIME_INTERNAL_ERR", "need MultiDOM");
/* 1181 */           return null;
/*      */         }
/*      */       }
/*      */       int handle;
/* 1183 */       dtmHandles[i] = handle;
/* 1184 */       System.out.println("Node " + i + " has handle 0x" + Integer.toString(handle, 16));
/*      */     }
/*      */ 
/* 1187 */     return new ArrayNodeListIterator(dtmHandles);
/*      */   }
/*      */ 
/*      */   public static DTMAxisIterator nodeList2Iterator(NodeList nodeList, Translet translet, DOM dom)
/*      */   {
/* 1203 */     int n = 0;
/* 1204 */     Document doc = null;
/* 1205 */     DTMManager dtmManager = null;
/* 1206 */     int[] proxyNodes = new int[nodeList.getLength()];
/* 1207 */     if ((dom instanceof MultiDOM))
/* 1208 */       dtmManager = ((MultiDOM)dom).getDTMManager();
/* 1209 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 1210 */       org.w3c.dom.Node node = nodeList.item(i);
/* 1211 */       if ((node instanceof DTMNodeProxy)) {
/* 1212 */         DTMNodeProxy proxy = (DTMNodeProxy)node;
/* 1213 */         DTM nodeDTM = proxy.getDTM();
/* 1214 */         int handle = proxy.getDTMNodeNumber();
/* 1215 */         boolean isOurDOM = nodeDTM == dom;
/* 1216 */         if ((!isOurDOM) && (dtmManager != null)) {
/*      */           try {
/* 1218 */             isOurDOM = nodeDTM == dtmManager.getDTM(handle);
/*      */           }
/*      */           catch (ArrayIndexOutOfBoundsException e)
/*      */           {
/*      */           }
/*      */         }
/* 1224 */         if (isOurDOM) {
/* 1225 */           proxyNodes[i] = handle;
/* 1226 */           n++;
/* 1227 */           continue;
/*      */         }
/*      */       }
/* 1230 */       proxyNodes[i] = -1;
/* 1231 */       int nodeType = node.getNodeType();
/* 1232 */       if (doc == null) {
/* 1233 */         if (!(dom instanceof MultiDOM)) {
/* 1234 */           runTimeError("RUN_TIME_INTERNAL_ERR", "need MultiDOM");
/* 1235 */           return null;
/*      */         }
/*      */         try {
/* 1238 */           AbstractTranslet at = (AbstractTranslet)translet;
/* 1239 */           doc = at.newDocument("", "__top__");
/*      */         }
/*      */         catch (ParserConfigurationException e) {
/* 1242 */           runTimeError("RUN_TIME_INTERNAL_ERR", e.getMessage());
/* 1243 */           return null;
/*      */         }
/*      */       }
/*      */       Element mid;
/* 1251 */       switch (nodeType) {
/*      */       case 1:
/*      */       case 3:
/*      */       case 4:
/*      */       case 5:
/*      */       case 7:
/*      */       case 8:
/* 1258 */         mid = doc.createElementNS(null, "__dummy__");
/* 1259 */         mid.appendChild(doc.importNode(node, true));
/* 1260 */         doc.getDocumentElement().appendChild(mid);
/* 1261 */         n++;
/* 1262 */         break;
/*      */       case 2:
/* 1267 */         mid = doc.createElementNS(null, "__dummy__");
/* 1268 */         mid.setAttributeNodeNS((Attr)doc.importNode(node, true));
/* 1269 */         doc.getDocumentElement().appendChild(mid);
/* 1270 */         n++;
/* 1271 */         break;
/*      */       case 6:
/*      */       default:
/* 1275 */         runTimeError("RUN_TIME_INTERNAL_ERR", "Don't know how to convert node type " + nodeType);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1282 */     DTMAxisIterator iter = null; DTMAxisIterator childIter = null; DTMAxisIterator attrIter = null;
/* 1283 */     if (doc != null) {
/* 1284 */       MultiDOM multiDOM = (MultiDOM)dom;
/* 1285 */       DOM idom = (DOM)dtmManager.getDTM(new DOMSource(doc), false, null, true, false);
/*      */ 
/* 1288 */       DOMAdapter domAdapter = new DOMAdapter(idom, translet.getNamesArray(), translet.getUrisArray(), translet.getTypesArray(), translet.getNamespaceArray());
/*      */ 
/* 1293 */       multiDOM.addDOMAdapter(domAdapter);
/*      */ 
/* 1295 */       DTMAxisIterator iter1 = idom.getAxisIterator(3);
/* 1296 */       DTMAxisIterator iter2 = idom.getAxisIterator(3);
/* 1297 */       iter = new AbsoluteIterator(new StepIterator(iter1, iter2));
/*      */ 
/* 1300 */       iter.setStartNode(0);
/*      */ 
/* 1302 */       childIter = idom.getAxisIterator(3);
/* 1303 */       attrIter = idom.getAxisIterator(2);
/*      */     }
/*      */ 
/* 1307 */     int[] dtmHandles = new int[n];
/* 1308 */     n = 0;
/* 1309 */     for (int i = 0; i < nodeList.getLength(); i++)
/* 1310 */       if (proxyNodes[i] != -1) {
/* 1311 */         dtmHandles[(n++)] = proxyNodes[i];
/*      */       }
/*      */       else {
/* 1314 */         org.w3c.dom.Node node = nodeList.item(i);
/* 1315 */         DTMAxisIterator iter3 = null;
/* 1316 */         int nodeType = node.getNodeType();
/* 1317 */         switch (nodeType) {
/*      */         case 1:
/*      */         case 3:
/*      */         case 4:
/*      */         case 5:
/*      */         case 7:
/*      */         case 8:
/* 1324 */           iter3 = childIter;
/* 1325 */           break;
/*      */         case 2:
/* 1327 */           iter3 = attrIter;
/* 1328 */           break;
/*      */         case 6:
/*      */         default:
/* 1331 */           throw new InternalRuntimeError("Mismatched cases");
/*      */         }
/* 1333 */         if (iter3 != null) {
/* 1334 */           iter3.setStartNode(iter.next());
/* 1335 */           dtmHandles[n] = iter3.next();
/*      */ 
/* 1337 */           if (dtmHandles[n] == -1)
/* 1338 */             throw new InternalRuntimeError("Expected element missing at " + i);
/* 1339 */           if (iter3.next() != -1)
/* 1340 */             throw new InternalRuntimeError("Too many elements at " + i);
/* 1341 */           n++;
/*      */         }
/*      */       }
/* 1344 */     if (n != dtmHandles.length) {
/* 1345 */       throw new InternalRuntimeError("Nodes lost in second pass");
/*      */     }
/* 1347 */     return new ArrayNodeListIterator(dtmHandles);
/*      */   }
/*      */ 
/*      */   public static DOM referenceToResultTree(Object obj)
/*      */   {
/*      */     try
/*      */     {
/* 1355 */       return (DOM)obj;
/*      */     }
/*      */     catch (IllegalArgumentException e) {
/* 1358 */       String className = obj.getClass().getName();
/* 1359 */       runTimeError("DATA_CONVERSION_ERR", "reference", className);
/* 1360 */     }return null;
/*      */   }
/*      */ 
/*      */   public static DTMAxisIterator getSingleNode(DTMAxisIterator iterator)
/*      */   {
/* 1369 */     int node = iterator.next();
/* 1370 */     return new SingletonIterator(node);
/*      */   }
/*      */ 
/*      */   public static void copy(Object obj, SerializationHandler handler, int node, DOM dom)
/*      */   {
/*      */     try
/*      */     {
/* 1383 */       if ((obj instanceof DTMAxisIterator))
/*      */       {
/* 1385 */         DTMAxisIterator iter = (DTMAxisIterator)obj;
/* 1386 */         dom.copy(iter.reset(), handler);
/*      */       }
/* 1388 */       else if ((obj instanceof Node)) {
/* 1389 */         dom.copy(((Node)obj).node, handler);
/*      */       }
/* 1391 */       else if ((obj instanceof DOM))
/*      */       {
/* 1393 */         DOM newDom = (DOM)obj;
/* 1394 */         newDom.copy(newDom.getDocument(), handler);
/*      */       }
/*      */       else {
/* 1397 */         String string = obj.toString();
/* 1398 */         int length = string.length();
/* 1399 */         if (length > _characterArray.length)
/* 1400 */           _characterArray = new char[length];
/* 1401 */         string.getChars(0, length, _characterArray, 0);
/* 1402 */         handler.characters(_characterArray, 0, length);
/*      */       }
/*      */     }
/*      */     catch (SAXException e) {
/* 1406 */       runTimeError("RUN_TIME_COPY_ERR");
/*      */     }
/*      */   }
/*      */ 
/*      */   public static void checkAttribQName(String name)
/*      */   {
/* 1415 */     int firstOccur = name.indexOf(":");
/* 1416 */     int lastOccur = name.lastIndexOf(":");
/* 1417 */     String localName = name.substring(lastOccur + 1);
/*      */ 
/* 1419 */     if (firstOccur > 0) {
/* 1420 */       String newPrefix = name.substring(0, firstOccur);
/*      */ 
/* 1422 */       if (firstOccur != lastOccur) {
/* 1423 */         String oriPrefix = name.substring(firstOccur + 1, lastOccur);
/* 1424 */         if (!XML11Char.isXML11ValidNCName(oriPrefix))
/*      */         {
/* 1426 */           runTimeError("INVALID_QNAME_ERR", oriPrefix + ":" + localName);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1431 */       if (!XML11Char.isXML11ValidNCName(newPrefix)) {
/* 1432 */         runTimeError("INVALID_QNAME_ERR", newPrefix + ":" + localName);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1437 */     if ((!XML11Char.isXML11ValidNCName(localName)) || (localName.equals("xmlns")))
/* 1438 */       runTimeError("INVALID_QNAME_ERR", localName);
/*      */   }
/*      */ 
/*      */   public static void checkNCName(String name)
/*      */   {
/* 1447 */     if (!XML11Char.isXML11ValidNCName(name))
/* 1448 */       runTimeError("INVALID_NCNAME_ERR", name);
/*      */   }
/*      */ 
/*      */   public static void checkQName(String name)
/*      */   {
/* 1457 */     if (!XML11Char.isXML11ValidQName(name))
/* 1458 */       runTimeError("INVALID_QNAME_ERR", name);
/*      */   }
/*      */ 
/*      */   public static String startXslElement(String qname, String namespace, SerializationHandler handler, DOM dom, int node)
/*      */   {
/*      */     try
/*      */     {
/* 1471 */       int index = qname.indexOf(':');
/*      */ 
/* 1473 */       if (index > 0) {
/* 1474 */         String prefix = qname.substring(0, index);
/*      */ 
/* 1477 */         if ((namespace == null) || (namespace.length() == 0)) {
/*      */           try
/*      */           {
/* 1480 */             namespace = dom.lookupNamespace(node, prefix);
/*      */           }
/*      */           catch (RuntimeException e) {
/* 1483 */             handler.flushPending();
/* 1484 */             NamespaceMappings nm = handler.getNamespaceMappings();
/* 1485 */             namespace = nm.lookupNamespace(prefix);
/* 1486 */             if (namespace == null) {
/* 1487 */               runTimeError("NAMESPACE_PREFIX_ERR", prefix);
/*      */             }
/*      */           }
/*      */         }
/*      */ 
/* 1492 */         handler.startElement(namespace, qname.substring(index + 1), qname);
/*      */ 
/* 1494 */         handler.namespaceAfterStartElement(prefix, namespace);
/*      */       }
/* 1498 */       else if ((namespace != null) && (namespace.length() > 0)) {
/* 1499 */         String prefix = generatePrefix();
/* 1500 */         qname = prefix + ':' + qname;
/* 1501 */         handler.startElement(namespace, qname, qname);
/* 1502 */         handler.namespaceAfterStartElement(prefix, namespace);
/*      */       }
/*      */       else {
/* 1505 */         handler.startElement(null, null, qname);
/*      */       }
/*      */     }
/*      */     catch (SAXException e)
/*      */     {
/* 1510 */       throw new RuntimeException(e.getMessage());
/*      */     }
/*      */ 
/* 1513 */     return qname;
/*      */   }
/*      */ 
/*      */   public static String getPrefix(String qname)
/*      */   {
/* 1520 */     int index = qname.indexOf(':');
/* 1521 */     return index > 0 ? qname.substring(0, index) : null;
/*      */   }
/*      */ 
/*      */   public static String generatePrefix()
/*      */   {
/* 1530 */     synchronized (BasisLibrary.class) {
/* 1531 */       return "ns" + prefixIndex++;
/*      */     }
/*      */   }
/*      */ 
/*      */   public static void runTimeError(String code)
/*      */   {
/* 1594 */     throw new RuntimeException(m_bundle.getString(code));
/*      */   }
/*      */ 
/*      */   public static void runTimeError(String code, Object[] args) {
/* 1598 */     String message = MessageFormat.format(m_bundle.getString(code), args);
/*      */ 
/* 1600 */     throw new RuntimeException(message);
/*      */   }
/*      */ 
/*      */   public static void runTimeError(String code, Object arg0) {
/* 1604 */     runTimeError(code, new Object[] { arg0 });
/*      */   }
/*      */ 
/*      */   public static void runTimeError(String code, Object arg0, Object arg1) {
/* 1608 */     runTimeError(code, new Object[] { arg0, arg1 });
/*      */   }
/*      */ 
/*      */   public static void consoleOutput(String msg) {
/* 1612 */     System.out.println(msg);
/*      */   }
/*      */ 
/*      */   public static String replace(String base, char ch, String str)
/*      */   {
/* 1619 */     return base.indexOf(ch) < 0 ? base : replace(base, String.valueOf(ch), new String[] { str });
/*      */   }
/*      */ 
/*      */   public static String replace(String base, String delim, String[] str)
/*      */   {
/* 1624 */     int len = base.length();
/* 1625 */     StringBuilder result = (StringBuilder)threadLocalStringBuilder.get();
/* 1626 */     result.setLength(0);
/*      */ 
/* 1628 */     for (int i = 0; i < len; i++) {
/* 1629 */       char ch = base.charAt(i);
/* 1630 */       int k = delim.indexOf(ch);
/*      */ 
/* 1632 */       if (k >= 0) {
/* 1633 */         result.append(str[k]);
/*      */       }
/*      */       else {
/* 1636 */         result.append(ch);
/*      */       }
/*      */     }
/* 1639 */     return result.toString();
/*      */   }
/*      */ 
/*      */   public static String mapQNameToJavaName(String base)
/*      */   {
/* 1653 */     return replace(base, ".-:/{}?#%*", new String[] { "$dot$", "$dash$", "$colon$", "$slash$", "", "$colon$", "$ques$", "$hash$", "$per$", "$aster$" });
/*      */   }
/*      */ 
/*      */   static
/*      */   {
/*  916 */     NumberFormat f = NumberFormat.getInstance(Locale.getDefault());
/*  917 */     defaultFormatter = (f instanceof DecimalFormat) ? (DecimalFormat)f : new DecimalFormat();
/*      */ 
/*  921 */     defaultFormatter.setMaximumFractionDigits(340);
/*  922 */     defaultFormatter.setMinimumFractionDigits(0);
/*  923 */     defaultFormatter.setMinimumIntegerDigits(1);
/*  924 */     defaultFormatter.setGroupingUsed(false);
/*      */ 
/*  928 */     xpathFormatter = new DecimalFormat("", new DecimalFormatSymbols(Locale.US));
/*      */ 
/*  930 */     xpathFormatter.setMaximumFractionDigits(340);
/*  931 */     xpathFormatter.setMinimumFractionDigits(0);
/*  932 */     xpathFormatter.setMinimumIntegerDigits(1);
/*  933 */     xpathFormatter.setGroupingUsed(false);
/*      */ 
/*  978 */     _fieldPosition = new FieldPosition(0);
/*      */ 
/* 1376 */     _characterArray = new char[32];
/*      */ 
/* 1527 */     prefixIndex = 0;
/*      */ 
/* 1586 */     String resource = "com.sun.org.apache.xalan.internal.xsltc.runtime.ErrorMessages";
/*      */   }
/*      */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary
 * JD-Core Version:    0.6.2
 */