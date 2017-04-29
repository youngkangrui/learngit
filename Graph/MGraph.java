package Graph;

import java.util.ArrayList;
import java.util.Collections;

public class MGraph {
	private int vexnum,arcnum;
	private Vex[] vexs;
	private Arc[][] arcs;
	MGraph(int vexnum,int arcnum,Vex[] vexs,Arc[][] arcs){
		this.vexnum=vexnum;
		this.arcnum=arcnum;
		this.vexs=vexs;
		this.arcs=arcs;
	}
	public int get_vexnum(){
		return vexnum;
	}
	public int get_arcnum(){
		return arcnum;
	}
	public Vex[] get_vexs(){
		return vexs;
	}
	public Arc[][] get_arcs(){
		return arcs;
	}
	public static void DIJ(MGraph graph){
		ArrayList<Vex> vexs=new ArrayList<Vex>();
		Collections.addAll(vexs, graph.get_vexs());
		vexs.remove(0);
		Arc[][] arcs=graph.get_arcs();
		int n=0;int[] D=new int[18];D[0]=Integer.MAX_VALUE;
		for(int i=1;i<=17;i++){
			D[i]=arcs[0][i].get_v();
		}
		int min;Vex v;
		n=min(D);//最小路径的终点id
		min=D[n];//保存当前最小路径
		D[n]=Integer.MAX_VALUE;//使得已经找到最短路径的重点不再参与比较
		v=get(n,vexs);
		vexs.remove(v);
		for(int i=2;i<=17;i++){
			for(Vex vex:vexs){
				int id=vex.get_id();
				if(D[id]-min>arcs[n][id].get_v()){
						D[id]=min+arcs[n][id].get_v();
					}
			}
			n=min(D);
			min=D[n];
			if(n==16)System.out.println(min);
			D[n]=Integer.MAX_VALUE;
			v=get(n,vexs);
			vexs.remove(v);
		}
	}
	public static int min(int[] D){
		int min=0;
		for(int i=1;i<D.length;i++){
			if(D[i]<D[min])min=i;
		}
		return min;
	}
	public static Vex get(int id,ArrayList<Vex> vexs){
		int i=0;
		while(vexs.get(i).get_id()!=id){
			i++;
		}
		return vexs.get(i);
	}
	public static void main(String[] args){
		Vex[] vexs=new Vex[18];Arc[][] arcs=new Arc[18][18];
		for(int i=0;i<18;i++)vexs[i]=new Vex();
		for(int i=0;i<18;i++){
			for(int j=i;j<18;j++){
				arcs[i][j]=new Arc();
				arcs[j][i]=arcs[i][j];
			}
		}
		vexs[7].set_pass();vexs[12].set_pass();
		arcs[0][1].set_v(3);
		arcs[0][2].set_v(1);
		arcs[0][3].set_v(1);
		arcs[1][2].set_v(1);
		arcs[1][4].set_v(1);
		arcs[1][9].set_v(4);
		arcs[2][3].set_v(1);
		arcs[2][4].set_v(2);arcs[2][4].set_pass();
		arcs[2][5].set_v(1);
		arcs[3][5].set_v(2);
		arcs[3][6].set_v(2);
		arcs[3][7].set_v(1);
		arcs[4][5].set_v(1);
		arcs[4][9].set_v(1);
		arcs[5][6].set_v(1);
		arcs[5][9].set_v(3);
		arcs[5][10].set_v(1);
		arcs[5][12].set_v(3);
		arcs[6][7].set_v(1);
		arcs[6][8].set_v(2);
		arcs[6][14].set_v(3);
		arcs[6][13].set_v(4);
		arcs[6][12].set_v(2);
		arcs[7][8].set_v(1);
		arcs[8][14].set_v(1);
		arcs[8][15].set_v(3);
		arcs[9][10].set_v(1);
		arcs[9][11].set_v(1);
		arcs[10][11].set_v(1);
		arcs[10][12].set_v(2);
	    arcs[11][12].set_v(1);
		arcs[11][16].set_v(1);
		arcs[12][13].set_v(2);
		arcs[12][16].set_v(1);
		arcs[13][16].set_v(2);
		arcs[13][14].set_v(1);arcs[13][14].set_pass();
		arcs[13][15].set_v(2);
		arcs[13][17].set_v(1);
		arcs[14][15].set_v(1);
		arcs[15][17].set_v(4);
		MGraph graph=new MGraph(18,39,vexs,arcs);
		MGraph.DIJ(graph);
	}
}
