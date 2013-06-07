/*    */ package java.awt.dnd;
/*    */ 
/*    */ import java.util.EventObject;
/*    */ 
/*    */ public class DropTargetEvent extends EventObject
/*    */ {
/*    */   private static final long serialVersionUID = 2821229066521922993L;
/*    */   protected DropTargetContext context;
/*    */ 
/*    */   public DropTargetEvent(DropTargetContext paramDropTargetContext)
/*    */   {
/* 58 */     super(paramDropTargetContext.getDropTarget());
/*    */ 
/* 60 */     this.context = paramDropTargetContext;
/*    */   }
/*    */ 
/*    */   public DropTargetContext getDropTargetContext()
/*    */   {
/* 71 */     return this.context;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.awt.dnd.DropTargetEvent
 * JD-Core Version:    0.6.2
 */