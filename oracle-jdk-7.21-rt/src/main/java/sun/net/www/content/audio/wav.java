/*    */ package sun.net.www.content.audio;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.ContentHandler;
/*    */ import java.net.URLConnection;
/*    */ import sun.applet.AppletAudioClip;
/*    */ 
/*    */ public class wav extends ContentHandler
/*    */ {
/*    */   public Object getContent(URLConnection paramURLConnection)
/*    */     throws IOException
/*    */   {
/* 41 */     return new AppletAudioClip(paramURLConnection);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.net.www.content.audio.wav
 * JD-Core Version:    0.6.2
 */