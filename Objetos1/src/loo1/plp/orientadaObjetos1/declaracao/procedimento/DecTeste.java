package loo1.plp.orientadaObjetos1.declaracao.procedimento;


import loo1.plp.orientadaObjetos1.comando.Teste;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;

import java.util.Collection;

public interface DecTeste extends DecProcedimento {

    Collection<Id> getNomesTestes();
    Teste getTeste(Id nomeTeste) throws ProcedimentoNaoDeclaradoException;

}
