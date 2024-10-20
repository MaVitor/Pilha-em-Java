public interface Pilha {    
    public int size();    // Retorna o tamanho atual da pilha.
    public boolean isEmpty();  // Verifica se a pilha está vazia.
    public Object top() throws PilhaVaziaExcecao;  // Retorna o elemento do topo sem remover.
    public void push(Object o);  // Insere um elemento no topo da pilha.
    public Object pop() throws PilhaVaziaExcecao;  // Remove e retorna o elemento do topo.
}
