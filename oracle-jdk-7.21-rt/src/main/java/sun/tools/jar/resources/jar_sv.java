/*   */ package sun.tools.jar.resources;
/*   */ 
/*   */ import java.util.ListResourceBundle;
/*   */ 
/*   */ public final class jar_sv extends ListResourceBundle
/*   */ {
/*   */   protected final Object[][] getContents()
/*   */   {
/* 7 */     return new Object[][] { { "error.bad.cflag", "för c-flaggan måste manifest- eller indatafiler anges." }, { "error.bad.eflag", "e-flaggan och manifest med attributet Main-Class kan inte anges \ntillsammans." }, { "error.bad.option", "Ett av alternativen -{ctxu} måste anges." }, { "error.bad.uflag", "för u-flaggan måste manifest-, e-flagg- eller indatafiler anges." }, { "error.cant.open", "kan inte öppna: {0} " }, { "error.create.dir", "{0} : kunde inte skapa någon katalog" }, { "error.illegal.option", "Otillåtet alternativ: {0}" }, { "error.incorrect.length", "ogiltig längd vid bearbetning: {0}" }, { "error.nosuch.fileordir", "{0} : det finns ingen sådan fil eller katalog" }, { "error.write.file", "Det uppstod ett fel vid skrivning till befintlig jar-fil." }, { "out.added.manifest", "tillagt manifestfil" }, { "out.adding", "lägger till: {0}" }, { "out.create", "  skapad: {0}" }, { "out.deflated", "({0}% packat)" }, { "out.extracted", "extraherat: {0}" }, { "out.ignore.entry", "ignorerar posten {0}" }, { "out.inflated", "\\uppackat: {0}" }, { "out.size", "(in = {0}) (ut = {1})" }, { "out.stored", "(0% lagrat)" }, { "out.update.manifest", "uppdaterat manifest" }, { "usage", "Syntax: jar-filer {ctxui}[vfm0Me] [jar-fil] [manifestfil] [startpunkt] [-C-katalog] ...\nAlternativ:\n    -c  skapa nytt arkiv\n    -t  lista innehållsförteckning för arkiv\n    -x  extrahera namngivna (eller alla) filer från arkiv\n    -u  uppdatera befintligt arkiv\n    -v  generera utförliga utdata vid standardutmatning\n    -f  ange arkivfilens namn\n    -m  inkludera manifestinformation från angivet manifest\n    -e  ange programstartpunkt för fristående applikation \n        som medföljer i en jar-programfil\n    -0  endast lagra  (ingen zip-komprimering)\n    -M  skapa inte någon manifestfil för posterna\n    -i  generera indexinformation för de angivna jar-filerna\n    -C  ändra till den angivna katalogen och inkludera följande fil\nOm en fil är en katalog bearbetas den rekursivt.\nNamnen på manifestfilen, arkivfilen och startpunkten anges i samma\nordning som m-, f- och e-flaggorna.\n\nExempel 1: Så här arkiverar du två klassfiler i ett arkiv med namnet classes.jar: \n       jar cvf classes.jar Foo.class Bar.class \nExempel 2: Använd en befintlig manifestfil (mymanifest) och arkivera alla\n           filer från katalogen foo/ i classes.jar: \n       jar cvfm classes.jar mymanifest -C foo/ .\n" } };
/*   */   }
/*   */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.tools.jar.resources.jar_sv
 * JD-Core Version:    0.6.2
 */