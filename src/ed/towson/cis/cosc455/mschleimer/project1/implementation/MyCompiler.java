package ed.towson.cis.cosc455.mschleimer.project1.implementation;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.*;

import java.awt.Desktop;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.util.*;

/**
 * Contains the main 
 * Initialize arrayLists, lexer, parser, and generator
 * @author MeghanNoelSchleimer
 *
 */

public class MyCompiler {
	public static String currentToken; 
	public static String completeFile; 
	public static String text; 
	static MyLexicalAnalyzer Lexer; 
	static MySyntaxAnalyzer parser; 
	static MySemanticAnalyzer generator; 
	public static ArrayList<String> legalTokens; 
	public static ArrayList<String> parseTree; 
	public static ArrayList<String> variableTokens; 
	public static String htmlFileStr;
	//rivate static Scanner scanner; 
			
	public static void main(String[] args) throws CompilerException{
		currentToken=""; 
		completeFile=""; 
		text =""; 
	
		/*if(args.length != 1){
			System.err.println("Error: 1 argument is required."); 
			System.exit(0); 
		}
		File file = new File(args[0]); 
		try{
			scanner = new Scanner(file); 
			while(scanner.hasNextLine()){
				completeFile+= scanner.nextLine() + ""; 
			}
		}catch(FileNotFoundException e){
			e.printStackTrace(); 
		}*/
                
        File file= new File("");
		if(!file.exists()){
			System.err.println("File "+ htmlFileStr +" does not exist.");
			return;
		}
		try{
			Desktop.getDesktop().browse(file.toURI());
		}
		catch(IOException ioe){
			System.err.println("Failed to open file");
		}
                
		//checks the arguments
		
		//checks the file extension
                String extension = ""; 
		String filename = file.getName(); 
		int i = filename.lastIndexOf('.');
		htmlFileStr = filename.substring(0, i); 
		htmlFileStr+= ".html"; 
		if(i>0){
			extension=filename.substring(i+1); 
		}
		if(!extension.equals("mrk")){
			System.err.println("Error! File must be a .mrk file");
			System.exit(0); 
		}
		
		//initializes (creates instances of objects)
		parseTree = new ArrayList<String>(); 
		
		//calls lexical analyzer to get first token, put it in currentToken
		Lexer = new MyLexicalAnalyzer(); 
		Lexer.getNextToken(); 
		
		//calls syntax analyzer to start method
		parser = new MySyntaxAnalyzer(); 
		parser.markdown(); 
		
		//calls semantic analyzer to start method 
		generator = new MySemanticAnalyzer(); 
		generator.writeOutput(); 
		
	}

}