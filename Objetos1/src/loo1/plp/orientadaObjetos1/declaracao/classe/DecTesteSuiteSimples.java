package loo1.plp.orientadaObjetos1.declaracao.classe;

import loo1.plp.expressions2.memory.VariavelJaDeclaradaException;
import loo1.plp.expressions2.memory.VariavelNaoDeclaradaException;
import loo1.plp.orientadaObjetos1.declaracao.procedimento.DecTeste;
import loo1.plp.orientadaObjetos1.declaracao.procedimento.DecTesteSetup;
import loo1.plp.orientadaObjetos1.declaracao.procedimento.DecTesteTearDown;
import loo1.plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ClasseJaDeclaradaException;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ClasseNaoDeclaradaException;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ProcedimentoJaDeclaradoException;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;
import loo1.plp.orientadaObjetos1.memoria.AmbienteCompilacaoOO1;
import loo1.plp.orientadaObjetos1.memoria.AmbienteExecucaoOO1;
import loo1.plp.orientadaObjetos1.memoria.DefTesteSuite;
import loo1.plp.orientadaObjetos1.util.TipoClasse;

public class DecTesteSuiteSimples extends DecClasseSimples implements DecTesteSuite {

    private DecTeste testes;
    private DecTesteSetup setup;
    private DecTesteTearDown teardown;

    public DecTesteSuiteSimples(Id nomeTesteSuite, DecVariavel atributos, DecTeste testes, DecTesteSetup setup, DecTesteTearDown teardown) {
        super(nomeTesteSuite, atributos, testes);
        this.testes = testes;
        this.setup = setup;
        this.teardown = teardown;
    }


    public boolean checaTipo(AmbienteCompilacaoOO1 ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
            ClasseJaDeclaradaException, ClasseNaoDeclaradaException,
            ProcedimentoNaoDeclaradoException, ProcedimentoJaDeclaradoException {

        ambiente.mapDefTesteSuite(nomeClasse, new DefTesteSuite(nomeClasse, atributos, testes, setup, teardown));
        boolean resposta = false;
        ambiente.incrementa();
        if (atributos.checaTipo(ambiente)){
            ambiente.map(new Id("this"), new TipoClasse(nomeClasse));
            resposta =  metodos.checaTipo(ambiente);
        }
        ambiente.restaura();
        return resposta;
    }

    public AmbienteExecucaoOO1 elabora(AmbienteExecucaoOO1 ambiente)
            throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
            ClasseJaDeclaradaException, ClasseNaoDeclaradaException,
            ProcedimentoNaoDeclaradoException, ProcedimentoJaDeclaradoException {

        ambiente.mapDefTesteSuite(nomeClasse, new DefTesteSuite(nomeClasse, atributos,testes, setup, teardown));

        return ambiente;
    }

}
