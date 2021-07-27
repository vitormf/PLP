package loo1.plp.orientadaObjetos1.unitTests;

import loo1.plp.orientadaObjetos1.comando.ChamadaTeste;
import loo1.plp.orientadaObjetos1.comando.Teste;
import loo1.plp.orientadaObjetos1.declaracao.procedimento.DecTesteSetup;
import loo1.plp.orientadaObjetos1.declaracao.procedimento.DecTesteTearDown;
import loo1.plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import loo1.plp.orientadaObjetos1.excecao.declaracao.*;
import loo1.plp.orientadaObjetos1.excecao.execucao.EntradaInvalidaException;
import loo1.plp.orientadaObjetos1.expressao.leftExpression.Id;
import loo1.plp.orientadaObjetos1.expressao.valor.ValorRef;
import loo1.plp.orientadaObjetos1.memoria.*;

import java.util.Collection;

public class TesteSuiteExecutor {

    private DefTesteSuite defTesteSuite;

    public TesteSuiteExecutor(DefTesteSuite defTesteSuite) {
        this.defTesteSuite = defTesteSuite;
    }

    public void executar(AmbienteExecucaoOO1 ambiente) throws ClasseNaoDeclaradaException, ObjetoNaoDeclaradoException, ObjetoJaDeclaradoException, ClasseJaDeclaradaException {
        DecVariavel decVariavel = defTesteSuite.getDecVariavel();

        Id idTesteSuite = defTesteSuite.getIdClasse();
        AmbienteExecucaoOO1 aux = decVariavel.elabora(new ContextoExecucaoOO1(ambiente));
        ContextoObjeto estadoObj = new ContextoObjeto(aux.getPilha().pop());
        Objeto objeto = new Objeto(idTesteSuite, estadoObj);


        Collection<Id> nomesTestes = defTesteSuite.getNomesTestes();


        ContextoExecucaoOO1 ctx = new ContextoExecucaoOO1(ambiente);
        ValorRef vr = ctx.getProxRef();
        ctx.mapObjeto(vr, objeto);
        ctx.changeValor(new Id("this"), vr);


        for (Id nomeTeste: nomesTestes) {
            String idExecucao = idTesteSuite.toString() + "." + nomeTeste + "()";
            boolean chamouTeardown = false;
            try {
                executar(defTesteSuite.getSetup(), ctx);
                executar(defTesteSuite.getTeste(nomeTeste), ctx);
                chamouTeardown = true;
                executar(defTesteSuite.getTearDown(), ctx);
                TestRunner.addSuccess(idExecucao);
            } catch (Exception e) {
               TestRunner.addFailure(idExecucao, e);
                try {
                    if (!chamouTeardown) {
                        executar(defTesteSuite.getTearDown(), ctx);
                    }
                } catch (Exception e2) {
                    // do nothing
                }
            }
        }
    }

    private void executar(Teste teste, AmbienteExecucaoOO1 ctx)
            throws ProcedimentoNaoDeclaradoException, ClasseNaoDeclaradaException, ProcedimentoJaDeclaradoException,
            ObjetoNaoDeclaradoException, ObjetoJaDeclaradoException, ClasseJaDeclaradaException, EntradaInvalidaException {
        if (teste != null) {
            new ChamadaTeste(teste).executar(ctx);
        }
    }

}
