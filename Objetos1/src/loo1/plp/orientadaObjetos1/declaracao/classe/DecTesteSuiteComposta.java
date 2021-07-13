package loo1.plp.orientadaObjetos1.declaracao.classe;

public class DecTesteSuiteComposta extends DecClasseComposta implements DecTesteSuite {

    private final DecTesteSuite declaracao1;
    private final DecTesteSuite declaracao2;

    public DecTesteSuiteComposta(DecTesteSuite declaracao1, DecTesteSuite declaracao2) {
        super(declaracao1, declaracao2);
        this.declaracao1 = declaracao1;
        this.declaracao2 = declaracao2;
    }

}
