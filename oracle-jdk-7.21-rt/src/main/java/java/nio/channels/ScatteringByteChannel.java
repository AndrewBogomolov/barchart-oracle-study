package java.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract interface ScatteringByteChannel extends ReadableByteChannel
{
  public abstract long read(ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2)
    throws IOException;

  public abstract long read(ByteBuffer[] paramArrayOfByteBuffer)
    throws IOException;
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.nio.channels.ScatteringByteChannel
 * JD-Core Version:    0.6.2
 */