package javax.swing.plaf.synth;

import java.awt.Graphics;
import javax.swing.JComponent;

public abstract interface SynthUI extends SynthConstants
{
  public abstract SynthContext getContext(JComponent paramJComponent);

  public abstract void paintBorder(SynthContext paramSynthContext, Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.swing.plaf.synth.SynthUI
 * JD-Core Version:    0.6.2
 */