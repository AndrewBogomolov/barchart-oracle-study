package sun.java2d.pipe.hw;

import java.awt.image.VolatileImage;

public abstract interface AccelGraphicsConfig extends BufferedContextProvider
{
  public abstract VolatileImage createCompatibleVolatileImage(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public abstract ContextCapabilities getContextCapabilities();

  public abstract void addDeviceEventListener(AccelDeviceEventListener paramAccelDeviceEventListener);

  public abstract void removeDeviceEventListener(AccelDeviceEventListener paramAccelDeviceEventListener);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.java2d.pipe.hw.AccelGraphicsConfig
 * JD-Core Version:    0.6.2
 */