// -*- mode: java  -*-
import java.util.*;

float oh=0, ow=0, sk;
Board board;

void setup() {
  size(800, 800);
  //noLoop();

  frame.setResizable(true);
  //background(255);
  frameRate(15);


  //ColorPair.colour == color
  
  ArrayList<Art> drawings = new ArrayList<Art>();
  drawings.add(new Lambda(new ColorPair(color(100, 233, 33), .4)));
  drawings.add(new Delta(new ColorPair(color(70, 30, 5), .9)));
  drawings.add(new Xi(new ColorPair(color(50, 50, 140), color(255, 220, 155))));
  drawings.add(new Star(new ColorPair(color(67, 127, 127), .8)));
  int bl = 195;
  drawings.add(new YinYang(new ColorPair(color(bl), 1-bl/255f)));
  drawings.add(new Nstar(new ColorPair(color(254, 220, 6), .4)));
  
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

