/*     */ package sun.java2d.xr;
/*     */ 
/*     */ import java.awt.Composite;
/*     */ import sun.awt.SunToolkit;
/*     */ import sun.java2d.SurfaceData;
/*     */ import sun.java2d.loops.CompositeType;
/*     */ import sun.java2d.loops.ScaledBlit;
/*     */ import sun.java2d.loops.SurfaceType;
/*     */ import sun.java2d.pipe.Region;
/*     */ 
/*     */ class XrSwToPMScaledBlit extends ScaledBlit
/*     */ {
/*     */   ScaledBlit pmToSurfaceBlit;
/*     */ 
/*     */   XrSwToPMScaledBlit(SurfaceType paramSurfaceType1, SurfaceType paramSurfaceType2)
/*     */   {
/* 361 */     super(paramSurfaceType1, CompositeType.AnyAlpha, paramSurfaceType2);
/* 362 */     this.pmToSurfaceBlit = new XRPMScaledBlit(paramSurfaceType2, paramSurfaceType2);
/*     */   }
/*     */ 
/*     */   public void Scale(SurfaceData paramSurfaceData1, SurfaceData paramSurfaceData2, Composite paramComposite, Region paramRegion, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
/*     */   {
/* 368 */     int i = paramInt3 - paramInt1;
/* 369 */     int j = paramInt4 - paramInt2;
/*     */     try
/*     */     {
/* 372 */       SunToolkit.awtLock();
/* 373 */       XRSurfaceData localXRSurfaceData = XRPMBlitLoops.cacheToTmpSurface(paramSurfaceData1, (XRSurfaceData)paramSurfaceData2, i, j, paramInt1, paramInt2);
/* 374 */       this.pmToSurfaceBlit.Scale(localXRSurfaceData, paramSurfaceData2, paramComposite, paramRegion, 0, 0, i, j, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
/*     */     } finally {
/* 376 */       SunToolkit.awtUnlock();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.java2d.xr.XrSwToPMScaledBlit
 * JD-Core Version:    0.6.2
 */