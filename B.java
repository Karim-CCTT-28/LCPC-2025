public class B {
    


    static int distance(int A , int B , int T){


       int distanceA = A * T;
       int distanceB = B * T;


        return Math.abs(distanceA - distanceB);
    }




    public static void main(String[] args) {
        System.out.println(distance(10,12,5));
    }
}
