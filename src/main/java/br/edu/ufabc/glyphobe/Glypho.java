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
      isilangLexer lexer = new isilangLexer(CharStreams.fromString(code));
      //Fluxo de tokens para passar para o parser
      CommonTokenStream tokenStream = new CommonTokenStream(lexer);

      //crio o parser a partir do tokenStream
      isilangParser parser = new isilangParser(tokenStream);

      parser.setTargetLanguage(targetLanguage);
      //Expression Analysis
      parser.program();

      parser.showCmds();

      targetCode = parser.generateObjectCode();

      compilationResult = "Compilation Successful\n";
      return compilationResult;
    }
    catch (semanticException e) {
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
      isilangLexer lexer = new isilangLexer(CharStreams.fromString(code));
      //Fluxo de tokens para passar para o parser
      CommonTokenStream tokenStream = new CommonTokenStream(lexer);

      //crio o parser a partir do tokenStream
      isilangParser parser = new isilangParser(tokenStream);

      parser.setTargetLanguage("js");

      parser.program();
      //parser.showCmds();

      parser.generateObjectCode();

      return "Compilation Successful";
    }
    catch (semanticException e) {
      return "Compilation Failed\n" + e.getMessage();
    }
    catch(Exception e) {
      e.printStackTrace();
      return "UNKNOWN ERROR: " + e.getMessage();
    }
  }
}
