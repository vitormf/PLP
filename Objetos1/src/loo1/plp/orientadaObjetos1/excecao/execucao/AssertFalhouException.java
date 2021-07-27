package loo1.plp.orientadaObjetos1.excecao.execucao;

import loo1.plp.orientadaObjetos1.comando.ChamadaAssert;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ClasseNaoDeclaradaException;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ObjetoNaoDeclaradoException;
import loo1.plp.orientadaObjetos1.expressao.valor.Valor;
import loo1.plp.orientadaObjetos1.memoria.AmbienteExecucaoOO1;

public class AssertFalhouException extends RuntimeException {
    private static final long serialVersionUID = -4319934799920230514L;
    private static final String template = "Esperava \"%s\" mas era \"%s\"";

    public AssertFalhouException(AmbienteExecucaoOO1 ambiente, ChamadaAssert chamadaAssert) throws ClasseNaoDeclaradaException, ObjetoNaoDeclaradoException {
        super(generateMessage(ambiente, chamadaAssert));
    }

    private static String generateMessage(AmbienteExecucaoOO1 ambiente, ChamadaAssert chamadaAssert) throws ClasseNaoDeclaradaException, ObjetoNaoDeclaradoException {
        Valor esq = chamadaAssert.getEsq().avaliar(ambiente);
        Valor dir = chamadaAssert.getDir().avaliar(ambiente);
        return String.format("Esperava \"%s\" mas era \"%s\"", esq.toString(), dir.toString());
    }
}

