/*    */ package sun.java2d.pipe;
/*    */ 
/*    */ import sun.font.GlyphList;
/*    */ import sun.java2d.SunGraphics2D;
/*    */ import sun.java2d.loops.DrawGlyphListAA;
/*    */ import sun.java2d.loops.RenderLoops;
/*    */ 
/*    */ public class AATextRenderer extends GlyphListLoopPipe
/*    */   implements LoopBasedPipe
/*    */ {
/*    */   protected void drawGlyphList(SunGraphics2D paramSunGraphics2D, GlyphList paramGlyphList)
/*    */   {
/* 41 */     paramSunGraphics2D.loops.drawGlyphListAALoop.DrawGlyphListAA(paramSunGraphics2D, paramSunGraphics2D.surfaceData, paramGlyphList);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.java2d.pipe.AATextRenderer
 * JD-Core Version:    0.6.2
 */