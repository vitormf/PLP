package li2.plp.imperative2.declaration;

import li2.plp.expressions2.expression.Id;

public class DeclaracaoTesteTeardown extends DeclaracaoTeste {
    public DeclaracaoTesteTeardown(DefTesteTeardown defTeste) {
        super(new Id("test_teardown"), defTeste);
    }
}