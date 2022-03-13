import java.util.Scanner;
public class subset {
    public static void printSubsets(String set[],int rank)
    {
        int n = set.length;
        int count=1;
        if(rank==1){
            System.out.println("");
        }
        else{
        for (int i = 0; i < (1<<n); i++)
        {
            // System.out.print("{ "); 
            count++;
            for (int j = 0; j < n; j++)
            {
                if ((i & (1 << j)) > 0){
                    if(count==rank)
                    System.out.print(set[j] + " ");
                }
            }
            // System.out.println("}");
        }
        }
    }

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args)
    {
        int n = scn.nextInt();
        
        int rank = scn.nextInt();

        String[] set = new String[n];

        for(int i=0;i<set.length;i++){
            set[i] = scn.next();
        }

        printSubsets(set, rank);

    }
      
}
