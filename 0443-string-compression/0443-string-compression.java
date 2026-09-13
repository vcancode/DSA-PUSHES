class Solution {

    public int compress(char[] chars) {
        return compress(chars, 0, 0);
    }

    private int compress(char[] chars, int read, int write) {

        // Base case
        if (read >= chars.length) {
            return write;
        }

        char current = chars[read];

        // Count consecutive characters
        int count = 0;

        while (read + count < chars.length &&
               chars[read + count] == current) {
            count++;
        }

        // Write the character
        chars[write++] = current;

        // Write count only if > 1
        if (count > 1) {

            String number = String.valueOf(count);

            for (int i = 0; i < number.length(); i++) {
                chars[write++] = number.charAt(i);
            }
        }

        // Recursively process the next group
        return compress(chars, read + count, write);
    }
}