package li2.plp.imperative2.declaration;

import li2.plp.expressions2.expression.Id;
import li2.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li2.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li2.plp.imperative1.memory.EntradaVaziaException;
import li2.plp.imperative1.memory.ErroTipoEntradaException;
import li2.plp.imperative2.TestRunner;
import li2.plp.imperative2.command.ChamadaTeste;

public class DeclaracaoTeste extends DeclaracaoProcedimento {


	public DeclaracaoTeste(Id id, DefTeste defTeste) {
		super(id, defTeste);
	}
	
	@Override
	public AmbienteExecucaoImperativa elabora(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException, IdentificadorNaoDeclaradoException, EntradaVaziaException {
		
		AmbienteExecucaoImperativa amb =  super.elabora(ambiente);
		
		try {
			new ChamadaTeste(getId()).executar(ambiente);
			TestRunner.addSuccess(getId());
		} catch (Exception exc) {
			TestRunner.addFailure(getId(), exc);
		}
		
		return amb;
	}
	
}
