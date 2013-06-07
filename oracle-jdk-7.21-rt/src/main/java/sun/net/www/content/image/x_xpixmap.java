/*    */ package sun.net.www.content.image;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import java.awt.Toolkit;
/*    */ import java.io.IOException;
/*    */ import java.net.ContentHandler;
/*    */ import java.net.URLConnection;
/*    */ import sun.awt.image.URLImageSource;
/*    */ 
/*    */ public class x_xpixmap extends ContentHandler
/*    */ {
/*    */   public Object getContent(URLConnection paramURLConnection)
/*    */     throws IOException
/*    */   {
/* 35 */     return new URLImageSource(paramURLConnection);
/*    */   }
/*    */ 
/*    */   public Object getContent(URLConnection paramURLConnection, Class[] paramArrayOfClass) throws IOException {
/* 39 */     for (int i = 0; i < paramArrayOfClass.length; i++) {
/* 40 */       if (paramArrayOfClass[i].isAssignableFrom(URLImageSource.class)) {
/* 41 */         return new URLImageSource(paramURLConnection);
/*    */       }
/* 43 */       if (paramArrayOfClass[i].isAssignableFrom(Image.class)) {
/* 44 */         Toolkit localToolkit = Toolkit.getDefaultToolkit();
/* 45 */         return localToolkit.createImage(new URLImageSource(paramURLConnection));
/*    */       }
/*    */     }
/* 48 */     return null;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.net.www.content.image.x_xpixmap
 * JD-Core Version:    0.6.2
 */