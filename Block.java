public class Block {
    Art art;

    public Block(Art a){art=a;}

    public void draw(float x, float y){
	art.draw(x,y);
    }

}
