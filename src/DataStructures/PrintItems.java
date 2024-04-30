package DataStructures;

public class PrintItems {

    public static void main(String args[]){
        print(10);
    }
    public static void print(int n){
        for(int i=0;i<n;i++){
            if (i != 0) {
                System.out.print(",");
            }
            System.out.print(i);
        }
    }
}
