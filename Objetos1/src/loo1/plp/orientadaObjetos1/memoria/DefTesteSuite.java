package loo1.plp.orientadaObjetos1.memoria;

import loo1.plp.orientadaObjetos1.comando.Teste;
import loo1.plp.orientadaObjetos1.declaracao.procedimento.DecTeste;
import loo1.plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;

import java.util.Collection;

public class DefTesteSuite extends DefClasse {

    private DecTeste decTeste;

    public DefTesteSuite(Id idClasse, DecVariavel decVariavel, DecTeste decTeste) {
        super(idClasse, decVariavel, decTeste);
        this.decTeste = decTeste;
    }

    public Collection<Teste> getTestes() {
        return decTeste.getTestes();
    }
}
