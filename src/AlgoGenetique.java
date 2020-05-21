import java.util.ArrayList;
import java.util.Random;

public class AlgoGenetique extends graph{

	public AlgoGenetique(int nbVille) {
		super(nbVille);
		// TODO Auto-generated constructor stub
	}
	public int[] mutation(int[] individu)
	{
		    int i= (int)((Math.random()*matrice.length));
		    int j = (int)((Math.random()*matrice.length));
		//	int[] voisin = individu.clone();
			int temp = individu[i]; 
			individu[i] = individu[j];
			individu[j] = temp;
			return individu;
	}
	public boolean isExist(int[] individu2,int[] newIndividu)
	{
		for (int j = 0; j < individu2.length; j++) {
			for (int j2 = 0; j2 < newIndividu.length; j2++) {
				if(individu2[j]!=newIndividu[j2])
				{
					return true;
				}
				
			}
			
		}
		return false;
	}
	public int[] crossOver(int[] individu1,int[] individu2)
	{
		int[] newIndividu = new int[sol.length];
		int indiceDepart= (int)(Math.random()+1)*matrice.length;
		for (int i = 0; i < individu2.length; i++) {
			
			if(i>=indiceDepart)
			{
				if(!isExist(individu2,newIndividu)){
					newIndividu[i] = individu2[i];
				}
			}
			else {
				newIndividu[i] = individu1[i];
			}
		}
		return newIndividu;
	}
	 public int[] solve()
	    {
	    	
	    	int i=0;
	    	this.solutionInit();
	    	 ArrayList<int[]> populationInit= this.allVoisinage(sol);
	    	while(i<super.getnbiteration())
	    	{
	    		ArrayList<int[]> newPopulation=evaluation(populationInit);
	    		//Selection
	    		int[] individu1=newPopulation.get(0);
	    		int[] individu2=newPopulation.get(1);
	    		//Mutation
	            mutation(individu1);
	            mutation(individu2);
	            //Cross Over
	            int[] individu1ApresCross=crossOver(individu1, individu2);
	            int[] individu2ApresCross=crossOver(individu2, individu1);
	    	    populationInit.add(individu1ApresCross);
	    	    populationInit.add(individu2ApresCross);
                if(fctObjectif(individu2ApresCross)<fctObjectif(individu1ApresCross))
                {
                	sol=individu2ApresCross;
                }
                else{
                	sol=individu1ApresCross;
                }
	    	    i++;
	    	}
	    	return sol;
	    }
	
	public ArrayList<int[]> evaluation(ArrayList<int[]> population)
	{
		int[] individu1= population.get(0);	
		
		for (int[] individus : population) {
			if(fctObjectif(individus)<fctObjectif(individu1))
			{
				individu1=individus;
				int [] tmp;
				tmp=individus;
				individus=individu1;
				individu1=tmp;
			}
				
		}
		return population;
	}
	

}
