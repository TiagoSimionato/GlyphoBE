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
  public Result compile(@RequestHeader(value = "code", defaultValue = "programafimprog.") String code) {
    code = code.substring(1, code.length() - 1).replace("\\n", "\n").replace("\\", "");
    System.out.println(code);
    
    Glypho g = new Glypho("js", code);
    String result = g.getCompilationResult();
    String targetCode = g.getTargetCode();
    return new Result(result, targetCode);
  }
}
