## NOVAS FEATURES BNF
_PS: Por simplicidade, esta BNF mostra apenas o que foi mudado e o que foi adicionado_.

[Programa](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/Programa.java) ::= "{" [DecClasse](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/classe/DecClasse.java) ";" [DecTestSuite](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/classe/DecTesteSuite.java) ";" [Comando](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/Comando.java) "}"

[DecTestSuite](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/classe/DecTesteSuite.java) ::= [DecTestSuiteAtomica](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/classe/DecTesteSuiteSimples.java) | [DecTestSuiteComposta](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/classe/DecTesteSuiteComposta.java)

[DecTestSuiteComposta](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/classe/DecTesteSuiteComposta.java) ::= [DecTestSuiteAtomica](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/classe/DecTesteSuiteSimples.java) "," [DecTestSuite](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/classe/DecTesteSuite.java)

DecTestSuiteAtomica ::= "suite" Id "{" DecVariavel ";" DecTeste "}"  

> | "suite" Id "{" DecVariavel ";" DeclaracaoTesteSetup ";" DecTeste "}"  

> | "suite" Id "{" DecVariavel ";" DeclaracaoTesteTearDown ";" DecTeste "}"  

> | "suite" Id "{" DecVariavel ";" [DeclaracaoTesteSetup](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/procedimento/DecTesteSetup.java) ";" [DeclaracaoTesteTearDown](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/procedimento/DecTesteTearDown.java) ";" [DecTeste](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/procedimento/DecTeste.java) "}"

DeclaracaoTesteSetup ::= "setup" "(" ")" "{" Comando "}"

DeclaracaoTesteTearDown ::= "teardown" "(" ")" "{" Comando "}"

DecTest ::= [DecTestAtomica](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/procedimento/DecTesteSimples.java) | [DecTestComposta](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/procedimento/DecTesteComposta.java)

DecTestComposta ::= [DecTestAtomica](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/procedimento/DecTesteSimples.java) "," [DecTest](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/declaracao/procedimento/DecTeste.java)

DecTestAtomica ::= "test" ID "(" ")" "{" Comando "}"

Comando ::= Atribuicao
            | [ComDeclaracao](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/ComDeclaracao.java)
            | [While](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/While.java)
            | [IfThenElse](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/IfThenElse.java)
            | [IO](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/IO.java)
            | Comando ";" Comando
            | [Skip](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/Skip.java)
            | [New](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/New.java)
            | [ChamadaMetodo](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/ChamadaMetodo.java)
            | [Assert](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/ChamadaAssert.java)
            | [AssertTrue](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/ChamadaAssertTrue.java)
            | [AssertFalse](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/ChamadaAssertFalse.java)

[Assert](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/ChamadaAssert.java) ::=  "assert" "(" Expressao "," Expressao ")"

[AssertTrue](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/ChamadaAssertTrue.java) ::=  "assertTrue" "(" Expressao ")"

[AssertFalse](https://github.com/vitormf/PLP/blob/oo1-unit-test/Objetos1/src/loo1/plp/orientadaObjetos1/comando/ChamadaAssertFalse.java) ::=  "assertFalse" "(" Expressao ")"

