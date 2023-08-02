package br.edu.ufabc.glyphobe.server;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufabc.glyphobe.Glypho;

@RestController
public class CompileController {

  @CrossOrigin(origins = "*")
  @GetMapping("/compile")
  public Result compile (
    @RequestHeader(value = "code", defaultValue = "programafimprog.") String code,
    @RequestHeader(value = "targetLang", defaultValue = "js") String targetLanguage
  ){
    code = code.substring(1, code.length() - 1).replace("\\n", "\n").replace("\\", "");
    targetLanguage = targetLanguage.substring(1, targetLanguage.length() - 1);
    
    Glypho g = new Glypho(targetLanguage, code);
    String result = g.compile(code, targetLanguage);
    String targetCode = g.getTargetCode();
    
    return new Result(result, targetCode);
  }
}
