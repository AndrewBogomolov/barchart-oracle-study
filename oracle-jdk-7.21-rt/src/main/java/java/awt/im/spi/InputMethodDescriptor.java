package java.awt.im.spi;

import java.awt.AWTException;
import java.awt.Image;
import java.util.Locale;

public abstract interface InputMethodDescriptor
{
  public abstract Locale[] getAvailableLocales()
    throws AWTException;

  public abstract boolean hasDynamicLocaleList();

  public abstract String getInputMethodDisplayName(Locale paramLocale1, Locale paramLocale2);

  public abstract Image getInputMethodIcon(Locale paramLocale);

  public abstract InputMethod createInputMethod()
    throws Exception;
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.awt.im.spi.InputMethodDescriptor
 * JD-Core Version:    0.6.2
 */