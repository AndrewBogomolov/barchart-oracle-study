package javax.sql;

import java.util.EventListener;

public abstract interface ConnectionEventListener extends EventListener
{
  public abstract void connectionClosed(ConnectionEvent paramConnectionEvent);

  public abstract void connectionErrorOccurred(ConnectionEvent paramConnectionEvent);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.sql.ConnectionEventListener
 * JD-Core Version:    0.6.2
 */