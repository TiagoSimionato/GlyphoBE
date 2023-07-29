package br.edu.ufabc.glyphobe.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class SyntaxErrorListener extends BaseErrorListener {
  private final List<SyntaxError> se = new ArrayList<>();

  public SyntaxErrorListener() {
    super();
  }

  @Override
  public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
      String msg, RecognitionException e) {
    se.add(new SyntaxError("At line " + line + ". " + msg));
  }

  public List<SyntaxError> getSyntaxErrors() {
    return se;
  }

  @Override
  public String toString() {
    StringBuilder strBuilder = new StringBuilder();
    se.stream().forEach(e -> {
      strBuilder.append(e.getMessage() + "\n");
    });
    return strBuilder.toString();
  }
}
