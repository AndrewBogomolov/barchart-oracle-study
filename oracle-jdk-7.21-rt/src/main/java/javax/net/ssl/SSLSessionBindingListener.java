package javax.net.ssl;

import java.util.EventListener;

public abstract interface SSLSessionBindingListener extends EventListener
{
  public abstract void valueBound(SSLSessionBindingEvent paramSSLSessionBindingEvent);

  public abstract void valueUnbound(SSLSessionBindingEvent paramSSLSessionBindingEvent);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.net.ssl.SSLSessionBindingListener
 * JD-Core Version:    0.6.2
 */