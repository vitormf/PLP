package loo1.plp.orientadaObjetos1.declaracao.procedimento;

import loo1.plp.orientadaObjetos1.comando.Comando;
import loo1.plp.orientadaObjetos1.comando.Procedimento;
import loo1.plp.orientadaObjetos1.comando.Teste;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;

import java.util.ArrayList;
import java.util.List;

public class DecTesteSimples extends DecProcedimentoSimples implements DecTeste {
    public DecTesteSimples(Id nome, Comando comando) {
        super(nome, new ListaDeclaracaoParametro(), comando);
    }

    public Teste getTeste() {
        return new Teste(comando);
    }

    public List<Teste> getTestes() {
        List<Teste> lista = new ArrayList<>();
        lista.add(getTeste());
        return lista;
    }
}
