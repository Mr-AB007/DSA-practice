//Roman to Integer (leet code)
import java.util.Map;
class RomanToInt {
    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = Map.of(
            'M', 1000, 'D', 500, 'C', 100, 'L', 50,
            'X', 10, 'V', 5, 'I', 1
        );

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = romanMap.get(s.charAt(i));  //checking from end
            if (value < prevValue) {   //current value from end is less than last value then subtract
                total -= value;
            } else {
                total += value;
            }
            prevValue = value;
        }

        return total;
    }

    public static void main(String[] args) {
        String s = "IXX"; //19
        System.out.println(romanToInt(s));
    }
}
