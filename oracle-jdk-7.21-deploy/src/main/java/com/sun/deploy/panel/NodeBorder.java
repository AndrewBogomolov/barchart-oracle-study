package com.sun.deploy.panel;

import java.awt.Color;
import javax.swing.border.LineBorder;

public class NodeBorder extends LineBorder
{
  public NodeBorder(Color paramColor)
  {
    super(paramColor);
  }

  public NodeBorder(Color paramColor, int paramInt)
  {
    super(paramColor, paramInt);
  }

  public NodeBorder(Color paramColor, int paramInt, boolean paramBoolean)
  {
    super(paramColor, paramInt, paramBoolean);
  }

  public void setBorderColor(Color paramColor)
  {
    this.lineColor = paramColor;
  }
}

/* Location:           /home/user1/Temp/jvm/deploy.jar
 * Qualified Name:     com.sun.deploy.panel.NodeBorder
 * JD-Core Version:    0.6.2
 */