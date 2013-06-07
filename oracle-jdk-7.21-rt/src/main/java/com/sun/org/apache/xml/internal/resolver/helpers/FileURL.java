/*    */ package com.sun.org.apache.xml.internal.resolver.helpers;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URI;
/*    */ import java.net.URL;
/*    */ 
/*    */ public abstract class FileURL
/*    */ {
/*    */   public static URL makeURL(String pathname)
/*    */     throws MalformedURLException
/*    */   {
/* 90 */     File file = new File(pathname);
/* 91 */     return file.toURI().toURL();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xml.internal.resolver.helpers.FileURL
 * JD-Core Version:    0.6.2
 */