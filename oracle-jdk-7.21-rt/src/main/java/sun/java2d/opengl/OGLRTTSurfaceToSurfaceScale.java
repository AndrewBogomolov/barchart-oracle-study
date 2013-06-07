/*     */ package sun.java2d.opengl;
/*     */ 
/*     */ import java.awt.Composite;
/*     */ import sun.java2d.SurfaceData;
/*     */ import sun.java2d.loops.CompositeType;
/*     */ import sun.java2d.loops.ScaledBlit;
/*     */ import sun.java2d.pipe.Region;
/*     */ 
/*     */ class OGLRTTSurfaceToSurfaceScale extends ScaledBlit
/*     */ {
/*     */   OGLRTTSurfaceToSurfaceScale()
/*     */   {
/* 463 */     super(OGLSurfaceData.OpenGLSurfaceRTT, CompositeType.AnyAlpha, OGLSurfaceData.OpenGLSurface);
/*     */   }
/*     */ 
/*     */   public void Scale(SurfaceData paramSurfaceData1, SurfaceData paramSurfaceData2, Composite paramComposite, Region paramRegion, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
/*     */   {
/* 475 */     OGLBlitLoops.IsoBlit(paramSurfaceData1, paramSurfaceData2, null, null, paramComposite, paramRegion, null, 1, paramInt1, paramInt2, paramInt3, paramInt4, paramDouble1, paramDouble2, paramDouble3, paramDouble4, true);
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.java2d.opengl.OGLRTTSurfaceToSurfaceScale
 * JD-Core Version:    0.6.2
 */