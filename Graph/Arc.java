package Graph;
//first explain
public class Arc {
	private int v=Integer.MAX_VALUE;//Ȩ��
	private int pass=0;//�Ƿ���뾭����
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
