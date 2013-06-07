/*     */ package sun.nio.cs;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetDecoder;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ 
/*     */ public class KOI8_R extends Charset
/*     */   implements HistoricallyNamedCharset
/*     */ {
/*     */   private static final String b2cTable = "";
/* 105 */   private static final char[] b2c = "".toCharArray();
/* 106 */   private static final char[] c2b = new char[1280];
/* 107 */   private static final char[] c2bIndex = new char[256];
/*     */ 
/*     */   public KOI8_R()
/*     */   {
/*  39 */     super("KOI8-R", StandardCharsets.aliases_KOI8_R);
/*     */   }
/*     */ 
/*     */   public String historicalName() {
/*  43 */     return "KOI8_R";
/*     */   }
/*     */ 
/*     */   public boolean contains(Charset paramCharset) {
/*  47 */     return (paramCharset.name().equals("US-ASCII")) || ((paramCharset instanceof KOI8_R));
/*     */   }
/*     */ 
/*     */   public CharsetDecoder newDecoder() {
/*  51 */     return new SingleByte.Decoder(this, b2c);
/*     */   }
/*     */ 
/*     */   public CharsetEncoder newEncoder() {
/*  55 */     return new SingleByte.Encoder(this, c2b, c2bIndex);
/*     */   }
/*     */ 
/*     */   public String getDecoderSingleByteMappings() {
/*  59 */     return "";
/*     */   }
/*     */ 
/*     */   public char[] getEncoderIndex2() {
/*  63 */     return c2b;
/*     */   }
/*     */ 
/*     */   public char[] getEncoderIndex1() {
/*  67 */     return c2bIndex;
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/* 110 */     char[] arrayOfChar1 = b2c;
/* 111 */     char[] arrayOfChar2 = null;
/* 112 */     SingleByte.initC2B(arrayOfChar1, arrayOfChar2, c2b, c2bIndex);
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.nio.cs.KOI8_R
 * JD-Core Version:    0.6.2
 */