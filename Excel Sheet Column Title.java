public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(Character.valueOf((char)((int)('A') + (n - 1) % 26)));
            n = (n - 1) / 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
