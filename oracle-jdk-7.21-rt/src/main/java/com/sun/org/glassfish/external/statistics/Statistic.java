package com.sun.org.glassfish.external.statistics;

public abstract interface Statistic
{
  public abstract String getName();

  public abstract String getUnit();

  public abstract String getDescription();

  public abstract long getStartTime();

  public abstract long getLastSampleTime();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.glassfish.external.statistics.Statistic
 * JD-Core Version:    0.6.2
 */