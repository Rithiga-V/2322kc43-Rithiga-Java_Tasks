package Task3;

public class Overloading {

   
    public int sum(int a, int b) {
        return a + b;
    }

   
    public double sum(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Overloading example = new Overloading();

        
        int intResult = example.sum(5, 10);
        System.out.println("Sum of integers: " + intResult); 

       
        double doubleResult = example.sum(5.5, 10.5);
        System.out.println("Sum of doubles: " + doubleResult); 
    }
}
