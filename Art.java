import processing.core.*;

public abstract class Art {
  int ca, cb; //the 2 colors
  static float sw=.03f; //border width
  public static PApplet p;

  public Art(ColorPair cp)
    {ca=cp.ca; cb=cp.cb;}

  public void draw(float x, float y)
  {
    p.println("XX"+x+" : "+y);
    p.fill(ca);
    p.stroke(cb);
    p.strokeWeight(sw);
    p.rect(x, y, 1-sw, 1-sw, .08f);
    drew(x, y);
  }

  public abstract void drew(float x, float y);
}

