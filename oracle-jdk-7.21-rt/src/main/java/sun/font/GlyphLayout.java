/*     */ package sun.font;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.awt.font.FontRenderContext;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.NoninvertibleTransformException;
/*     */ import java.awt.geom.Point2D.Float;
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ public final class GlyphLayout
/*     */ {
/*     */   private GVData _gvdata;
/*     */   private static volatile GlyphLayout cache;
/*     */   private LayoutEngineFactory _lef;
/*     */   private TextRecord _textRecord;
/*     */   private ScriptRun _scriptRuns;
/*     */   private FontRunIterator _fontRuns;
/*     */   private int _ercount;
/*     */   private ArrayList _erecords;
/*     */   private Point2D.Float _pt;
/*     */   private FontStrikeDesc _sd;
/*     */   private float[] _mat;
/*     */   private int _typo_flags;
/*     */   private int _offset;
/*     */ 
/*     */   public static GlyphLayout get(LayoutEngineFactory paramLayoutEngineFactory)
/*     */   {
/* 184 */     if (paramLayoutEngineFactory == null) {
/* 185 */       paramLayoutEngineFactory = SunLayoutEngine.instance();
/*     */     }
/* 187 */     GlyphLayout localGlyphLayout = null;
/* 188 */     synchronized (GlyphLayout.class) {
/* 189 */       if (cache != null) {
/* 190 */         localGlyphLayout = cache;
/* 191 */         cache = null;
/*     */       }
/*     */     }
/* 194 */     if (localGlyphLayout == null) {
/* 195 */       localGlyphLayout = new GlyphLayout();
/*     */     }
/* 197 */     localGlyphLayout._lef = paramLayoutEngineFactory;
/* 198 */     return localGlyphLayout;
/*     */   }
/*     */ 
/*     */   public static void done(GlyphLayout paramGlyphLayout)
/*     */   {
/* 206 */     paramGlyphLayout._lef = null;
/* 207 */     cache = paramGlyphLayout;
/*     */   }
/*     */ 
/*     */   public StandardGlyphVector layout(Font paramFont, FontRenderContext paramFontRenderContext, char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, StandardGlyphVector paramStandardGlyphVector)
/*     */   {
/* 365 */     if ((paramArrayOfChar == null) || (paramInt1 < 0) || (paramInt2 < 0) || (paramInt2 > paramArrayOfChar.length - paramInt1)) {
/* 366 */       throw new IllegalArgumentException();
/*     */     }
/*     */ 
/* 369 */     init(paramInt2);
/*     */ 
/* 373 */     if (paramFont.hasLayoutAttributes()) {
/* 374 */       localObject1 = ((AttributeMap)paramFont.getAttributes()).getValues();
/* 375 */       if (((AttributeValues)localObject1).getKerning() != 0) this._typo_flags |= 1;
/* 376 */       if (((AttributeValues)localObject1).getLigatures() != 0) this._typo_flags |= 2;
/*     */     }
/*     */ 
/* 379 */     this._offset = paramInt1;
/*     */ 
/* 383 */     Object localObject1 = SDCache.get(paramFont, paramFontRenderContext);
/* 384 */     this._mat[0] = ((float)((SDCache)localObject1).gtx.getScaleX());
/* 385 */     this._mat[1] = ((float)((SDCache)localObject1).gtx.getShearY());
/* 386 */     this._mat[2] = ((float)((SDCache)localObject1).gtx.getShearX());
/* 387 */     this._mat[3] = ((float)((SDCache)localObject1).gtx.getScaleY());
/* 388 */     this._pt.setLocation(((SDCache)localObject1).delta);
/*     */ 
/* 390 */     int i = paramInt1 + paramInt2;
/*     */ 
/* 392 */     int j = 0;
/* 393 */     int k = paramArrayOfChar.length;
/* 394 */     if (paramInt3 != 0) {
/* 395 */       if ((paramInt3 & 0x1) != 0) {
/* 396 */         this._typo_flags |= -2147483648;
/*     */       }
/*     */ 
/* 399 */       if ((paramInt3 & 0x2) != 0) {
/* 400 */         j = paramInt1;
/*     */       }
/*     */ 
/* 403 */       if ((paramInt3 & 0x4) != 0) {
/* 404 */         k = i;
/*     */       }
/*     */     }
/*     */ 
/* 408 */     int m = -1;
/*     */ 
/* 410 */     Font2D localFont2D = FontUtilities.getFont2D(paramFont);
/*     */ 
/* 412 */     this._textRecord.init(paramArrayOfChar, paramInt1, i, j, k);
/* 413 */     int n = paramInt1;
/* 414 */     if ((localFont2D instanceof CompositeFont)) {
/* 415 */       this._scriptRuns.init(paramArrayOfChar, paramInt1, paramInt2);
/* 416 */       this._fontRuns.init((CompositeFont)localFont2D, paramArrayOfChar, paramInt1, i);
/* 417 */       while (this._scriptRuns.next()) {
/* 418 */         i1 = this._scriptRuns.getScriptLimit();
/* 419 */         i2 = this._scriptRuns.getScriptCode();
/* 420 */         while (this._fontRuns.next(i2, i1)) {
/* 421 */           PhysicalFont localPhysicalFont = this._fontRuns.getFont();
/*     */ 
/* 428 */           if ((localPhysicalFont instanceof NativeFont)) {
/* 429 */             localPhysicalFont = ((NativeFont)localPhysicalFont).getDelegateFont();
/*     */           }
/* 431 */           int i4 = this._fontRuns.getGlyphMask();
/* 432 */           int i5 = this._fontRuns.getPos();
/* 433 */           nextEngineRecord(n, i5, i2, m, localPhysicalFont, i4);
/* 434 */           n = i5;
/*     */         }
/*     */       }
/*     */     }
/* 438 */     this._scriptRuns.init(paramArrayOfChar, paramInt1, paramInt2);
/* 439 */     while (this._scriptRuns.next()) {
/* 440 */       i1 = this._scriptRuns.getScriptLimit();
/* 441 */       i2 = this._scriptRuns.getScriptCode();
/* 442 */       nextEngineRecord(n, i1, i2, m, localFont2D, 0);
/* 443 */       n = i1;
/*     */     }
/*     */ 
/* 447 */     int i1 = 0;
/* 448 */     int i2 = this._ercount;
/* 449 */     int i3 = 1;
/*     */ 
/* 451 */     if (this._typo_flags < 0) {
/* 452 */       i1 = i2 - 1;
/* 453 */       i2 = -1;
/* 454 */       i3 = -1;
/*     */     }
/*     */ 
/* 458 */     this._sd = ((SDCache)localObject1).sd;
/* 459 */     for (; i1 != i2; i1 += i3) {
/* 460 */       localObject2 = (EngineRecord)this._erecords.get(i1);
/*     */       while (true) {
/*     */         try {
/* 463 */           ((EngineRecord)localObject2).layout();
/*     */         }
/*     */         catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
/*     */         {
/* 467 */           this._gvdata.grow();
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 476 */     Object localObject2 = this._gvdata.createGlyphVector(paramFont, paramFontRenderContext, paramStandardGlyphVector);
/*     */ 
/* 478 */     return localObject2;
/*     */   }
/*     */ 
/*     */   private GlyphLayout()
/*     */   {
/* 486 */     this._gvdata = new GVData();
/* 487 */     this._textRecord = new TextRecord();
/* 488 */     this._scriptRuns = new ScriptRun();
/* 489 */     this._fontRuns = new FontRunIterator();
/* 490 */     this._erecords = new ArrayList(10);
/* 491 */     this._pt = new Point2D.Float();
/* 492 */     this._sd = new FontStrikeDesc();
/* 493 */     this._mat = new float[4];
/*     */   }
/*     */ 
/*     */   private void init(int paramInt) {
/* 497 */     this._typo_flags = 0;
/* 498 */     this._ercount = 0;
/* 499 */     this._gvdata.init(paramInt);
/*     */   }
/*     */ 
/*     */   private void nextEngineRecord(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Font2D paramFont2D, int paramInt5) {
/* 503 */     EngineRecord localEngineRecord = null;
/* 504 */     if (this._ercount == this._erecords.size()) {
/* 505 */       localEngineRecord = new EngineRecord();
/* 506 */       this._erecords.add(localEngineRecord);
/*     */     } else {
/* 508 */       localEngineRecord = (EngineRecord)this._erecords.get(this._ercount);
/*     */     }
/* 510 */     localEngineRecord.init(paramInt1, paramInt2, paramFont2D, paramInt3, paramInt4, paramInt5);
/* 511 */     this._ercount += 1;
/*     */   }
/*     */ 
/*     */   private final class EngineRecord
/*     */   {
/*     */     private int start;
/*     */     private int limit;
/*     */     private int gmask;
/*     */     private int eflags;
/*     */     private GlyphLayout.LayoutEngineKey key;
/*     */     private GlyphLayout.LayoutEngine engine;
/*     */ 
/*     */     EngineRecord()
/*     */     {
/* 629 */       this.key = new GlyphLayout.LayoutEngineKey();
/*     */     }
/*     */ 
/*     */     void init(int paramInt1, int paramInt2, Font2D paramFont2D, int paramInt3, int paramInt4, int paramInt5) {
/* 633 */       this.start = paramInt1;
/* 634 */       this.limit = paramInt2;
/* 635 */       this.gmask = paramInt5;
/* 636 */       this.key.init(paramFont2D, paramInt3, paramInt4);
/* 637 */       this.eflags = 0;
/*     */ 
/* 640 */       for (int i = paramInt1; i < paramInt2; i++) {
/* 641 */         int j = GlyphLayout.this._textRecord.text[i];
/* 642 */         if ((Character.isHighSurrogate((char)j)) && (i < paramInt2 - 1) && (Character.isLowSurrogate(GlyphLayout.this._textRecord.text[(i + 1)])))
/*     */         {
/* 646 */           j = Character.toCodePoint((char)j, GlyphLayout.this._textRecord.text[(++i)]);
/*     */         }
/* 648 */         int k = Character.getType(j);
/* 649 */         if ((k == 6) || (k == 7) || (k == 8))
/*     */         {
/* 653 */           this.eflags = 4;
/* 654 */           break;
/*     */         }
/*     */       }
/*     */ 
/* 658 */       this.engine = GlyphLayout.this._lef.getEngine(this.key);
/*     */     }
/*     */ 
/*     */     void layout() {
/* 662 */       GlyphLayout.this._textRecord.start = this.start;
/* 663 */       GlyphLayout.this._textRecord.limit = this.limit;
/* 664 */       this.engine.layout(GlyphLayout.this._sd, GlyphLayout.this._mat, this.gmask, this.start - GlyphLayout.this._offset, GlyphLayout.this._textRecord, GlyphLayout.this._typo_flags | this.eflags, GlyphLayout.this._pt, GlyphLayout.this._gvdata);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static final class GVData
/*     */   {
/*     */     public int _count;
/*     */     public int _flags;
/*     */     public int[] _glyphs;
/*     */     public float[] _positions;
/*     */     public int[] _indices;
/*     */     private static final int UNINITIALIZED_FLAGS = -1;
/*     */ 
/*     */     public void init(int paramInt)
/*     */     {
/* 527 */       this._count = 0;
/* 528 */       this._flags = -1;
/*     */ 
/* 530 */       if ((this._glyphs == null) || (this._glyphs.length < paramInt)) {
/* 531 */         if (paramInt < 20) {
/* 532 */           paramInt = 20;
/*     */         }
/* 534 */         this._glyphs = new int[paramInt];
/* 535 */         this._positions = new float[paramInt * 2 + 2];
/* 536 */         this._indices = new int[paramInt];
/*     */       }
/*     */     }
/*     */ 
/*     */     public void grow() {
/* 541 */       grow(this._glyphs.length / 4);
/*     */     }
/*     */ 
/*     */     public void grow(int paramInt) {
/* 545 */       int i = this._glyphs.length + paramInt;
/* 546 */       int[] arrayOfInt1 = new int[i];
/* 547 */       System.arraycopy(this._glyphs, 0, arrayOfInt1, 0, this._count);
/* 548 */       this._glyphs = arrayOfInt1;
/*     */ 
/* 550 */       float[] arrayOfFloat = new float[i * 2 + 2];
/* 551 */       System.arraycopy(this._positions, 0, arrayOfFloat, 0, this._count * 2 + 2);
/* 552 */       this._positions = arrayOfFloat;
/*     */ 
/* 554 */       int[] arrayOfInt2 = new int[i];
/* 555 */       System.arraycopy(this._indices, 0, arrayOfInt2, 0, this._count);
/* 556 */       this._indices = arrayOfInt2;
/*     */     }
/*     */ 
/*     */     public void adjustPositions(AffineTransform paramAffineTransform) {
/* 560 */       paramAffineTransform.transform(this._positions, 0, this._positions, 0, this._count);
/*     */     }
/*     */ 
/*     */     public StandardGlyphVector createGlyphVector(Font paramFont, FontRenderContext paramFontRenderContext, StandardGlyphVector paramStandardGlyphVector)
/*     */     {
/* 566 */       if (this._flags == -1) {
/* 567 */         this._flags = 0;
/*     */ 
/* 569 */         if (this._count > 1) {
/* 570 */           int i = 1;
/* 571 */           int j = 1;
/*     */ 
/* 573 */           int k = this._count;
/* 574 */           for (int m = 0; (m < this._count) && ((i != 0) || (j != 0)); m++) {
/* 575 */             int n = this._indices[m];
/*     */ 
/* 577 */             i = (i != 0) && (n == m) ? 1 : 0;
/* 578 */             j = (j != 0) && (n == --k) ? 1 : 0;
/*     */           }
/*     */ 
/* 581 */           if (j != 0) this._flags |= 4;
/* 582 */           if ((j == 0) && (i == 0)) this._flags |= 8;
/*     */ 
/*     */         }
/*     */ 
/* 588 */         this._flags |= 2;
/*     */       }
/*     */ 
/* 591 */       int[] arrayOfInt1 = new int[this._count];
/* 592 */       System.arraycopy(this._glyphs, 0, arrayOfInt1, 0, this._count);
/*     */ 
/* 594 */       float[] arrayOfFloat = null;
/* 595 */       if ((this._flags & 0x2) != 0) {
/* 596 */         arrayOfFloat = new float[this._count * 2 + 2];
/* 597 */         System.arraycopy(this._positions, 0, arrayOfFloat, 0, arrayOfFloat.length);
/*     */       }
/*     */ 
/* 600 */       int[] arrayOfInt2 = null;
/* 601 */       if ((this._flags & 0x8) != 0) {
/* 602 */         arrayOfInt2 = new int[this._count];
/* 603 */         System.arraycopy(this._indices, 0, arrayOfInt2, 0, this._count);
/*     */       }
/*     */ 
/* 606 */       if (paramStandardGlyphVector == null)
/* 607 */         paramStandardGlyphVector = new StandardGlyphVector(paramFont, paramFontRenderContext, arrayOfInt1, arrayOfFloat, arrayOfInt2, this._flags);
/*     */       else {
/* 609 */         paramStandardGlyphVector.initGlyphVector(paramFont, paramFontRenderContext, arrayOfInt1, arrayOfFloat, arrayOfInt2, this._flags);
/*     */       }
/*     */ 
/* 612 */       return paramStandardGlyphVector;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static abstract interface LayoutEngine
/*     */   {
/*     */     public abstract void layout(FontStrikeDesc paramFontStrikeDesc, float[] paramArrayOfFloat, int paramInt1, int paramInt2, TextRecord paramTextRecord, int paramInt3, Point2D.Float paramFloat, GlyphLayout.GVData paramGVData);
/*     */   }
/*     */ 
/*     */   public static abstract interface LayoutEngineFactory
/*     */   {
/*     */     public abstract GlyphLayout.LayoutEngine getEngine(Font2D paramFont2D, int paramInt1, int paramInt2);
/*     */ 
/*     */     public abstract GlyphLayout.LayoutEngine getEngine(GlyphLayout.LayoutEngineKey paramLayoutEngineKey);
/*     */   }
/*     */ 
/*     */   public static final class LayoutEngineKey
/*     */   {
/*     */     private Font2D font;
/*     */     private int script;
/*     */     private int lang;
/*     */ 
/*     */     LayoutEngineKey()
/*     */     {
/*     */     }
/*     */ 
/*     */     LayoutEngineKey(Font2D paramFont2D, int paramInt1, int paramInt2)
/*     */     {
/* 111 */       init(paramFont2D, paramInt1, paramInt2);
/*     */     }
/*     */ 
/*     */     void init(Font2D paramFont2D, int paramInt1, int paramInt2) {
/* 115 */       this.font = paramFont2D;
/* 116 */       this.script = paramInt1;
/* 117 */       this.lang = paramInt2;
/*     */     }
/*     */ 
/*     */     LayoutEngineKey copy() {
/* 121 */       return new LayoutEngineKey(this.font, this.script, this.lang);
/*     */     }
/*     */ 
/*     */     Font2D font() {
/* 125 */       return this.font;
/*     */     }
/*     */ 
/*     */     int script() {
/* 129 */       return this.script;
/*     */     }
/*     */ 
/*     */     int lang() {
/* 133 */       return this.lang;
/*     */     }
/*     */ 
/*     */     public boolean equals(Object paramObject) {
/* 137 */       if (this == paramObject) return true;
/* 138 */       if (paramObject == null) return false; try
/*     */       {
/* 140 */         LayoutEngineKey localLayoutEngineKey = (LayoutEngineKey)paramObject;
/* 141 */         return (this.script == localLayoutEngineKey.script) && (this.lang == localLayoutEngineKey.lang) && (this.font.equals(localLayoutEngineKey.font));
/*     */       }
/*     */       catch (ClassCastException localClassCastException)
/*     */       {
/*     */       }
/* 146 */       return false;
/*     */     }
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 151 */       return this.script ^ this.lang ^ this.font.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */   private static final class SDCache
/*     */   {
/*     */     public Font key_font;
/*     */     public FontRenderContext key_frc;
/*     */     public AffineTransform dtx;
/*     */     public AffineTransform invdtx;
/*     */     public AffineTransform gtx;
/*     */     public Point2D.Float delta;
/*     */     public FontStrikeDesc sd;
/* 269 */     private static final Point2D.Float ZERO_DELTA = new Point2D.Float();
/*     */     private static SoftReference<ConcurrentHashMap<SDKey, SDCache>> cacheRef;
/*     */ 
/*     */     private SDCache(Font paramFont, FontRenderContext paramFontRenderContext)
/*     */     {
/* 221 */       this.key_font = paramFont;
/* 222 */       this.key_frc = paramFontRenderContext;
/*     */ 
/* 227 */       this.dtx = paramFontRenderContext.getTransform();
/* 228 */       this.dtx.setTransform(this.dtx.getScaleX(), this.dtx.getShearY(), this.dtx.getShearX(), this.dtx.getScaleY(), 0.0D, 0.0D);
/*     */ 
/* 231 */       if (!this.dtx.isIdentity()) {
/*     */         try {
/* 233 */           this.invdtx = this.dtx.createInverse();
/*     */         }
/*     */         catch (NoninvertibleTransformException localNoninvertibleTransformException) {
/* 236 */           throw new InternalError();
/*     */         }
/*     */       }
/*     */ 
/* 240 */       float f = paramFont.getSize2D();
/* 241 */       if (paramFont.isTransformed()) {
/* 242 */         this.gtx = paramFont.getTransform();
/* 243 */         this.gtx.scale(f, f);
/* 244 */         this.delta = new Point2D.Float((float)this.gtx.getTranslateX(), (float)this.gtx.getTranslateY());
/*     */ 
/* 246 */         this.gtx.setTransform(this.gtx.getScaleX(), this.gtx.getShearY(), this.gtx.getShearX(), this.gtx.getScaleY(), 0.0D, 0.0D);
/*     */ 
/* 249 */         this.gtx.preConcatenate(this.dtx);
/*     */       } else {
/* 251 */         this.delta = ZERO_DELTA;
/* 252 */         this.gtx = new AffineTransform(this.dtx);
/* 253 */         this.gtx.scale(f, f);
/*     */       }
/*     */ 
/* 260 */       int i = FontStrikeDesc.getAAHintIntVal(paramFontRenderContext.getAntiAliasingHint(), FontUtilities.getFont2D(paramFont), (int)Math.abs(f));
/*     */ 
/* 264 */       int j = FontStrikeDesc.getFMHintIntVal(paramFontRenderContext.getFractionalMetricsHint());
/*     */ 
/* 266 */       this.sd = new FontStrikeDesc(this.dtx, this.gtx, paramFont.getStyle(), i, j);
/*     */     }
/*     */ 
/*     */     public static SDCache get(Font paramFont, FontRenderContext paramFontRenderContext)
/*     */     {
/* 310 */       if (paramFontRenderContext.isTransformed()) {
/* 311 */         localObject = paramFontRenderContext.getTransform();
/* 312 */         if ((((AffineTransform)localObject).getTranslateX() != 0.0D) || (((AffineTransform)localObject).getTranslateY() != 0.0D))
/*     */         {
/* 314 */           localObject = new AffineTransform(((AffineTransform)localObject).getScaleX(), ((AffineTransform)localObject).getShearY(), ((AffineTransform)localObject).getShearX(), ((AffineTransform)localObject).getScaleY(), 0.0D, 0.0D);
/*     */ 
/* 319 */           paramFontRenderContext = new FontRenderContext((AffineTransform)localObject, paramFontRenderContext.getAntiAliasingHint(), paramFontRenderContext.getFractionalMetricsHint());
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 326 */       Object localObject = new SDKey(paramFont, paramFontRenderContext);
/* 327 */       ConcurrentHashMap localConcurrentHashMap = null;
/* 328 */       SDCache localSDCache = null;
/* 329 */       if (cacheRef != null) {
/* 330 */         localConcurrentHashMap = (ConcurrentHashMap)cacheRef.get();
/* 331 */         if (localConcurrentHashMap != null) {
/* 332 */           localSDCache = (SDCache)localConcurrentHashMap.get(localObject);
/*     */         }
/*     */       }
/* 335 */       if (localSDCache == null) {
/* 336 */         localSDCache = new SDCache(paramFont, paramFontRenderContext);
/* 337 */         if (localConcurrentHashMap == null) {
/* 338 */           localConcurrentHashMap = new ConcurrentHashMap(10);
/* 339 */           cacheRef = new SoftReference(localConcurrentHashMap);
/*     */         }
/* 341 */         else if (localConcurrentHashMap.size() >= 512) {
/* 342 */           localConcurrentHashMap.clear();
/*     */         }
/* 344 */         localConcurrentHashMap.put(localObject, localSDCache);
/*     */       }
/* 346 */       return localSDCache;
/*     */     }
/*     */ 
/*     */     private static final class SDKey
/*     */     {
/*     */       private final Font font;
/*     */       private final FontRenderContext frc;
/*     */       private final int hash;
/*     */ 
/*     */       SDKey(Font paramFont, FontRenderContext paramFontRenderContext)
/*     */       {
/* 280 */         this.font = paramFont;
/* 281 */         this.frc = paramFontRenderContext;
/* 282 */         this.hash = (paramFont.hashCode() ^ paramFontRenderContext.hashCode());
/*     */       }
/*     */ 
/*     */       public int hashCode() {
/* 286 */         return this.hash;
/*     */       }
/*     */ 
/*     */       public boolean equals(Object paramObject) {
/*     */         try {
/* 291 */           SDKey localSDKey = (SDKey)paramObject;
/* 292 */           return (this.hash == localSDKey.hash) && (this.font.equals(localSDKey.font)) && (this.frc.equals(localSDKey.frc));
/*     */         }
/*     */         catch (ClassCastException localClassCastException)
/*     */         {
/*     */         }
/*     */ 
/* 299 */         return false;
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.font.GlyphLayout
 * JD-Core Version:    0.6.2
 */