public class Roman {

    public static int translationvalue(String str) {
        int j = 0;
        for (int i = 0; i < str.length(); i++) {

            int s1 = substitution(str.charAt(i));
            if(s1 == -1) {
                throw new IllegalArgumentException("Incorrect data");
            }
            if (i + 1 < str.length()) {
                int s2 = substitution(str.charAt(i + 1));
                if(s2 == -1) {
                    throw new IllegalArgumentException("Incorrect data");
                }
                if (s1 >= s2) {
                    j = j + s1;
                } else {
                    j = j + s2 - s1;
                    i++;
                }
            } else {
                j = j + s1;
                i++;
            }
        }
        return j;
    }
    public static int substitution(char s) {
        switch (s) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
    public static String toRoman(int num) {
        String a[] = {"", "C"};
        String b[] = {"", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX"};
        String c[] = {"", "I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX"};
        String hund = a[(num%1000)/100];
        String tens = b[(num%100)/10];
        String ones = c[num%10];
        return (hund + tens + ones);
    }
}
