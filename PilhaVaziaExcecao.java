public class PilhaVaziaExcecao extends RuntimeException {
    public PilhaVaziaExcecao(String err) {
        super(err);  // Chama o construtor da superclasse com a mensagem de erro.
    }   
}
