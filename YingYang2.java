public class YingYang2 extends Art {
  public YingYang2(ColorPair cp) {
    super(cp);
  }

  public void drew(float x, float y) {

    float z = (1-sw)/2;
    x+=z; 
    y+=3*sw;
    int mx = 100;
    float inc = p.TAU/mx, ng=-p.PI, r=.40f;
    p.noStroke();
    p.fill(cb);

    float lr = .2f;
    p.ellipse(x+.1f, y+.2f, lr, lr);
    p.beginShape();
    int i;
    for (i=0; i<=mx; i++)
    {
      p.vertex(x+r*p.sin(ng)/p.PI, y+r*2*i/mx);
      ng+=inc;
    }
    ng = p.HALF_PI; 
    inc/=2; 
    y+=.5-3.2f*sw;
    for (i=0; i<=mx; i++)
    {
      p.vertex(x+r*p.cos(ng), y+r*p.sin(ng));
      ng+=inc;
    }
    p.endShape();
    p.fill(ca);
    p.ellipse(x-.1f, y+.2f, lr, lr);
  }
}

