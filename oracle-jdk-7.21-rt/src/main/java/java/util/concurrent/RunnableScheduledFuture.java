package java.util.concurrent;

public abstract interface RunnableScheduledFuture<V> extends RunnableFuture<V>, ScheduledFuture<V>
{
  public abstract boolean isPeriodic();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.util.concurrent.RunnableScheduledFuture
 * JD-Core Version:    0.6.2
 */