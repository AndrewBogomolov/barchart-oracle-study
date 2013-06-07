/*    */ package sun.misc;
/*    */ 
/*    */ public class Lock
/*    */ {
/* 62 */   private boolean locked = false;
/*    */ 
/*    */   public final synchronized void lock()
/*    */     throws InterruptedException
/*    */   {
/* 79 */     while (this.locked) {
/* 80 */       wait();
/*    */     }
/* 82 */     this.locked = true;
/*    */   }
/*    */ 
/*    */   public final synchronized void unlock()
/*    */   {
/* 90 */     this.locked = false;
/* 91 */     notifyAll();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.misc.Lock
 * JD-Core Version:    0.6.2
 */