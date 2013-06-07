package javax.swing.text;

import java.awt.Graphics;
import java.awt.Shape;

public abstract class LayeredHighlighter
  implements Highlighter
{
  public abstract void paintLayeredHighlights(Graphics paramGraphics, int paramInt1, int paramInt2, Shape paramShape, JTextComponent paramJTextComponent, View paramView);

  public static abstract class LayerPainter
    implements Highlighter.HighlightPainter
  {
    public abstract Shape paintLayer(Graphics paramGraphics, int paramInt1, int paramInt2, Shape paramShape, JTextComponent paramJTextComponent, View paramView);
  }
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.swing.text.LayeredHighlighter
 * JD-Core Version:    0.6.2
 */