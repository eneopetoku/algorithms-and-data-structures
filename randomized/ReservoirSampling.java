import java.util.Iterator;
import java.util.Random;

public class ReservoirSampling {

    public static <T> T pickRandom(Iterator<T> stream, Random random) {
        if (!stream.hasNext()) {
            throw new IllegalArgumentException("Stram must not be empty");
        }

        T selected = stream.next();
        long count = 1;

        while (stream.hasNext()) {
            T current = stream.next();
            count++;

            // A random integer from 0 to count -1.
            // Exactly one possible value triggers replacement.
            if (random.nextLong(count) == 0){
                selected = current;
            }
        }
        return selected;
    }

    public static void main(String[] args) {
        var names = java.util.List.of("Eneo", "Ana", "Glauk", "Mira");
        Random random = new Random();

        String result = pickRandom(names.iterator(), random);
        System.out.println("Randomly selected: " + result);

        int n = 1000000000;
        var counts = new java.util.LinkedHashMap<String, Integer>();

        for (String name : names) {
            counts.put(name, 0);
        }

        // Each run starts with a fresh iterator over all names.
        for (int i = 0; i < n; i++) {
            String selected = pickRandom(names.iterator(), random);
            counts.put(selected, counts.get(selected) + 1);
        }

        System.out.println("\nResults after " + n + " runs:");

        for (var entry : counts.entrySet()) {
            int count = entry.getValue();
            double percentage = 100.0 * count / n;

            System.out.printf(
                    "%s: %d selections (%.2f%%)%n",
                    entry.getKey(), count, percentage
            );
        }}}