/*    */ package org.omg.DynamicAny.DynAnyFactoryPackage;
/*    */ 
/*    */ import org.omg.CORBA.UserException;
/*    */ 
/*    */ public final class InconsistentTypeCode extends UserException
/*    */ {
/*    */   public InconsistentTypeCode()
/*    */   {
/* 16 */     super(InconsistentTypeCodeHelper.id());
/*    */   }
/*    */ 
/*    */   public InconsistentTypeCode(String paramString)
/*    */   {
/* 22 */     super(InconsistentTypeCodeHelper.id() + "  " + paramString);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     org.omg.DynamicAny.DynAnyFactoryPackage.InconsistentTypeCode
 * JD-Core Version:    0.6.2
 */