package java.awt.print;

import java.awt.Graphics;

public abstract interface Printable
{
  public static final int PAGE_EXISTS = 0;
  public static final int NO_SUCH_PAGE = 1;

  public abstract int print(Graphics paramGraphics, PageFormat paramPageFormat, int paramInt)
    throws PrinterException;
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.awt.print.Printable
 * JD-Core Version:    0.6.2
 */