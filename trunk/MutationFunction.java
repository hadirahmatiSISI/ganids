package ga;

import java.util.Random;

public class MutationFunction {
	public String protocolType;
	public String service;
	public int isLand;
	public long durationMin;
	public long durationMax;
	public long sourceBytesMin;
	public long sourceBytesMax;
	public long destinationBytesMin;
	public long destinationBytesMax;
	public float mutationRate = 0.10f;
	public Chromosome chromosome;
	
	public MutationFunction( Chromosome _chromosome ){
		this.chromosome = _chromosome;
	}
	
	public void mutate(){
		GeneRandomizer gr = new GeneRandomizer();
		int dummy;
		float rate;
		for( int i=0; i<9;i++){
			rate = new Random().nextFloat();
			if( rate <= this.mutationRate/2 || rate >= 1-this.mutationRate/2)
			switch( i ){
				case 0: this.chromosome.protocolType = gr.getRandomProtocolType();
					break;
				case 1: this.chromosome.service = gr.getRandomService();
					break;
				case 2: this.chromosome.isLand = gr.getRandomLanding();
					break;
				case 3: 
					this.chromosome.durationMin = gr.getRandomDuration();
					if(this.chromosome.durationMin > this.chromosome.durationMax){
						dummy = this.chromosome.durationMin;
						this.chromosome.durationMin = this.chromosome.durationMax;
						chromosome.durationMax = dummy;
					}
					break;
				case 4:
					this.chromosome.durationMax = gr.getRandomDuration();
					if(this.chromosome.durationMax < this.chromosome.durationMin){
						dummy = this.chromosome.durationMin;
						this.chromosome.durationMin = this.chromosome.durationMax;
						chromosome.durationMax = dummy;
					}
					break;
				case 5:
					this.chromosome.sourceBytesMin = gr.getRandomSourceBytes();
					if(this.chromosome.sourceBytesMin > this.chromosome.sourceBytesMax){
						dummy = this.chromosome.sourceBytesMin;
						this.chromosome.sourceBytesMin = this.chromosome.sourceBytesMax;
						chromosome.sourceBytesMax = dummy;
					}
					break;
				case 6:
					this.chromosome.sourceBytesMax = gr.getRandomSourceBytes();
					if(this.chromosome.sourceBytesMax < this.chromosome.sourceBytesMin){
						dummy = this.chromosome.sourceBytesMin;
						this.chromosome.sourceBytesMin = this.chromosome.sourceBytesMax;
						chromosome.sourceBytesMax = dummy;
					}
					break;
				case 7:
					this.chromosome.destinationBytesMin = gr.getRandomDestinationBytes();
					if(this.chromosome.destinationBytesMin > this.chromosome.destinationBytesMax){
						dummy = this.chromosome.destinationBytesMin;
						this.chromosome.destinationBytesMin = this.chromosome.destinationBytesMax;
						chromosome.destinationBytesMax = dummy;
					}
					break;
				case 8:		
					this.chromosome.destinationBytesMax = gr.getRandomDestinationBytes();
					if(this.chromosome.destinationBytesMax < this.chromosome.destinationBytesMin){
						dummy = this.chromosome.destinationBytesMin;
						this.chromosome.destinationBytesMin = this.chromosome.destinationBytesMax;
						chromosome.destinationBytesMax = dummy;
					}
					break;
			}	
		}
	}

	public Chromosome getResult(){
		return this.chromosome;
	}
}
