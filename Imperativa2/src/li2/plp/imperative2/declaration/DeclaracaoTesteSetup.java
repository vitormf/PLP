package li2.plp.imperative2.declaration;

import li2.plp.expressions2.expression.Id;

public class DeclaracaoTesteSetup extends DeclaracaoTeste {
    public DeclaracaoTesteSetup(DefTesteSetup defTeste) {
        super(new Id("test_setup"), defTeste);
    }
}