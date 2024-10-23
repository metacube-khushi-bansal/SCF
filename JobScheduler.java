import java.util.Scanner;
import java.util.Arrays;

public class JobScheduler {
    private int[][] processes;
    private int[] completionTime;
    private int[] waitingTime;
    private int[] turnAroundTime;
    private double avgWaitingTime;
    private int maxWaitingTime;

    public JobScheduler(int[][] processes) {
        this.processes = processes;
        this.completionTime = new int[processes.length];
        this.waitingTime = new int[processes.length];
        this.turnAroundTime = new int[processes.length];

    }

    public int[] calcCompletionTime() {
        int length = processes.length;
        completionTime[0] = processes[0][1]; // first process

        for (int i = 1; i < length; i++) {
            if (processes[i][0] <= completionTime[i - 1])
                completionTime[i] = processes[i][1] + completionTime[i - 1];

            else {
                // if next process arival time is more than the last process completion time
                completionTime[i] = processes[i][0] + processes[i][1];
            }
        }
        return completionTime;

    }

    public int[] calcTurnAroundTime() {
        int length = processes.length;
        for (int i = 0; i < length; i++) {
            turnAroundTime[i] = completionTime[i] - processes[i][0]; // completionTime - arrivalTime
        }
        return turnAroundTime;
    }

    public int[] calcWaitingTime() {
        int length = processes.length;
        for (int i = 0; i < length; i++) {
            waitingTime[i] = turnAroundTime[i] - processes[i][1]; // turnAroundTime - BurstTime
        }
        return waitingTime;
    }

    public double calcAvgWaitingTime() {
        int length = processes.length;
        avgWaitingTime = 0;
        for (int i = 0; i < length; i++) {
            avgWaitingTime += waitingTime[i];
        }
        avgWaitingTime = avgWaitingTime / length;
        return avgWaitingTime;
    }

    public int calcMaxWaitingTime() {
        int length = processes.length;
        maxWaitingTime = waitingTime[0];
        for (int i = 1; i < length; i++) {
            maxWaitingTime = Math.max(waitingTime[i], maxWaitingTime);
        }
        return maxWaitingTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int length = scanner.nextInt();
        int[][] processes = new int[length][3];

        for (int i = 0; i < length; i++) {
            processes[i][2] = (i + 1);
            System.out.println("Enter the arrival time for process " + (i + 1) + " : ");
            processes[i][0] = scanner.nextInt();
            System.out.println("Enter the burst time for the process " + (i + 1) + " : ");
            processes[i][1] = scanner.nextInt();
        }

        scanner.close();
        // sample input{ { 0, 10 }, { 6, 20 }, { 60, 10 }, { 110, 5 } };
        // { { 2, 2 }, { 5, 6 }, { 0, 4 }, { 0, 7 }, { 7, 4 } };

        Arrays.sort(processes, (a, b) -> Integer.compare(a[0], b[0]));

        JobScheduler jobScheduler = new JobScheduler(processes);

        jobScheduler.completionTime = jobScheduler.calcCompletionTime();
        for (int i = 0; i < jobScheduler.completionTime.length; i++) {
            System.out.println(
                    "Process: " + (processes[i][2]) + " completed at the time " + jobScheduler.completionTime[i]);
        }

        jobScheduler.turnAroundTime = jobScheduler.calcTurnAroundTime();
        for (int i = 0; i < jobScheduler.turnAroundTime.length; i++) {
            System.out.println("Process " + (processes[i][2]) + " Turn Around Time: " + jobScheduler.turnAroundTime[i]);

        }

        jobScheduler.waitingTime = jobScheduler.calcWaitingTime();
        for (int i = 0; i < jobScheduler.waitingTime.length; i++) {
            System.out.println("Process " + (processes[i][2]) + " Waiting Time: " + jobScheduler.waitingTime[i]);
        }

        double avgWaitingTime = jobScheduler.calcAvgWaitingTime();
        System.out.println("Avg waiting time of processses is : " + avgWaitingTime);

        int maxWaitingTime = jobScheduler.calcMaxWaitingTime();
        System.out.println("Max waiting time of processses is : " + maxWaitingTime);

    }
}
