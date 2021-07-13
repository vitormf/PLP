package loo1.plp.orientadaObjetos1.memoria;

import loo1.plp.orientadaObjetos1.comando.Teste;
import loo1.plp.orientadaObjetos1.declaracao.procedimento.DecTeste;
import loo1.plp.orientadaObjetos1.declaracao.procedimento.DecTesteSetup;
import loo1.plp.orientadaObjetos1.declaracao.procedimento.DecTesteTearDown;
import loo1.plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;

import java.util.Collection;

public class DefTesteSuite extends DefClasse {

    private DecTeste decTeste;
    private DecTesteSetup decTesteSetup;
    private DecTesteTearDown decTesteTearDown;

    public DefTesteSuite(Id idClasse, DecVariavel decVariavel, DecTeste decTeste, DecTesteSetup decTesteSetup, DecTesteTearDown decTesteTearDown) {
        super(idClasse, decVariavel, decTeste);
        this.decTeste = decTeste;
        this.decTesteSetup = decTesteSetup;
        this.decTesteTearDown = decTesteTearDown;
    }

    public Collection<Id> getNomesTestes() {
        return decTeste.getNomesTestes();
    }

    public Teste getTeste(Id idTeste) throws ProcedimentoNaoDeclaradoException {
        return decTeste.getTeste(idTeste);
    }

    public Teste getSetup() {
        try {
            return decTesteSetup.getTeste(new Id("setup"));
        } catch (ProcedimentoNaoDeclaradoException e) {
            return null;
        }
    }

    public Teste getTearDown() {
        try {
            return decTesteTearDown.getTeste(new Id("teardown"));
        } catch (ProcedimentoNaoDeclaradoException e) {
            return null;
        }
    }

}
