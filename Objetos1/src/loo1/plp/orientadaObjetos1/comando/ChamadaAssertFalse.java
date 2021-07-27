package loo1.plp.orientadaObjetos1.comando;

import loo1.plp.orientadaObjetos1.expressao.Expressao;
import loo1.plp.orientadaObjetos1.expressao.valor.ValorBooleano;

public class ChamadaAssertFalse extends ChamadaAssert {
    public ChamadaAssertFalse(Expressao expressao) {
        super(new ValorBooleano(false), expressao);
    }
}
