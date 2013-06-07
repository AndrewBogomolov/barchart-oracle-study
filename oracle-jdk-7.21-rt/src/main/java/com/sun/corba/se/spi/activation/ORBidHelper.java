/*    */ package com.sun.corba.se.spi.activation;
/*    */ 
/*    */ import org.omg.CORBA.Any;
/*    */ import org.omg.CORBA.ORB;
/*    */ import org.omg.CORBA.TypeCode;
/*    */ import org.omg.CORBA.portable.InputStream;
/*    */ import org.omg.CORBA.portable.OutputStream;
/*    */ 
/*    */ public abstract class ORBidHelper
/*    */ {
/* 15 */   private static String _id = "IDL:activation/ORBid:1.0";
/*    */ 
/* 30 */   private static TypeCode __typeCode = null;
/*    */ 
/*    */   public static void insert(Any paramAny, String paramString)
/*    */   {
/* 19 */     OutputStream localOutputStream = paramAny.create_output_stream();
/* 20 */     paramAny.type(type());
/* 21 */     write(localOutputStream, paramString);
/* 22 */     paramAny.read_value(localOutputStream.create_input_stream(), type());
/*    */   }
/*    */ 
/*    */   public static String extract(Any paramAny)
/*    */   {
/* 27 */     return read(paramAny.create_input_stream());
/*    */   }
/*    */ 
/*    */   public static synchronized TypeCode type()
/*    */   {
/* 33 */     if (__typeCode == null)
/*    */     {
/* 35 */       __typeCode = ORB.init().create_string_tc(0);
/* 36 */       __typeCode = ORB.init().create_alias_tc(id(), "ORBid", __typeCode);
/*    */     }
/* 38 */     return __typeCode;
/*    */   }
/*    */ 
/*    */   public static String id()
/*    */   {
/* 43 */     return _id;
/*    */   }
/*    */ 
/*    */   public static String read(InputStream paramInputStream)
/*    */   {
/* 48 */     String str = null;
/* 49 */     str = paramInputStream.read_string();
/* 50 */     return str;
/*    */   }
/*    */ 
/*    */   public static void write(OutputStream paramOutputStream, String paramString)
/*    */   {
/* 55 */     paramOutputStream.write_string(paramString);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.corba.se.spi.activation.ORBidHelper
 * JD-Core Version:    0.6.2
 */