import java.io.File;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        File inputFile = new File("Input");
        int[] log = readFile(inputFile);
        int stickCount = countSticks(log);
        System.out.println(stickCount);
    }
    public static int[] readFile(File inputFile) {
        int[] answer = new int[0];
        try {
            Scanner scan = new Scanner(inputFile);
            int[] log = new int[Integer.parseInt(scan.nextLine())];
            for (int i = -1; scan.hasNextLine(); i += 2) { //-1 = green, 1 = black
                String line = scan.nextLine();
                String[] tokens = line.split(" ");
                for (String token : tokens) {
                    log[Integer.parseInt(token)] = i;
                }
            }
            answer = log;
        } catch (Exception e) {
            System.out.println("File not found");
            System.exit(1);
        }
        return answer;
    }
    public static int countSticks(int[] log) {
        int stickCount = 0;
        int start = 0;
        while (start < log.length && log[start] == 0) {
            start++;
        }
        int currentAnt = log[start];
        for (int i = start; i < log.length; i++) {
            if (log[i] != 0 && log[i] != currentAnt) {
                currentAnt = log[i];
                stickCount++;
            }
        }
        return stickCount;
    }
}