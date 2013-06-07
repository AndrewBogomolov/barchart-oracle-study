/*    */ package sun.reflect.misc;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ 
/*    */ public final class ConstructorUtil
/*    */ {
/*    */   public static Constructor getConstructor(Class paramClass, Class[] paramArrayOfClass)
/*    */     throws NoSuchMethodException
/*    */   {
/* 37 */     ReflectUtil.checkPackageAccess(paramClass);
/* 38 */     return paramClass.getConstructor(paramArrayOfClass);
/*    */   }
/*    */ 
/*    */   public static Constructor[] getConstructors(Class paramClass) {
/* 42 */     ReflectUtil.checkPackageAccess(paramClass);
/* 43 */     return paramClass.getConstructors();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.reflect.misc.ConstructorUtil
 * JD-Core Version:    0.6.2
 */