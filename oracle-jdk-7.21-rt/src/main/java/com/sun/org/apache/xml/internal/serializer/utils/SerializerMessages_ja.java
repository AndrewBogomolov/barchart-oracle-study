/*     */ package com.sun.org.apache.xml.internal.serializer.utils;
/*     */ 
/*     */ import java.util.ListResourceBundle;
/*     */ 
/*     */ public class SerializerMessages_ja extends ListResourceBundle
/*     */ {
/*     */   public Object[][] getContents()
/*     */   {
/*  30 */     Object[][] contents = { { "ER_SERIALIZER_NOT_CONTENTHANDLER", "シリアライザー・クラス ''{0}'' は org.xml.sax.ContentHandler をインプリメントしません。" }, { "ER_RESOURCE_COULD_NOT_FIND", "リソース [ {0} ] は見つかりませんでした。\n {1}" }, { "ER_RESOURCE_COULD_NOT_LOAD", "リソース [ {0} ] をロードできませんでした: {1} \n {2} \n {3}" }, { "ER_BUFFER_SIZE_LESSTHAN_ZERO", "バッファー・サイズ <=0" }, { "ER_INVALID_UTF16_SURROGATE", "無効な UTF-16 サロゲートが検出されました: {0} ?" }, { "ER_OIERROR", "入出力エラー" }, { "ER_ILLEGAL_ATTRIBUTE_POSITION", "下位ノードの後またはエレメントが生成される前に属性 {0} を追加できません。属性は無視されます。" }, { "ER_NAMESPACE_PREFIX", "接頭部 ''{0}'' のネーム・スペースが宣言されていません。" }, { "ER_STRAY_NAMESPACE", "ネーム・スペース宣言 ''{0}''=''{1}'' がエレメントの外側です。" }, { "ER_COULD_NOT_LOAD_RESOURCE", "''{0}'' をロードできませんでした (CLASSPATH を調べてください)。現在は単にデフォルトを使用しています。" }, { "ER_COULD_NOT_LOAD_METHOD_PROPERTY", "出力メソッド ''{1}'' のプロパティー・ファイル ''{0}'' をロードできませんでした (CLASSPATH を確認)" }, { "ER_INVALID_PORT", "無効なポート番号" }, { "ER_PORT_WHEN_HOST_NULL", "ホストがヌルであるとポートを設定できません" }, { "ER_HOST_ADDRESS_NOT_WELLFORMED", "ホストはうまく構成されたアドレスでありません" }, { "ER_SCHEME_NOT_CONFORMANT", "スキームは一致していません。" }, { "ER_SCHEME_FROM_NULL_STRING", "ヌル・ストリングからはスキームを設定できません" }, { "ER_PATH_CONTAINS_INVALID_ESCAPE_SEQUENCE", "パスに無効なエスケープ・シーケンスが含まれています" }, { "ER_PATH_INVALID_CHAR", "パスに無効文字: {0} が含まれています" }, { "ER_FRAG_INVALID_CHAR", "フラグメントに無効文字が含まれています" }, { "ER_FRAG_WHEN_PATH_NULL", "パスがヌルであるとフラグメントを設定できません" }, { "ER_FRAG_FOR_GENERIC_URI", "総称 URI のフラグメントしか設定できません" }, { "ER_NO_SCHEME_IN_URI", "スキームは URI {0} で見つかりません" }, { "ER_CANNOT_INIT_URI_EMPTY_PARMS", "URI は空のパラメーターを使用して初期化できません" }, { "ER_NO_FRAGMENT_STRING_IN_PATH", "フラグメントはパスとフラグメントの両方に指定できません" }, { "ER_NO_QUERY_STRING_IN_PATH", "照会ストリングはパスおよび照会ストリング内に指定できません" }, { "ER_NO_PORT_IF_NO_HOST", "ホストが指定されていない場合はポートを指定してはいけません" }, { "ER_NO_USERINFO_IF_NO_HOST", "ホストが指定されていない場合は Userinfo を指定してはいけません" }, { "ER_SCHEME_REQUIRED", "スキームが必要です!" } };
/*     */ 
/* 120 */     return contents;
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_ja
 * JD-Core Version:    0.6.2
 */