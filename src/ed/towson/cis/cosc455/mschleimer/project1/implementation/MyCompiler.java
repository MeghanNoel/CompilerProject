package ed.towson.cis.cosc455.mschleimer.project1.implementation;

import java.io.IOException; 

public class MyCompiler {

	public static String currentToken = " "; 
	
	public static String path = "H:\\COSC 455\\Lab 3"; 
	public static void main(String[] args) throws IOException {
		//checks the arguments
		
		//checks the file extension
		
		//initializes (creates instances of objects)
		try {
			ReadFile file = new ReadFile(path); 
			String[] aryLines = file.OpenFile(); 
			for(int i =0; i<aryLines.length; i++){
				System.out.println(aryLines[i]); 
			}
		}
		catch(IOException e){
			System.out.println(e.getMessage()); 
		}
		//calls lexical analyzer to get first token, put it in currentToken
		
		//calls syntax analyzer to start method
		
		//Post-processing steps 
		//writes out files/opens browsers
		
		//closes files it opens
		
		//cleans up memory (ie destorys objects) 
		
	}

}
