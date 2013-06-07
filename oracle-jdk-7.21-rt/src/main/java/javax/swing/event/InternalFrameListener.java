package javax.swing.event;

import java.util.EventListener;

public abstract interface InternalFrameListener extends EventListener
{
  public abstract void internalFrameOpened(InternalFrameEvent paramInternalFrameEvent);

  public abstract void internalFrameClosing(InternalFrameEvent paramInternalFrameEvent);

  public abstract void internalFrameClosed(InternalFrameEvent paramInternalFrameEvent);

  public abstract void internalFrameIconified(InternalFrameEvent paramInternalFrameEvent);

  public abstract void internalFrameDeiconified(InternalFrameEvent paramInternalFrameEvent);

  public abstract void internalFrameActivated(InternalFrameEvent paramInternalFrameEvent);

  public abstract void internalFrameDeactivated(InternalFrameEvent paramInternalFrameEvent);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.swing.event.InternalFrameListener
 * JD-Core Version:    0.6.2
 */