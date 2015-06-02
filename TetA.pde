int oh;
Board board;
Block[] test = new Block[6];

void setup() {
  size(600, 600);
  noLoop();

  frame.setResizable(true);
  //background(255);
  //frameRate(16);

  board = new Board(height);
  oh = height;
  Art.p = this;
  int i = 0;
  //ColorPair.colour == color
  
  test[i++] = new Block(new Lambda(new ColorPair(color(100, 233, 33), .4)));
  test[i++] = new Block(new Delta(new ColorPair(color(70, 30, 5), .9)));
  test[i++] = new Block(new Xi(new ColorPair(color(25, 7, 0), .8)));
  test[i++] = new Block(new Star(new ColorPair(color(67, 127, 127), .8)));
  int bl = 189;
  test[i++] = new Block(new YinYang(new ColorPair(color(bl), 1-bl/255f)));
  for (int j=i; j<6; j++)
    test[j]=null;
}

void draw() {
  //translate((width - height/2)/2,0); 
  translate(0, height/2);
  int sk = 100;
  scale(sk, sk);

  if (oh != height) {
    board.resize(height);
    oh = height;
  }

  //board.draw();
  for (int i =0; i<6; i++) {
    if (test[i] != null)
    {
      test[i].art.draw(i, 0); 
    }
  }
}

