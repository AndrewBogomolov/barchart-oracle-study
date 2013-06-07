package java.nio.file;

import java.util.List;

public abstract interface WatchKey
{
  public abstract boolean isValid();

  public abstract List<WatchEvent<?>> pollEvents();

  public abstract boolean reset();

  public abstract void cancel();

  public abstract Watchable watchable();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.nio.file.WatchKey
 * JD-Core Version:    0.6.2
 */