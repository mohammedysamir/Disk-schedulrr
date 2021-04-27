/*
* we need to implement FCFS, SSTF , SCAN, C-Scan, Look, C-Look and the newely optimized algos
*
* input:
*   the input queue
*   the head initial pos
* output:
*   output the sequence of accessing
*   total movements
*
* Example input:
* 98, 183, 37, 122, 14, 124, 65, 67
    Initial head start cylinder: 53
* */

import java.util.*;

import static java.util.Arrays.sort;


public class App {
    static int totalMoves = 0;
    static String Order = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of requests: ");
        int no_requests = scan.nextInt();
        int[] Requests = new int[no_requests+1];

        System.out.print("\nEnter beginning of the range: ");
        int Begin = scan.nextInt();

        System.out.print("\nEnter end of the range: ");
        int End = scan.nextInt();

        System.out.print("\nFill the Request list");
        for (int i = 1; i < no_requests+1; i++) {
            int reqeust = scan.nextInt();
            Requests[i] = reqeust;
        }

        System.out.print("\nEnter initial position of the disk head: ");
        int initialPos = scan.nextInt();
        Requests[0]=initialPos; //save initial pos in the array

        System.out.print("\nEnter Direction: ");
        String Direction = scan.next();
        System.out.print("\n");
        //Start calling all algorithms
          FCFS(initialPos,Requests);
//        SSTF(initialPos,Requests);
//        SCAN(initialPos, Requests, Direction, Begin, End);
//        CSCAN(initialPos,Requests,Direction,Begin,End);
//        LOOK(initialPos,Requests,Direction,Begin,End);
//        CLOOK(initialPos,Requests,Direction,Begin,End);
    }

    public static void FCFS(int pos, int[] Requests) {
        System.out.println("in FCFS algorithm");
        //move sequentially
        //copy pos and requests into new array to move seq.
        totalMoves = 0;
        Order = "";
        int[] currentRequests = Requests.clone();
        //calculate moves
        for (int i = 1; i < currentRequests.length; i++) {
            totalMoves += Math.abs(currentRequests[i] - currentRequests[i - 1]);
            Order += (currentRequests[i-1]) + " ";
        }
        Order+=currentRequests[currentRequests.length-1];
        System.out.println("Total cylinders scanned: " + totalMoves + "\n" + "and the order of execution is: " + Order);
    }

    public static void SSTF(int pos, int[] Requests) {
        System.out.println("in SSTF algorithm");
        //copy pos and requests into new array to move seq.
        totalMoves = 0;
        Order = "";
        int[] currentRequests = Requests.clone();

        //print
        System.out.println("Total cylinders scanned: " + totalMoves + "\n" + "and the order of execution is: " + Order);
    }

    public static void SCAN(int pos, int[] Requests, String Direction, int begin, int end) {
        System.out.println("in SCAN algorithm");
        totalMoves = 0;
        Order = "";
        int[] currentRequests = new int[Requests.length + 1];
        for (int i = 0; i < Requests.length; i++) {
            currentRequests[i] = Requests[i];
        }

        if (Direction.equalsIgnoreCase("Left")) {
            //go begin then last request
            currentRequests[currentRequests.length - 1] = begin;
            //sort
            Arrays.sort(currentRequests);
            //find position to start with
            int index = findPos(pos, currentRequests);
            for (int i = index; i > 0; i--) {
                //calculate first half
                totalMoves += currentRequests[i] - currentRequests[i - 1];
                Order += currentRequests[i] + " ";
            }Order+=currentRequests[0]+" "; //cause begin wasn't printed.
            for (int i = index + 1; i < currentRequests.length-1; i++) {
                //calculate second half
                totalMoves += Math.abs(currentRequests[i] - currentRequests[i + 1]);
                Order += currentRequests[i] + " ";
            }Order+=currentRequests[currentRequests.length-1]+" ";
        }
        else if (Direction.equalsIgnoreCase("Right")) {
            //go to end then to first request
            currentRequests[currentRequests.length - 1] = end;
            //sort
            Arrays.sort(currentRequests);
            //find position to start with
            int index = findPos(pos, currentRequests);
            for (int i = index; i < currentRequests.length; i++) {
                //calculate second half
                totalMoves += Math.abs(currentRequests[i] - currentRequests[i + 1]);
                Order += currentRequests[i] + " ";
            }
            for (int i = index - 1; i > 0; i--) {
                //calculate first half
                totalMoves += currentRequests[i] - currentRequests[i + 1];
                Order += currentRequests[i] + " ";
            }
        }
        else {
            System.out.println("Invalid direction..");
            return;
        }
        System.out.println("Total cylinders scanned: " + totalMoves + "\n" + "and the order of execution is: " + Order);
    }

    public static void CSCAN(int pos, int[] Requests, String Direction, int begin, int end) {
        System.out.println("in C-SCAN algorithm");
        if (Direction.equalsIgnoreCase("Left")) {

        } else if (Direction.equalsIgnoreCase("Right")) {

        } else {
            System.out.println("Invalid direction..");
            return;
        }
    }

    public static void LOOK(int pos, int[] Requests, String Direction, int begin, int end) {
        System.out.println("in LOOK algorithm");
        if (Direction.equalsIgnoreCase("Left")) {

        } else if (Direction.equalsIgnoreCase("Right")) {

        } else {
            System.out.println("Invalid direction..");
            return;
        }
    }

    public static void CLOOK(int pos, int[] Requests, String Direction, int begin, int end) {
        System.out.println("in C-LOOK algorithm");
        if (Direction.equalsIgnoreCase("Left")) {

        } else if (Direction.equalsIgnoreCase("Right")) {

        } else {
            System.out.println("Invalid direction..");
            return;
        }
    }

    public static int findPos(int pos, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == pos) return i;
        }
        return -1;
    }
};
/*
* Test case
8
0
199
98 183 37 122 14 124 65 67
53
--------------------------------------------
* output for FCFS
* 640
* 53 98 183 37 122 14 124 65 67
--------------------------------------------
* output for SSTF
* 236
* 53 67 65 37 14 98 122 124 183
--------------------------------------------
* output for SCAN --Left
*
* 53 37 14 0 65 67 98 122 124 183
--------------------------------------------
* output for C-SCAN --Right
*
* 53 65 67 98 122 124 183 199 0 14 37
--------------------------------------------
* output for LOOK --Left
*
* 53 37 14 65 98 122 124 183
--------------------------------------------
* output for C-LOOK --Right
*
* 53 65 67 98 122 124 183 14 37
* */