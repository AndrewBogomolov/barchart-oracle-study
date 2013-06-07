package javax.management.openmbean;

import javax.management.MBeanParameterInfo;

public abstract interface OpenMBeanOperationInfo
{
  public abstract String getDescription();

  public abstract String getName();

  public abstract MBeanParameterInfo[] getSignature();

  public abstract int getImpact();

  public abstract String getReturnType();

  public abstract OpenType<?> getReturnOpenType();

  public abstract boolean equals(Object paramObject);

  public abstract int hashCode();

  public abstract String toString();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.management.openmbean.OpenMBeanOperationInfo
 * JD-Core Version:    0.6.2
 */