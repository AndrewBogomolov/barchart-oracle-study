/*     */ package com.sun.org.apache.xpath.internal.objects;
/*     */ 
/*     */ import com.sun.org.apache.xml.internal.utils.XMLString;
/*     */ 
/*     */ class GreaterThanOrEqualComparator extends Comparator
/*     */ {
/*     */   boolean compareStrings(XMLString s1, XMLString s2)
/*     */   {
/* 884 */     return s1.toDouble() >= s2.toDouble();
/*     */   }
/*     */ 
/*     */   boolean compareNumbers(double n1, double n2)
/*     */   {
/* 899 */     return n1 >= n2;
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xpath.internal.objects.GreaterThanOrEqualComparator
 * JD-Core Version:    0.6.2
 */