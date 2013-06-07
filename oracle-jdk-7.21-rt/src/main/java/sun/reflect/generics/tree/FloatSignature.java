/*    */ package sun.reflect.generics.tree;
/*    */ 
/*    */ import sun.reflect.generics.visitor.TypeTreeVisitor;
/*    */ 
/*    */ public class FloatSignature
/*    */   implements BaseType
/*    */ {
/* 32 */   private static FloatSignature singleton = new FloatSignature();
/*    */ 
/*    */   public static FloatSignature make()
/*    */   {
/* 36 */     return singleton;
/*    */   }
/* 38 */   public void accept(TypeTreeVisitor<?> paramTypeTreeVisitor) { paramTypeTreeVisitor.visitFloatSignature(this); }
/*    */ 
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.reflect.generics.tree.FloatSignature
 * JD-Core Version:    0.6.2
 */