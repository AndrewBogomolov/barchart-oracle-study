package sun.awt;

import java.util.EventListener;

public abstract interface DisplayChangedListener extends EventListener
{
  public abstract void displayChanged();

  public abstract void paletteChanged();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.awt.DisplayChangedListener
 * JD-Core Version:    0.6.2
 */