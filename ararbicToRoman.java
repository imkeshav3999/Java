public class ararbicToRoman {
    public static void toRoman(int num) {
        System.out.println(num);
        int value[] = { 10, 9, 5, 4, 1 };
        String roman[] = { "X", "IX", "V", "IV", "I" };
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                num = num - value[i];
                r.append(roman[i]);
            }
        }
        System.out.println(r);
    }

    public static void main(String[] args) {
        toRoman(9);
    }
}