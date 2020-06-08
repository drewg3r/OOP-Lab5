public class Punctuation extends SentencePart{
    private String symbols;


    public Punctuation(String symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return symbols;
    }
}
