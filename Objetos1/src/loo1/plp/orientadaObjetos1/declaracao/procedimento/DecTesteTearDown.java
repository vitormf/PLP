package loo1.plp.orientadaObjetos1.declaracao.procedimento;

import loo1.plp.orientadaObjetos1.comando.Comando;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;

public class DecTesteTearDown extends DecTesteSimples {
    public DecTesteTearDown(Comando comando) {
        super(new Id("teardown"), comando);
    }
}
