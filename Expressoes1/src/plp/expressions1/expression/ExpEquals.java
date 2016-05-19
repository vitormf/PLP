package plp.expressions1.expression;

import plp.expressions1.memory.AmbienteCompilacaoVazio;
import plp.expressions1.memory.AmbienteExecucaoVazio;
import plp.expressions1.util.Tipo;
import plp.expressions1.util.TipoPrimitivo;

/**
 * Um objeto desta classe representa uma Expressao de Igualdade entre Expressoes
 * cuja avaliacao resulta num mesmo valor primitivo.
 */
public class ExpEquals extends ExpBinaria {

	/**
	 * Controi uma Expressao de Igualdade com as sub-expressoes especificadas.
	 * Assume-se que estas sub-expressoes resultam num mesmo valor primitivo
	 * quando avaliadas.
	 * 
	 * @param esq
	 *            Expressao da esquerda
	 * @param dir
	 *            Expressao da direita
	 */
	public ExpEquals(Expressao esq, Expressao dir) {
		super(esq, dir, "==");
	}

	/**
	 * Retorna o valor da Expressao de Igualdade
	 * 
	 * @param amb
	 *            o ambiente de execu��o.
	 */
	public Valor avaliar(AmbienteExecucaoVazio amb) {
		return (new ValorBooleano(
				((ValorConcreto) getEsq().avaliar(amb))
						.isEquals((ValorConcreto) getDir().avaliar(amb))));
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
		return (getEsq().getTipo(amb).eIgual(getDir().getTipo(amb)));
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
		return TipoPrimitivo.BOOLEANO;
	}

}
