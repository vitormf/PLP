package plp.expressions1.expression;

import plp.expressions1.memory.AmbienteCompilacaoVazio;
import plp.expressions1.memory.AmbienteExecucaoVazio;
import plp.expressions1.util.Tipo;
import plp.expressions1.util.TipoPrimitivo;

/**
* Um objeto desta classe representa uma Expressao de menos unario.
*/

public class ExpMenos extends ExpUnaria{

	/**
	 * Controi uma Expressao de menos unario com expressao especificada
	 *
	 * @param exp Expressao cuja avaliacao resulta <code>ValorInteiro</code>.
	 */
	public ExpMenos(Expressao exp){
		super(exp, "-");
	}

	/**
	 * Retorna o valor da Expressao de menos unario.
	 * 
	 * @param amb
	 *            o ambiente de execu��o.
	 */
	public Valor avaliar(AmbienteExecucaoVazio amb) {
		return new ValorInteiro(- ((ValorInteiro)getExp().avaliar(amb)).valor());
	}

	/**
	 * Realiza a verificacao de tipos desta expressao.
	 *
	 * @param amb
	 *            o ambiente de compila��o.
	 *
	 * @return <code>true</code> se os tipos da expressao sao validos;
	 *         <code>false</code> caso contrario.
	 */
	protected boolean checaTipoElementoTerminal(AmbienteCompilacaoVazio amb) {
		return (getExp().getTipo(amb).eInteiro());
	}

	/**
	 * Retorna os tipos possiveis desta expressao.
	 * 
	 * @param amb
	 *            o ambiente de compila��o.
	 * 
	 * @return os tipos possiveis desta expressao.
	 */
	public Tipo getTipo(AmbienteCompilacaoVazio amb) {
		return TipoPrimitivo.INTEIRO;
	}
}
