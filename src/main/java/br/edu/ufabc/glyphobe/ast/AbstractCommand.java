package br.edu.ufabc.glyphobe.ast;

public abstract class AbstractCommand {
  protected String language;
  
  public abstract String generateCode();
  public abstract void run();

  public AbstractCommand() {
    this.language = "js";
  }

  public AbstractCommand(String lang) {
    setLanguage(lang);
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String lang) {
    if (lang == "java") this.language = lang;
    else this.language = "js";
  }
}
