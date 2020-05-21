import java.util.ArrayList;

public class recuitSimule extends graph{

	
	
	public recuitSimule(int nbVille) {
		super(nbVille);
		
	}
	 public int[] solve()
	    {
		float T = 100;
	    	int i=0;
	    	this.solutionInit();
	    	while(i<super.getnbiteration())
	    	{
	    	    ArrayList<int[]> allVoisins;
	    		allVoisins= this.allVoisinage(sol);
	    		int best[] = this.evaluerSol(allVoisins);
	    		float r = (float) Math.random();
	    		if (r < fctBoltzmann(T, sol, best)) {
					sol = best;
				}
	    		T = (float) Math.exp(-T);
	    		
	    		i++;
	    	}
	    	return sol;
	    }
	 public float fctBoltzmann(float t,int[] s, int[] best)
	 {
		 float deltat = fctObjectif(s) - fctObjectif(best);
		 
		 return (float) Math.exp(deltat/t);
	 }
	

}
