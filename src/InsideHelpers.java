import java.util.Scanner;

public abstract class InsideHelpers {

    private static Scanner input = new Scanner(System.in);

    /**
     * Read a String from keyboard and then convert to an int, so it'll just work
     *  if enter with a number
     * @param min The smallest number (int) that can be gotten
     * @param max The biggest one (int)
     * @return the number (int) was gotten
     */
    public static int get_Int(int min, int max)
    {
        int i;

        do{
            i = Integer.parseInt(input.nextLine());
        } while(i < min || i > max);

        return i;
    }

    /**
     * Read a String from keyboard and then convert to a double, so it'll just work
     *      *  if enter with a number
     * @param min The smallest double that can be gotten
     * @param max The biggest one
     * @return the double was gotten
     */
    public static double get_double(double min, double max)
    {
        double i;

        do{
            i = Double.parseDouble(input.nextLine());
        } while(i < min || i > max);

        return i;
    }

    /**
     * An overload method of get_double. This one just receive the smallest double
     *  you can get, there's no maximum limit
     * @param min The smallest double that can be gotten
     * @return the double gotten
     */
    public static double get_double(double min){
        double i;

        do{
            i = Double.parseDouble(input.nextLine());
        } while(i < min);

        return i;
    }

    /**
     * Read a String from keyboard
     * @return that String
     */
    public static String get_string(){
        String s = input.nextLine();
        return s;
    }

}
