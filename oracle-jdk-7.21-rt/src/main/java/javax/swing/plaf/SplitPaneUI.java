package javax.swing.plaf;

import java.awt.Graphics;
import javax.swing.JSplitPane;

public abstract class SplitPaneUI extends ComponentUI
{
  public abstract void resetToPreferredSizes(JSplitPane paramJSplitPane);

  public abstract void setDividerLocation(JSplitPane paramJSplitPane, int paramInt);

  public abstract int getDividerLocation(JSplitPane paramJSplitPane);

  public abstract int getMinimumDividerLocation(JSplitPane paramJSplitPane);

  public abstract int getMaximumDividerLocation(JSplitPane paramJSplitPane);

  public abstract void finishedPaintingChildren(JSplitPane paramJSplitPane, Graphics paramGraphics);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.swing.plaf.SplitPaneUI
 * JD-Core Version:    0.6.2
 */