package com.sun.management;

import java.io.IOException;
import java.lang.management.PlatformManagedObject;
import java.util.List;

public abstract interface HotSpotDiagnosticMXBean extends PlatformManagedObject
{
  public abstract void dumpHeap(String paramString, boolean paramBoolean)
    throws IOException;

  public abstract List<VMOption> getDiagnosticOptions();

  public abstract VMOption getVMOption(String paramString);

  public abstract void setVMOption(String paramString1, String paramString2);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.management.HotSpotDiagnosticMXBean
 * JD-Core Version:    0.6.2
 */