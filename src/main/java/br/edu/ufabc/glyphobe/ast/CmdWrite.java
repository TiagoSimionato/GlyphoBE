package br.edu.ufabc.glyphobe.ast;

public class CmdWrite extends AbstractCommand {
  
  private String text;
  
  public CmdWrite(String lang, String text) {
    super(lang);
    this.text = text;
  }

  @Override
  public String generateCode() {
    if      (language == "java") return "System.out.println(" + text + ");\n";
    else if (language == "py")   return "print(" + text + ")\n";
    else /*js*/                  return "alert(" + text + ");\n";
  }
}
