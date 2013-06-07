package java.nio.file.attribute;

import java.io.IOException;

public abstract interface DosFileAttributeView extends BasicFileAttributeView
{
  public abstract String name();

  public abstract DosFileAttributes readAttributes()
    throws IOException;

  public abstract void setReadOnly(boolean paramBoolean)
    throws IOException;

  public abstract void setHidden(boolean paramBoolean)
    throws IOException;

  public abstract void setSystem(boolean paramBoolean)
    throws IOException;

  public abstract void setArchive(boolean paramBoolean)
    throws IOException;
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.nio.file.attribute.DosFileAttributeView
 * JD-Core Version:    0.6.2
 */