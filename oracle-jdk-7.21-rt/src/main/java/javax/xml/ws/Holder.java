/*    */ package javax.xml.ws;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public final class Holder<T>
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 2623699057546497185L;
/*    */   public T value;
/*    */ 
/*    */   public Holder()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Holder(T value)
/*    */   {
/* 56 */     this.value = value;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.xml.ws.Holder
 * JD-Core Version:    0.6.2
 */