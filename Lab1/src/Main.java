public class Main implements IArithmeticsDiff, IArithmeticsMult, IArithmeticsAdd{

    public static void main(String[] args) {
        System.out.println("Grupa1 Operation Paxon96");
        System.out.println("Zandros229");
        System.out.println("Poxx123");
        System.out.println("adamsylla97");
    }

    @Override
    public double Difference(double A, double B) {
        return A - B;
    }

    @Override
    public double Multiplication(double A, double B) {
        return A * B;
    }

    @Override
    public double Addition(double A, double B) {
        return A+B;

    }
}
