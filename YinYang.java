public class YinYang extends Art {
  public YinYang(ColorPair cp) {
    super(cp);
  }
  static final float rads = 6.283185307f; 
  
  public void cirk(float x, float y,float r,  float b, float e){
    float ii = rads/100;
    boolean zf = false, flip = b > e, loop=true;
    for (float i = b; loop; i +=  ii)
    {
      if (i > e && (!flip || zf))
      {
        loop = false;
      }
      else if ( flip && i > rads )
      {
         i = 0; 
         zf = true;
      }
      p.vertex(x+r*p.cos(i), y+r*p.sin(i));
    }
  }
  
    public void Bcirk(float x, float y,float r,  float b, float e){
    float ii = rads/100;
    boolean zf = false, flip = b < e, loop=true;
    for (float i = b; loop; i -=  ii)
    {
      if (i < e && (!flip || zf))
      {
        loop = false;
      }
      else if ( flip && i < 0 )
      {
         i = rads; 
         zf = true;
      }
      p.vertex(x+r*p.cos(i), y+r*p.sin(i));
    }
  }
  
  public void drew(float x, float y) {
    p.fill(cb);
        p.noStroke();
    p.beginShape();

//background
  cirk(x+.5f, y+.5f, .4f, p.HALF_PI, 3*p.HALF_PI);
  //other point .7 .3
  p.vertex(x+.5f,y-sw/2);
  p.vertex(x,y-sw/2);
  
  p.vertex(x,y+1);
  p.vertex(x+.5f,y+1);
  

  p.endShape();
 
   //main curve
   p.fill(cb);
   p.beginShape();
   cirk(x+.5f,y+.3f,.2f,3*p.HALF_PI,p.HALF_PI);
   Bcirk(x+.5f,y+.7f,.2f,3*p.HALF_PI,p.HALF_PI);
   Bcirk(x+.5f,y+.5f,.4f,p.HALF_PI,3*p.HALF_PI);
   p.endShape();
   
   //dark dot
   p.ellipse(x+.5f,y+.3f,.14f,.14f);
   
   p.fill(ca);
   p.ellipse(x+.5f,y+.7f,.14f,.14f);
 
  }
  
  public void drew2(float x, float y) {  
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

