package com.sun.management;

public abstract interface ThreadMXBean extends java.lang.management.ThreadMXBean
{
  public abstract long[] getThreadCpuTime(long[] paramArrayOfLong);

  public abstract long[] getThreadUserTime(long[] paramArrayOfLong);

  public abstract long getThreadAllocatedBytes(long paramLong);

  public abstract long[] getThreadAllocatedBytes(long[] paramArrayOfLong);

  public abstract boolean isThreadAllocatedMemorySupported();

  public abstract boolean isThreadAllocatedMemoryEnabled();

  public abstract void setThreadAllocatedMemoryEnabled(boolean paramBoolean);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.management.ThreadMXBean
 * JD-Core Version:    0.6.2
 */