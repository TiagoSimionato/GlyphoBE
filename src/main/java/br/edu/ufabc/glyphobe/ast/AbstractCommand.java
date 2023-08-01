package br.edu.ufabc.glyphobe.ast;

public abstract class AbstractCommand {
  protected String language;
  
  public abstract String generateCode();

  public AbstractCommand() {
    this.language = "js";
  }

  public AbstractCommand(String lang) {
    setLanguage(lang);
    System.out.println(language);
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String lang) {
    this.language = lang;
  }
}
