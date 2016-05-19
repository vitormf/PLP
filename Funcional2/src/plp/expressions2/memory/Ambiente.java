package plp.expressions2.memory;

import plp.expressions1.memory.AmbienteVazio;
import plp.expressions2.expression.Id;


public interface Ambiente<T> extends AmbienteVazio<T> {

	public void incrementa();

	public void restaura();

	public void map(Id idArg, T tipoId) throws VariavelJaDeclaradaException;

	public T get(Id idArg) throws VariavelNaoDeclaradaException;

}
