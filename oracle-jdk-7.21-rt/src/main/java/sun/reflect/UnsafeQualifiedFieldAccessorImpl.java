/*    */ package sun.reflect;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ 
/*    */ abstract class UnsafeQualifiedFieldAccessorImpl extends UnsafeFieldAccessorImpl
/*    */ {
/*    */   protected final boolean isReadOnly;
/*    */ 
/*    */   UnsafeQualifiedFieldAccessorImpl(Field paramField, boolean paramBoolean)
/*    */   {
/* 49 */     super(paramField);
/* 50 */     this.isReadOnly = paramBoolean;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.reflect.UnsafeQualifiedFieldAccessorImpl
 * JD-Core Version:    0.6.2
 */