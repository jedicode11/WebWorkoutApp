package SimpleConditionStatements;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstTime = Integer.parseInt(scanner.nextLine());
        int secondTime = Integer.parseInt(scanner.nextLine());
        int thirdTime = Integer.parseInt(scanner.nextLine());

        int totalTimeSec = firstTime + secondTime + thirdTime;

        int min = totalTimeSec / 60;
        int sec = totalTimeSec % 60;

        if (sec < 10) {
            System.out.printf("%d:%02d", min, sec);
        } else {
            System.out.printf("%d:%02d", min, sec);
        }
    }
}
