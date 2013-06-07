package javax.management.remote;

import java.io.IOException;
import java.util.Map;
import javax.management.MBeanServer;

public abstract interface JMXConnectorServerProvider
{
  public abstract JMXConnectorServer newJMXConnectorServer(JMXServiceURL paramJMXServiceURL, Map<String, ?> paramMap, MBeanServer paramMBeanServer)
    throws IOException;
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.management.remote.JMXConnectorServerProvider
 * JD-Core Version:    0.6.2
 */