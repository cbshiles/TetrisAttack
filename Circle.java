public class Circle extends Art{
    public Circle(ColorPair cp){super(cp);}

    public void drew(float x, float y){
      p.fill(cb);
      p.ellipse(x+.5f, y+.5f, .8f,.8f);
      p.fill(ca);
      p.ellipse(x+.5f, y+.5f, .8f,.4f);
    }
}
