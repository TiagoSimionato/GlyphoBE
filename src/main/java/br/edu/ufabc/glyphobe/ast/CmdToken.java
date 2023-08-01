package br.edu.ufabc.glyphobe.ast;

public class CmdToken extends AbstractCommand {
  private String token;

  public CmdToken(String language, String token) {
    super(language);
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  @Override
  public String generateCode() {
    switch(language) {
      case "py":
        token = token.replace("{", ":")
             .replace("}", "");
        return format(token);
      default: /*js, java */
        return format(token);
    }
  }

  private String format(String token) {
    if (token.contains("{")) return token + "\n";
    if (token.contains("}")) return token + "\n";
    if (token.contains(":")) return token + "\n";
    else return token;
  }
}
