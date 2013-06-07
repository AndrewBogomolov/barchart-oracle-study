package java.awt.event;

import java.util.EventListener;

public abstract interface ComponentListener extends EventListener
{
  public abstract void componentResized(ComponentEvent paramComponentEvent);

  public abstract void componentMoved(ComponentEvent paramComponentEvent);

  public abstract void componentShown(ComponentEvent paramComponentEvent);

  public abstract void componentHidden(ComponentEvent paramComponentEvent);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.awt.event.ComponentListener
 * JD-Core Version:    0.6.2
 */