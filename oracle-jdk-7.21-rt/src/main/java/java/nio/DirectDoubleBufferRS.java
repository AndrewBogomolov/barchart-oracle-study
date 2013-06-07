/*     */ package java.nio;
/*     */ 
/*     */ import sun.nio.ch.DirectBuffer;
/*     */ 
/*     */ class DirectDoubleBufferRS extends DirectDoubleBufferS
/*     */   implements DirectBuffer
/*     */ {
/*     */   DirectDoubleBufferRS(DirectBuffer paramDirectBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
/*     */   {
/* 202 */     super(paramDirectBuffer, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */   public DoubleBuffer slice()
/*     */   {
/* 207 */     int i = position();
/* 208 */     int j = limit();
/* 209 */     assert (i <= j);
/* 210 */     int k = i <= j ? j - i : 0;
/* 211 */     int m = i << 3;
/* 212 */     assert (m >= 0);
/* 213 */     return new DirectDoubleBufferRS(this, -1, 0, k, k, m);
/*     */   }
/*     */ 
/*     */   public DoubleBuffer duplicate() {
/* 217 */     return new DirectDoubleBufferRS(this, markValue(), position(), limit(), capacity(), 0);
/*     */   }
/*     */ 
/*     */   public DoubleBuffer asReadOnlyBuffer()
/*     */   {
/* 234 */     return duplicate();
/*     */   }
/*     */ 
/*     */   public DoubleBuffer put(double paramDouble)
/*     */   {
/* 294 */     throw new ReadOnlyBufferException();
/*     */   }
/*     */ 
/*     */   public DoubleBuffer put(int paramInt, double paramDouble)
/*     */   {
/* 303 */     throw new ReadOnlyBufferException();
/*     */   }
/*     */ 
/*     */   public DoubleBuffer put(DoubleBuffer paramDoubleBuffer)
/*     */   {
/* 344 */     throw new ReadOnlyBufferException();
/*     */   }
/*     */ 
/*     */   public DoubleBuffer put(double[] paramArrayOfDouble, int paramInt1, int paramInt2)
/*     */   {
/* 373 */     throw new ReadOnlyBufferException();
/*     */   }
/*     */ 
/*     */   public DoubleBuffer compact()
/*     */   {
/* 390 */     throw new ReadOnlyBufferException();
/*     */   }
/*     */ 
/*     */   public boolean isDirect()
/*     */   {
/* 395 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean isReadOnly() {
/* 399 */     return true;
/*     */   }
/*     */ 
/*     */   public ByteOrder order()
/*     */   {
/* 450 */     return ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.nio.DirectDoubleBufferRS
 * JD-Core Version:    0.6.2
 */