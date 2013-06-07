package javax.sql;

import java.sql.Connection;
import java.sql.SQLException;

public abstract interface PooledConnection
{
  public abstract Connection getConnection()
    throws SQLException;

  public abstract void close()
    throws SQLException;

  public abstract void addConnectionEventListener(ConnectionEventListener paramConnectionEventListener);

  public abstract void removeConnectionEventListener(ConnectionEventListener paramConnectionEventListener);

  public abstract void addStatementEventListener(StatementEventListener paramStatementEventListener);

  public abstract void removeStatementEventListener(StatementEventListener paramStatementEventListener);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.sql.PooledConnection
 * JD-Core Version:    0.6.2
 */