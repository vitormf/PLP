package loo1.plp.orientadaObjetos1.memoria;

import loo1.plp.orientadaObjetos1.comando.Teste;
import loo1.plp.orientadaObjetos1.declaracao.procedimento.DecTeste;
import loo1.plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;

import java.util.Collection;

public class DefTesteSuite extends DefClasse {

    private DecTeste decTeste;

    public DefTesteSuite(Id idClasse, DecVariavel decVariavel, DecTeste decTeste) {
        super(idClasse, decVariavel, decTeste);
        this.decTeste = decTeste;
    }

    public Collection<Id> getNomesTestes() {
        return decTeste.getNomesTestes();
    }

    public Teste getTeste(Id idTeste) throws ProcedimentoNaoDeclaradoException {
        return decTeste.getTeste(idTeste);
    }
}
