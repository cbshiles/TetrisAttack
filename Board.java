import java.util.ArrayList;

public class Board {
  static final int xd=6, yd=12, ty=yd+5; //tb = top buffer, how much above it can go
  static final int tz = xd*ty;
  float sz;
  ArrayList<Block> blocks;
  public Board(int h){
    resize(h);
    blocks = new ArrayList<Block>(tz);
    
    for (int i=0; i<tz; i++){
      if (i < tz-xd)
        {blocks.add(null);}
      else
        {blocks.add(null);} //Add the actual row
    }
  }
  
  void resize(int h) {
  sz = h / (float)yd;
}
  
  void draw(){
  Block b;
  for (int i=0; i<tz; i++){
     b = blocks.get(i);
 //    if (b != null) b.draw(i%xd,i/xd);
    }
  }
}
