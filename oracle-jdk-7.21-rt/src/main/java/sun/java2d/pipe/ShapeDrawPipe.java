package sun.java2d.pipe;

import java.awt.Shape;
import sun.java2d.SunGraphics2D;

public abstract interface ShapeDrawPipe
{
  public abstract void draw(SunGraphics2D paramSunGraphics2D, Shape paramShape);

  public abstract void fill(SunGraphics2D paramSunGraphics2D, Shape paramShape);
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.java2d.pipe.ShapeDrawPipe
 * JD-Core Version:    0.6.2
 */