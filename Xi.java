public class Xi extends Art{
    public Xi(ColorPair cp){super(cp);}

    public void drew(float x, float y){
    p.noStroke();
    float s = .8f, zz = (1-s-sw/2)/2;
    x+=zz; y+=zz;
    float m = s/2.0f;
    p.fill(cb);
    p.rect(x, y, s, s, s/10);
    p.fill(ca);
    p.rect(x-.01f, y+s/10, s+.02f, s*8f/10, s/6.6f);
    p.fill(cb);
    float xr=s/3.0f, yr=s/7.6f;
    p.rect(x+m-xr, y+m-yr, 2.0f*xr, 2.0f*yr);
    p.fill(ca);
    float z = s/9.5f;

    p.rect(x+m-xr+z/2, y+m-yr-z, 2*xr-z, 2*yr-z, z);
    p.rect(x+m-xr+z/2, y+m-yr+2*z, 2*xr-z, 2*yr-z, z);
  }
  
}
