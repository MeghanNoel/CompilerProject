package ed.towson.cis.cosc455.mschleimer.project1.implementation;

import java.io.*; 

public class MySemanticAnalyzer {
	public void writeOutput(){
		Writer writer = null; 
		String input; 
		
		/** 
		 * Creates an html file by converting the given input to html
		 */
		try{
			writer = new BufferedWriter(new FileWriter(MyCompiler.htmlFileStr)); 
			for ( int i = 0; i<MyCompiler.parseTree.size(); i++){
				input = MyCompiler.parseTree.get(i); 
				if(input.equalsIgnoreCase(Tokens.DOCB))
					writer.write("</html>");
				else if(input.equalsIgnoreCase(Tokens.DOCE))
					writer.write("</html>"); 
				else if(input.equalsIgnoreCase(Tokens.HEAD))
					writer.write("<head>");
				else if(input.equalsIgnoreCase(Tokens.TITLEB))
					writer.write("<title>"); 
				else if(input.equalsIgnoreCase(Tokens.TITLEE))
					writer.write("</head>");
				else if(input.equalsIgnoreCase(Tokens.PARAB))
					writer.write("<p>");
				else if(input.equalsIgnoreCase(Tokens.PARAE))
					writer.write("</p>");
				else if(input.equalsIgnoreCase(Tokens.BOLD))
					writer.write("<b>");
				else if(input.equalsIgnoreCase(Tokens.ITALICS))
					writer.write("<i>"); 
				else if(input.equalsIgnoreCase(Tokens.LISTITEMB))
					writer.write("<li>"); 
				else if(input.equalsIgnoreCase(Tokens.LISTITEME))
					writer.write("</li>");
				else if(input.equalsIgnoreCase(Tokens.LINKB))
					writer.write("<a href = ");
				else if(input.equalsIgnoreCase(Tokens.LINKE))
					writer.write("</a>");
				else if(input.equalsIgnoreCase(Tokens.AUDIO))
					writer.write("<audio controls> \n <source src =");
				else if(input.equalsIgnoreCase(Tokens.ADDRESSB))
					writer.write("<");
				else if(input.equalsIgnoreCase(Tokens.ADDRESSE))
					writer.write(">"); 
				else if(input.equalsIgnoreCase(Tokens.VIDEO))
					writer.write("<iframe src = ");
				
			}
		}catch(IOException e){
			e.printStackTrace(); 
		}finally{
			if(writer!=null) try {writer.close(); } catch(IOException ignore){}
		}
	}
}
