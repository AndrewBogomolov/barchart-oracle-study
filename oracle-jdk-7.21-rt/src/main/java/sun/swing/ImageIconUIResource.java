/*    */ package sun.swing;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.plaf.UIResource;
/*    */ 
/*    */ public class ImageIconUIResource extends ImageIcon
/*    */   implements UIResource
/*    */ {
/*    */   public ImageIconUIResource(byte[] paramArrayOfByte)
/*    */   {
/* 47 */     super(paramArrayOfByte);
/*    */   }
/*    */ 
/*    */   public ImageIconUIResource(Image paramImage)
/*    */   {
/* 57 */     super(paramImage);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.swing.ImageIconUIResource
 * JD-Core Version:    0.6.2
 */