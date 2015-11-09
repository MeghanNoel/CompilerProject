package ed.towson.cis.cosc455.mschleimer.project1.implementation;

import edu.towson.cis.cosc455.mschleimer.project1.interfaces.SyntaxAnalyzer;

public class MySyntaxAnalyzer implements SyntaxAnalyzer {

	@Override
	public void markdown() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.DOCB)){
			MyCompiler.parseTree.add(MyCompiler.currentToken);
			MyCompiler.Lexer.getNextToken(); 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.DEFB))
				variableDefine(); 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.HEAD))
				head(); 
			body(); 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.DOCE)){
				MyCompiler.parseTree.add(MyCompiler.currentToken); 
				//SHOULD I CHECK IF IT IS COMPLETE???
			}
			else{
				throw new CompilerException("Syntax Error: " +MyCompiler.currentToken+ "is not allowed in the markdown language"); 
			}
		}
		else {
			throw new CompilerException("Not allowed in Markdown Language."); 
		}

	}//end of markdown

	@Override
	public void head() throws CompilerException {
		MyCompiler.parseTree.add(MyCompiler.currentToken); 
		MyCompiler.Lexer.getNextToken(); 
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.HEAD)){
			MyCompiler.parseTree.add(MyCompiler.currentToken);  
			MyCompiler.Lexer.getNextToken(); 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.TITLEB)){
				title(); 
			}
			text(); //check text; 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.HEAD)){
				MyCompiler.parseTree.add(MyCompiler.currentToken); 
			}
			else{
				throw new CompilerException("Syntax Error: " +MyCompiler.currentToken + " is not allowed"); 
			}
		}
		else{
			throw new CompilerException("Syntax Error: " +MyCompiler.currentToken+ "is not allowed");  
		}
	}

	@Override
	public void title() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.TITLEB)){
			MyCompiler.parseTree.add(MyCompiler.currentToken); 
			MyCompiler.Lexer.getNextToken();
			text(); //Check Text 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.TITLEE)){
				MyCompiler.parseTree.add(MyCompiler.currentToken); 
			}
			else{
				throw new CompilerException("Syntax Error: " + MyCompiler.currentToken+ " is not allowed"); 
			}
		}
		else{
			throw new CompilerException("Syntax Error: " + MyCompiler.currentToken+ " is not allowed"); 
		}
	}//end of title()
		

	@Override
	public void body() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.PARAB)){
			paragraph(); 
			body(); 
		}
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.NEWLINE)){
			newline(); 
			body(); 
		}
		if(!MyCompiler.currentToken.isEmpty()){
			innerText(); 
			body();
		}
		else{ 
			throw new CompilerException("Syntax Error: " + MyCompiler.currentToken+ " is not allowed"); 	
		}
	} // end of body 
		

	@Override
	public void paragraph() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.PARAB)){
			//getNextToken();
			while(!MyCompiler.currentToken.equalsIgnoreCase(Tokens.PARAB)){
				if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.LISTITEMB)){
					listitem(); 
				}
				if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.LINKB)){
					link(); 
				}
				if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.AUDIO)){
					audio(); 
				}
				if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.VIDEO)){
					video(); 
				}
				if(MyCompiler.currentToken.equalsIgnoreCase("$")){ 
					variableUse(); 
				}
				if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.NEWLINE)){
					newline(); 
				}
				if(MyCompiler.currentToken.equalsIgnoreCase("a")){
					innerText(); 
				}
				//getNextToken(); 
			}
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.PARAE)){
					//yay it did it! 
			}
		}
		else {
			throw new CompilerException("Not allowed in paragraph part."); 
		}
	}

	@Override
	public void innerText() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.USEB)){
			variableUse();  
			innerText();
		}
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.BOLD)){
			bold(); 
			innerText(); 
		}
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ITALICS)){
			italics(); 
			innerText(); 
		}
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.LISTITEMB)){
			listitem(); 
			innerText(); 
		}
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.AUDIO)){
			audio(); 
			innerText(); 
		}
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.VIDEO)){
			video(); 
			innerText(); 
		}
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.LINKB)){
			link(); 
			innerText(); 
		}
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.NEWLINE)){
			newline(); 
			innerText(); 
		}
		if(!MyCompiler.currentToken.isEmpty()){
			text(); 
			innerText(); 
		}
		if(MyCompiler.currentToken.isEmpty()){
			MyCompiler.parseTree.add(MyCompiler.currentToken); 
		}
	}

	@Override
	public void variableDefine() throws CompilerException {
		MyCompiler.parseTree.add(MyCompiler.currentToken);  
		MyCompiler.Lexer.getNextToken(); 
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.DEFB)){
			MyCompiler.parseTree.add(MyCompiler.currentToken);  
			MyCompiler.Lexer.getNextToken(); 
			text(); 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.EQSIGN)){
				MyCompiler.parseTree.add(MyCompiler.currentToken);  
				MyCompiler.Lexer.getNextToken(); 
				text(); 
				if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.DEFUSEE)){
					MyCompiler.parseTree.add(MyCompiler.currentToken); 
				}
				else{
					throw new CompilerException("Syntax Error: " +MyCompiler.currentToken+ " is not allowed"); 
				}
			}
			else{
				throw new CompilerException("Syntax Error: " +MyCompiler.currentToken+ " is not allowed"); 
			}
		}
		else {
			throw new CompilerException("Not allowed in variable definiton"); 
		}

	}//end of variable define

	@Override
	public void variableUse() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.USEB)){
			MyCompiler.parseTree.add(MyCompiler.currentToken);  
			MyCompiler.Lexer.getNextToken(); 
			text(); 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.DEFUSEE)){
				MyCompiler.parseTree.add(MyCompiler.currentToken); 
			}
			else{
				throw new CompilerException("Syntax Error: " +MyCompiler.currentToken+ " is not allowed"); 
			}
		}
		else{
			throw new CompilerException("Syntax Error: " +MyCompiler.currentToken+ " is not allowed"); 
		}

	}// end of variableUse()

	@Override
	public void bold() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.BOLD)){
			MyCompiler.parseTree.add(MyCompiler.currentToken);  
			MyCompiler.Lexer.getNextToken(); 
			text(); 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.BOLD)){
				MyCompiler.parseTree.add(MyCompiler.currentToken); 
			}
			else{
				throw new CompilerException("Syntax Error: " +MyCompiler.currentToken+ " is not allowed"); 
			}
		}
		else { 
			throw new CompilerException("Syntax Error: " +MyCompiler.currentToken+ " is not allowed"); 
		}

	}

	@Override
	public void italics() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ITALICS)){
			MyCompiler.parseTree.add(MyCompiler.currentToken);  
			MyCompiler.Lexer.getNextToken(); 
			text(); 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ITALICS)){
				MyCompiler.parseTree.add(MyCompiler.currentToken); 
			}
			else{
				throw new CompilerException("Syntax Error: " +MyCompiler.currentToken+ " is not allowed"); 
			}
		}
		else{
			throw new CompilerException("Syntax Error: " +MyCompiler.currentToken+ " is not allowed"); 
		}

	}//end of italics 

	@Override
	public void listitem() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.LISTITEMB)){
			MyCompiler.parseTree.add(MyCompiler.currentToken);  
			MyCompiler.Lexer.getNextToken(); 
			innerItem(); 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.LISTITEME)){
				MyCompiler.parseTree.add(MyCompiler.currentToken);
			}
			else{
				throw new CompilerException("Syntax Error: " +MyCompiler.currentToken+ "is not allowed"); 
			}
		}
		else{
			throw new CompilerException("Syntax Error: " +MyCompiler.currentToken+ "is not allowed"); 
		}

	}

	@Override
	public void innerItem() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.USEB)){
			variableUse(); 
			innerItem(); 
		}
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.BOLD)){
			bold(); 
			innerItem(); 
		}
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ITALICS)){
			italics(); 
			innerItem(); 
		}
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.LINKB)){
			link(); 
			innerItem(); 
		}
		if(!MyCompiler.currentToken.isEmpty()){
			text(); 
			innerItem(); 
		}
		else{
			MyCompiler.parseTree.add(MyCompiler.currentToken); 
		}
		throw new CompilerException("Syntax Error: " +MyCompiler.currentToken+ " is not allowed."); 
	} // end of innerItem()

	@Override
	public void link() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.LINKB)){
			MyCompiler.parseTree.add(MyCompiler.currentToken);  
			MyCompiler.Lexer.getNextToken(); 
			text(); 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.LINKE)){
				MyCompiler.parseTree.add(MyCompiler.currentToken);  
				MyCompiler.Lexer.getNextToken();  
				if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSB)){
					MyCompiler.parseTree.add(MyCompiler.currentToken);  
					MyCompiler.Lexer.getNextToken(); 				//getNextToken(); 
					text(); 
					if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSE)){
						MyCompiler.parseTree.add(MyCompiler.currentToken); 
					}
					else{
						throw new CompilerException("Syntax Error: " +MyCompiler.currentToken + " is not allowed."); 
					}
				}
				else {
					throw new CompilerException("Syntax Error: " +MyCompiler.currentToken + " is not allowed.");
				}
			}
			else{
				throw new CompilerException("Syntax Error: " +MyCompiler.currentToken + " is not allowed.");
			}
		}
		else{
			throw new CompilerException("Syntax Error: " +MyCompiler.currentToken + " is not allowed."); 
		}

	}

	@Override
	public void audio() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.AUDIO)){
			MyCompiler.parseTree.add(MyCompiler.currentToken);  
			MyCompiler.Lexer.getNextToken();
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSB)){
				MyCompiler.parseTree.add(MyCompiler.currentToken);  
				MyCompiler.Lexer.getNextToken();
				text(); 
				if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSE)){
					MyCompiler.parseTree.add(MyCompiler.currentToken); 
				}
				else{
					throw new CompilerException("Syntax Error: " +MyCompiler.currentToken + " is not allowed."); 
				}
			}
			else{
				throw new CompilerException("Syntax Error: " +MyCompiler.currentToken + " is not allowed."); 
			}
		}
		else{
			throw new CompilerException("Syntax Error: " +MyCompiler.currentToken + " is not allowed."); 
		}

	}//end of audio()

	@Override
	public void video() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.VIDEO)){
			MyCompiler.parseTree.add(MyCompiler.currentToken);  
			MyCompiler.Lexer.getNextToken();
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSB)){
				MyCompiler.parseTree.add(MyCompiler.currentToken);  
				MyCompiler.Lexer.getNextToken();
				text(); 
				if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSE)){
					MyCompiler.parseTree.add(MyCompiler.currentToken); 
				}
				else{
					throw new CompilerException("Syntax Error: " +MyCompiler.currentToken + " is not allowed.");
				}
			}
			else{
				throw new CompilerException("Syntax Error: " +MyCompiler.currentToken + " is not allowed.");
			}
		}
		else{
			throw new CompilerException("Syntax Error: " +MyCompiler.currentToken + " is not allowed.");
		}

	}//end of video()

	@Override
	public void newline() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.NEWLINE))
			MyCompiler.parseTree.add(MyCompiler.currentToken);
		else if(MyCompiler.currentToken.isEmpty())
			MyCompiler.parseTree.add(MyCompiler.currentToken); 
		else{
			throw new CompilerException("Syntax Error: " +MyCompiler.currentToken + " is not allowed.");
		}

	}//end of newline()
	
	public boolean text(){
		if(!MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSB))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSE))
			return false; 		
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.AUDIO))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.BOLD))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.DEFB))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.DEFUSEE))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.DOCB))
			return false;
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.EQSIGN))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.HEAD))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.ITALICS))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.LINKB))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.LINKE))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.LISTITEMB))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.LISTITEME))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.NEWLINE))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.PARAB))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.PARAE))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.TITLEB))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.TITLEE))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.USEB))
			return false; 
		else if (!MyCompiler.currentToken.equalsIgnoreCase(Tokens.VIDEO))
			return false; 
		else 
			return true; 
	}

}//end of MySyntaxAnalyzer class 