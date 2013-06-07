/*    */ package org.omg.DynamicAny;
/*    */ 
/*    */ import org.omg.CORBA.Any;
/*    */ import org.omg.CORBA.ORB;
/*    */ import org.omg.CORBA.TypeCode;
/*    */ import org.omg.CORBA.portable.InputStream;
/*    */ import org.omg.CORBA.portable.OutputStream;
/*    */ 
/*    */ public abstract class NameValuePairSeqHelper
/*    */ {
/* 13 */   private static String _id = "IDL:omg.org/DynamicAny/NameValuePairSeq:1.0";
/*    */ 
/* 28 */   private static TypeCode __typeCode = null;
/*    */ 
/*    */   public static void insert(Any paramAny, NameValuePair[] paramArrayOfNameValuePair)
/*    */   {
/* 17 */     OutputStream localOutputStream = paramAny.create_output_stream();
/* 18 */     paramAny.type(type());
/* 19 */     write(localOutputStream, paramArrayOfNameValuePair);
/* 20 */     paramAny.read_value(localOutputStream.create_input_stream(), type());
/*    */   }
/*    */ 
/*    */   public static NameValuePair[] extract(Any paramAny)
/*    */   {
/* 25 */     return read(paramAny.create_input_stream());
/*    */   }
/*    */ 
/*    */   public static synchronized TypeCode type()
/*    */   {
/* 31 */     if (__typeCode == null)
/*    */     {
/* 33 */       __typeCode = NameValuePairHelper.type();
/* 34 */       __typeCode = ORB.init().create_sequence_tc(0, __typeCode);
/* 35 */       __typeCode = ORB.init().create_alias_tc(id(), "NameValuePairSeq", __typeCode);
/*    */     }
/* 37 */     return __typeCode;
/*    */   }
/*    */ 
/*    */   public static String id()
/*    */   {
/* 42 */     return _id;
/*    */   }
/*    */ 
/*    */   public static NameValuePair[] read(InputStream paramInputStream)
/*    */   {
/* 47 */     NameValuePair[] arrayOfNameValuePair = null;
/* 48 */     int i = paramInputStream.read_long();
/* 49 */     arrayOfNameValuePair = new NameValuePair[i];
/* 50 */     for (int j = 0; j < arrayOfNameValuePair.length; j++)
/* 51 */       arrayOfNameValuePair[j] = NameValuePairHelper.read(paramInputStream);
/* 52 */     return arrayOfNameValuePair;
/*    */   }
/*    */ 
/*    */   public static void write(OutputStream paramOutputStream, NameValuePair[] paramArrayOfNameValuePair)
/*    */   {
/* 57 */     paramOutputStream.write_long(paramArrayOfNameValuePair.length);
/* 58 */     for (int i = 0; i < paramArrayOfNameValuePair.length; i++)
/* 59 */       NameValuePairHelper.write(paramOutputStream, paramArrayOfNameValuePair[i]);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     org.omg.DynamicAny.NameValuePairSeqHelper
 * JD-Core Version:    0.6.2
 */