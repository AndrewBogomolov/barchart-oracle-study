package javax.sql;

import java.sql.SQLException;

public abstract interface XADataSource extends CommonDataSource
{
  public abstract XAConnection getXAConnection()
    throws SQLException;

  public abstract XAConnection getXAConnection(String paramString1, String paramString2)
    throws SQLException;
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.sql.XADataSource
 * JD-Core Version:    0.6.2
 */