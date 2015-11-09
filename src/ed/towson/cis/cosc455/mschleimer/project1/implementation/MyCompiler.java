package ed.towson.cis.cosc455.mschleimer.project1.implementation;

import java.io.IOException; 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.*;
import java.awt.Desktop; 

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
	public static String pathFile = "H:\\COSC 455\\Lab 3"; 
			
	public static void main(String[] args) throws CompilerException{
		currentToken=""; 
		completeFile=""; 
		text =""; 
		variableTokens = new ArrayList<String>();	 
		legalTokens.add(Tokens.ADDRESSB); 
		legalTokens.add(Tokens.ADDRESSE); 
		legalTokens.add(Tokens.AUDIO); 
		legalTokens.add(Tokens.BOLD); 
		legalTokens.add(Tokens.DEFUSEE); 
		legalTokens.add(Tokens.DEFB); 
		legalTokens.add(Tokens.DOCB); 
		legalTokens.add(Tokens.DOCE);
		legalTokens.add(Tokens.EQSIGN); 
		legalTokens.add(Tokens.HEAD);
		legalTokens.add(Tokens.ITALICS); 
		legalTokens.add(Tokens.LINKB); 
		legalTokens.add(Tokens.LINKE); 
		legalTokens.add(Tokens.LISTITEMB); 
		legalTokens.add(Tokens.LISTITEME); 
		legalTokens.add(Tokens.NEWLINE); 
		legalTokens.add(Tokens.PARAB); 
		legalTokens.add(Tokens.PARAE); 
		legalTokens.add(Tokens.TITLEB); 
		legalTokens.add(Tokens.TITLEE); 
		legalTokens.add(Tokens.TITLEE); 
		legalTokens.add(Tokens.USEB); 
		legalTokens.add(Tokens.VIDEO);
		
		if(args.length != 1){
			System.err.println("Error: 1 argument is required."); 
			System.exit(0); 
		}
		File file = new File(args[0]); 
		try{
			Scanner scanner = new Scanner(file); 
			while(scanner.hasNextLine()){
				completeFile+= scanner.nextLine() + ""; 
			}
		}catch(FileNotFoundException e){
			e.printStackTrace(); 
		}
		//checks the arguments
		
		//checks the file extension ??
		String extension = ""; 
		String filename = file.getName(); 
		int i = filename.lastIndexOf('.');
		pathFile = filename.substring(0, i); 
		pathFile+= ".html"; 
		//if(i>0){
		//	extension=file.substring(i+1); 
		//}
		if(!extension.equals("markedown")){
			System.err.println("Error! File must be a .markdown file");
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
