package loo1.plp.orientadaObjetos1.unitTests;

import loo1.plp.orientadaObjetos1.comando.ChamadaProcedimento;
import loo1.plp.orientadaObjetos1.comando.ChamadaTeste;
import loo1.plp.orientadaObjetos1.comando.Teste;
import loo1.plp.orientadaObjetos1.declaracao.classe.DecTesteSuite;
import loo1.plp.orientadaObjetos1.declaracao.classe.DecTesteSuiteSimples;
import loo1.plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import loo1.plp.orientadaObjetos1.excecao.declaracao.*;
import loo1.plp.orientadaObjetos1.excecao.execucao.EntradaInvalidaException;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;
import loo1.plp.orientadaObjetos1.expressao.valor.ValorRef;
import loo1.plp.orientadaObjetos1.memoria.*;
import loo1.plp.orientadaObjetos1.memoria.colecao.ListaValor;

import java.util.Collection;
import java.util.List;

public class TesteSuiteExecutor {

    private DefTesteSuite defTesteSuite;

    public TesteSuiteExecutor(DefTesteSuite defTesteSuite) {
        this.defTesteSuite = defTesteSuite;
    }

    public void executar(AmbienteExecucaoOO1 ambiente) throws ClasseNaoDeclaradaException, ObjetoNaoDeclaradoException, ObjetoJaDeclaradoException, ClasseJaDeclaradaException {
        DecVariavel decVariavel = defTesteSuite.getDecVariavel();

        Id id = defTesteSuite.getIdClasse();
        AmbienteExecucaoOO1 aux = decVariavel.elabora(new ContextoExecucaoOO1(ambiente));
        ContextoObjeto estadoObj = new ContextoObjeto(aux.getPilha().pop());
        Objeto objeto = new Objeto(id, estadoObj);


        Collection<Teste> testes = defTesteSuite.getTestes();


        ContextoExecucaoOO1 ctx = new ContextoExecucaoOO1(ambiente);
        ValorRef vr = ctx.getProxRef();
        ctx.mapObjeto(vr, objeto);
        ctx.changeValor(new Id("this"), vr);


        for (Teste teste: testes) {
            String testId = id.toString() + "." + "TODO";
            try {

                new ChamadaTeste(teste).executar(ctx);
                TestRunner.addSuccess(testId);
            } catch (Exception e) {
               TestRunner.addFailure(testId, e);
            }
        }
    }

}
