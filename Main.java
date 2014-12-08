import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        verseCreator fac = new ConcreteVerseCreator();
        songBuilder build = new ConcreteSongBuilder();
        for (BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.valueOf(12)) < 0; i = i.add(BigInteger.ONE)) {
            Verse v = null;
            try {
                v = fac.getVerse();
            } catch (VerseFactoryException e) {
                e.printStackTrace();
            }

            v.setVerseID(i);
            build.addVerse(v);
        }

        System.out.print(build.getSong().toString());
    }

    public static class Song {
        private final List<Verse>  verses;
        public Song (List<Verse> x) {
            verses = x;
        }
        public String toString () {
            StringBuilder sb = new StringBuilder();
            for (Verse v : verses) {
                sb.append(v.getVerse());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    public static interface songBuilder {
        public void addVerse(Verse v);
        public Song getSong();
    }

    public static class ConcreteSongBuilder implements songBuilder{
        private List<Verse> x = new ArrayList<Verse>();
        public void addVerse(Verse v) {
            x.add(v);
        }

        public Song getSong() {
            return new Song(x);
        }
    }

    public static class Verse {
        private BigInteger verseID;
        void setVerseID(BigInteger verseID){ this.verseID = verseID; }
        public String getVerse() {
            String[] numbers = new String[]{"a", "too", "three", "four", "five", "six", "seven", "eight", "9.000000000000002", "ten", "eleven", "twelve"};
            String[] lyrics = new String[]{"big Oh of n log n", "bad namings", "undefined functions", "random numbers", "thread-safe functions", "unknown errors", "monads binding", "off-by-one errors", "imprecise Floats", "zero divisions", "pipers Piping", "dumb end users"};
            String[] ordinals = new String[]{"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"};

            Random ran = new Random();
            StringBuilder verse = new StringBuilder();

            verse.append("On the ");
            verse.append(ordinals[verseID.intValue()]);
            verse.append(" day of Christmas my compiler gave to me");
            verse.append('\n');
            for (BigInteger j = verseID; j.compareTo(BigInteger.ZERO) >= 0; j = j.subtract(BigInteger.ONE)) {
                if (j.equals(BigInteger.ZERO) && verseID.intValue() != 0) {
                    verse.append("and ");
                }
                if (j.equals(BigInteger.valueOf(3))) {
                    verse.append(numbers[ran.nextInt(12)]);
                    verse.append(" ");
                    verse.append(lyrics[j.intValue()]);
                    verse.append('\n');
                }
                else if (j.equals(BigInteger.valueOf(7))) {
                    verse.append(numbers[j.subtract(BigInteger.ONE).intValue()]);
                    verse.append(" ");
                    verse.append(lyrics[j.intValue()]);
                    verse.append('\n');}
                else {
                    verse.append(numbers[j.intValue()] );
                    verse.append(" ");
                    verse.append(lyrics[j.intValue()]);
                    verse.append('\n');
                }
            }

            return verse.toString();
        }
    }

    public interface verseCreator {
        public Verse getVerse() throws VerseFactoryException;
    }

    public static class ConcreteVerseCreator implements verseCreator {
        public Verse getVerse() throws VerseFactoryException{
            Verse out = new Verse();
            out.setVerseID(BigInteger.ZERO);
            return out;
        }
    }

    public static class VerseFactoryException extends Exception {
        public VerseFactoryException(String message) {
            super(message);
        }
    }
}