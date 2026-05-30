public class LevenshteinDistance {

    // Compute Levenshtein distance between two strings
    public static int compute(String a, String b) {

        int m = a.length();
        int n = b.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // delete all characters
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // insert all characters
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;

                dp[i][j] = Math.min(
                        Math.min(
                                dp[i - 1][j] + 1,      // deletion
                                dp[i][j - 1] + 1       // insertion
                        ),
                        dp[i - 1][j - 1] + cost     // substitution
                );
            }
        }

        return dp[m][n];
    }

    // Demo / executable example
    public static void main(String[] args) {

        String s1 = "kitten";
        String s2 = "sitting";

        int distance = compute(s1, s2);

        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("Levenshtein Distance: " + distance);

        // Another example
        String a = "dashuri";
        String b = "dashurie";

        System.out.println("\nString 1: " + a);
        System.out.println("String 2: " + b);
        System.out.println("Levenshtein Distance: " + compute(a, b));
    }
}