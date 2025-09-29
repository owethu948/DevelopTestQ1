import java.util.Scanner;

public class BatsmenRuns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of batsmen and stadiums
        System.out.print("Enter number of batsmen: ");
        int numBatsmen = scanner.nextInt();
        System.out.print("Enter number of stadiums: ");
        int numStadiums = scanner.nextInt();

        // Initialize arrays
        String[] batsmen = new String[numBatsmen];
        String[] stadiums = new String[numStadiums];
        int[][] runsScored = new int[numBatsmen][numStadiums];

        // Input batsmen names
        System.out.println("Enter batsmen names:");
        for (int i = 0; i < numBatsmen; i++) {
            System.out.print("Batsman " + (i + 1) + ": ");
            batsmen[i] = scanner.next();
        }

        // Input stadium names
        System.out.println("Enter stadium names:");
        for (int i = 0; i < numStadiums; i++) {
            System.out.print("Stadium " + (i + 1) + ": ");
            stadiums[i] = scanner.next();
        }

        // Input runs scored
        System.out.println("Enter runs scored:");
        for (int i = 0; i < numBatsmen; i++) {
            for (int j = 0; j < numStadiums; j++) {
                System.out.print(batsmen[i] + " at " + stadiums[j] + ": ");
                runsScored[i][j] = scanner.nextInt();
            }
        }

        // Calculate total runs scored by each batsman
        int[] totalRuns = new int[numBatsmen];
        for (int i = 0; i < numBatsmen; i++) {
            for (int j = 0; j < numStadiums; j++) {
                totalRuns[i] += runsScored[i][j];
            }
        }

        // Determine the batsman with the highest total runs
        int maxRuns = totalRuns[0];
        String topBatsman = batsmen[0];
        for (int i = 1; i < numBatsmen; i++) {
            if (totalRuns[i] > maxRuns) {
                maxRuns = totalRuns[i];
                topBatsman = batsmen[i];
            }
        }

        // Determine the stadium with the most runs
        int[] stadiumTotalRuns = new int[numStadiums];
        for (int j = 0; j < numStadiums; j++) {
            for (int i = 0; i < numBatsmen; i++) {
                stadiumTotalRuns[j] += runsScored[i][j];
            }
        }
        int maxStadiumRuns = stadiumTotalRuns[0];
        String topStadium = stadiums[0];
        for (int j = 1; j < numStadiums; j++) {
            if (stadiumTotalRuns[j] > maxStadiumRuns) {
                maxStadiumRuns = stadiumTotalRuns[j];
                topStadium = stadiums[j];
            }
        }

        // Display total runs scored by each batsman
        System.out.println("Total Runs Scored by Batsmen:");
        for (int i = 0; i < numBatsmen; i++) {
            System.out.println(batsmen[i] + ": " + totalRuns[i]);
        }

        // Display the batsman with the highest total runs
        System.out.println("\nThe batsman with the highest total runs is " + topBatsman + " with " + maxRuns + " runs.");

        // Display the stadium with the most runs
        System.out.println("The stadium with the most runs is " + topStadium + " with " + maxStadiumRuns + " runs.");

        scanner.close();
    }
}