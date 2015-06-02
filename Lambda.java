public class Lambda extends Art{
    public Lambda(ColorPair cp){super(cp);}

    public void drew(float x, float y){
    float f = .95f;
    float sh = .19f/f;
    p.noFill();

    p.strokeWeight(.16333f);
    p.stroke(cb);
    float r = .1033f, d = r*2;
    float ang = p.atan(.33333f);
    float ang1 = p.TAU - ang;

    x+=sh/.65; 
    y+=sh*1.2;
    p.arc(x, y, d, d, p.PI, ang1);
    float x1=x+r*p.cos(ang1), y1=y+r*p.sin(ang1);
    float len=.1933f, lb=.0666f;
    float x2=x1+len, y2=y1+3*len;
    p.line(x1, y1, x2, y2); 


    float x3 = x2+r*p.cos(ang), y3 = y2-r*p.sin(ang);
    p.arc(x3, y3, d, d, 0, p.PI-ang);

    float xb=x1+lb, yb=y1+3*lb;
    float angb = (float)(p.HALF_PI - ang + p.PI/4.0);
    float yc=y3+r;
    float m = p.tan(angb), b = yb-m*xb;
    float xc = (yc - b)/m;
    p.line(xb, yb, xc, yc);
  }
}
