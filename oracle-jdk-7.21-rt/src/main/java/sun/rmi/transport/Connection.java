package sun.rmi.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface Connection
{
  public abstract InputStream getInputStream()
    throws IOException;

  public abstract void releaseInputStream()
    throws IOException;

  public abstract OutputStream getOutputStream()
    throws IOException;

  public abstract void releaseOutputStream()
    throws IOException;

  public abstract boolean isReusable();

  public abstract void close()
    throws IOException;

  public abstract Channel getChannel();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.rmi.transport.Connection
 * JD-Core Version:    0.6.2
 */