package java.nio.file.attribute;

import java.util.Set;

public abstract interface PosixFileAttributes extends BasicFileAttributes
{
  public abstract UserPrincipal owner();

  public abstract GroupPrincipal group();

  public abstract Set<PosixFilePermission> permissions();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.nio.file.attribute.PosixFileAttributes
 * JD-Core Version:    0.6.2
 */