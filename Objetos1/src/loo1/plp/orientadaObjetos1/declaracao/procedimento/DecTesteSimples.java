package loo1.plp.orientadaObjetos1.declaracao.procedimento;

import loo1.plp.orientadaObjetos1.comando.Comando;
import loo1.plp.orientadaObjetos1.comando.Teste;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;

import java.util.ArrayList;
import java.util.Collection;

public class DecTesteSimples extends DecProcedimentoSimples implements DecTeste {
    public DecTesteSimples(Id nome, Comando comando) {
        super(nome, new ListaDeclaracaoParametro(), comando);
    }

    public Collection<Id> getNomesTestes() {
        Collection<Id> nomes = new ArrayList<>();
        nomes.add(nome);
        return nomes;
    }

    @Override
    public Teste getTeste(Id nomeTeste) throws ProcedimentoNaoDeclaradoException {
        if(this.nome.equals(nomeTeste)){
            return new Teste(comando);
        } else {
            throw new ProcedimentoNaoDeclaradoException(nome);
        }
    }
}
