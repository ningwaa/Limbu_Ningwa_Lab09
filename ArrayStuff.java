import java.util.Random;
import java.util.Scanner;

public class ArrayStuff {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] dataPoints = new int[100];


        Random rand = new Random();
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1;
        }


        System.out.print("Array values: ");
        for (int value : dataPoints) {
            System.out.printf("%d | ", value);
        }
        System.out.println();


        int sum = 0;
        for (int value : dataPoints) {
            sum += value;
        }
        double average = (double) sum / dataPoints.length;
        System.out.println("Sum of array values: " + sum);
        System.out.printf("The average of the random array dataPoints is: %.2f\n", average);


        int userValue = SafeInput.getRangedInt(scanner, "Enter a value between 1 and 100", 1, 100);


        int count = 0;
        for (int value : dataPoints) {
            if (value == userValue) {
                count++;
            }
        }
        System.out.println("The user's value is found " + count + " times in the array.");


        int userValue2 = SafeInput.getRangedInt(scanner, "Enter another value between 1 and 100", 1, 100);
        int position = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue2) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            System.out.println("The value " + userValue2 + " was found at array index " + position);
        } else {
            System.out.println("The value " + userValue2 + " was not found in the array.");
        }


        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);

        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }

    public static double getAverage(int values[]) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }
}