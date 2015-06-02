public class ColorPair {
    public int ca, cb;

    public ColorPair(int caa, int cbb){ca=caa; cb=cbb;}

    public ColorPair(int caa, float br){ca=caa; cb=bright(ca, br);}

    public static int colour(int r, int g, int b){
	return b+256*(g+256*r) | 0xFF000000;  
    }

    public static int bright(int c, float br){
	int r = c >> 16 & 255;
	int g = c >> 8 & 255;
	int b = c & 255;
        float m = r > g ? r : g;
        m = m > b ? m : b;
	float rt = 255.0f*br/m;
	r *= rt; b *= rt; g *= rt;
	return colour(r,g,b);
    }
    
  public static void princ(int c){
    int r = c >> 16 & 255;
    int g = c >> 8 & 255;
    int b = c & 255;
    System.out.println(r+" "+g+" "+b);
  }
}
