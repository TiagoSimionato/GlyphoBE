package br.edu.ufabc.glyphobe.ast;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufabc.glyphobe.symbols.IdTable;

public class Program {
  private String fileName;
  private List<AbstractCommand> cmds;
  private IdTable it;
  private String language;
  private int blockLevel;

  public Program() {
    this.fileName = "output";
    this.cmds = new ArrayList<AbstractCommand>();
    setLanguage("js");
    blockLevel = 0;
  }

  public String generateTarget() {
    try {
      FileWriter fw = new FileWriter(fileName + "." + language);
      PrintWriter pw = new PrintWriter(fw);
      StringBuilder strBuilder = new StringBuilder();

      strBuilder.append(generatePreCode());

      cmds.stream().forEach(c -> {
        if (c.generateCode().contains("{")) blockLevel++;
        else if (c.generateCode().contains("}")) blockLevel--;

        String blockSpaces = indentBlock();
        if (c.generateCode().contains("{")) blockSpaces = "";

        strBuilder.append(blockSpaces + c.generateCode());
      });

      strBuilder.append(generatePostCode());

      pw.println(strBuilder.toString());
      pw.close();
      fw.close();

      return strBuilder.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return "ERROR: " + e.getMessage();
    }
  }

  private String indentBlock() {
    String spaces = "";
    for (int i = 0; i < blockLevel; i++) {
      spaces += "  ";
    }
    return spaces;
  }

  private String generatePreCode() {
    switch(language) {
      case "java":
        blockLevel++;
        return "public class Main { \n"+
          "  public static void main(String[] args) {\n";
      default:
        return "";
    }
  }

  private String generatePostCode() {
    switch(language) {
      case "java":
        return "  }\n}\n";
      default:
        return "";
    }
  }

  public List<AbstractCommand> getCommands() {
    return cmds;
  }

  public void setCommands(List<AbstractCommand> cmds) {
    this.cmds = cmds;
  }

  public IdTable getIdTable() {
    return it;
  }

  public void setIdTable(IdTable it) {
    this.it = it;
  }

  public void setLanguage(String lang) {
    if (lang == "java") this.language = lang;

    else this.language = "js";
  }

  public String getLanguage() {
    return this.language;
  }
}
