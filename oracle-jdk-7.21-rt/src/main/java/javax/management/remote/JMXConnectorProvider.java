package javax.management.remote;

import java.io.IOException;
import java.util.Map;

public abstract interface JMXConnectorProvider
{
  public abstract JMXConnector newJMXConnector(JMXServiceURL paramJMXServiceURL, Map<String, ?> paramMap)
    throws IOException;
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.management.remote.JMXConnectorProvider
 * JD-Core Version:    0.6.2
 */