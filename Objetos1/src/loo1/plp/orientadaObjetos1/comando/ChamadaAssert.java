package loo1.plp.orientadaObjetos1.comando;

import loo1.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import loo1.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import loo1.plp.imperative1.memory.EntradaVaziaException;
import loo1.plp.imperative1.memory.ErroTipoEntradaException;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ClasseNaoDeclaradaException;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ObjetoNaoDeclaradoException;
import loo1.plp.orientadaObjetos1.excecao.execucao.AssertFalhouException;
import loo1.plp.orientadaObjetos1.expressao.Expressao;
import loo1.plp.orientadaObjetos1.expressao.valor.ValorConcreto;
import loo1.plp.orientadaObjetos1.memoria.AmbienteCompilacaoOO1;
import loo1.plp.orientadaObjetos1.memoria.AmbienteExecucaoOO1;
import loo1.plp.orientadaObjetos1.memoria.ContextoExecucaoOO1;

public class ChamadaAssert implements Comando {
	
	private Expressao esq;
	private Expressao dir;
	
	public ChamadaAssert(Expressao esq, Expressao dir) {
		this.esq = esq;
		this.dir = dir;
	}
	
	public Expressao getEsq() {
		return esq;
	}

	public Expressao getDir() {
		return dir;
	}

	@Override
	public AmbienteExecucaoOO1 executar(AmbienteExecucaoOO1 ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException,
			ClasseNaoDeclaradaException, ObjetoNaoDeclaradoException {
		
		if (ambiente.getTestar()) {
			ValorConcreto esq = (ValorConcreto) this.esq.avaliar(ambiente);
			ValorConcreto dir = (ValorConcreto) this.dir.avaliar(ambiente);

			if (!esq.equals(dir)) {
				ambiente.restaura();
				throw new AssertFalhouException(ambiente, this);
			}
		}
		
		return ambiente;
	}

	@Override
	public boolean checaTipo(AmbienteCompilacaoOO1 ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException,  ClasseNaoDeclaradaException {
		return esq.getTipo(ambiente).equals(dir.getTipo(ambiente));
	}

}
