# GlyphoBE
 Repo containing the Back-End of the Glypho Compiler

 The project was made using [ANTL](https://www.antlr.org/) to generate the compiler classes and [SPRING](https://spring.io/) to setup the project server 

## To Execute ANTLR4 and generate the source classes

`java -cp ./antlr-4.7.1-complete.jar org.antlr.v4.Tool ./src/isilang.g4 -o ./src/main/java/br/edu/ufabc/glyphobe/core -package br.edu.ufabc.glyphobe.core`

## Starting the Server

`.\mvnw spring-boot:run`

## TODO

- Editor Highlight (simulando uma pequena IDE)
  - Fetch do back end perguntando por palavras chave?
- Operadores relacionais?
- Bug de indentação no front
- Comentar o Código
- Gravar o vídeo do projeto
- Implementar erro semântico como subclasse de RecognitionError para tratar melhor error semânticos
- Revisar resposta da API REST

## Erros semânticos implementados

- Variável já declarada
- Variável está sendo usada sem ter valor inicial
- Variável foi declarada e não foi usada
- Variável não declarada
- Caso seja esperado uma exprBooleana e for encontrado outro tipo de expr
- Elementos de tipos diferentes dentro de uma mesma expressão. I.E. 5 + VERDADEIRO - 3.3R
- Se tipo da expressão é compatível com tipo do identificador