public class PilhaVetor implements Pilha {
    private Object[] a;  // Array para armazenar os elementos da pilha.
    private int FC;  // Fator de crescimento, pode ser fixo ou duplicação.
    private int topo;  // Índice do topo da pilha.

    public PilhaVetor(int capacidade, int crescimento) {
        a = new Object[capacidade];  // Inicializa o array com a capacidade inicial.
        FC = crescimento;  // Define o fator de crescimento.
        topo = -1;  // Pilha começa vazia, portanto, o topo está em -1.
    }

    @Override
    public int size() {
        return topo + 1;  // Tamanho da pilha é topo + 1.
    }

    @Override
    public boolean isEmpty() {
        return topo == -1;  // Verifica se o topo está em -1 (ou seja, vazio).
    }

    @Override
    public Object top() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("Pilha vazia");  // Lança exceção se a pilha estiver vazia.
        }
        return a[topo];  // Retorna o elemento do topo.
    }

    @Override
    public void push(Object o) {
        if (topo + 1 == a.length) {  // Se o array está cheio, é necessário aumentar a capacidade.
            aumentaCapacidade();  // Aumenta a capacidade.
        }
        a[++topo] = o;  // Insere o elemento e incrementa o topo.
    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("Pilha vazia");
        }
        Object temp = a[topo];  // Armazena o valor a ser removido.
        a[topo--] = null;  // Remove o elemento do topo e decrementa o topo.
        return temp;  // Retorna o valor removido.
    }

    // Método para aumentar a capacidade da pilha com base no fator de crescimento.
    private void aumentaCapacidade() {
        int novaCapacidade;
        if (FC == 0) {
            // Duplicação: nova capacidade é o dobro da atual.
            novaCapacidade = a.length * 2;
        } else {
            // Crescimento fixo: nova capacidade é aumentada por um valor constante.
            novaCapacidade = a.length + FC;
        }
        Object[] novoArray = new Object[novaCapacidade];  // Cria novo array com a nova capacidade.
        System.arraycopy(a, 0, novoArray, 0, a.length);  // Copia os elementos do array antigo.
        a = novoArray;  // Atualiza a referência do array.
    }
}
