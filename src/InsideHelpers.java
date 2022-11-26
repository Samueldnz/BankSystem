import java.util.Scanner;

public abstract class InsideHelpers {

    private static Scanner input = new Scanner(System.in);
    public static int get_Int(int min, int max)
    {
        int i = 0;

        while(i < min || i > max){
            i = Integer.parseInt(input.nextLine());
        }

        return i;
    }

    public static double get_double(double min, double max)
    {
        double i = 0;

        while(i < min || i > max)
        {
            i = Double.parseDouble(input.nextLine());
        }
        return i;
    }

    public static double get_double(double min){
        double i = 0;

        while(i < min)
        {
            i = Double.parseDouble(input.nextLine());
        }
        return i;
    }
    public static String get_string(){
        String s = input.nextLine();
        return s;
    }

}
