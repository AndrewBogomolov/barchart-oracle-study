/*     */ package com.sun.org.apache.xerces.internal.jaxp.validation;
/*     */ 
/*     */ import com.sun.org.apache.xerces.internal.utils.SecuritySupport;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.Locale;
/*     */ import java.util.MissingResourceException;
/*     */ import java.util.ResourceBundle;
/*     */ 
/*     */ final class JAXPValidationMessageFormatter
/*     */ {
/*     */   public static String formatMessage(Locale locale, String key, Object[] arguments)
/*     */     throws MissingResourceException
/*     */   {
/*  55 */     ResourceBundle resourceBundle = null;
/*  56 */     if (locale != null) {
/*  57 */       resourceBundle = SecuritySupport.getResourceBundle("com.sun.org.apache.xerces.internal.impl.msg.JAXPValidationMessages", locale);
/*     */     }
/*     */     else
/*     */     {
/*  61 */       resourceBundle = SecuritySupport.getResourceBundle("com.sun.org.apache.xerces.internal.impl.msg.JAXPValidationMessages");
/*     */     }
/*     */ 
/*     */     String msg;
/*     */     try
/*     */     {
/*  68 */       msg = resourceBundle.getString(key);
/*  69 */       if (arguments != null) {
/*     */         try {
/*  71 */           msg = MessageFormat.format(msg, arguments);
/*     */         }
/*     */         catch (Exception e) {
/*  74 */           msg = resourceBundle.getString("FormatFailed");
/*  75 */           msg = msg + " " + resourceBundle.getString(key);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (MissingResourceException e)
/*     */     {
/*  82 */       msg = resourceBundle.getString("BadMessageKey");
/*  83 */       throw new MissingResourceException(key, msg, key);
/*     */     }
/*     */ 
/*  87 */     if (msg == null) {
/*  88 */       msg = key;
/*  89 */       if (arguments.length > 0) {
/*  90 */         StringBuffer str = new StringBuffer(msg);
/*  91 */         str.append('?');
/*  92 */         for (int i = 0; i < arguments.length; i++) {
/*  93 */           if (i > 0) {
/*  94 */             str.append('&');
/*     */           }
/*  96 */           str.append(String.valueOf(arguments[i]));
/*     */         }
/*     */       }
/*     */     }
/* 100 */     return msg;
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xerces.internal.jaxp.validation.JAXPValidationMessageFormatter
 * JD-Core Version:    0.6.2
 */