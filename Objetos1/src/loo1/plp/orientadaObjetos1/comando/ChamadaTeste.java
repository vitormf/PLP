package loo1.plp.orientadaObjetos1.comando;

import loo1.plp.expressions2.expression.Id;
import loo1.plp.orientadaObjetos1.excecao.declaracao.*;
import loo1.plp.orientadaObjetos1.excecao.execucao.EntradaInvalidaException;
import loo1.plp.orientadaObjetos1.expressao.ListaExpressao;
import loo1.plp.orientadaObjetos1.memoria.AmbienteExecucaoOO1;

public class ChamadaTeste extends ChamadaProcedimento {

    public ChamadaTeste(Teste teste) {
        super(teste, new ListaExpressao());
    }

    @Override
    public AmbienteExecucaoOO1 executar(AmbienteExecucaoOO1 amb)
            throws ProcedimentoNaoDeclaradoException, ClasseNaoDeclaradaException, ProcedimentoJaDeclaradoException,
            ObjetoNaoDeclaradoException, ObjetoJaDeclaradoException, ClasseJaDeclaradaException,
            EntradaInvalidaException {
        if (amb.getTestar()) {
            return super.executar(amb);
        } else {
            throw new RuntimeException("Testes não devem ser chamado em modo executar");
        }
    }

}
