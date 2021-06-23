package li2.plp.imperative2.command;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;
import li2.plp.imperative2.memory.AmbienteExecucaoImperativa2;

public class ChamadaTeste extends ChamadaProcedimento {

	public ChamadaTeste(Id nomeProcedimento) {
		super(nomeProcedimento, new ListaExpressao());
	}
	
	@Override
	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa amb)
			throws IdentificadorNaoDeclaradoException, IdentificadorJaDeclaradoException, EntradaVaziaException,
			ErroTipoEntradaException {
		AmbienteExecucaoImperativa2 amb2 = (AmbienteExecucaoImperativa2) amb;
		if (amb2.getTestar()) {
			return super.executar(amb);
		} else {
			throw new RuntimeException("Testes não devem ser chamado em modo executar");
		}
	}

}
