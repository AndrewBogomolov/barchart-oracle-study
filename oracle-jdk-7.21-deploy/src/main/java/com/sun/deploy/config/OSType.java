package com.sun.deploy.config;

public class OSType
{
  public static final int WINDOWS = 1;
  public static final int UNIX = 2;
  public static final int MACOSX = 3;
  private static final int _osType;

  public static int getOSType()
  {
    return _osType;
  }

  public static boolean isMac()
  {
    return _osType == 3;
  }

  public static boolean isWin()
  {
    return _osType == 1;
  }

  public static boolean isUnix()
  {
    return _osType == 2;
  }

  static
  {
    String str = System.getProperty("os.name");
    if (str.startsWith("Win"))
      _osType = 1;
    else if (str.indexOf("OS X") != -1)
      _osType = 3;
    else
      _osType = 2;
  }
}

/* Location:           /home/user1/Temp/jvm/deploy.jar
 * Qualified Name:     com.sun.deploy.config.OSType
 * JD-Core Version:    0.6.2
 */