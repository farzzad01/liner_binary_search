import java.util.Scanner;

public class Main {
    public static int linearSearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int[] sortNumbers(int[] numbers) {
        int[] sortedNumbers = numbers.clone();
        for (int i = 0; i < sortedNumbers.length - 1; i++) {
            for (int j = 0; j < sortedNumbers.length - i - 1; j++) {
                if (sortedNumbers[j] > sortedNumbers[j + 1]) {
                    int temp = sortedNumbers[j];
                    sortedNumbers[j] = sortedNumbers[j + 1];
                    sortedNumbers[j + 1] = temp;
                }
            }
        }
        return sortedNumbers;
    }

    public static void displayNumbers(int[] numbers) {
        System.out.print("Sorted numbers --> ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many numbers do you want to enter? ");
        int numInputs = scanner.nextInt();

        while (true) {
            int[] numbers = new int[numInputs];
            for (int i = 0; i < numInputs; i++) {
                System.out.print("Enter a number: ");
                numbers[i] = scanner.nextInt();
            }

            int[] sortedNumbers = sortNumbers(numbers);
            displayNumbers(sortedNumbers);

            System.out.println("Choose search method:");
            System.out.println("1. Linear search");
            System.out.println("2. Binary search");
            System.out.print("Enter your choice: ");
            String searchChoice = scanner.next();

            if (searchChoice.equals("1")) {
                while (true) {
                    System.out.print("Enter a number to perform a linear search: ");
                    if (scanner.hasNextInt()) {
                        int target = scanner.nextInt();
                        int index = linearSearch(numbers, target);
                        if (index != -1) {
                            System.out.println("(linear search) Number found at index: " + index);
                        } else {
                            System.out.println("Number not found.");
                        }
                        break;
                    } else {
                        break;
                    }
                }
            } else if (searchChoice.equals("2")) {
                while (true) {
                    System.out.print("Enter a number to perform a binary search: ");
                    if (scanner.hasNextInt()) {
                        int target = scanner.nextInt();
                        int index = binarySearch(sortedNumbers, target);
                        if (index != -1) {
                            System.out.println("(binary search) Number found at index: " + index);
                        } else {
                            System.out.println("Number not found.");
                        }
                        break;
                    } else {
                        break;
                    }
                }
            }

            System.out.print("Do you want to continue? (y/n): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }

            System.out.print("How many numbers do you want to enter? ");
            numInputs = scanner.nextInt();
        }
    }
}
