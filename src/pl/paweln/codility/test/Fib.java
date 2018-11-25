package pl.paweln.codility.test;

public class Fib {
    static int calcFibonacii(int number){
        int [] t = new int[3];
        t[1] = 1;
        t[2] = 1;
        if (number <=0){
            return 0;
        } else if (number == 1 || number == 2){
            return 1;
        }

        for(int i =1; i < number; i++){
            t[2] = t[0] + t[1];
            t[0] = t[1];
            t[1] = t[2];
        }
        return  t[2];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(calcFibonacii(i));
        }


    }
}
