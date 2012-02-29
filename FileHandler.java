package util;

import java.io.*;
import java.util.*;

public class FileHandler {
	public String fileName="";
	String fileData="";
    private Runtime rt;
	private Process proc;
	private InputStream err;
    private InputStream std;
    private BufferedReader stdInput;
    private BufferedReader stdErr;
	private StringBuffer result;
    
	public FileHandler() {
	}
	
	public FileHandler(String fileName) {
		setFileName(fileName);
	}
    
	public void setFileName (String fileName) {
	   this.fileName = fileName;	
	}	

		
	public void setFileData (String fileData) {
	   this.fileData = fileData;	
	}	

    /*public void createFile() throws IOException, Exception {
        File theFile = new File(fileName);
        FileWriter out = new FileWriter(theFile, true);
        out.write(fileData +"\n");
        out.close();
	}*/
	
	public void saveFile() throws Exception
	{ 
		PrintWriter outputStream = null;
		
		outputStream = new PrintWriter(new FileOutputStream(fileName));
									
		
		//System.out.println ("File "+strFileName+" successfully saved");
		outputStream.close();			
	}
	    
	public void createFile() throws IOException, Exception {
        BufferedWriter bWriter;
		bWriter = new BufferedWriter(new FileWriter(fileName,true));
        bWriter.write(fileData+ "\r\n"); 
        bWriter.flush();
        bWriter.close();		
	}
	    	

	public void deleteFile() {
	   File deleteFile = new File(fileName);	
	   deleteFile.delete();
	}	

	public long lastModified() {
	   long dateTime;
	   File theFile = new File(fileName);	
	   dateTime=theFile.lastModified();
	   
	   return dateTime;
	   
	}
		
	public boolean checkFlagIfExist(String location,String name)
	{
        boolean exist = false;
        try
        {
            setFileName(location+name+".txt");
            
            exist = isExist();
            
            renameTo(location+name+".prc");
        }
        catch(Exception ex)
        {
	        ex.printStackTrace();
	    }
        
	    //System.out.println("FILE existing["+fileName+"]? "+exist);
        
        return exist;
    }
	
	public boolean isExist() {
	   boolean bln=false;
	   File fileCheck = new File(fileName);
	   bln=fileCheck.exists();	
	   
	   return bln;
	}	
	
	public long fileLength() {
	    long len;
	    File fileLen = new File(fileName);
	    len = fileLen.length();
	    
	    return len;
	}
	
		
	public boolean isDirectory() {
	   boolean bln=false;
	   File dir = new File(fileName);	
	   bln=dir.isDirectory();
	   
	   return bln;
	}	
	
	
	public void addLine(String line)
	{
		try
		{
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName,true));
			
			bWriter.write(line+ "\r\n");         
	        bWriter.flush();
	        bWriter.close();
	        
	        //System.out.println(line);		
		}
		catch(Exception e)
		{ e.printStackTrace(); }				
	}
	

	public synchronized void moveFile(String dir) throws Exception {
	   boolean bln;			
	   File currFile = new File(fileName);	
	   File remdir = new File (dir);
	   bln=currFile.renameTo(new File(remdir,currFile.getName()));
	}	
		
	/*public void renameTo(String newFile) {
	   boolean bln;			
	   File currFile = new File(fileName);	
	   bln=currFile.renameTo(new File(newFile));
	}*/
	
	public synchronized void renameTo(String newFile) throws Exception{
		rt = Runtime.getRuntime();
		result = new StringBuffer();
		/*LOW LEVEL PROCEDURE FOR RENAME**********
		String moveCom = "mv -f " + fileName + " " + newFile;
		String moveCom = "move " + fileName + " " + newFile;
		System.out.println("Executing OS-Level mv command: " + moveCom);
		String[] cmdArray=moveCom.split(" ");
		rt.exec(cmdArray);
		*************************/
		File tmpFile = new File(fileName);
		File newFiled = new File(newFile);
		tmpFile.renameTo(newFiled);
	
//		Thread.sleep(100);
	
// 		std = proc.getInputStream();
// 		err = proc.getInputStream();
// 		stdInput = new BufferedReader(new InputStreamReader(std));
// 		stdErr = new BufferedReader(new InputStreamReader(err));
// 		
// 		System.out.println("Output " + stdInput + ". " + stdErr);
	}
	
	public synchronized void createDumFile() throws Exception{
		rt = Runtime.getRuntime();
		String com = "touch " + fileName;
		System.out.println("Executing OS-Level command:" + com);
		String[] cmdArray=com.split(" ");
		rt.exec(cmdArray);
	}
	
	public synchronized void byebyeFile() throws Exception{
		rt = Runtime.getRuntime();
		//result = new StringBuffer();
		String removeCom = "rm -f " + fileName;
		System.out.println("Executing OS-Level rm command: " + removeCom);
		String[] cmdArray=removeCom.split(" ");
		rt.exec(cmdArray);
	
		//Thread.sleep(100);
	}
	
	public String [] listFile () {  //dir
	    String [] filenames;
		File fileDir = new File(fileName);
	    filenames = fileDir.list();
	    
	    return filenames;	
	}	
		
	public BufferedReader readFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		return br;  
		
	}
	
	
	public Vector<String> readTheFile() throws Exception
	{ 
		BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
		Vector <String>        vFile       = new Vector<String>();
		String         readlyn;			
			
		while((readlyn = inputStream.readLine()) != null)
			vFile.add(readlyn);
		
		inputStream.close();		
		
		return vFile;
	}	
		
		
	/*public DataInputStream readFile () throws IOException {
		FileInputStream fstream = new FileInputStream(fileName);
        DataInputStream in = new DataInputStream(fstream);
	
        return in; 
	}*/
	
	
	public void makeDir () throws IOException,Exception {
		(new File (this.fileName)).mkdir();
	}
	  
	
}	