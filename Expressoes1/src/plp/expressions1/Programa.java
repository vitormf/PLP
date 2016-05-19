package plp.expressions1;

import plp.expressions1.expression.Expressao;
import plp.expressions1.expression.Valor;
import plp.expressions1.memory.AmbienteCompilacaoVazio;
import plp.expressions1.memory.AmbienteExecucaoVazio;
import plp.expressions1.memory.ContextoCompilacaoVazio;
import plp.expressions1.memory.ContextoExecucaoVazio;

public class Programa{

	private Expressao exp;

	public Valor executar() {
		AmbienteExecucaoVazio ambExec = new ContextoExecucaoVazio();
		Valor result = exp.avaliar(ambExec);
		System.out.println(result);
		return  result;		
 	}

	public boolean checaTipo() {
		AmbienteCompilacaoVazio ambComp = new ContextoCompilacaoVazio();
		return exp.checaTipo(ambComp);
 	}

	public Programa(Expressao exp){
		this.exp = exp;
	}

	public Expressao getExpressao() {
		return exp;
	}

}
