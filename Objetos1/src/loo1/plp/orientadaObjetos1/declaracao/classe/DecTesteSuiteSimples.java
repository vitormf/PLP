package loo1.plp.orientadaObjetos1.declaracao.classe;

import loo1.plp.orientadaObjetos1.declaracao.procedimento.DecProcedimento;
import loo1.plp.orientadaObjetos1.declaracao.procedimento.DecTeste;
import loo1.plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;

public class DecTesteSuiteSimples extends DecClasseSimples implements DecTesteSuite {
    public DecTesteSuiteSimples(Id nomeTesteSuite, DecVariavel atributos, DecTeste testes) {
        super(nomeTesteSuite, atributos, testes);
    }
}
