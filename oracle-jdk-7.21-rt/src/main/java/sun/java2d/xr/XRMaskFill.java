/*     */ package sun.java2d.xr;
/*     */ 
/*     */ import java.awt.Composite;
/*     */ import sun.awt.SunToolkit;
/*     */ import sun.java2d.SunGraphics2D;
/*     */ import sun.java2d.SurfaceData;
/*     */ import sun.java2d.loops.CompositeType;
/*     */ import sun.java2d.loops.GraphicsPrimitive;
/*     */ import sun.java2d.loops.GraphicsPrimitiveMgr;
/*     */ import sun.java2d.loops.MaskFill;
/*     */ import sun.java2d.loops.SurfaceType;
/*     */ 
/*     */ public class XRMaskFill extends MaskFill
/*     */ {
/*     */   static void register()
/*     */   {
/*  49 */     GraphicsPrimitive[] arrayOfGraphicsPrimitive = { new XRMaskFill(SurfaceType.AnyColor, CompositeType.SrcOver, XRSurfaceData.IntRgbX11), new XRMaskFill(SurfaceType.OpaqueColor, CompositeType.SrcNoEa, XRSurfaceData.IntRgbX11), new XRMaskFill(SurfaceType.GradientPaint, CompositeType.SrcOver, XRSurfaceData.IntRgbX11), new XRMaskFill(SurfaceType.OpaqueGradientPaint, CompositeType.SrcNoEa, XRSurfaceData.IntRgbX11), new XRMaskFill(SurfaceType.LinearGradientPaint, CompositeType.SrcOver, XRSurfaceData.IntRgbX11), new XRMaskFill(SurfaceType.OpaqueLinearGradientPaint, CompositeType.SrcNoEa, XRSurfaceData.IntRgbX11), new XRMaskFill(SurfaceType.RadialGradientPaint, CompositeType.SrcOver, XRSurfaceData.IntRgbX11), new XRMaskFill(SurfaceType.OpaqueRadialGradientPaint, CompositeType.SrcNoEa, XRSurfaceData.IntRgbX11), new XRMaskFill(SurfaceType.TexturePaint, CompositeType.SrcOver, XRSurfaceData.IntRgbX11), new XRMaskFill(SurfaceType.OpaqueTexturePaint, CompositeType.SrcNoEa, XRSurfaceData.IntRgbX11), new XRMaskFill(SurfaceType.AnyColor, CompositeType.SrcOver, XRSurfaceData.IntArgbPreX11), new XRMaskFill(SurfaceType.OpaqueColor, CompositeType.SrcNoEa, XRSurfaceData.IntArgbPreX11), new XRMaskFill(SurfaceType.GradientPaint, CompositeType.SrcOver, XRSurfaceData.IntArgbPreX11), new XRMaskFill(SurfaceType.OpaqueGradientPaint, CompositeType.SrcNoEa, XRSurfaceData.IntArgbPreX11), new XRMaskFill(SurfaceType.LinearGradientPaint, CompositeType.SrcOver, XRSurfaceData.IntArgbPreX11), new XRMaskFill(SurfaceType.OpaqueLinearGradientPaint, CompositeType.SrcNoEa, XRSurfaceData.IntArgbPreX11), new XRMaskFill(SurfaceType.RadialGradientPaint, CompositeType.SrcOver, XRSurfaceData.IntArgbPreX11), new XRMaskFill(SurfaceType.OpaqueRadialGradientPaint, CompositeType.SrcNoEa, XRSurfaceData.IntArgbPreX11), new XRMaskFill(SurfaceType.TexturePaint, CompositeType.SrcOver, XRSurfaceData.IntArgbPreX11), new XRMaskFill(SurfaceType.OpaqueTexturePaint, CompositeType.SrcNoEa, XRSurfaceData.IntArgbPreX11) };
/*     */ 
/*  85 */     GraphicsPrimitiveMgr.register(arrayOfGraphicsPrimitive);
/*     */   }
/*     */ 
/*     */   protected XRMaskFill(SurfaceType paramSurfaceType1, CompositeType paramCompositeType, SurfaceType paramSurfaceType2)
/*     */   {
/*  90 */     super(paramSurfaceType1, paramCompositeType, paramSurfaceType2);
/*     */   }
/*     */ 
/*     */   protected native void maskFill(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, byte[] paramArrayOfByte);
/*     */ 
/*     */   public void MaskFill(SunGraphics2D paramSunGraphics2D, SurfaceData paramSurfaceData, Composite paramComposite, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5, int paramInt6)
/*     */   {
/*     */     try
/*     */     {
/* 100 */       SunToolkit.awtLock();
/*     */ 
/* 102 */       XRSurfaceData localXRSurfaceData = (XRSurfaceData)paramSurfaceData;
/* 103 */       localXRSurfaceData.validateAsDestination(null, paramSunGraphics2D.getCompClip());
/*     */ 
/* 105 */       XRCompositeManager localXRCompositeManager = localXRSurfaceData.maskBuffer;
/* 106 */       localXRCompositeManager.validateCompositeState(paramComposite, paramSunGraphics2D.transform, paramSunGraphics2D.paint, paramSunGraphics2D);
/*     */ 
/* 108 */       int i = localXRCompositeManager.getMaskBuffer().uploadMask(paramInt3, paramInt4, paramInt6, paramInt5, paramArrayOfByte);
/* 109 */       localXRCompositeManager.XRComposite(0, i, localXRSurfaceData.picture, paramInt1, paramInt2, 0, 0, paramInt1, paramInt2, paramInt3, paramInt4);
/* 110 */       localXRCompositeManager.getMaskBuffer().clearUploadMask(i, paramInt3, paramInt4);
/*     */     } finally {
/* 112 */       SunToolkit.awtUnlock();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.java2d.xr.XRMaskFill
 * JD-Core Version:    0.6.2
 */