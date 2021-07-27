## NOVAS FEATURES BNF (com link para a classe) 

[Comando](Imperativa2/src/li2/plp/imperative1/command/Comando.java) ::= [Atribuicao](/Imperativa2/src/li2/plp/imperative1/command/Atribuicao.java) 

> | [ComandoDeclaracao](/Imperativa2/src/li2/plp/imperative1/command/ComandoDeclaracao.java) 
  
> | [While](/Imperativa2/src/li2/plp/imperative1/command/While.java)

> | [IfThenElse](/Imperativa2/src/li2/plp/imperative1/command/IfThenElse.java)

> | [IO](/Imperativa2/src/li2/plp/imperative1/command/IO.java)

> | [Comando](Imperativa2/src/li2/plp/imperative1/command/Comando.java) ";" [Comando](Imperativa2/src/li2/plp/imperative1/command/Comando.java)

> | [Skip](/Imperativa2/src/li2/plp/imperative1/command/Skip.java)

> | [ChamadaProcedimento](Imperativa2/src/li2/plp/imperative2/command/ChamadaProcedimento.java)

> | [ChamadaTeste](/Imperativa2/src/li2/plp/imperative2/command/ChamadaTeste.java)

> | [Assercao](/Imperativa2/src/li2/plp/imperative2/command/ChamadaAssert.java)



[ComandoDeclaracao](/Imperativa2/src/li2/plp/imperative1/command/ComandoDeclaracao.java) :: = "{" [Declaracao](/Imperativa2/src/li2/plp/imperative1/declaration/Declaracao.java) [ "," [DeclaracaoTestes](/Imperativa2/src/li2/plp/imperative2/declaration/DeclaracaoTeste.java) ] ";" [Comando](Imperativa2/src/li2/plp/imperative1/command/Comando.java) "}"

[DeclaracaoTestes](/Imperativa2/src/li2/plp/imperative2/declaration/DeclaracaoTeste.java) ::= [[DeclaracaoTesteSetup](/Imperativa2/src/li2/plp/imperative2/declaration/DeclaracaoTesteSetup.java) ] [DeclaracaoTeste](/Imperativa2/src/li2/plp/imperative2/declaration/DefTeste.java) [[DeclaracaoTesteTearDown](/Imperativa2/src/li2/plp/imperative2/declaration/DefTesteTeardown.java)]

DeclaracaoTeste ::= DecTest | DecTestComposto

DecTestComposto ::= DecTest | DecTestComposto

[DecTest](/Imperativa2/src/li2/plp/imperative2/declaration/DefTeste.java) ::= "test" ID "(" ")" "{" Comando "}"

[DeclaracaoTesteSetup](/Imperativa2/src/li2/plp/imperative2/declaration/DeclaracaoTesteSetup.java) ::= "test_setup" "(" ")" "{" Comando "}"

[DeclaracaoTesteTearDown](/Imperativa2/src/li2/plp/imperative2/declaration/DefTesteTeardown.java) ::= "test_teardown" "(" ")" "{" Comando "}"


[Assercao](/Imperativa2/src/li2/plp/imperative2/command/ChamadaAssert.java) ::= AssertTrue

> | AssertFalse

> | AssertEquals

AssertTrue ::=  "assert_true" "(" [Expressao](/Imperativa2/src/li2/plp/expressions2/expression/Expressao.java) ")"

AssertFalse ::=  "assert_false" "(" [Expressao](/Imperativa2/src/li2/plp/expressions2/expression/Expressao.java) ")"

AssertEquals ::=  "assert" "(" [Expressao](/Imperativa2/src/li2/plp/expressions2/expression/Expressao.java) "," [Expressao](/Imperativa2/src/li2/plp/expressions2/expression/Expressao.java) ")"
