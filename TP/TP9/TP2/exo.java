class Trie extends Thread {
	int[] T;
	int a;
	int z;

	Trie(int[] T, int a, int z){
		this.T=T;
		this.a=a;
		this.z=z;
	}

	int partitionner (/*int[] T,int a,int z*/){
		System.out.println("deb partitionner");
		RUN.afficheTab(T);
		int j = a;
		for(int i=a;i<z;i++){
			if(T[i]<=T[z-1]){
				int tmp = T[i];
				T[i]=T[j];
				T[j]=tmp;
				j++;
			}
		}
		int tmp = T[z-1];
			T[z-1]=T[j];
			T[j]=tmp;
		RUN.afficheTab(T);
		System.out.println(j);
		return j;
	}
	/*void tri_rapide(int[] T,int a,int z){
		if(a<z){
			int pivot = partitionner(T,a,z);
			tri_rapide(T,a,pivot-1);
			tri_rapide(T,pivot+1,z);
		}
	}*/

	public void run (){
		if(a<z){
			int pivot = partitionner();
			Trie ta = new Trie(T,a,pivot-1);
			Trie tb = new Trie(T,pivot+1,z);
			ta.start();
			tb.start();
			
			try{
				ta.join();
				tb.join();
			} catch (Exception e){;}
		}
	}
}

class RUN {
	static void afficheTab(int[] T){
		//System.out.println(T.size());
		for(int i : T){
			System.out.print(i+" ");
		}
		System.out.println("");
	}

	public static void main (String[] args){
		int[] T = {945,5,46,374,542,543,132,84,8001};
		afficheTab(T);

		int a=0;int z=9;
		Trie trie = new Trie(T,a,z);
		
		trie.start();
		afficheTab(T);
	}
}