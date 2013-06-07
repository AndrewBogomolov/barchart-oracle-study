/*     */ package sun.java2d.opengl;
/*     */ 
/*     */ import java.awt.Composite;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import sun.java2d.SurfaceData;
/*     */ import sun.java2d.loops.CompositeType;
/*     */ import sun.java2d.loops.SurfaceType;
/*     */ import sun.java2d.loops.TransformBlit;
/*     */ import sun.java2d.pipe.Region;
/*     */ 
/*     */ class OGLSwToSurfaceTransform extends TransformBlit
/*     */ {
/*     */   private int typeval;
/*     */ 
/*     */   OGLSwToSurfaceTransform(SurfaceType paramSurfaceType, int paramInt)
/*     */   {
/* 608 */     super(paramSurfaceType, CompositeType.AnyAlpha, OGLSurfaceData.OpenGLSurface);
/*     */ 
/* 611 */     this.typeval = paramInt;
/*     */   }
/*     */ 
/*     */   public void Transform(SurfaceData paramSurfaceData1, SurfaceData paramSurfaceData2, Composite paramComposite, Region paramRegion, AffineTransform paramAffineTransform, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
/*     */   {
/* 619 */     OGLBlitLoops.Blit(paramSurfaceData1, paramSurfaceData2, paramComposite, paramRegion, paramAffineTransform, paramInt1, paramInt2, paramInt3, paramInt2 + paramInt6, paramInt3 + paramInt7, paramInt4, paramInt5, paramInt4 + paramInt6, paramInt5 + paramInt7, this.typeval, false);
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.java2d.opengl.OGLSwToSurfaceTransform
 * JD-Core Version:    0.6.2
 */