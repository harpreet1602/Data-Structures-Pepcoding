
public class Basic {
    public static int heightOfTree(int[] arr, int idx)
    {
        if(idx >= arr.length)
        {
            return -1;
        }

        int lh = heightOfTree(arr, 2 * idx + 1);
        int rh = heightOfTree(arr, 2 * idx + 2);

        return Math.max(lh,rh) + 1;
    }

    public static void main(String[] args)
    {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
     System.out.println(heightOfTree(arr, 0)); 
    }
}
