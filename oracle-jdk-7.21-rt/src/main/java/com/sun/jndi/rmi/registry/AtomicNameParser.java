/*     */ package com.sun.jndi.rmi.registry;
/*     */ 
/*     */ import java.util.Properties;
/*     */ import javax.naming.CompoundName;
/*     */ import javax.naming.Name;
/*     */ import javax.naming.NameParser;
/*     */ import javax.naming.NamingException;
/*     */ 
/*     */ class AtomicNameParser
/*     */   implements NameParser
/*     */ {
/* 477 */   private static final Properties syntax = new Properties();
/*     */ 
/*     */   public Name parse(String paramString) throws NamingException {
/* 480 */     return new CompoundName(paramString, syntax);
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.jndi.rmi.registry.AtomicNameParser
 * JD-Core Version:    0.6.2
 */