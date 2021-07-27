package loo1.plp.orientadaObjetos1.declaracao.procedimento;

import loo1.plp.orientadaObjetos1.comando.Procedimento;
import loo1.plp.orientadaObjetos1.comando.Teste;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;

import java.util.Collection;
import java.util.List;

public class DecTesteComposta extends DecProcedimentoComposta implements DecTeste {

    private final DecTeste declaracao1;
    private final DecTeste declaracao2;

    public DecTesteComposta(DecTeste declaracao1, DecTeste declaracao2) {
        super(declaracao1, declaracao2);
        this.declaracao1 = declaracao1;
        this.declaracao2 = declaracao2;
    }

    @Override
    public Collection<Id> getNomesTestes() {
        Collection<Id> nomes = declaracao1.getNomesTestes();
        nomes.addAll(declaracao2.getNomesTestes());
        return nomes;
    }

    @Override
    public Teste getTeste(Id id) throws ProcedimentoNaoDeclaradoException {
        Teste teste;
        try {
            teste = declaracao1.getTeste(id);
        } catch(ProcedimentoNaoDeclaradoException e) {
            teste = declaracao2.getTeste(id);
        }
        return teste;
    }
}
