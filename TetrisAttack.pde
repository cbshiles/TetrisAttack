// -*- mode: java  -*-
import java.util.*;

float oh=0, ow=0, sk;
Board board;

ColorPair getCP(ArrayList<ColorPair> arr){
  Random rando = new Random(System.currentTimeMillis());
  int x = rando.nextInt(arr.size());
   ColorPair cp =  arr.get(x);
    arr.remove(x);
    return cp;
}

void setup() {
  size(800, 800);
  //noLoop();

  frame.setResizable(true);
  //background(255);
  frameRate(15);


  //ColorPair.colour == color
  
  ArrayList<ColorPair> colors = new  ArrayList<ColorPair>();
  colors.add(new ColorPair(color(100, 233, 33), .4)); //lamdba
  colors.add(new ColorPair(color(70, 30, 5), .9)); //Delta
  colors.add(new ColorPair(color(50, 50, 140), color(255, 220, 155))); //Xi
  colors.add(new ColorPair(color(67, 127, 127), .8)); //Star
   int bl = 195;
  colors.add(new ColorPair(color(bl), 1-bl/255f)); //Ying_Yang
  colors.add(new ColorPair(color(254, 220, 6), .4));//Nstar
  
  
  
  ArrayList<Art> drawings = new ArrayList<Art>();
  drawings.add(new Lambda(getCP(colors)));
  drawings.add(new Delta(getCP(colors)));
  drawings.add(new Xi(getCP(colors)));
  drawings.add(new Star(getCP(colors)));

  drawings.add(new YinYang(getCP(colors)));
  drawings.add(new Nstar(getCP(colors)));
  
    board = new Board(height, drawings);
  Art.p = this;
}

void draw() {
  clear();
  //translate((width - height/2)/2,0); 
  if (oh != height || ow != width) {
    oh = height; ow=width;
    float ysk = oh*3/4/13;
    float xsk = ow*2/5/6;
    sk = xsk<ysk?xsk:ysk;
  }
  

  translate(width*3/10, height/8);
  scale(sk, sk);

  board.draw();
}

