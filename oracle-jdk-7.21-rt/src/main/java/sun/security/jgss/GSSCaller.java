/*    */ package sun.security.jgss;
/*    */ 
/*    */ public class GSSCaller
/*    */ {
/* 34 */   public static final GSSCaller CALLER_UNKNOWN = new GSSCaller();
/* 35 */   public static final GSSCaller CALLER_INITIATE = new GSSCaller();
/* 36 */   public static final GSSCaller CALLER_ACCEPT = new GSSCaller();
/* 37 */   public static final GSSCaller CALLER_SSL_CLIENT = new GSSCaller();
/* 38 */   public static final GSSCaller CALLER_SSL_SERVER = new GSSCaller();
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.security.jgss.GSSCaller
 * JD-Core Version:    0.6.2
 */