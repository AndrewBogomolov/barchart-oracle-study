/*    */ package javax.print.event;
/*    */ 
/*    */ import java.util.EventObject;
/*    */ 
/*    */ public class PrintEvent extends EventObject
/*    */ {
/*    */   private static final long serialVersionUID = 2286914924430763847L;
/*    */ 
/*    */   public PrintEvent(Object paramObject)
/*    */   {
/* 44 */     super(paramObject);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 51 */     return "PrintEvent on " + getSource().toString();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.print.event.PrintEvent
 * JD-Core Version:    0.6.2
 */