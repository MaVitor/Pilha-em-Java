public class PilhaVetor implements Pilha {
    private Object[] a;  // Array para armazenar os elementos da pilha
    private int FC;  // Fator de crescimento (0 = duplicação, >0 = incremento fixo)
    private int topo;  // Índice do topo da pilha

    public PilhaVetor(int capacidadeInicial, int crescimento) {
        a = new Object[capacidadeInicial];  // Inicializa o array com a capacidade inicial
        FC = crescimento;  // Define o fator de crescimento
        topo = -1;  // Inicializa o topo como -1 (pilha vazia)
    }

    @Override
    public int size() {
        return topo + 1;  // Retorna o tamanho atual da pilha
    }

    @Override
    public boolean isEmpty() {
        return topo == -1;  // Verifica se a pilha está vazia
    }

    @Override
    public Object top() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("Pilha está vazia");
        }
        return a[topo];  // Retorna o elemento no topo
    }

    @Override
    public void push(Object o) {
        if (topo + 1 == a.length) {  // Se o array estiver cheio, aumenta a capacidade
            aumentaCapacidade();
        }
        a[++topo] = o;  // Insere o elemento no topo
    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("Pilha está vazia");
        }
        Object elemento = a[topo];  // Remove o elemento do topo
        a[topo--] = null;  // Remove a referência e decrementa o topo
        return elemento;  // Retorna o elemento removido
    }

    // Método que aumenta a capacidade da pilha quando necessário
    private void aumentaCapacidade() {
        int novaCapacidade = (FC > 0) ? a.length + FC : a.length * 2;
        Object[] novoArray = new Object[novaCapacidade];  // Cria um novo array com a nova capacidade
        System.arraycopy(a, 0, novoArray, 0, a.length);  // Copia os elementos para o novo array
        a = novoArray;  // Atualiza o array da pilha
    }

    // Método para esvaziar a pilha, removendo todos os elementos
    public void empty() {
        for (int i = 0; i <= topo; i++) {
            a[i] = null;  // Remove as referências aos objetos armazenados no array
        }
        topo = -1;  // Reseta o índice do topo, indicando que a pilha está vazia
    }
}
