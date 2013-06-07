package com.sun.jmx.snmp.internal;

import com.sun.jmx.snmp.SnmpEngine;
import com.sun.jmx.snmp.SnmpUnknownModelException;

public abstract interface SnmpSubSystem
{
  public abstract SnmpEngine getEngine();

  public abstract void addModel(int paramInt, SnmpModel paramSnmpModel);

  public abstract SnmpModel removeModel(int paramInt)
    throws SnmpUnknownModelException;

  public abstract SnmpModel getModel(int paramInt)
    throws SnmpUnknownModelException;

  public abstract int[] getModelIds();

  public abstract String[] getModelNames();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.jmx.snmp.internal.SnmpSubSystem
 * JD-Core Version:    0.6.2
 */