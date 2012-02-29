package ga;

public class Chromosome {
	
	public String protocolType;
	public String service;
	public int isLand;
	public int durationMin;
	public int durationMax;
	public int sourceBytesMin;
	public int sourceBytesMax;
	public int destinationBytesMin;
	public int destinationBytesMax;
	public float fitness;
	public int numClassified = 0; 
	public float[] individualFitness = new float[9];
	
	public Chromosome(){
		int dummy;
		GeneRandomizer gr = new GeneRandomizer();
		this.durationMin = gr.getRandomDuration();		
		this.durationMax = gr.getRandomDuration();
		if(this.durationMin>this.durationMax){
			dummy = this.durationMin;
			this.durationMin = this.durationMax;
			this.durationMax = dummy;
		}
		
		this.sourceBytesMin = gr.getRandomSourceBytes();
		this.sourceBytesMax = gr.getRandomSourceBytes();
		if(this.sourceBytesMin>this.sourceBytesMax){
			dummy = this.sourceBytesMin;
			this.sourceBytesMin = this.sourceBytesMax;
			this.sourceBytesMax = dummy;
		}
		
		this.destinationBytesMin = gr.getRandomDestinationBytes();
		this.destinationBytesMax = gr.getRandomDestinationBytes();
		if(this.destinationBytesMin>this.destinationBytesMax){
			dummy = this.destinationBytesMin;
			this.destinationBytesMin = this.destinationBytesMax;
			this.destinationBytesMax = dummy;
		}
		
		this.protocolType = gr.getRandomProtocolType();
		this.service = gr.getRandomService();
		this.isLand = gr.getRandomLanding();
		this.fitness = 0.0f;
		
		for(int i=0; i<this.individualFitness.length; i++){
			this.individualFitness[i] = 0.0f;
		}
	}
}
