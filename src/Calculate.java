public class Calculate {
    public static int count(int one, int two, char sign){
        int result = 0;
        switch (sign){
            case '+': result = one + two;
            break;
            case '-': result = one - two;
            break;
            case '*': result = one * two;
            break;
            case '/': result = one / two;
            break;
            default: throw  new IllegalArgumentException("Invalid input parameters");
        }
        return result;
    }
}
