/*     */ package sun.font;
/*     */ 
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.GeneralPath;
/*     */ import java.awt.geom.NoninvertibleTransformException;
/*     */ import java.awt.geom.Point2D.Float;
/*     */ import java.awt.geom.Rectangle2D.Float;
/*     */ import sun.util.logging.PlatformLogger;
/*     */ 
/*     */ class NativeStrike extends PhysicalStrike
/*     */ {
/*     */   NativeFont nativeFont;
/*     */   int numGlyphs;
/*     */   AffineTransform invertDevTx;
/*     */   AffineTransform fontTx;
/*     */ 
/*     */   private int getNativePointSize()
/*     */   {
/*  58 */     double[] arrayOfDouble = new double[4];
/*  59 */     this.desc.glyphTx.getMatrix(arrayOfDouble);
/*  60 */     this.fontTx = new AffineTransform(arrayOfDouble);
/*     */ 
/*  63 */     if ((!this.desc.devTx.isIdentity()) && (this.desc.devTx.getType() != 1)) {
/*     */       try
/*     */       {
/*  66 */         this.invertDevTx = this.desc.devTx.createInverse();
/*  67 */         this.fontTx.concatenate(this.invertDevTx);
/*     */       } catch (NoninvertibleTransformException localNoninvertibleTransformException) {
/*  69 */         localNoninvertibleTransformException.printStackTrace();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  76 */     Point2D.Float localFloat = new Point2D.Float(1.0F, 1.0F);
/*  77 */     this.fontTx.deltaTransform(localFloat, localFloat);
/*  78 */     double d = Math.abs(localFloat.y);
/*  79 */     int i = this.fontTx.getType();
/*  80 */     if (((i & 0xFFFFFFFD) != 0) || (this.fontTx.getScaleY() <= 0.0D))
/*     */     {
/*  85 */       this.fontTx.scale(1.0D / d, 1.0D / d);
/*     */     }
/*  87 */     else this.fontTx = null;
/*     */ 
/*  89 */     return (int)d;
/*     */   }
/*     */ 
/*     */   NativeStrike(NativeFont paramNativeFont, FontStrikeDesc paramFontStrikeDesc) {
/*  93 */     super(paramNativeFont, paramFontStrikeDesc);
/*  94 */     this.nativeFont = paramNativeFont;
/*     */ 
/* 101 */     if (paramNativeFont.isBitmapDelegate) {
/* 102 */       i = paramFontStrikeDesc.glyphTx.getType();
/* 103 */       if (((i & 0xFFFFFFFD) != 0) || (paramFontStrikeDesc.glyphTx.getScaleX() <= 0.0D))
/*     */       {
/* 105 */         this.numGlyphs = 0;
/* 106 */         return;
/*     */       }
/*     */     }
/*     */ 
/* 110 */     int i = getNativePointSize();
/* 111 */     byte[] arrayOfByte = paramNativeFont.getPlatformNameBytes(i);
/* 112 */     double d = Math.abs(paramFontStrikeDesc.devTx.getScaleX());
/* 113 */     this.pScalerContext = createScalerContext(arrayOfByte, i, d);
/* 114 */     if (this.pScalerContext == 0L) {
/* 115 */       SunFontManager.getInstance().deRegisterBadFont(paramNativeFont);
/* 116 */       this.pScalerContext = createNullScalerContext();
/* 117 */       this.numGlyphs = 0;
/* 118 */       if (FontUtilities.isLogging()) {
/* 119 */         FontUtilities.getLogger().severe("Could not create native strike " + new String(arrayOfByte));
/*     */       }
/*     */ 
/* 123 */       return;
/*     */     }
/* 125 */     this.numGlyphs = paramNativeFont.getMapper().getNumGlyphs();
/* 126 */     this.disposer = new NativeStrikeDisposer(paramNativeFont, paramFontStrikeDesc, this.pScalerContext);
/*     */   }
/*     */ 
/*     */   private boolean usingIntGlyphImages()
/*     */   {
/* 136 */     if (this.intGlyphImages != null)
/* 137 */       return true;
/* 138 */     if (longAddresses) {
/* 139 */       return false;
/*     */     }
/*     */ 
/* 144 */     int i = getMaxGlyph(this.pScalerContext);
/*     */ 
/* 147 */     if (i < this.numGlyphs) {
/* 148 */       i = this.numGlyphs;
/*     */     }
/* 150 */     this.intGlyphImages = new int[i];
/* 151 */     this.disposer.intGlyphImages = this.intGlyphImages;
/* 152 */     return true;
/*     */   }
/*     */ 
/*     */   private long[] getLongGlyphImages()
/*     */   {
/* 157 */     if ((this.longGlyphImages == null) && (longAddresses))
/*     */     {
/* 162 */       int i = getMaxGlyph(this.pScalerContext);
/*     */ 
/* 165 */       if (i < this.numGlyphs) {
/* 166 */         i = this.numGlyphs;
/*     */       }
/* 168 */       this.longGlyphImages = new long[i];
/* 169 */       this.disposer.longGlyphImages = this.longGlyphImages;
/*     */     }
/* 171 */     return this.longGlyphImages;
/*     */   }
/*     */ 
/*     */   NativeStrike(NativeFont paramNativeFont, FontStrikeDesc paramFontStrikeDesc, boolean paramBoolean)
/*     */   {
/* 176 */     super(paramNativeFont, paramFontStrikeDesc);
/* 177 */     this.nativeFont = paramNativeFont;
/*     */ 
/* 179 */     int i = (int)paramFontStrikeDesc.glyphTx.getScaleY();
/* 180 */     double d = paramFontStrikeDesc.devTx.getScaleX();
/* 181 */     byte[] arrayOfByte = paramNativeFont.getPlatformNameBytes(i);
/* 182 */     this.pScalerContext = createScalerContext(arrayOfByte, i, d);
/*     */ 
/* 184 */     int j = paramNativeFont.getMapper().getNumGlyphs();
/*     */   }
/*     */ 
/*     */   StrikeMetrics getFontMetrics()
/*     */   {
/* 196 */     if (this.strikeMetrics == null) {
/* 197 */       if (this.pScalerContext != 0L) {
/* 198 */         this.strikeMetrics = this.nativeFont.getFontMetrics(this.pScalerContext);
/*     */       }
/* 200 */       if ((this.strikeMetrics != null) && (this.fontTx != null)) {
/* 201 */         this.strikeMetrics.convertToUserSpace(this.fontTx);
/*     */       }
/*     */     }
/* 204 */     return this.strikeMetrics;
/*     */   }
/*     */ 
/*     */   private native long createScalerContext(byte[] paramArrayOfByte, int paramInt, double paramDouble);
/*     */ 
/*     */   private native int getMaxGlyph(long paramLong);
/*     */ 
/*     */   private native long createNullScalerContext();
/*     */ 
/*     */   void getGlyphImagePtrs(int[] paramArrayOfInt, long[] paramArrayOfLong, int paramInt)
/*     */   {
/* 215 */     for (int i = 0; i < paramInt; i++)
/* 216 */       paramArrayOfLong[i] = getGlyphImagePtr(paramArrayOfInt[i]);
/*     */   }
/*     */ 
/*     */   long getGlyphImagePtr(int paramInt)
/*     */   {
/* 223 */     if (usingIntGlyphImages()) {
/* 224 */       if ((l = this.intGlyphImages[paramInt] & 0xFFFFFFFF) != 0L) {
/* 225 */         return l;
/*     */       }
/* 227 */       l = this.nativeFont.getGlyphImage(this.pScalerContext, paramInt);
/*     */ 
/* 231 */       synchronized (this) {
/* 232 */         if (this.intGlyphImages[paramInt] == 0) {
/* 233 */           this.intGlyphImages[paramInt] = ((int)l);
/* 234 */           return l;
/*     */         }
/* 236 */         StrikeCache.freeIntPointer((int)l);
/* 237 */         return this.intGlyphImages[paramInt] & 0xFFFFFFFF;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 243 */     if ((l = getLongGlyphImages()[paramInt]) != 0L) {
/* 244 */       return l;
/*     */     }
/* 246 */     long l = this.nativeFont.getGlyphImage(this.pScalerContext, paramInt);
/*     */ 
/* 248 */     synchronized (this) {
/* 249 */       if (this.longGlyphImages[paramInt] == 0L) {
/* 250 */         this.longGlyphImages[paramInt] = l;
/* 251 */         return l;
/*     */       }
/* 253 */       StrikeCache.freeLongPointer(l);
/* 254 */       return this.longGlyphImages[paramInt];
/*     */     }
/*     */   }
/*     */ 
/*     */   long getGlyphImagePtrNoCache(int paramInt)
/*     */   {
/* 268 */     return this.nativeFont.getGlyphImageNoDefault(this.pScalerContext, paramInt);
/*     */   }
/*     */ 
/*     */   void getGlyphImageBounds(int paramInt, Point2D.Float paramFloat, Rectangle paramRectangle)
/*     */   {
/*     */   }
/*     */ 
/*     */   Point2D.Float getGlyphMetrics(int paramInt) {
/* 276 */     Point2D.Float localFloat = new Point2D.Float(getGlyphAdvance(paramInt), 0.0F);
/* 277 */     return localFloat;
/*     */   }
/*     */ 
/*     */   float getGlyphAdvance(int paramInt) {
/* 281 */     return this.nativeFont.getGlyphAdvance(this.pScalerContext, paramInt);
/*     */   }
/*     */ 
/*     */   Rectangle2D.Float getGlyphOutlineBounds(int paramInt) {
/* 285 */     return this.nativeFont.getGlyphOutlineBounds(this.pScalerContext, paramInt);
/*     */   }
/*     */ 
/*     */   GeneralPath getGlyphOutline(int paramInt, float paramFloat1, float paramFloat2) {
/* 289 */     return new GeneralPath();
/*     */   }
/*     */ 
/*     */   GeneralPath getGlyphVectorOutline(int[] paramArrayOfInt, float paramFloat1, float paramFloat2) {
/* 293 */     return new GeneralPath();
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.font.NativeStrike
 * JD-Core Version:    0.6.2
 */