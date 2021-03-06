package ed.towson.cis.cosc455.mschleimer.project1.implementation;

import edu.towson.cis.cosc455.mschleimer.project1.interfaces.LexicalAnalyzer;


public class MyLexicalAnalyzer implements LexicalAnalyzer {
	String nextCharacter = ""; 
	String currentCharacter = ""; 
	int currentPosition = 0; 
	char currentChar; 
	char nextChar; 
	
	/**
	 * This is the public method to be called when the Syntax Analyzer needs a new
	 * token to be parsed.
	 */
	@Override
	public void getNextToken() {
		getCharacter(); 
		while(isSpace(currentCharacter)){
			getCharacter(); 
		}
		if(!lookupToken()){
			System.out.println("Lexical Error: " + MyCompiler.currentToken + "is no a valid token.");
			System.exit(0); 
		}
		else{
			while(!isSpace(nextCharacter)){
				MyCompiler.currentToken+=nextCharacter; 
				addCharacter(); 
			}
		}
	}
	
	/**
	 * This is method gets the next character from the input and places it in
	 * the nextCharacter class variable.
	 *
	 * @return the character
	 */
	@Override
	public void getCharacter() {
		currentChar = MyCompiler.completeFile.charAt(currentPosition);
		currentCharacter = currentChar + ""; 
		currentPosition ++; 
	}
	
	/**
     * This method adds the current character the nextToken.
     */
	@Override
	public void addCharacter() {
		nextChar = MyCompiler.completeFile.charAt(currentPosition); 
		nextCharacter = nextChar + ""; 
		currentPosition++; 
	}

	@Override
	public boolean isSpace(String c) {
		if(c.trim().isEmpty())
			return true; 
		else
			return false;
	}

	@Override
	public boolean lookupToken() {
		if(MyCompiler.currentToken == "#BEGIN")
			return true; 
		if(MyCompiler.currentToken == "#END")
			return true;
		if(MyCompiler.currentToken == "^") 
			return true; 
		if(MyCompiler.currentToken == "<")
			return true; 
		if(MyCompiler.currentToken == ">")
			return true; 
		if(MyCompiler.currentToken == "{")
			return true; 
		if(MyCompiler.currentToken == "}")
			return true; 
		if(MyCompiler.currentToken == "$DEF")
			return true; 
		if(MyCompiler.currentToken == "$END")
			return true; 
		if(MyCompiler.currentToken == "=")
			return true; 
		if(MyCompiler.currentToken == "$USE")
			return true; 
		if(MyCompiler.currentToken == "**")
			return true; 
		if(MyCompiler.currentToken == "*")
			return true; 
		if(MyCompiler.currentToken == "+")
			return true; 
		if(MyCompiler.currentToken == ";")
			return true; 
		if(MyCompiler.currentToken == "~")
			return true; 
		if(MyCompiler.currentToken == "[")
			return true; 
		if(MyCompiler.currentToken == "]")
			return true; 
		if(MyCompiler.currentToken == "@")
			return true; 
		if(MyCompiler.currentToken == "%")
			return true; 
		if(MyCompiler.currentToken == "(")
			return true; 
		if(MyCompiler.currentToken == ")")
			return true;
		return false;
	}

}
