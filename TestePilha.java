public class TestePilha {
    public static void main(String[] args) {
        // Executa o teste para crescimento fixo (incremento de 10).
        System.out.println("Crescimento fixo:");
        testaCrescimento(10, 1000);       // Teste com 10 elementos
        testaCrescimento(100, 1000);      // Teste com 100 elementos
        testaCrescimento(1000, 1000);     // Teste com 1000 elementos
        testaCrescimento(10000, 1000);    // Teste com 10000 elementos
        testaCrescimento(100000, 1000);   // Teste com 100000 elementos
        testaCrescimento(1000000, 1000);  // Teste com 1000000 elementos
    }
        /*
        // Executa o teste para duplicação.
        System.out.println("\nCrescimento por duplicação:");
        testaCrescimento(10, 0);        // Teste com 10 elementos e duplicação
        testaCrescimento(100, 0);       // Teste com 100 elementos e duplicação
        testaCrescimento(1000, 0);      // Teste com 1000 elementos e duplicação
        testaCrescimento(10000, 0);     // Teste com 10000 elementos e duplicação
        testaCrescimento(100000, 0);    // Teste com 100000 elementos e duplicação
        testaCrescimento(1000000, 0);   // Teste com 1000000 elementos e duplicação
    }
        */
    // Função para testar e medir o tempo de inserção de N elementos.
    public static void testaCrescimento(int nElementos, int crescimento) {
        PilhaVetor pilha = new PilhaVetor(1, crescimento);  // Inicializa a pilha com capacidade inicial 1.
        long inicio = System.currentTimeMillis();  // Marca o tempo inicial.
        
        for (int i = 0; i < nElementos; i++) {
            pilha.push(i);  // Insere os elementos na pilha.
        }
        
        long fim = System.currentTimeMillis();  // Marca o tempo final.
        System.out.println("Tempo para " + nElementos + " elementos: " + (fim - inicio) + " ms");  // Exibe o tempo gasto.
    }
}
