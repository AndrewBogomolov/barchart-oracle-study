/*    */ package sun.management.snmp.jvmmib;
/*    */ 
/*    */ import com.sun.jmx.snmp.Enumerated;
/*    */ import java.io.Serializable;
/*    */ import java.util.Hashtable;
/*    */ 
/*    */ public class EnumJvmMemPoolState extends Enumerated
/*    */   implements Serializable
/*    */ {
/* 46 */   protected static Hashtable<Integer, String> intTable = new Hashtable();
/*    */ 
/* 48 */   protected static Hashtable<String, Integer> stringTable = new Hashtable();
/*    */ 
/*    */   public EnumJvmMemPoolState(int paramInt)
/*    */     throws IllegalArgumentException
/*    */   {
/* 58 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   public EnumJvmMemPoolState(Integer paramInteger) throws IllegalArgumentException {
/* 62 */     super(paramInteger);
/*    */   }
/*    */ 
/*    */   public EnumJvmMemPoolState() throws IllegalArgumentException
/*    */   {
/*    */   }
/*    */ 
/*    */   public EnumJvmMemPoolState(String paramString) throws IllegalArgumentException {
/* 70 */     super(paramString);
/*    */   }
/*    */ 
/*    */   protected Hashtable getIntTable() {
/* 74 */     return intTable;
/*    */   }
/*    */ 
/*    */   protected Hashtable getStringTable() {
/* 78 */     return stringTable;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 51 */     intTable.put(new Integer(2), "valid");
/* 52 */     intTable.put(new Integer(1), "invalid");
/* 53 */     stringTable.put("valid", new Integer(2));
/* 54 */     stringTable.put("invalid", new Integer(1));
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.management.snmp.jvmmib.EnumJvmMemPoolState
 * JD-Core Version:    0.6.2
 */