package java.awt.datatransfer;

import java.util.Map;

public abstract interface FlavorMap
{
  public abstract Map<DataFlavor, String> getNativesForFlavors(DataFlavor[] paramArrayOfDataFlavor);

  public abstract Map<String, DataFlavor> getFlavorsForNatives(String[] paramArrayOfString);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.awt.datatransfer.FlavorMap
 * JD-Core Version:    0.6.2
 */