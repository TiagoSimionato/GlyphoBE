# GlyphoBE
 Repo for the Back-End of the Glypho Compiler


## Para Executar o ANTLR4

`java -cp ./antlr-4.7.1-complete.jar org.antlr.v4.Tool ./src/isilang.g4 -o ./src/main/java/br/edu/ufabc/glyphobe/core -package br.edu.ufabc.glyphobe.core`

## Para rodar o servidor com o Spring

`.\mvnw spring-boot:run`

## TODO

- Editor Highlight (simulando uma pequena IDE)
- Geração de várias linguagens-alvo
- Uma API Rest para implementação do compilador
- Operadores relacionais?

## Erros semânticos implementados

- Variável já declarada
- Variável está sendo usada sem ter valor inicial
- Variável foi declarada e não foi usada
- Variável não declarada
- Caso seja esperado uma exprBooleana e for encontrado outro tipo de expr
- Elementos de tipos diferentes dentro de uma mesma expressão. I.E. 5 + VERDADEIRO - 3.3R
- Se tipo da expressão é compatível com tipo do identificador