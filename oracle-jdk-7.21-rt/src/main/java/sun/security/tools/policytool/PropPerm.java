/*      */ package sun.security.tools.policytool;
/*      */ 
/*      */ class PropPerm extends Perm
/*      */ {
/*      */   public PropPerm()
/*      */   {
/* 3952 */     super("PropertyPermission", "java.util.PropertyPermission", new String[0], new String[] { "read", "write" });
/*      */   }
/*      */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.security.tools.policytool.PropPerm
 * JD-Core Version:    0.6.2
 */