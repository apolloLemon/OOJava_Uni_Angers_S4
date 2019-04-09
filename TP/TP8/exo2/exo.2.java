import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Game {

	int[][] M;
	int p;


	Game() {
		M=new int[3][3];
		p=0;
	}

	//For Kibonn:
	Collection<CaseMorpion> cases = new ArrayList<CaseMorpion>();
	void addCase(CaseMorpion c){
		cases.add(c);
	}
	void DesactiverCases(){
		for(CaseMorpion c : cases)
			c.b.setEnabled(false);
	}//

	boolean full() {
		for(int[] l : M){
			for(int i : l) {
				if(i==0) return false;
			}
		}
		return true;
	}

	boolean win(int P){
		boolean out=false;

		for(int i=0;i<3;i++){
			if(M[i][0]==P && M[i][1]==P && M[i][2]==P) out=true;
			if(M[0][i]==P && M[1][i]==P && M[2][i]==P) out=true;
		}
		if((M[0][0]==P && M[1][1]==P && M[2][2]==P) || (M[2][0]==P && M[1][1]==P && M[0][2]==P)) out=true;

		return out;
	}

	void Jouer (int x,int y){
		int P=p+1;

		if(M[x][y]==0){
			M[x][y]=P;
		}

		boolean victoire = win(P);
		if(fini()){
			System.out.println("Fini"+(P));
			DesactiverCases();//For Kibonn
		}


		p = (p+1)%2;
	}

	boolean fini (){
		return win(1) || win(2) || full();
	}

}

/*class VSIA extends Game {

	boolean winning(int x,int y,int p){

		if(M[x][(y+1)%3]==p && M[x][(y+2)%3]==p) return true;
		if(M[(x+1)%3][y]==p && M[(x+2)%3][y]==p) return true;
	}

	void IAPlay(){

	}

	void Jouer (int x, int y){
		int P=p+1;

		if(M[x][y]==0){
			M[x][y]=P;
		}

		boolean victoire = win(P);
		if(fini()){
			System.out.println("Fini"+(P));
		}

		p = (p+1)%2;
	}
}*/

class GameTest {
	public static void main (String[] args){
		Game g = new Game();
		g.Jouer(0,0);
		g.Jouer(0,1);
		g.Jouer(1,1);
		g.Jouer(0,2);
		g.Jouer(2,2);

		for(int[] l : g.M){
			for(int i : l) {
				System.out.print(i);		
			}
			System.out.println("");
		}

		System.out.println(g.win(1));
	}
}

class CaseMorpion {
	int x,y;
	Game g;
	JButton b;
	
	CaseMorpion(int x,int y, Game g) {
		this.x=x;
		this.y=y;
		this.g=g;
		
		b=new JButton();
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a){
				g.Jouer(x,y);
				if(g.p==1){
					b.setText("X");
				} else {
					b.setText("O");
				}
				b.setEnabled(false);
			}
		});
	}
}

class Morpion {
	public static void main (String[] args){
		JFrame f = new JFrame("Morpion");
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(3,3));

		Game g = new Game();

		CaseMorpion aa = new CaseMorpion(0,0,g);
		CaseMorpion ab = new CaseMorpion(0,1,g);
		CaseMorpion ac = new CaseMorpion(0,2,g);
		CaseMorpion ba = new CaseMorpion(1,0,g);
		CaseMorpion bb = new CaseMorpion(1,1,g);
		CaseMorpion bc = new CaseMorpion(1,2,g);
		CaseMorpion ca = new CaseMorpion(2,0,g);
		CaseMorpion cb = new CaseMorpion(2,1,g);
		CaseMorpion cc = new CaseMorpion(2,2,g);

		g.addCase(aa);
		g.addCase(ab);
		g.addCase(ac);
		g.addCase(ba);
		g.addCase(bb);
		g.addCase(bc);
		g.addCase(ca);
		g.addCase(cb);
		g.addCase(cc);

		f.add(aa.b);
		f.add(ab.b);
		f.add(ac.b);
		f.add(ba.b);
		f.add(bb.b);
		f.add(bc.b);
		f.add(ca.b);
		f.add(cb.b);
		f.add(cc.b);

		f.setVisible(true);

		/*for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				
			}			
		}*/
	}
}