/*     */ package sun.java2d.opengl;
/*     */ 
/*     */ import java.awt.Composite;
/*     */ import sun.java2d.SurfaceData;
/*     */ import sun.java2d.loops.Blit;
/*     */ import sun.java2d.loops.CompositeType;
/*     */ import sun.java2d.loops.SurfaceType;
/*     */ import sun.java2d.pipe.Region;
/*     */ 
/*     */ class OGLSwToTextureBlit extends Blit
/*     */ {
/*     */   private int typeval;
/*     */ 
/*     */   OGLSwToTextureBlit(SurfaceType paramSurfaceType, int paramInt)
/*     */   {
/* 632 */     super(paramSurfaceType, CompositeType.SrcNoEa, OGLSurfaceData.OpenGLTexture);
/*     */ 
/* 635 */     this.typeval = paramInt;
/*     */   }
/*     */ 
/*     */   public void Blit(SurfaceData paramSurfaceData1, SurfaceData paramSurfaceData2, Composite paramComposite, Region paramRegion, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
/*     */   {
/* 642 */     OGLBlitLoops.Blit(paramSurfaceData1, paramSurfaceData2, paramComposite, paramRegion, null, 1, paramInt1, paramInt2, paramInt1 + paramInt5, paramInt2 + paramInt6, paramInt3, paramInt4, paramInt3 + paramInt5, paramInt4 + paramInt6, this.typeval, true);
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.java2d.opengl.OGLSwToTextureBlit
 * JD-Core Version:    0.6.2
 */