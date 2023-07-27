package br.edu.ufabc.glyphobe;

import java.io.IOException;

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
      System.out.println(CharStreams.fromFileName("input.isi").toString());
      compile(CharStreams.fromFileName("input.isi").toString());
    } catch (IOException e) {
      System.out.println("No such file in directory");
    }
  }
  
  public static String compile(String code) {
    try {
      isilangLexer lexer = new isilangLexer(CharStreams.fromString(code));
      //Fluxo de tokens para passar para o parser
      CommonTokenStream tokenStream = new CommonTokenStream(lexer);

      //crio o parser a partir do tokenStream
      isilangParser parser = new isilangParser(tokenStream);

      parser.program();

      return "Compilation Successful";
    }
    catch (semanticException e) {
      return e.getMessage();
    }
    catch(Exception e) {
      return "UNKNOWN ERROR: " + e.getMessage();
    }
  }
}
