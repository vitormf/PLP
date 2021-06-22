package li2.plp.imperative2.command;

import li2.plp.expressions2.expression.Valor;
import li2.plp.imperative1.memory.AmbienteExecucaoImperativa;

public class AssertFalhouException extends RuntimeException {

	private static final long serialVersionUID = -4319934799920230514L;
	
	private static final String template = "Assertion error: expecting \"%s\" but was \"%s\"";
	
	public AssertFalhouException(AmbienteExecucaoImperativa ambiente, ChamadaAssert chamadaAssert) {
		super(generateMessage(ambiente, chamadaAssert));
	}
	
	private static String generateMessage(AmbienteExecucaoImperativa ambiente, ChamadaAssert chamadaAssert) {
		Valor esq = chamadaAssert.getEsq().avaliar(ambiente);
		Valor dir = chamadaAssert.getDir().avaliar(ambiente);
		return String.format(template, esq.toString(), dir.toString());
	}
	

}
