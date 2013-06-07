package javax.management;

import java.io.Serializable;

public abstract interface ValueExp extends Serializable
{
  public abstract ValueExp apply(ObjectName paramObjectName)
    throws BadStringOperationException, BadBinaryOpValueExpException, BadAttributeValueExpException, InvalidApplicationException;

  @Deprecated
  public abstract void setMBeanServer(MBeanServer paramMBeanServer);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.management.ValueExp
 * JD-Core Version:    0.6.2
 */