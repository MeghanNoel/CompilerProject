package ed.towson.cis.cosc455.mschleimer.project1.implementation;

import java.util.Stack;

import edu.towson.cis.cosc455.mschleimer.project1.interfaces.LexicalAnalyzer;

public class MyLexicalAnalyzer implements LexicalAnalyzer {
	Stack<String> tokens = new Stack<String>(); 
	
	/**
	 * This is the public method to be called when the Syntax Analyzer needs a new
	 * token to be parsed.
	 */
	@Override
	public void getNextToken() {
		getCharacter(); 
		if(isSpace(nextCharacter)){
			if(lookupToken()){
				tokens.push(MyCompiler.currentToken); 
			}
			else{
				//error 
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
	public char getCharacter() {
		currentPosition++;
		return charAt(currentPosition);
	}
	
	/**
     * This method adds the current character the nextToken.
     */
	@Override
	public void addCharacter() {
		if(!isSpace(getCharacter())
			MyCompiler.currentToken = MyCompiler.currentToken + getCharacter(); 
		else{
			MyCompiler.currentToken = ""; //set current token to empty
			
		}
	}

	@Override
	public boolean isSpace(String c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lookupToken() {
		if(nextToken == "#BEGIN")
			return true; 
		if(nextToken == "#END")
			return true;
		if(nextToken == "^") 
			return true; 
		if(nextToken == "<")
			return true; 
		if(nextToken == ">")
			return true; 
		if(nextToken == "{")
			return true; 
		if(nextToken == "}")
			return true; 
		if(nextToken == "$DEF")
			return true; 
		if(nextToken == "$END")
			return true; 
		if(nextToken == "=")
			return true; 
		if(nextToken == "$USE")
			return true; 
		if(nextToken == "**")
			return true; 
		if(nextToken == "*")
			return true; 
		if(nextToken == "+")
			return true; 
		if(nextToken == ";")
			return true; 
		if(nextToken == "~")
			return true; 
		if(nextToken == "[")
			return true; 
		if(nextToken == "]")
			return true; 
		if(nextToken == "@")
			return true; 
		if(nextToken == "%")
			return true; 
		if(nextToken ="(")
			return true; 
		if(nextToken == ")")
			return true;
		return false;
	}

}
