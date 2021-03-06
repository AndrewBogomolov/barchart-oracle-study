package com.sun.deploy.association.utility;

import com.sun.deploy.model.LocalApplicationProperties;
import java.net.URL;
import java.util.List;

public class GnomeAppAssociationReader
  implements AppAssociationReader
{
  public GnomeAppAssociationReader(LocalApplicationProperties paramLocalApplicationProperties)
  {
  }

  public String getDescriptionByMimeType(String paramString)
  {
    return GnomeAssociationUtil.getDescriptionByMimeType(paramString);
  }

  public String getDescriptionByFileExt(String paramString)
  {
    paramString = AppUtility.removeDotFromFileExtension(paramString);
    if (getMimeTypeByFileExt(paramString) == null)
      return null;
    return getDescriptionByMimeType(getMimeTypeByFileExt(paramString));
  }

  public String getMimeTypeByURL(URL paramURL)
  {
    return GnomeAssociationUtil.getMimeTypeByURL(paramURL);
  }

  public List getFileExtListByMimeType(String paramString)
  {
    return GnomeAssociationUtil.getFileExtListByMimeType(paramString);
  }

  public String getMimeTypeByFileExt(String paramString)
  {
    paramString = AppUtility.removeDotFromFileExtension(paramString);
    return GnomeAssociationUtil.getMimeTypeByFileExt(paramString);
  }

  public String getIconFileNameByMimeType(String paramString)
  {
    return GnomeAssociationUtil.getIconFileNameByMimeType(paramString);
  }

  public String getIconFileNameByFileExt(String paramString)
  {
    paramString = AppUtility.removeDotFromFileExtension(paramString);
    if (getMimeTypeByFileExt(paramString) == null)
      return null;
    return getIconFileNameByMimeType(getMimeTypeByFileExt(paramString));
  }

  public List getActionListByMimeType(String paramString)
  {
    return GnomeAssociationUtil.getActionListByMimeType(paramString);
  }

  public List getActionListByFileExt(String paramString)
  {
    paramString = AppUtility.removeDotFromFileExtension(paramString);
    if (getMimeTypeByFileExt(paramString) == null)
      return null;
    return getActionListByMimeType(getMimeTypeByFileExt(paramString));
  }

  public boolean isMimeTypeExist(String paramString)
  {
    return GnomeAssociationUtil.isMimeTypeExist(paramString);
  }

  public boolean isFileExtExist(String paramString)
  {
    paramString = AppUtility.removeDotFromFileExtension(paramString);
    return GnomeAssociationUtil.isFileExtExist(paramString);
  }

  public List getAssociations()
  {
    throw new RuntimeException("Unexpected call");
  }
}

/* Location:           /home/user1/Temp/jvm/deploy.jar
 * Qualified Name:     com.sun.deploy.association.utility.GnomeAppAssociationReader
 * JD-Core Version:    0.6.2
 */