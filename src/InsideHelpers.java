import java.util.Scanner;

public abstract class InsideHelpers {

    private static Scanner input = new Scanner(System.in);
    public static int get_Int(int min, int max)
    {
        int i;

        do{
            i = Integer.parseInt(input.nextLine());
        } while(i < min || i > max);

        return i;
    }

    public static double get_double(double min, double max)
    {
        double i;

        do{
            i = Double.parseDouble(input.nextLine());
        } while(i < min || i > max);

        return i;
    }

    public static double get_double(double min){
        double i;

        do{
            i = Double.parseDouble(input.nextLine());
        } while(i < min);

        return i;
    }
    public static String get_string(){
        String s = input.nextLine();
        return s;
    }

}
