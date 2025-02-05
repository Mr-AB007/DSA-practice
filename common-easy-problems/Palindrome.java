class Palindrom {
    public static boolean isPalindrome(int x) {
        int num = x;
        if(x<0 || (x != 0 && x % 10 == 0)) //if number is negative or end with 0 means it can not be palindrome
            return false;
        
        int plim = 0;

        while(num > 0){

            plim = plim*10 + num%10;
            num /= 10;
        }
        return plim == x ? true: false;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(x+" is Palindrom : "+ isPalindrome(x));
    }
}