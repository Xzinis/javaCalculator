import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int inf = 0;
        while (inf != 1) {
            Calculate calc = new Calculate();
            Roman rom = new Roman();
            String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            Scanner scanner = new Scanner(System.in);
            String[] blocks = scanner.nextLine().split(" ");
            char operation = blocks[1].charAt(0);
            int one = 0, two = 0;
            boolean a = false, b = false;
            if (blocks.length != 3) {
                throw new IllegalArgumentException("Invalid input parameters");
            }
            try {
                for (int i = 0; i < roman.length; i++) {
                    if (roman[i].equals(blocks[0])) {
                        a = true;
                    }
                    if (roman[i].equals(blocks[2])) {
                        b = true;
                    }
                }
                if (a && b) {
                    one = rom.translationvalue(blocks[0]);
                    two = rom.translationvalue(blocks[2]);
                    if ((one > 10 || one < 1) || (two > 10 || two < 1)) {
                        throw new IllegalArgumentException("Invalid input parameters");
                    }
                    System.out.println(rom.toRoman(calc.count(one, two, operation)));

                    if (calc.count(one, two, operation) == 0) {
                        throw new IllegalArgumentException();
                    }
                } else if (!a && !b) {
                    try {
                        one = Integer.parseInt(blocks[0]);
                        two = Integer.parseInt(blocks[2]);
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Invalid input parameters");
                    }
                    if ((one > 10 || one < 1) || (two > 10 || two < 1)) {
                        throw new IllegalArgumentException("Invalid input parameters");
                    }
                    System.out.println(calc.count(one, two, operation));
                } else {
                    throw new IllegalArgumentException("Invalid input parameters");
                }
            } catch (RuntimeException e) {
                throw new IllegalArgumentException("Invalid input parameters");
            }
        }
    }
}
