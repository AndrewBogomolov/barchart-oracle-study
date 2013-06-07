package javax.swing.plaf;

import java.awt.Rectangle;
import javax.swing.JTabbedPane;

public abstract class TabbedPaneUI extends ComponentUI
{
  public abstract int tabForCoordinate(JTabbedPane paramJTabbedPane, int paramInt1, int paramInt2);

  public abstract Rectangle getTabBounds(JTabbedPane paramJTabbedPane, int paramInt);

  public abstract int getTabRunCount(JTabbedPane paramJTabbedPane);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.swing.plaf.TabbedPaneUI
 * JD-Core Version:    0.6.2
 */