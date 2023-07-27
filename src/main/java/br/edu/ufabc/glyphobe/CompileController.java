package br.edu.ufabc.glyphobe;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompileController {
  @CrossOrigin(origins = {"http://127.0.0.1:5500/", ""})
  @GetMapping("/compile")
  public Result compile(@RequestHeader(value = "code", defaultValue = "programafimprog.") String code) {
    code = code.substring(1, code.length() - 1).replace("\\n", "\n");
    System.out.println("\n" + code + "\n");

    String result = Glypho.compile(code);
    System.out.println(result);
    return new Result(result);
  }
}
