/*    */ package sun.reflect.generics.tree;
/*    */ 
/*    */ import sun.reflect.generics.visitor.TypeTreeVisitor;
/*    */ 
/*    */ public class LongSignature
/*    */   implements BaseType
/*    */ {
/* 32 */   private static LongSignature singleton = new LongSignature();
/*    */ 
/*    */   public static LongSignature make()
/*    */   {
/* 36 */     return singleton;
/*    */   }
/* 38 */   public void accept(TypeTreeVisitor<?> paramTypeTreeVisitor) { paramTypeTreeVisitor.visitLongSignature(this); }
/*    */ 
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.reflect.generics.tree.LongSignature
 * JD-Core Version:    0.6.2
 */