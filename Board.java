import java.util.ArrayList;
import java.util.Random;


public class Board {
    static final int a=12, b=5;
    static final int xd=6, yd=a+b+1;
    static final int tb = xd*yd; //total # of block slots
    int ptr=0;
    float yp=1, ii=.05f; //wheres the pointer at?, how much to increment by
    float sz;
    ArrayList<Block> blocks;
    ArrayList<Art> arts;
    Random rando;
    
    public Board(int h, ArrayList<Art> aarts){
	blocks = new ArrayList<Block>(tb);
	arts = aarts;
	
	for (int i=0; i<tb; i++)
	    blocks.add(null);


	rando = new Random(System.currentTimeMillis());
	fillRow();
	
    }

    private Block get(int x, int y){
	return blocks.get(((y+ptr)%yd)*xd+x);
    }

    private void fillRow(){
	int p = ((ptr+a)%yd)*xd, i; 
	for (i=0; i<xd; i++){
	    blocks.set(p+i, new Block(randArt()));
	}
    }

    private Art randArt(){
	return arts.get(rando.nextInt(arts.size()));
    }
  
    void draw(){
	Block b;

	int iy, ix;
	for (iy=0; iy<a+1; iy++){
	    for (ix=0; ix<xd; ix++){
		b = get(ix, iy);
		if (b != null) b.draw(ix, iy+yp);
	    }
	}
	
	yp -= ii;
	if (yp < 0) {
	    yp=1; ptr++;
	    if (ptr >= yd) {
		ptr=0;
	    }
	    fillRow();
	} 
    }

}
