package loo1.plp.orientadaObjetos1.declaracao.procedimento;

import loo1.plp.orientadaObjetos1.comando.Teste;

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
    public List<Teste> getTestes() {
        List<Teste> testes = declaracao1.getTestes();
        testes.addAll(declaracao2.getTestes());
        return testes;
    }
}
