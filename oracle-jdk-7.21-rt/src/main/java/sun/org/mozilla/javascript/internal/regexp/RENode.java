/*      */ package sun.org.mozilla.javascript.internal.regexp;
/*      */ 
/*      */ class RENode
/*      */ {
/*      */   byte op;
/*      */   RENode next;
/*      */   RENode kid;
/*      */   RENode kid2;
/*      */   int parenIndex;
/*      */   int min;
/*      */   int max;
/*      */   int parenCount;
/*      */   boolean greedy;
/*      */   int startIndex;
/*      */   int kidlen;
/*      */   int bmsize;
/*      */   int index;
/*      */   char chr;
/*      */   int length;
/*      */   int flatIndex;
/*      */ 
/*      */   RENode(byte paramByte)
/*      */   {
/* 2631 */     this.op = paramByte;
/*      */   }
/*      */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.org.mozilla.javascript.internal.regexp.RENode
 * JD-Core Version:    0.6.2
 */