package java.awt.peer;

import java.awt.Dimension;

public abstract interface TextAreaPeer extends TextComponentPeer
{
  public abstract void insert(String paramString, int paramInt);

  public abstract void replaceRange(String paramString, int paramInt1, int paramInt2);

  public abstract Dimension getPreferredSize(int paramInt1, int paramInt2);

  public abstract Dimension getMinimumSize(int paramInt1, int paramInt2);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     java.awt.peer.TextAreaPeer
 * JD-Core Version:    0.6.2
 */