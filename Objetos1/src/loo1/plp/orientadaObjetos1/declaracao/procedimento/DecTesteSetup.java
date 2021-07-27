package loo1.plp.orientadaObjetos1.declaracao.procedimento;

import loo1.plp.orientadaObjetos1.comando.Comando;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;

public class DecTesteSetup extends DecTesteSimples {
    public DecTesteSetup(Comando comando) {
        super(new Id("setup"), comando);
    }
}
