import java.util.*;

public class Board {
  static final int a=12, b=8;
  static final int xd=6, yd=a+b+1;
  static final int tb = xd*yd; //total # of block slots
  int ptr=0;
  float yp=1, ii=.05f; //wheres the pointer at?, how much to increment by
  float sz;
  ArrayList<Block> blocks;
  ArrayList<Art> arts;
  Random rando;
  int randP=-1; //previously selected random art
  boolean twice = false; //has the same art been selected twice in a row?
  
  int bkgd;

  public Board(int h, ArrayList<Art> aarts, int bc) {
    blocks = new ArrayList<Block>(tb);
    arts = aarts;
    bkgd = bc;

    for (int i=0; i<tb; i++)
      blocks.add(null);

    rando = new Random(System.currentTimeMillis());
    fillRow();
  }

  private Block get(int x, int y) {
    return blocks.get(((y+ptr)%yd)*xd+x);
  }

  private void fillRow() {
    int p = ((ptr+a)%yd)*xd, i; 
    for (i=0; i<xd; i++) {
      blocks.set(p+i, new Block(randArt()));
    }
    randP = -1; 
    twice = false;
  }

  private Art randArt() {
    int roll;
    if (! twice) {
      roll = rando.nextInt(arts.size());
      if (roll == randP) twice = true;
      else randP = roll;
    } else {
      roll = rando.nextInt(arts.size()-1);
      if (roll >= randP) roll++;
      randP = roll;
      twice = false;
    }
    return arts.get(roll);
  }

  void draw(float w, float h, float sk) {

    Art.p.pushMatrix();
    Art.p.translate(w*3/10, h/8);
    Art.p.scale(sk, sk);

    Block b;

    int iy, ix;
    for (iy=0; iy<a; iy++) {
      for (ix=0; ix<xd; ix++) {
        b = get(ix, iy);
        if (b != null) b.draw(ix, iy+yp);
      }
    }

    //dark row
    for (ix=0; ix<xd; ix++) {
      get(ix, iy).darkDraw(ix, iy+yp);
    }

    yp -= ii;
    if (yp < 0) {
      yp=1; 
      ptr++;
      if (ptr >= yd) {
        ptr=0;
      }
      fillRow();
    }
    
    Art.p.fill(bkgd);
    Art.p.noStroke();
    Art.p.rect(-.1f,a+1f,6.2f,1);
    Art.p.rect(-.1f,0,6.2f,1);
    
    Art.p.popMatrix();
  }
}

