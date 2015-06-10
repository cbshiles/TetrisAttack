import processing.core.*;

public abstract class Art {
  int ca, cb; //the 2 colors
  int da, db; //the 2 dark colors
  static float sw=.03f; //border width
  public static PApplet p;

  public Art(ColorPair cp)
    {
    ca=cp.ca; cb=cp.cb;
    ColorPair p2 = cp.dim();
    da=p2.ca; db=p2.cb;
  }

  public void draw(float x, float y)
  {
    p.fill(ca);
    p.stroke(cb);
    p.strokeWeight(sw);
    p.rect(x, y, 1-sw, 1-sw, .08f);
    drew(x, y);
  }
  
  public void darkDraw(float x, float y)
  {
   int tmpa=ca, tmpb=cb;
    ca=da;
   cb=db;
  draw(x,y);
  ca = tmpa;
  cb = tmpb;
  }

  public abstract void drew(float x, float y);
}

