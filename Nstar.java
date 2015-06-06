public class Nstar extends Art{
    public Nstar(ColorPair cp){super(cp);}

    public void drew(float x, float y){
    p.noStroke();
     x += .5; y += .5 ;
     p.stroke(255); 
     p.fill(cb);
    p.strokeWeight(.0143f);
    
   druw(x, y,4);
    }
    
  private void druw(float x, float y, int s) {
  float i = 3*s+1;
  float len = .7f;
  float del = len/1.7f;
  float the = i;
  float sx ,sy;
  

  p.beginShape();
  
  while (i != 0) {
    
    sy = del*p.sin(the);
    sx = del*p.cos(the);
    
    if (i % 2 == 0) {
      sx *= p.pow(-1,i%s/2);
      p.vertex(x-sx, y-sy);
    } else {
      p.vertex(x+sx, y+sy);
    }
    i -= 1;
    the += p.PI/s;
  }

  p.endShape();
  }

}  





