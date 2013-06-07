/*    */ package com.sun.imageio.spi;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.RandomAccessFile;
/*    */ import java.util.Locale;
/*    */ import javax.imageio.spi.ImageInputStreamSpi;
/*    */ import javax.imageio.stream.FileImageInputStream;
/*    */ import javax.imageio.stream.ImageInputStream;
/*    */ 
/*    */ public class RAFImageInputStreamSpi extends ImageInputStreamSpi
/*    */ {
/*    */   private static final String vendorName = "Oracle Corporation";
/*    */   private static final String version = "1.0";
/* 41 */   private static final Class inputClass = RandomAccessFile.class;
/*    */ 
/*    */   public RAFImageInputStreamSpi() {
/* 44 */     super("Oracle Corporation", "1.0", inputClass);
/*    */   }
/*    */ 
/*    */   public String getDescription(Locale paramLocale) {
/* 48 */     return "Service provider that instantiates a FileImageInputStream from a RandomAccessFile";
/*    */   }
/*    */ 
/*    */   public ImageInputStream createInputStreamInstance(Object paramObject, boolean paramBoolean, File paramFile)
/*    */   {
/* 54 */     if ((paramObject instanceof RandomAccessFile)) {
/*    */       try {
/* 56 */         return new FileImageInputStream((RandomAccessFile)paramObject);
/*    */       } catch (Exception localException) {
/* 58 */         return null;
/*    */       }
/*    */     }
/* 61 */     throw new IllegalArgumentException("input not a RandomAccessFile!");
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.imageio.spi.RAFImageInputStreamSpi
 * JD-Core Version:    0.6.2
 */