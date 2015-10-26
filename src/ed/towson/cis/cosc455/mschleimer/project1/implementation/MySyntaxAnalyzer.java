package ed.towson.cis.cosc455.mschleimer.project1.implementation;

import edu.towson.cis.cosc455.mschleimer.project1.interfaces.SyntaxAnalyzer;

public class MySyntaxAnalyzer implements SyntaxAnalyzer {

	@Override
	public void markdown() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.DOCB)){
			LexicalAnalyzer.getNextToken(); //call code method with next token
			//stuff(MyCompiler.currentToken);
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.DOCE)){
				//correct and complete markdown 
			}
		}
		else {
			throw new CompilerException("Not allowed in Markdown Language."); 
		}

	}

	@Override
	public void head() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.HEAD)){
			MyLexicalAnalyzer.getNextToken(); 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.TITLEB)){
				title(); 
			}
			else {
				//check text; 
			}
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.HEAD)){
				//Yes this is a head 
			}
		}
		else{
			throw new CompilerException("Not a head part.");  
		}

	}

	@Override
	public void title() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.TITLEB)){
			//getNextToken(); 
			//Check Text 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.TITLEE)){
					//Yes this is a title  
			}
		}
		else{
			throw new CompilerException("Not a title part."); 
		}
	}
		

	@Override
	public void body() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.PARAB)){
			paragraph();
		}
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
		/*if(MyCompiler.currentTokens.equalsIgnoreCase(Tokens.TEXT)){
			innerText(); WHAT IS INNERTEXT??????????????????
		}*/
		throw new CompilerException("Not allowed in body part."); 
	}

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
		// TODO Auto-generated method stub

	}

	@Override
	public void variableDefine() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.DEFB)){
			//getNextToken(); 
			//check text
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.EQSIGN)){
				//getNextToken(); 
				//check text 
				if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.DEFUSEE)){
					//Yes it is a variable Definition
				}
			}
		}
		else {
			throw new CompilerException("Not allowed in variable definiton"); 
		}

	}

	@Override
	public void variableUse() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.USEB)){
			//getNextToken(); 
			//check text
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.DEFUSEE)){
				//Yes it is uses a variable
			}
		}
		else{
			throw new CompilerException("Not allowed for vaiable use."); 
		}

	}

	@Override
	public void bold() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.BOLD)){
			//getNextToken(); 
			//check text; 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.BOLD)){
				//Yes it is bold 
			}
		}
		else { 
			throw new CompilerException("Not a bold part."); 
		}

	}

	@Override
	public void italics() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ITALICS)){
			//getNextToken(); 
			//check text; 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ITALICS)){
				//Yes it is italics 
			}
		}
		else{
			throw new CompilerException("Not an italics part."); 
		}

	}

	@Override
	public void listitem() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.LISTITEMB)){
			//getNextToken(); 
			//check text and variable use 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.LISTITEME)){
				//yes it is a list item 
			}
		}
		else{
			throw new CompilerException("Not allow list item part."); 
		}

	}

	@Override
	public void innerItem() throws CompilerException {
		// TODO Auto-generated method stub

	}

	@Override
	public void link() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.LINKB)){
			//getNextToken(); 
			//check Text; 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.LINKE)){
				//getNextToken(); 
				if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSB)){
					//getNextToken(); 
					//check Text;
					if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSE)){
						//Yes it is a link 
					}
				}
			}
		}
		else{
			throw new CompilerException("Not a link part."); 
		}

	}

	@Override
	public void audio() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.AUDIO)){
			//getNextToken(); 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSB)){
				//getNextToken();
				//check Text; 
				if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSE)){
					//Yes it is a link
				}
			}
		}
		else{
			throw new CompilerException("Not an audio part."); 
		}

	}

	@Override
	public void video() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.VIDEO)){
			//getNextToken(); 
			if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSB)){
				//getNextToken(); 
				//check Text; 
				if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.ADDRESSE)){
					//Yes it is a video
				}
			}
		}
		else{
			throw new CompilerException("Not a video part."); 
		}

	}

	@Override
	public void newline() throws CompilerException {
		if(MyCompiler.currentToken.equalsIgnoreCase(Tokens.NEWLINE)){
			//Yes it is a new line
		}
		else{
			throw new CompilerException("Not allowed for a new line."); 
		}

	}

}//end of MySyntaxAnalyzer class 