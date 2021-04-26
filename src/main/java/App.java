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


public class App {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter number of requests: ");
    int no_requests=scan.nextInt();
    int[] Requests=new int[no_requests];
    System.out.print("\nFill the Request list");
    for(int i=0;i<no_requests;i++){
        int reqeust=scan.nextInt();
        Requests[i]=reqeust;
    }
    System.out.print("Enter initial position of the disk head: ");
    int initialPos=scan.nextInt();
    System.out.print("\n");
    //Start calling all algorithms
        FCFS(initialPos,Requests);
//        SSTF(initialPos,Requests);
//        SCAN(initialPos,Requests);
//        CSCAN(initialPos,Requests);
//        LOOK(initialPos,Requests);
//        CLOOK(initialPos,Requests);
    }
    public static void FCFS(int pos,int[] Requests){
        //move sequentially
        //copy pos and requests into new array to move seq.
        int totalMoves=0;
        String Order="";
        int[] currentRequests=new int[Requests.length+1];
        currentRequests[0]=pos;
        for(int i=1;i<currentRequests.length;i++){
            currentRequests[i]=Requests[i-1];
        }
        //calculate moves
        for(int i=1;i<currentRequests.length;i++){
            totalMoves+= Math.abs(currentRequests[i]-currentRequests[i-1]);
            Order+=(currentRequests[i-1])+" ";
        }
        System.out.println("Total cylinders scanned: "+totalMoves+"\n"+"and the order of execution is: "+Order);
    }

    public static void SSTF(int pos,int[] Requests){}

    public static void SCAN(int pos,int[] Requests){}

    public static void CSCAN(int pos,int[] Requests){}

    public static void LOOK(int pos,int[] Requests){}

    public static void CLOOK(int pos,int[] Requests){}

};
/*
* Test case
8
98 183 37 122 14 124 65 67

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