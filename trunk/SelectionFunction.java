package ga;

import java.util.ArrayList;
import java.util.Random;

public class SelectionFunction {
	ArrayList<Float> selectionProbability; 
	public ArrayList<Chromosome> potentialSolution;
	public int fitnessSummation;
	
	public SelectionFunction( ArrayList<Chromosome> potential ){
		this.potentialSolution = potential;
		this.fitnessSummation = 0;
		this.selectionProbability = new ArrayList<Float>();
	}
	
	public void getFitnessSummation(){
		for(int i=0;i<this.potentialSolution.size();i++){
			this.fitnessSummation += this.potentialSolution.get(i).fitness;
		}
		for(int i=0;i<this.potentialSolution.size();i++){
			selectionProbability.add((float) (this.potentialSolution.get(i).fitness/fitnessSummation));
		}
	}
	
	public Chromosome selectFather(){
		return this.potentialSolution.get(new Random().nextInt(this.potentialSolution.size()));
	}
	
	public Chromosome selectMother(){
		return this.potentialSolution.get(new Random().nextInt(this.potentialSolution.size()));
	}
}
