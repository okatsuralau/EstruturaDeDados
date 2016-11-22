package ifrn.tads.estruturadedados.graph;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class GrafoSimples implements InterfaceGrafosSimples {
    private final int ADJACENCY_MATRIX_SIZE = 10;
    private int qtdVertices;
    private Vector<Vertice> vertices;
    private Aresta adjacencyMatrix[][];

    public GrafoSimples() {
        this(10);
    }

    public GrafoSimples(int adjacency_matrix_size) {
        qtdVertices = 0;
        vertices = new Vector<Vertice>();
        adjacencyMatrix = new Aresta[adjacency_matrix_size][adjacency_matrix_size];
    }

    public void inserirVertice(List<Double> valores) {
        for (double valor : valores) {
            inserirVertice(valor);
        }
    }

    public Vertice inserirVertice(double valor) {
        int chave = vertices.size() + 1;
        return inserirVertice(new Vertice(chave, valor));
    }

    /**
     * Insere e retorna um novo vértice armazenando o elemento
     *
     * @param vertice
     * @exercicio
     */
    public Vertice inserirVertice(Vertice vertice) {
        vertices.add(vertice);

        return vertice;
    }

    public void removerVertice(Vertice vertice) {
        qtdVertices--;
        int indice = achaIndice(vertice.getChave());
        vertices.remove(indice);  // remove o vertice do vector
        // remove linhas e colunas da matriz de adjacencia
        Aresta tempMatrizAdj[][] = new Aresta[qtdVertices][qtdVertices];
        int ff = 0, gg;
        for (int f = 0; f < qtdVertices + 1; f++) {
            gg = 0;
            for (int g = 0; g < qtdVertices + 1; g++) {
                if (f != indice && g != indice) {
                    tempMatrizAdj[ff][gg] = adjacencyMatrix[f][g];
                    if (g != indice) {
                        gg++;
                    }
                }
            }
            if (f != indice) {
                ff++;
            }
        }
        adjacencyMatrix = tempMatrizAdj;
    }

    void insertAdjacencyMatrix(int indexLine, int indexCollumn, Aresta edge) {
        if (indexCollumn >= ADJACENCY_MATRIX_SIZE || indexLine >= ADJACENCY_MATRIX_SIZE) {
            throw new IndexOutOfBoundsException("The index size cannot be grater or equal to " + ADJACENCY_MATRIX_SIZE);
        }

        adjacencyMatrix[indexLine][indexCollumn] = edge;
    }

    public Aresta insereAresta(Vertice verticeUm, Vertice verticeDois, double valor) {
        Aresta A = new Aresta(verticeUm, verticeDois, valor);

        int ind1 = achaIndice(verticeUm.getChave());
        int ind2 = achaIndice(verticeDois.getChave());

        // grafo nao orientado
        insertAdjacencyMatrix(ind1, ind2, A);
        insertAdjacencyMatrix(ind2, ind1, A);

        return A;
    }

    public Aresta insereAresta(Vertice verticeUm, Vertice verticeDois) {
        return insereAresta(verticeUm, verticeDois, 0);
    }

    public void removeAresta(Aresta Aresta) {
        int ind1 = achaIndice(Aresta.getVerticeOrigem().getChave());
        int ind2 = achaIndice(Aresta.getVerticeDestino().getChave());

        // grafo nao orientado
        adjacencyMatrix[ind1][ind2] = adjacencyMatrix[ind2][ind1] = null;
    }

    public Aresta insereArco(Vertice verticeUm, Vertice verticeDois, double valor) {
        Aresta A = new Aresta(verticeUm, verticeDois, valor, true);

        int ind1 = achaIndice(verticeUm.getChave());
        int ind2 = achaIndice(verticeDois.getChave());

        // grafo orientado
        insertAdjacencyMatrix(ind1, ind2, A);

        return A;
    }

    public Aresta insereArco(Vertice verticeUm, Vertice verticeDois) {
        return insereArco(verticeUm, verticeDois, 0);
    }

    /**
     * OBS.: grafo orientado
     *
     * @param aresta
     * @exercicio
     */
    public void removeArco(Aresta aresta) {   // grafo orientado
        // exercicio, fique a vontade para implementa-lo coleguinha
    }

    public void mostraVertices() {
        for (int f = 0; f < vertices.size(); f++) {
            System.out.print(vertices.elementAt(f) + ",");
        }
    }

    public void mostraMatriz() {
        for (int f = 0; f < qtdVertices; f++) {
            for (int g = 0; g < qtdVertices; g++) {
                System.out.print(adjacencyMatrix[f][g] + " ");
            }

            System.out.println();
        }
    }

    public int grau(Vertice vertice) {
        // exercicio, fique a vontade para implementa-lo coleguinha
        return 0;
    }

    public int ordem() {
        return qtdVertices;
    }

    private int achaIndice(int chave) {
        Iterator I = vertices.iterator();
        int ind = 0;
        while (I.hasNext()) {
            Vertice v = (Vertice) (I.next());
            if (v.getChave() == chave) {
                // achei
                return ind;
            }

            ind++;
        }
        return -1; // nao achei
    }

    public Vector vertices() {
        return vertices;
    }

    public Vector arestas() {
        Vector v = new Vector();
        for (int l = 0; l < qtdVertices; l++) {
            for (int c = 0; c < qtdVertices; c++) {
                v.add(adjacencyMatrix[l][c]);
            }
        }

        return v;
    }

    public Vector arestasIncidentes(Vertice vertice) {
        // exercicio, fique a vontade para implementa-lo coleguinha
        return null;
    }

    public Vector finalVertices(Aresta a) {
        Vector v = new Vector();
        v.add(a.getVerticeOrigem());
        v.add(a.getVerticeDestino());

        return v;
    }

    public Vertice oposto(Vertice v, Aresta a) throws OpostoError {
        // exercicio, fique a vontade para implementa-lo coleguinha
        return null;
    }

    public boolean adjacente(Vertice v, Vertice w) {
        int ind1 = achaIndice(v.getChave());
        int ind2 = achaIndice(w.getChave());

        return (adjacencyMatrix[ind1][ind2]) != null;
    }

    public Aresta getAresta(Vertice v, Vertice w) {
        int ind1 = achaIndice(v.getChave());
        int ind2 = achaIndice(w.getChave());

        return (adjacencyMatrix[ind1][ind2]);
    }
}