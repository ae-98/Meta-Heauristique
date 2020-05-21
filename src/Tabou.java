import java.util.ArrayList;

public class Tabou extends graph {
        
	public Tabou(int nbVille) {
		super(nbVille);
		// TODO Auto-generated constructor stub
	}
	
	 public int[] solve()
	    {
	    	ArrayList<int[]> Tab = new ArrayList<>();
	    	this.solutionInit();
	    	int i=0;
	    	while(i<super.getnbiteration())
	    	{
	    	    ArrayList<int[]> allVoisins;
	    		allVoisins= this.allVoisinage(sol);
	    		int best[] = this.evaluerSol(allVoisins);
	    		sol = best;
	    		if (this.fctObjectif(best) < this.fctObjectif(sol)) {
					Tab.add(sol);
				}
	    		i++;
	    	}
	    	return sol;
	    }
         
}
