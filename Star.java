public class Star extends Art{
    public Star(ColorPair cp){super(cp);}

    public void drew(float x, float y){
      x+=.5; y+= .5;
     p.stroke(ca); p.fill(cb);
    p.strokeWeight(.0143f);
    float s = 16f;//5/4.0f*8f;
    float len = .44f;
    float del = len*.55f;
    float the = p.TAU/s;
    float ng = 0.2f;
    boolean b = false, yy=false;
    p.beginShape();
    float rot = the;//+.1f;
    float dg = rot+2.0f*p.TAU;
    while (ng <= dg) {

      float z = b?len:len-del;
      if (ng > p.TAU+rot && !yy) {
        b = !b;
        z = b?len:len-del;
        float m = 6.5f;
        b = true; 
        yy  = true; 
        ng=p.TAU;
      }

      p.curveVertex(x+z*p.sin(ng), y+z*p.cos(ng));
      b = !b;
      ng += the;
    }
    p.endShape();     
    }
}
