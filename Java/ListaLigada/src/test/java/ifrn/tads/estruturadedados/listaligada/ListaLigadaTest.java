package ifrn.tads.estruturadedados.listaligada;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ListaLigadaTest extends TestCase {
    private ListaLigada teamCap, teamIron;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ListaLigadaTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ListaLigadaTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        teamCap = new ListaLigada()
            .inserir("Capitão américa")
            .inserir("Gavião Arqueiro")
            .inserir("Falcão")
            .inserir("Feiticeira Escarlate")
            .inserir("Soldado Invernal")
            .inserir("Homem formiga");

        teamIron = new ListaLigada()
            .inserir("Iron Man")
            .inserir("Máquina de combate")
            .inserir("Viúva negra")
            .inserir("Visão")
            .inserir("Pantera Negra")
            .inserir("Spider Man");
    }

    public void testInserirDeveRetornarOrdemInversaDeCriacao() {
        assertTrue(teamCap.toString().equals(
            "[Capitão américa, Gavião Arqueiro, Falcão, Feiticeira Escarlate, Soldado Invernal, Homem formiga]"
        ));
    }

    public void testJuntarDeveConterOConteudoDasDuasListas() {
        assertTrue(teamCap.juntar(teamIron).toString().equals(
            "[Capitão américa, Gavião Arqueiro, Falcão, Feiticeira Escarlate, Soldado Invernal, Homem formiga, " +
            "Iron Man, Máquina de combate, Viúva negra, Visão, Pantera Negra, Spider Man]"
        ));
    }

    public void testDeletarDeveRetornarListaSemElementoRemovido() {
        assertTrue(teamCap.deletar(2).toString().equals(
            "[Capitão américa, Gavião Arqueiro, Feiticeira Escarlate, Soldado Invernal, Homem formiga]"
        ));
    }

    public void testOrdenarDeveRetornarListaEmOrdemCrescente(){
        assertTrue(teamCap.ordenar().toString().equals(
            "[Capitão américa, Falcão, Feiticeira Escarlate, Gavião Arqueiro, Homem formiga, Soldado Invernal]"
        ));
    }

    public void testOrdenar(){
        assertTrue(
            "a".compareTo("b") < 0
        );
    }

    public void testDividirDeveRetornarPrimeiraListaModificadaESegundaListaComConteudoDaDivisao(){
        ListaLigada newTeam = new ListaLigada();

        teamCap.dividir(2, newTeam);

        assertTrue(teamCap.toString().equals(
            "[Capitão américa, Gavião Arqueiro, Falcão]"
        ));

        assertTrue(newTeam.toString().equals(
            "[Feiticeira Escarlate, Soldado Invernal, Homem formiga]"
        ));
    }
}
