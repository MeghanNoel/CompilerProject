package ed.towson.cis.cosc455.mschleimer.project1.implementation;

import java.io.File;
import java.util.Scanner;

import edu.towson.cis.cosc455.mschleimer.project1.interfaces.LexicalAnalyzer;

public class MyLexicalAnalyzer implements LexicalAnalyzer {
	File file = new File("ThisPC".txt");
	Scanner scanner = new Scanner(file); 
	
	@Override
	public void getNextToken() {
		
		if(MyCompiler.currentToken.legal()){
			//put in currentToken bin; 
		}
		else {
			throw new CompilerException("Illegal element");
		}
	}

	@Override
	public void getCharacter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCharacter() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSpace(String c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lookupToken() {
		// TODO Auto-generated method stub
		return false;
	}

}
