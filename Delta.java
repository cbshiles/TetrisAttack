public class Delta extends Art{
    public Delta(ColorPair cp){super(cp);}

    public void drew(float x, float y){
    p.noStroke();
    float s=.385f, zz=(1-2*s)/2;
    x+=zz; y+=2*s+zz;
    p.fill(cb);
    dTri(x, y, s);
    p.fill(ca);
    float z = s/4;
    dTri(x+z, y-z/2, s*.65f);
    }
    
  private void dTri(float x, float y, float s) {
    p.beginShape();
    p.vertex(x, y);
    p.vertex(x+s, y-2*s);
    p.vertex(x+2*s, y);
    p.endShape();
  }

}  
