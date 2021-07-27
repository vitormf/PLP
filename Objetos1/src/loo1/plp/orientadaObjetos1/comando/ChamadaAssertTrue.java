package loo1.plp.orientadaObjetos1.comando;

import loo1.plp.orientadaObjetos1.expressao.Expressao;
import loo1.plp.orientadaObjetos1.expressao.valor.ValorBooleano;

public class ChamadaAssertTrue extends ChamadaAssert {
    public ChamadaAssertTrue(Expressao expressao) {
        super(new ValorBooleano(true), expressao);
    }
}
