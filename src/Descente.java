import java.util.ArrayList;

public class Descente extends graph{

	public Descente(int nbVille) {
		super(nbVille);
		// TODO Auto-generated constructor stub
	}
	
    public int[] solve()
    {
    	int i=0;
    	this.solutionInit();
    	while(i<super.getnbiteration())
    	{
    	    ArrayList<int[]> allVoisins;
    		allVoisins= this.allVoisinage(sol);
    		int best[] = this.evaluerSol(allVoisins);
    		if (this.fctObjectif(best) < this.fctObjectif(sol)) {
				sol = best;
			}
    		i++;
    	}
    	return sol;
    }
    
    
}
