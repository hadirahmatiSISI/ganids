package ga;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import util.FileHandler;
import util.KDDData;

public class FitnessFunction {
	public ArrayList<KDDData> data;
	public float fitness;
	public Chromosome chromosome;
	public String path;
	public String filename;
		
	public FitnessFunction() throws IOException {
		this.fitness = 0;
		this.data = new ArrayList<KDDData>();
	}
	
	public void start(Chromosome _chromosome, String _filename) throws IOException{
		this.path = new java.io.File(".").getCanonicalPath()+ "/src/util/";
		this.chromosome = _chromosome;
		this.chromosome.fitness = 0;
		this.filename = _filename;
		init();
		evaluteChromosome();
	}
		
	public void init() throws IOException {
		 FileHandler fp = new FileHandler();
		 Vector<String> content;
		 try{
			 fp.setFileName(path+"data/Training Data - MINIMIZED/"+this.filename+".txt");
			 content = fp.readTheFile();
			 for(int i=0; i<content.size(); i++){
				 this.data.add(new KDDData(content.get(i)));
			 }
		 }catch(Exception e){
			 System.out.println("File not found.");
		 } 
	}
	
	private void evaluteChromosome() {
		for(int i=0; i<this.data.size(); i++){
			checkFitness(this.data.get(i));
		}		
		this.chromosome.fitness = 0.0f;
		for(int i=0; i<this.chromosome.individualFitness.length; i++){
			this.chromosome.individualFitness[i] /= this.data.size();
			this.chromosome.fitness += this.chromosome.individualFitness[i];
		}
	}
	
	public void checkFitness( KDDData kdddata ){
		boolean canCover = true; 
		
		//protocol type
		if(!(this.chromosome.protocolType.equalsIgnoreCase(kdddata.protocol_type))){
			this.chromosome.individualFitness[0] += 0.66f;		//protocolType	
			canCover = false;
		}
		//service
		if(!this.chromosome.service.equalsIgnoreCase(kdddata.service)){
			this.chromosome.individualFitness[1] += 64/65;
			canCover = false;
		}
		//land
		if((this.chromosome.isLand - kdddata.land) != 0 ){
			this.chromosome.individualFitness[2] += 0.50f;
			canCover = false;
		}

		this.chromosome.individualFitness[3] = -1*Math.abs((this.chromosome.individualFitness[3]-Math.abs(kdddata.duration - this.chromosome.durationMin)));
		this.chromosome.individualFitness[4] = -1*Math.abs((this.chromosome.individualFitness[3]-Math.abs(this.chromosome.durationMax - kdddata.duration)));
		this.chromosome.individualFitness[5] = -1*Math.abs((this.chromosome.individualFitness[3]-Math.abs(kdddata.src_bytes - this.chromosome.sourceBytesMin)));
		this.chromosome.individualFitness[6] = -1*Math.abs((this.chromosome.individualFitness[3]-Math.abs(this.chromosome.sourceBytesMax - kdddata.src_bytes)));
		this.chromosome.individualFitness[7] = -1*Math.abs((this.chromosome.individualFitness[3]-Math.abs(kdddata.dst_bytes - this.chromosome.destinationBytesMin)));
		this.chromosome.individualFitness[8] = -1*Math.abs((this.chromosome.individualFitness[3]-Math.abs(this.chromosome.destinationBytesMax - kdddata.dst_bytes)));

		for(int i=3; i<9;i++){
			if (this.chromosome.individualFitness[i] < 0) canCover = false;	
		}
		if(canCover){
			this.chromosome.numClassified++;
		}		
	}
	
	public Chromosome getResult(){
		return this.chromosome;
	}
}
