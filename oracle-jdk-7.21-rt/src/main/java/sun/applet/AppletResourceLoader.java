/*    */ package sun.applet;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import java.net.URL;
/*    */ import sun.misc.Ref;
/*    */ 
/*    */ public class AppletResourceLoader
/*    */ {
/*    */   public static Image getImage(URL paramURL)
/*    */   {
/* 38 */     return AppletViewer.getCachedImage(paramURL);
/*    */   }
/*    */ 
/*    */   public static Ref getImageRef(URL paramURL) {
/* 42 */     return AppletViewer.getCachedImageRef(paramURL);
/*    */   }
/*    */ 
/*    */   public static void flushImages() {
/* 46 */     AppletViewer.flushImageCache();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.applet.AppletResourceLoader
 * JD-Core Version:    0.6.2
 */