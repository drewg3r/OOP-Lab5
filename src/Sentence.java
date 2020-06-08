public class Sentence {
    private final String punctuationSymbols = ",.!?;";
    private SentencePart[] sentenceParts;

    public Sentence(SentencePart[] sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    public Sentence(String sentenceString) {
        String[] sentenceElementsStrings = sentenceString.split("(?=[" + punctuationSymbols + "])|\\s");
        sentenceParts = new SentencePart[sentenceElementsStrings.length];
        String sentenceElementString;
        for (int i = 0; i < sentenceElementsStrings.length; i++) {
            sentenceElementString = sentenceElementsStrings[i];
            if (punctuationSymbols.contains(sentenceElementString)){
                sentenceParts[i] = new Punctuation((sentenceElementString));
            } else {
                char[] lettersChars = sentenceElementString.toCharArray();
                Letter[] letters = new Letter[lettersChars.length];
                for (int j = 0; j < lettersChars.length; j++) {
                    letters[j] = new Letter(lettersChars[j]);
                }
                sentenceParts[i] = new Word(letters);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sentenceString = new StringBuilder();
        String astr = "";
        for (int i = 0; i < sentenceParts.length; i++) {
            astr = "";
            if (i != 0 && sentenceParts[i] instanceof Word){
                astr = " ";
            }
            sentenceString.append(astr).append(sentenceParts[i].toString());
        }
        return sentenceString.toString();
    }

    public void replaceWords(int length, String s){
        for (SentencePart sentencePart : this.sentenceParts){
            if (sentencePart instanceof Word){
                ((Word) sentencePart).replaceWord(length, s);
            }
        }
    }
}
