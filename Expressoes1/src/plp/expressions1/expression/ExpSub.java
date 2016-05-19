package plp.expressions1.expression;

import plp.expressions1.memory.AmbienteCompilacaoVazio;
import plp.expressions1.memory.AmbienteExecucaoVazio;
import plp.expressions1.util.Tipo;
import plp.expressions1.util.TipoPrimitivo;

/**
* Um objeto desta classe representa uma Expressao de Subtracao.
*/
public class ExpSub extends ExpBinaria {

	/**
	 * Controi uma Expressao de Subtracao com as sub-expressoes especificadas.
	 * Assume-se que estas expressoes resultam em <code>ValorInteiro</code>
	 * quando avaliadas.
	 *
	 * @param esq Expressao da esquerda
	 * @param dir Expressao da direita
	 */
	public ExpSub(Expressao esq, Expressao dir) {
		super(esq, dir, "-");
	}

	/**
	 * Retorna o valor da Expressao de Subtracao
	 * 
	 * @param amb
	 *            o ambiente de execu��o.
	 */
	public Valor avaliar(AmbienteExecucaoVazio amb) {
		return new ValorInteiro(
				((ValorInteiro)getEsq().avaliar(amb)).valor() -
				((ValorInteiro)getDir().avaliar(amb)).valor()
		);
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
		return (getEsq().getTipo(amb).eInteiro() && getDir().getTipo(amb).eInteiro());
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
