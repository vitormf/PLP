package loo1.plp.orientadaObjetos1.declaracao.procedimento;

import loo1.plp.orientadaObjetos1.comando.Comando;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;

public class DecTesteSimples extends DecProcedimentoSimples implements DecTeste {
    public DecTesteSimples(Id nome, Comando comando) {
        super(nome, new ListaDeclaracaoParametro(), comando);
    }
}
