import java.util.Arrays;

public class Word extends SentencePart {
    private Letter[] letters;

    public Word(Letter[] letters) {
        this.letters = letters;
    }

    @Override
    public String toString() {
        StringBuilder wordString = new StringBuilder();
        for (Letter letter : letters) {
            wordString.append(letter.toString());
        }
        return wordString.toString();
    }

    public void replaceWord(int length, String s){
        if (this.toString().length() == length){
            char[] lettersChars = s.toCharArray();
            Letter[] letters = new Letter[lettersChars.length];
            for (int j = 0; j < lettersChars.length; j++) {
                letters[j] = new Letter(lettersChars[j]);
            }
            this.letters = letters;
        }
    }
}