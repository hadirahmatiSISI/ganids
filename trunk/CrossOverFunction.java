package ga;

import java.util.Random;

public class CrossOverFunction {
	public String protocolType;
	public String service;
	public int isLand;
	public int durationMin;
	public int durationMax;
	public int sourceBytesMin;
	public int sourceBytesMax;
	public int destinationBytesMin;
	public int destinationBytesMax;
	
	Chromosome son;
	Chromosome daughter;	
	
	int crossOverPoint;
	
	public CrossOverFunction( Chromosome _a, Chromosome _b ){
		this.son = _a;
		this.daughter = _b;
		this.son.fitness = 0;
		this.daughter.fitness = 0;
		this.son.numClassified = 0;
		this.daughter.numClassified = 0;
		this.crossOverPoint = new Random().nextInt(9);
		performCrossOver();
	}

	private void performCrossOver() {
		switch( this.crossOverPoint ){
			case 0:
				this.protocolType = this.son.protocolType;
				this.son.protocolType = this.daughter.protocolType;
				this.daughter.protocolType = this.protocolType;
			case 1:
				this.service = this.son.service;
				this.son.service = this.daughter.service;
				this.daughter.service = this.service;
			case 2:
				this.isLand = this.son.isLand;
				this.son.isLand = this.daughter.isLand;
				this.daughter.isLand = this.isLand;
			case 3:
				this.durationMin = this.son.durationMin;
				this.son.durationMin = this.daughter.durationMin;
				this.daughter.durationMin = this.durationMin;
			case 4:
				this.durationMax = this.son.durationMax;
				this.son.durationMax = this.daughter.durationMax;
				this.daughter.durationMax = this.durationMax;
			case 5:
				this.sourceBytesMin = this.son.sourceBytesMin;
				this.son.sourceBytesMin = this.daughter.sourceBytesMin;
				this.daughter.sourceBytesMin = this.sourceBytesMin;
			case 6:
				this.sourceBytesMax = this.son.sourceBytesMax;
				this.son.sourceBytesMax = this.daughter.sourceBytesMax;
				this.daughter.sourceBytesMax = this.sourceBytesMax;
			case 7:
				this.destinationBytesMin = this.son.destinationBytesMin;
				this.son.destinationBytesMin = this.daughter.destinationBytesMin;
				this.daughter.destinationBytesMin = this.destinationBytesMin;
			case 8:		
				this.destinationBytesMax = this.son.destinationBytesMax;
				this.son.destinationBytesMax = this.daughter.destinationBytesMax;
				this.daughter.destinationBytesMax = this.destinationBytesMax;
		}
	}
	public Chromosome returnSon(){
		return this.son;
	}

	public Chromosome returnDaughter(){
		return this.daughter;
	}
}
