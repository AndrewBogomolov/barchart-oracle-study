package java.nio.channels;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;

public abstract interface MulticastChannel extends NetworkChannel
{
  public abstract void close()
    throws IOException;

  public abstract MembershipKey join(InetAddress paramInetAddress, NetworkInterface paramNetworkInterface)
    throws IOException;

  public abstract MembershipKey join(InetAddress paramInetAddress1, NetworkInterface paramNetworkInterface, InetAddress paramInetAddress2)
    throws IOException;
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.nio.channels.MulticastChannel
 * JD-Core Version:    0.6.2
 */