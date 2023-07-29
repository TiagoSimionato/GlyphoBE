package br.edu.ufabc.glyphobe.ast;

public class CmdToken extends AbstractCommand {
  private String token;

  public CmdToken(String language, String token) {
    super(language);
    this.token = token;
  }

  @Override
  public String generateCode() {
    return format(token);
  }

  private String format(String token) {
    if (token.contains("{")) return token + "\n";
    if (token.contains("}")) return token + "\n";
    else return token;
  }
}
