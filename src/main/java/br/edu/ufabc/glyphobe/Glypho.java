package br.edu.ufabc.glyphobe;

import java.io.IOException;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import br.edu.ufabc.glyphobe.core.isilangLexer;
import br.edu.ufabc.glyphobe.core.isilangParser;
import br.edu.ufabc.glyphobe.exceptions.SyntaxErrorListener;
import br.edu.ufabc.glyphobe.exceptions.SemanticError;

/**
 * Arquivos fonte: .isi
*/

public class Glypho {

  private String targetCode;
  private String targetLanguage;
  private String compilationResult;

  public Glypho() {
    this.targetCode = "";
    this.targetLanguage = "js";
  }

  public Glypho(String language) {
    this.targetCode = "";
    this.targetLanguage = "js";
  }

  public Glypho(String language, String code) {
    this.targetCode = "";
    this.targetLanguage = language;
    compile(code);
  }
  
  public String compile(String code) {
    try {
      //Uso meu próprio error listener para manter track de todos os problemas e reportar no final
      SyntaxErrorListener listener = new SyntaxErrorListener();

      isilangLexer lexer = new isilangLexer(CharStreams.fromString(code));
      lexer.removeErrorListeners();
      lexer.addErrorListener(listener);

      //Fluxo de tokens para passar para o parser
      CommonTokenStream tokenStream = new CommonTokenStream(lexer);

      //crio o parser a partir do tokenStream
      isilangParser parser = new isilangParser(tokenStream);
      parser.removeErrorListeners();
      parser.addErrorListener(listener);

      parser.setTargetLanguage(targetLanguage);

      //Expression Analysis
      parser.program();

      if (listener.getSyntaxErrors().size() <= 0) {
        targetCode = parser.generateObjectCode();
        compilationResult = "Compilation Successful\n";
        return compilationResult;
      }
      compilationResult = "Compilation Failed\n" + listener.toString();
      return compilationResult;
    }
    catch (SemanticError e) {
      compilationResult = "Compilation Failed\n" + e.getMessage();
      return compilationResult;
    }
    catch(Exception e) {
      e.printStackTrace();
      compilationResult = "UNKNOWN ERROR: " + e.getMessage();
      return compilationResult;
    }
  }

  public String getTargetCode() {
    return targetCode;
  }

  public String getCompilationResult() {
    return compilationResult;
  }

  public static void main(String[] args) {
    try {
      System.out.println(compile(CharStreams.fromFileName("input.isi").toString(), ""));
    } catch (IOException e) {
      System.out.println("No such file in directory");
    }
  }

  //TODO: delete
  public static String compile(String code, String a) {
    try {
      //Uso meu próprio error listener para manter track de todos os problemas e reportar no final
      SyntaxErrorListener listener = new SyntaxErrorListener();

      isilangLexer lexer = new isilangLexer(CharStreams.fromString(code));
      lexer.removeErrorListeners();
      lexer.addErrorListener(listener);

      //Fluxo de tokens para passar para o parser
      CommonTokenStream tokenStream = new CommonTokenStream(lexer);

      //crio o parser a partir do tokenStream
      isilangParser parser = new isilangParser(tokenStream);
      parser.removeErrorListeners();
      parser.addErrorListener(listener);

      parser.setTargetLanguage("py");
      
      //Expression Analysis
      parser.program();

      if (listener.getSyntaxErrors().size() <= 0) {
        parser.generateObjectCode();
        return "Compilation Successful\n";
      }
      return "Compilation Failed\n" + listener.toString();
    }
    catch (SemanticError e) {
      return "Compilation Failed\n" + e.getMessage();
    }
    catch (ParseCancellationException e) {
      return "Compilation Failed\n" + e.getMessage();
    }
    catch(Exception e) {
      e.printStackTrace();
      return "UNKNOWN ERROR: " + e.getMessage();
    }
  }
}
