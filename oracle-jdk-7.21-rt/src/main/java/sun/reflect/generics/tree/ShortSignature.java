/*    */ package sun.reflect.generics.tree;
/*    */ 
/*    */ import sun.reflect.generics.visitor.TypeTreeVisitor;
/*    */ 
/*    */ public class ShortSignature
/*    */   implements BaseType
/*    */ {
/* 32 */   private static ShortSignature singleton = new ShortSignature();
/*    */ 
/*    */   public static ShortSignature make()
/*    */   {
/* 36 */     return singleton;
/*    */   }
/*    */   public void accept(TypeTreeVisitor<?> paramTypeTreeVisitor) {
/* 39 */     paramTypeTreeVisitor.visitShortSignature(this);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.reflect.generics.tree.ShortSignature
 * JD-Core Version:    0.6.2
 */