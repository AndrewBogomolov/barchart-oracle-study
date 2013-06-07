package javax.sql;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public abstract interface CommonDataSource
{
  public abstract PrintWriter getLogWriter()
    throws SQLException;

  public abstract void setLogWriter(PrintWriter paramPrintWriter)
    throws SQLException;

  public abstract void setLoginTimeout(int paramInt)
    throws SQLException;

  public abstract int getLoginTimeout()
    throws SQLException;

  public abstract Logger getParentLogger()
    throws SQLFeatureNotSupportedException;
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.sql.CommonDataSource
 * JD-Core Version:    0.6.2
 */