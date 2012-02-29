package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Separator {
	/**
	 * @param args
	 */
	String path;
	public Separator() throws IOException{
		this.path = new java.io.File(".").getCanonicalPath()+ "/src/util/";
	}
	
	ArrayList<KDDData> data = new ArrayList<KDDData>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Started");
		new Separator().init();
		System.out.println("Finished");
	}

	public void init() throws IOException {
		 FileHandler fp = new FileHandler();
		 Vector<String> content;
		 KDDData kdddata;
		 int i, j;
		 try{
			 for(i=0;i<7;i++ ){
				 fp.setFileName(path+"data/kddset"+i+".txt");
				 content = fp.readTheFile();
				 System.out.println("Reading set "+i);
				 for(j=0; j<content.size(); j++){
					 kdddata = new KDDData(content.get(j));
					 this.data.add(kdddata);
				 }
				 System.out.println("Writing set "+i);
				 separate();
				 this.data.clear();
			 }
		 }catch(Exception e){
			 System.out.println("File not found.");
		 } 
	}
	public void separate() throws IOException{
		FileHandler fp = new FileHandler();
		for(int i=0; i< this.data.size(); i++){
			fp.setFileName(this.path+"/separated/"+this.data.get(i).label+".txt");
			fp.addLine(this.data.get(i).raw);
		 } 
	}
}
