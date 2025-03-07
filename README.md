# GlyphoBE
 Repo containing the Back-End of the Glypho Compiler.

 The project was made using [ANTL](https://www.antlr.org/) to generate the compiler classes and [SPRING](https://spring.io/) to setup the project server 

## To Execute ANTLR4 and generate the source classes

`java -cp ./antlr-4.7.1-complete.jar org.antlr.v4.Tool ./src/isilang.g4 -o ./src/main/java/br/edu/ufabc/glyphobe/core -package br.edu.ufabc.glyphobe.core`

## Starting the Server

`.\mvnw spring-boot:run`

## Generating JAR

`.\mvnw package`

## Erros semânticos implementados

- Variável já declarada
- Variável está sendo usada sem ter valor inicial
- Variável foi declarada e não foi usada
- Variável não declarada
- Caso seja esperado uma exprBooleana e for encontrado outro tipo de expr
- Elementos de tipos diferentes dentro de uma mesma expressão. I.E. 5 + VERDADEIRO - 3.3R
- Se tipo da expressão é compatível com tipo do identificador

# IsiLanguage - Descrição da Linguagem

A IsiLanguage é uma linguagem de programação simples que possui um conjunto de regras definidas para controle de fluxo, declaração de variáveis, operações matemáticas e expressões booleanas. Neste documento, vamos explorar as principais características da IsiLanguage e como elas são implementadas na gramática fornecida.

## Tipos de Dados

A IsiLanguage suporta três tipos de dados:

- INTEIRO: Representa números inteiros, como 1, -5, 100.
- REAL: Representa números reais (de ponto flutuante), como 3.14, -0.5, 10.0.
- BOOLEANO: Representa valores booleanos verdadeiro (`VERDADEIRO`) e falso (`FALSO`).

## Declaração de Variáveis

Variáveis podem ser declaradas usando a palavra-chave `declare`, seguida pelo tipo da variável e seus identificadores. Exemplo:

declare INTEIRO x, y
declare REAL z


## Entrada e Saída

A linguagem permite a leitura de valores do usuário com o comando `leia`. Por exemplo:

leia(x)


A impressão na tela é realizada usando o comando `escreva`. Você pode imprimir uma string ou uma expressão. Exemplos:

escreva("Digite um número: ")
escreva(x + y)


## Atribuição

As variáveis podem ser atribuídas usando o operador `:=`. A atribuição também verifica a compatibilidade do tipo da expressão atribuída com o tipo da variável. Exemplos:

x := 10
y := x + 5


## Controle de Fluxo

A IsiLanguage oferece estruturas de controle de fluxo, como condicionais e loops.

### Condicional

A estrutura condicional `se ... entao` permite executar um bloco de comandos se uma condição for verdadeira. Você pode adicionar cláusulas `ou se` e `senao` para lidar com casos adicionais. Exemplo:

se (x > y) entao {
escreva("x é maior que y")
} senao {
escreva("x não é maior que y")
}


### Loop While

A estrutura `enquanto` permite criar um loop que executa um bloco de comandos enquanto uma condição for verdadeira. Exemplo:

enquanto (x > 0) {
escreva(x)
x := x - 1
}


## Expressões Aritméticas e Booleanas

Você pode criar expressões aritméticas e booleanas usando operadores. Os operadores aritméticos suportados são `+`, `-`, `*` e `/`. Os operadores relacionais incluem `>`, `<`, `>=`, `<=`, `==` e `<>` (diferente de). Exemplos:

x := 5 + y
z := x * 2.0
b := x > y
