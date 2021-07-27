package loo1.plp.orientadaObjetos1;

import loo1.plp.expressions2.memory.VariavelJaDeclaradaException;
import loo1.plp.expressions2.memory.VariavelNaoDeclaradaException;
import loo1.plp.orientadaObjetos1.comando.Comando;
import loo1.plp.orientadaObjetos1.declaracao.classe.DecClasse;
import loo1.plp.orientadaObjetos1.declaracao.classe.DecTesteSuite;
import loo1.plp.orientadaObjetos1.excecao.declaracao.*;
import loo1.plp.orientadaObjetos1.excecao.execucao.EntradaInvalidaException;
import loo1.plp.orientadaObjetos1.excecao.execucao.EntradaNaoFornecidaException;
import loo1.plp.orientadaObjetos1.memoria.AmbienteCompilacaoOO1;
import loo1.plp.orientadaObjetos1.memoria.AmbienteExecucaoOO1;
import loo1.plp.orientadaObjetos1.memoria.DefTesteSuite;
import loo1.plp.orientadaObjetos1.memoria.colecao.ListaValor;
import loo1.plp.orientadaObjetos1.unitTests.TestRunner;
import loo1.plp.orientadaObjetos1.unitTests.TesteSuiteExecutor;

import java.util.Collection;

/**
 * Classe que representa um programa na linguagem OO.
 */
public class Programa {
    /**
     * Declara�ao de classe
     */
    private DecClasse decClasse;
    /**
     * Comando executado ap�s a declara�ao de classes
     */
    private Comando comando;

    private DecTesteSuite decTesteSuite;

    private boolean testar;

    /**
     * Construtor.
     * @param decClasse A declara�ao de classe(s)
     * @param comando O comando executado ap�s a declara�ao.
     */
    public Programa(DecClasse decClasse, Comando comando, DecTesteSuite decTesteSuite, boolean testar){
        this.decClasse = decClasse;
        this.comando = comando;
        this.decTesteSuite = decTesteSuite;
        this.testar = testar;
    }

     /**
     * Executa o programa.
     *
     * @param ambiente o ambiente de execu��o.
     *
     * @return o ambiente depois de modificado pela execu��o
     * do programa.
     *
     * @exception EntradaNaoFornecidaException se n�o for fornecida
     *  a tail de valores de entrada do programa.
     *
     */
    public ListaValor executar(AmbienteExecucaoOO1 ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
               ObjetoNaoDeclaradoException, ObjetoJaDeclaradoException,
               ProcedimentoJaDeclaradoException,ProcedimentoNaoDeclaradoException,
               ClasseJaDeclaradaException, ClasseNaoDeclaradaException,
               EntradaNaoFornecidaException, EntradaInvalidaException {
        if(ambiente == null)
            throw new EntradaNaoFornecidaException();
        
        //nao precisa incrementar no inicio, j� que n�o existe a possibilidade 
        //de declarar vari�veis antes de uma declara��o de classes
        //ambiente.incrementa();
        ambiente = comando.executar(decClasse.elabora(ambiente));

        if (testar) {
            System.out.println("\nIniciando testes");

            ambiente = decTesteSuite.elabora(ambiente);
            Collection<DefTesteSuite> defTesteSuites = ambiente.getDefTesteSuites();
            for (DefTesteSuite suite : defTesteSuites) {
                TesteSuiteExecutor executor = new TesteSuiteExecutor(suite);
                executor.executar(ambiente);
            }
            System.out.println(TestRunner.report());
        }
        //ambiente.restaura();
        return ambiente.getSaida();
    }

    /**
     * Realiza a verificacao de tipos do programa
     *
     * @param ambiente o ambiente de compila��o.
     * @return <code>true</code> se o programa est� bem tipado;
     *          <code>false</code> caso contrario.
     *
     * @exception EntradaNaoFornecidaException se n�o for fornecida
     *  a tail de valores de entrada do programa.
     *
     */
    public boolean checaTipo(AmbienteCompilacaoOO1 ambiente)
        throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
               ProcedimentoNaoDeclaradoException, ProcedimentoJaDeclaradoException,
               ClasseJaDeclaradaException, ClasseNaoDeclaradaException,
               EntradaNaoFornecidaException{
        boolean resposta;
        if(ambiente == null) {
            throw new EntradaNaoFornecidaException();
        }
        //nao precisa incrementar no inicio, j� que n�o existe a possibilidade 
        //de declarar vari�veis antes de uma declara��o de classes
        //ambiente.incrementa();
        resposta = decClasse.checaTipo(ambiente) && comando.checaTipo(ambiente);
        //ambiente.restaura();
        return resposta;
    }
}