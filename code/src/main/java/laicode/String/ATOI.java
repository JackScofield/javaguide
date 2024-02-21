package laicode.String;

public class ATOI {
    public static int atoi(String str) {
        if (str == null || str.isEmpty()) return 0;

        str = str.trim(); // Step 1: Discard leading and trailing whitespaces.

        if (str.isEmpty()) return 0;

        int sign = 1; // Default sign is positive.
        int index = 0;
        long sum = 0; // Use long to handle overflow and underflow.

        // Step 2: Check for a sign.
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        // Step 3: Convert numbers.
        while (index < str.length()) {
            char c = str.charAt(index);
            if (c < '0' || c > '9') break; // Stop converting when a non-digit is found.

            sum = sum * 10 + (c - '0');
            if (sign == 1 && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE; // Handle overflow.
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) return Integer.MIN_VALUE; // Handle underflow.

            index++;
        }

        return (int) sum * sign;
    }
}
