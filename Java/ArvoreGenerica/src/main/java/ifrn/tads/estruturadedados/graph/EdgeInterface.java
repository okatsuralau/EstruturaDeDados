package ifrn.tads.estruturadedados.graph;

public interface EdgeInterface {
    /**
     * @return Returns the vertex.
     */
    Vertex getVertexTo();

    /**
     * @param vertexTo The vertex to set.
     */
    void setVertexTo(Vertex vertexTo);

    /**
     * @return Returns the vertex.
     */
    Vertex getVertexFrom();

    /**
     * @param vertexFrom The vertex to set.
     */
    void setVertexFrom(Vertex vertexFrom);

    /**
     * @return isDirected
     */
    boolean isDirected();

    /**
     * Makes the edge directed
     */
    void makeDirected();

    /**
     * Makes the edge undirected
     */
    void makeUndirected();

    /**
     * @return the label
     */
    int getDistance();

    /**
     * @param distance the distance to set
     */
    void setDistance(int distance);
}