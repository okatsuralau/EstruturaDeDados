package ifrn.tads.estruturadedados.listaligada;

class ListaLigadaCircular {
    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;

    ListaLigadaCircular() {
        totalDeElementos = 0;
        primeira = null;
        ultima = null;
    }

    public int size() {
        return totalDeElementos;
    }

    public void setTotalDeElementos(int totalDeElementos) {
        this.totalDeElementos = totalDeElementos;
    }

    public ListaLigadaCircular setPrimeira(Celula primeira) {
        this.primeira = primeira;

        return this;
    }

    public ListaLigadaCircular setUltima(Celula ultima) {
        this.ultima = ultima;

        return this;
    }

    public Celula getPrimeira() {
        return primeira;
    }

    public Celula getUltima() {
        return ultima;
    }

    public int getTotalDeElementos() {
        return totalDeElementos;
    }

    /**
     * Insere um novo elemento no topo da lista
     *
     * @param elemento Objeto a ser inserido na lista
     * @return instância da própria lista
     */
    public ListaLigadaCircular inserir(Object elemento) {
        Celula nova = new Celula(elemento);
        nova.setProxima(primeira);

        if (this.totalDeElementos == 0) {
            primeira = nova;
            ultima = nova;
        } else {
            this.ultima.setProxima(nova);
            this.ultima = nova;
        }
        this.totalDeElementos++;

        return this;
    }


    /**
     * Insere um elemento em uma dada posição
     *
     * @param elemento Objeto a ser inserido na lista
     * @param posicao  posição para inserir o elemento
     * @return instância da própria lista
     */
    public ListaLigadaCircular inserir(Object elemento, int posicao) {
        return this;
    }

    /**
     * Remove um elemento da lista
     *
     * @param posicao posição do elemento à ser removido da lista
     * @return instância da própria lista
     */
    public ListaLigadaCircular deletar(int posicao) {
        Celula atual = primeira;

        // Percorrendo até o penúltimo elemento.
        for (int i = 0; i <= this.totalDeElementos; i++) {
            if (i + 1 == posicao) {
                atual.setProxima(atual.getProxima().getProxima());
                this.totalDeElementos--;
                return this;
            }

            atual = atual.getProxima();
        }

        return this;
    }

    /**
     * Junta duas listas em uma só
     *
     * @param lista Lista a ser unida
     * @return instância da própria lista
     */
    public ListaLigadaCircular juntar(ListaLigadaCircular lista) {
        this.ultima.setProxima(lista.primeira);
        this.ultima = lista.ultima;
        lista.primeira = this.primeira;
        this.totalDeElementos += lista.size();
        lista.totalDeElementos = this.totalDeElementos;

        return this;
    }

    /**
     * Divide uma lista em duas
     *
     * @param posicao posição da lista à separar
     * @return instância da própria lista
     */
    public ListaLigadaCircular dividir(int posicao, ListaLigadaCircular novaLista) {
        Celula atual = primeira;

        // Percorrendo até o penúltimo elemento.
        for (int i = 0; i <= this.totalDeElementos; i++) {
            if (i == posicao) {
                novaLista.setPrimeira(atual.getProxima());
                novaLista.setTotalDeElementos(totalDeElementos - (i + 1));

                atual.setProxima(null);
                this.ultima = atual;
                this.totalDeElementos = i + 1;

                return this;
            }

            atual = atual.getProxima();
        }

        return this;
    }

    /**
     * Ordena uma lista com base no conteúdo
     *
     * @return instância da própria lista
     */
    public ListaLigadaCircular ordenar() {
        return this;
    }

    /**
     * @return elementos da lista
     */
    public String toString() {
        // Verificando se a Lista está vazia
        if (this.totalDeElementos == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        Celula atual = primeira;

        // Percorrendo até o penúltimo elemento.
        for (int i = 0; i < this.totalDeElementos - 1; i++) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }

        // último elemento
        builder.append(atual.getElemento());
        builder.append("]");

        return builder.toString();
    }
}
