package Graph;

public class Vex {
	static int num=0;
	private int pass=0;//0����Ǳ��뾭���ڵ㣬1������뾭���ڵ�
	private int id;
	Vex(){
		id=num++;
	}
	public int get_pass(){
		return pass;
	}
	public void set_pass(){
		pass=1;
	}
	public int get_id(){
		return id;
	}
//	public static void main(String[] args){
//		Vex[] a=new Vex[5];
//		for(int i=0;i<5;i++){
//			a[i]=new Vex();
//		}
//		for(int i=0;i<5;i++){
//			System.out.println(a[i].get_id());
//		}
//	}
}
