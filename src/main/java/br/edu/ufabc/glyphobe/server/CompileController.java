package br.edu.ufabc.glyphobe.server;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufabc.glyphobe.Glypho;

@RestController
public class CompileController {

  @CrossOrigin(origins = {"//127.0.0.1:5500/", "//tiago-simionato.github.io/"})
  @GetMapping("/compile")
  public Result compile(@RequestHeader(value = "code", defaultValue = "programafimprog.") String code) {
    code = code.substring(1, code.length() - 1).replace("\\n", "\n");
    
    Glypho g = new Glypho("js", code);
    String result = g.getCompilationResult();
    System.out.println(result);
    return new Result(result, g.getTargetCode());
  }
}