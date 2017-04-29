package Graph;
//first explain
//second explain
//third explain
public class Arc {
	private int v=Integer.MAX_VALUE;//È¨ÖØ
	private int pass=0;//ÊÇ·ñ±ØÐë¾­¹ý£»
	public int get_v(){
		return v;
	}
	public int get_pass(){
		return pass;
	}
	public void set_pass(){
		pass=1;
	}
	public void set_v(int x){
		v=x;
	}
}
