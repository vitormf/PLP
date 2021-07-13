package loo1.plp.orientadaObjetos1.unitTests;

import loo1.plp.orientadaObjetos1.comando.ChamadaTeste;
import loo1.plp.orientadaObjetos1.comando.Teste;
import loo1.plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ClasseJaDeclaradaException;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ClasseNaoDeclaradaException;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ObjetoJaDeclaradoException;
import loo1.plp.orientadaObjetos1.excecao.declaracao.ObjetoNaoDeclaradoException;
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
            try {
                Teste teste = defTesteSuite.getTeste(nomeTeste);
                new ChamadaTeste(teste).executar(ctx);
                TestRunner.addSuccess(idExecucao);
            } catch (Exception e) {
               TestRunner.addFailure(idExecucao, e);
            }
        }
    }

}
