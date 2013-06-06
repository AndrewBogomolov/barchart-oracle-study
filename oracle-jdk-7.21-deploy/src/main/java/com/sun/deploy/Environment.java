package com.sun.deploy;

import com.sun.deploy.config.Config;
import com.sun.deploy.config.Platform;
import com.sun.deploy.trace.Trace;
import com.sun.deploy.trace.TraceLevel;
import com.sun.deploy.util.StringUtils;
import com.sun.deploy.util.SystemUtils;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Date;

public class Environment
{
  public static final int ENV_PLUGIN = 0;
  public static final int ENV_JAVAWS = 1;
  public static final int ENV_JCP = 2;
  private static int environmentType = 0;
  public static final int JAVAFX_INSTALL_ONDEMAND = 0;
  public static final int JAVAFX_INSTALL_PRELOAD_INSTALLER = 1;
  public static final int JAVAFX_INSTALL_AUTOUPDATE = 2;
  private static int javaFxInstallMode = 0;
  private static boolean getenvSupported = true;
  private static boolean _javafx_install_initiated = false;
  private static boolean _isWebJava = true;
  private static boolean _isJavawsAppletLifecycle = false;
  private static String codebaseOverride = null;
  private static URL codebase = null;
  private static Date timestamp = null;
  private static Date expiration = null;
  private static String userAgent = null;
  private static boolean isSystemCache = false;
  private static boolean isSilentMode = false;
  private static boolean isImportMode = false;
  private static boolean isInstallMode = false;
  private static boolean _getenvSupported = true;
  private static String _javaHome;
  private static File deployment_home = null;
  private static String deploy_home_path = null;

  public static boolean isJavawsAppletLifecycle()
  {
    return _isJavawsAppletLifecycle;
  }

  public static void setJavawsAppletLifecycle(boolean paramBoolean)
  {
    _isJavawsAppletLifecycle = paramBoolean;
  }

  public static boolean isWebJava()
  {
    return _isWebJava;
  }

  public static void setIsWebJava(boolean paramBoolean)
  {
    _isWebJava = paramBoolean;
  }

  public static boolean isJavaFXInstallInitiated()
  {
    return _javafx_install_initiated;
  }

  public static void setDownloadInitiated(boolean paramBoolean)
  {
    if (getJavaFxInstallMode() != 0)
      _javafx_install_initiated = paramBoolean;
  }

  public static boolean allowAltJavaFxRuntimeURL()
  {
    try
    {
      if ((getenvSupported) && (System.getenv("ALLOW_ALT_JAVAFX_RT_URL") != null))
        return true;
    }
    catch (Error localError)
    {
      getenvSupported = false;
    }
    return false;
  }

  public static int getJavaFxInstallMode()
  {
    return javaFxInstallMode;
  }

  public static void setJavaFxInstallMode(int paramInt)
  {
    if ((!isImportMode()) && ((paramInt == 1) || (paramInt == 2)))
      return;
    javaFxInstallMode = paramInt;
  }

  public static void setEnvironmentType(int paramInt)
  {
    environmentType = paramInt;
  }

  public static boolean isJavaWebStart()
  {
    return environmentType == 1;
  }

  public static boolean isJavaControlPanel()
  {
    return environmentType == 2;
  }

  public static boolean isJavaPlugin()
  {
    return environmentType == 0;
  }

  public static void setImportModeTimestamp(Date paramDate)
  {
    timestamp = paramDate;
  }

  public static Date getImportModeTimestamp()
  {
    return timestamp;
  }

  public static void setImportModeExpiration(Date paramDate)
  {
    expiration = paramDate;
  }

  public static Date getImportModeExpiration()
  {
    return expiration;
  }

  public static void setImportModeCodebase(URL paramURL)
  {
    codebase = paramURL;
  }

  public static void setImportModeCodebaseOverride(String paramString)
  {
    if ((paramString != null) && (!paramString.endsWith("/")))
      paramString = paramString + "/";
    codebaseOverride = paramString;
  }

  public static URL getImportModeCodebase()
  {
    return codebase;
  }

  public static String getImportModeCodebaseOverride()
  {
    return codebaseOverride;
  }

  public static void setUserAgent(String paramString)
  {
    userAgent = paramString;
  }

  public static String getUserAgent()
  {
    return userAgent;
  }

  public static boolean isSystemCacheMode()
  {
    return isSystemCache;
  }

  public static void setSystemCacheMode(boolean paramBoolean)
  {
    isSystemCache = paramBoolean;
  }

  public static boolean isSilentMode()
  {
    return isSilentMode;
  }

  public static void setSilentMode(boolean paramBoolean)
  {
    isSilentMode = paramBoolean;
  }

  public static boolean isImportMode()
  {
    return isImportMode;
  }

  public static void setImportMode(boolean paramBoolean)
  {
    isImportMode = paramBoolean;
  }

  public static boolean isInstallMode()
  {
    return isInstallMode;
  }

  public static void setInstallMode(boolean paramBoolean)
  {
    isInstallMode = paramBoolean;
  }

  public static String getenv(String paramString)
  {
    try
    {
      if ((_getenvSupported) && (paramString != null))
        return System.getenv(paramString);
    }
    catch (Error localError)
    {
      _getenvSupported = false;
    }
    return null;
  }

  public static String getForcedJreRoot()
  {
    return (String)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        return Environment.getenv("FORCED_JRE_ROOT");
      }
    });
  }

  public static String getForcedDeployRoot()
  {
    return (String)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        return Environment.getenv("FORCED_DEPLOY_ROOT");
      }
    });
  }

  public static String getForcedBootClassPath()
  {
    return (String)AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        return Environment.getenv("FORCED_BOOTCLASSPATH");
      }
    });
  }

  public static boolean isForcedJreRoot(String paramString)
  {
    return (getForcedJreRoot() != null) && (paramString != null) && (paramString.startsWith(getForcedJreRoot()));
  }

  public static String getJavaHome()
  {
    if (_javaHome == null)
    {
      String str = getForcedDeployRoot();
      if (str != null)
      {
        _javaHome = str;
      }
      else
      {
        str = System.getProperty("jnlpx.home");
        if (str != null)
          str = str.substring(0, str.lastIndexOf(File.separator));
        else
          str = System.getProperty("java.home");
        _javaHome = str;
      }
    }
    return _javaHome;
  }

  public static void setJavaHome(String paramString)
  {
    _javaHome = paramString;
  }

  public static String getJavawsCommand()
  {
    String str = getDeploymentHomePath();
    if (!str.endsWith(File.separator))
      str = str + File.separator;
    str = str + "bin" + File.separator + "javaws" + Platform.get().getPlatformExtension();
    return str;
  }

  private static File constructJavawPath(File paramFile)
  {
    int i = Config.getOSName().indexOf("Windows") != -1 ? 1 : 0;
    return new File(paramFile, "bin" + File.separator + (i != 0 ? "javaw" : "java") + Platform.get().getPlatformExtension());
  }

  public static String getJavawCommand()
  {
    File localFile1 = null;
    File localFile2 = new File(SystemUtils.getJarPath(Object.class));
    if (localFile2 != null)
    {
      localFile1 = constructJavawPath(localFile2.getParentFile().getParentFile());
      if (!localFile1.exists())
        localFile1 = constructJavawPath(localFile2.getParentFile());
    }
    else
    {
      localFile1 = constructJavawPath(new File(System.getProperty("java.home")));
    }
    return localFile1.getPath();
  }

  public static File getDeploymentHome()
  {
    if (null != deployment_home)
      return deployment_home;
    String str1 = getForcedDeployRoot();
    Object localObject;
    if (str1 != null)
    {
      localObject = new File(str1);
      if ((((File)localObject).exists()) || (((File)localObject).isDirectory()))
      {
        Trace.println("Use deploy home from FORCED_DEPLOY_ROOT: " + str1, TraceLevel.BASIC);
        deployment_home = (File)localObject;
        return deployment_home;
      }
    }
    str1 = System.getProperty("sun.boot.class.path");
    try
    {
      localObject = str1.split(File.pathSeparator);
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      localObject = StringUtils.splitString(str1, File.pathSeparator);
    }
    for (int i = 0; i < localObject.length; i++)
      if (localObject[i].endsWith("deploy.jar"))
      {
        deployment_home = new File(localObject[i]).getParentFile().getParentFile();
        Trace.println("Derive deploy home from bootclasspath: " + localObject[i], TraceLevel.BASIC);
        return deployment_home;
      }
    try
    {
      String str2 = Environment.class.getProtectionDomain().getCodeSource().getLocation().getPath();
      String str3 = URLDecoder.decode(str2, "UTF-8");
      deployment_home = new File(str3).getParentFile().getParentFile();
      if (deployment_home.exists())
        return deployment_home;
      deployment_home = null;
    }
    catch (Throwable localThrowable)
    {
    }
    str1 = getJavaHome();
    Trace.println("Assume Java home: " + str1, TraceLevel.BASIC);
    deployment_home = new File(str1);
    return deployment_home;
  }

  public static String getDeploymentHomePath()
  {
    if (deploy_home_path == null)
      try
      {
        deploy_home_path = getDeploymentHome().getCanonicalPath();
      }
      catch (Exception localException)
      {
        deploy_home_path = getDeploymentHome().getPath();
      }
    return deploy_home_path;
  }
}

/* Location:           /home/user1/Temp/jvm/deploy.jar
 * Qualified Name:     com.sun.deploy.Environment
 * JD-Core Version:    0.6.2
 */