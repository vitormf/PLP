package plp.expressions1.expression;

import plp.expressions1.memory.AmbienteCompilacaoVazio;
import plp.expressions1.memory.AmbienteExecucaoVazio;
import plp.expressions1.util.Tipo;
import plp.expressions1.expression.Valor;

/** 
 * Uma expressao &eacute; a unidade basica na Linguagem de Expressoes.
 */
public interface Expressao {

	/**
	 * Avalia a expressao retornando seu Valor.
	 */
	Valor avaliar(AmbienteExecucaoVazio amb);

	/**
	 * Realiza a verificacao de tipos desta expressao.
	 *
	 * @param amb o ambiente que contem o mapeamento entre identificadores
	 *          e tipos.
	 * @return <code>true</code> se os tipos da expressao sao validos;
	 *          <code>false</code> caso contrario.
	 */
	boolean checaTipo(AmbienteCompilacaoVazio amb);

	/**
	 * Retorna os tipos possiveis desta expressao.
	 *
	 * @param amb o ambiente que contem o mapeamento entre identificadores
	 *          e tipos.
	 * @return os tipos possiveis desta expressao.
	 */
	Tipo getTipo(AmbienteCompilacaoVazio amb);

}
