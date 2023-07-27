package br.edu.ufabc.glyphobe;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.edu.ufabc.glyphobe.core.isilangLexer;
import br.edu.ufabc.glyphobe.core.isilangParser;
import br.edu.ufabc.glyphobe.exceptions.semanticException;

/**
 * Arquivos fonte: .isi
*/

public class Glypho {
  public static void main(String[] args) {
    try {
      isilangLexer lexer = new isilangLexer(CharStreams.fromFileName("input.isi"));

      //Fluxo de tokens para passar para o parser
      CommonTokenStream tokenStream = new CommonTokenStream(lexer);

      //crio o parser a partir do tokenStream
      isilangParser parser = new isilangParser(tokenStream);

      parser.program();
      
      //System.out.println("Compilation Successful");
    }
    catch (semanticException e) {
      System.err.println(e.getMessage());
    }
    catch(Exception e) {
      System.err.println("ERROR " + e.getMessage());
    }
  }
}
