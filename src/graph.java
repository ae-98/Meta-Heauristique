import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class graph {
        private int nbIterations;
	float matrice[][];
	int sol[];
	public graph(int nbVille){
		matrice=new float[nbVille][nbVille];
		sol = new int[nbVille];
		for(int i=0;i<nbVille;i++)
		{
			for(int j=0;j<nbVille;j++)
			{
				if(i==j)
				{
					matrice[i][j]=0;
				}
				else
				{
					//System.out.println(new Random().nextDouble()*100);
					matrice[i][j] = (float)new Random().nextDouble()*100;
				}
			}
		}
	}
	public void solutionInit(){
		
		for(int i=0; i<matrice.length; i++) 
			sol[i] = i;
	}
	public int[] voisinage()
	{
		    int i= (int)(Math.random()+1)*matrice.length;
		    int j = (int)(Math.random()+1)*matrice.length;
			int[] voisin = sol.clone();
			int temp = voisin[i]; 
			voisin[i] = voisin[j];
			voisin[j] = temp;
			return voisin;
	}
	public ArrayList<int[]> allVoisinage(int[] sol)
	{
		ArrayList<int[]> listVoisins = new ArrayList<>();
		   for (int i = 0; i < sol.length; i++) {
			   int[] currentSol = new int[sol.length];
			   currentSol = sol.clone();
				for (int j = i+1; j < sol.length; j++) {
					int tmp = currentSol[j];
					currentSol[j] = currentSol[i];
					currentSol[i] = tmp;
					listVoisins.add(currentSol);
				}
		}
			return listVoisins;
	}
	
	public float fctObjectif(int[] sol){
		int coutSol = 0;
	
		
		for (int i = 0; i < sol.length; i++){
			if (i != sol.length-1)
			coutSol+= matrice[sol[i]][sol[i + 1]];
		}
		
		coutSol+= matrice[sol[0]][sol[sol.length-1]];
		
		return coutSol;
	}
	public int[] evaluerSol(ArrayList<int[]> tableauVoisins)
	{
		int[] best = tableauVoisins.get(0);
		for (int[] tableau : tableauVoisins) {
			if (fctObjectif(tableau) < fctObjectif(best)) {
				best = tableau;
			}
		}
		return best;
	}
	@Override
	public String toString() {
		return  Arrays.toString(sol);
	}
	
        public void setnbiteration(int a){
            this.nbIterations=a;
        }
        public int getnbiteration(){
            return nbIterations;
        }
	
	
}
