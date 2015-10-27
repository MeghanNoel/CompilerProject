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
				try {
					throw new Exception("Token not valid");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
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
	public String getCharacter() {
		currentPosition++;
		return charAt(currentPosition);
	}
	
	/**
     * This method adds the current character the nextToken.
     */
	@Override
	public void addCharacter() {
		if(!isSpace(getCharacter()))
			MyCompiler.currentToken = MyCompiler.currentToken + getCharacter(); 
		else{
			MyCompiler.currentToken = ""; //set current token to empty
		}
	}

	@SuppressWarnings("unused")
	@Override
	public boolean isSpace(String c) {
		if("c" == " ")
			return true; 
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
