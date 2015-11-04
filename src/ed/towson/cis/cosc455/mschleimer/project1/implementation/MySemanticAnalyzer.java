package ed.towson.cis.cosc455.mschleimer.project1.implementation;

import java.io.*; 

public class MySemanticAnalyzer {
	public void writeOutput(){
		Writer writer = null; 
		String tag; 
		
		try{
			writer = new BufferedWriter(new FileWriter(MyCompiler.pathFile)); 
			for ( int i = 0; i<MyCompiler.parseTree.size(); i++){
				tag = MyCompiler.parseTree.get(i); 
				if(tag.equalsIgnoreCase(Tokens.DOCB))
					writer.write("</html>");
				else if(tag.equalsIgnoreCase(Tokens.DOCE))
					writer.write("</html>"); 
				//ADD MORE 
			}
		}catch(IOException e){
			e.printStackTrace(); 
		}finally{
			if(writer!=null) try {writer.close(); } catch(IOException ignore){}
		}
	}
}
