/*    */ package org.omg.CosNaming;
/*    */ 
/*    */ import org.omg.CORBA.portable.IDLEntity;
/*    */ 
/*    */ public final class NameComponent
/*    */   implements IDLEntity
/*    */ {
/* 13 */   public String id = null;
/* 14 */   public String kind = null;
/*    */ 
/*    */   public NameComponent()
/*    */   {
/*    */   }
/*    */ 
/*    */   public NameComponent(String paramString1, String paramString2)
/*    */   {
/* 22 */     this.id = paramString1;
/* 23 */     this.kind = paramString2;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     org.omg.CosNaming.NameComponent
 * JD-Core Version:    0.6.2
 */