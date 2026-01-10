package warmup;

public class Main {

    public static void main(String[] args) {
       int sum=0;
       int i=0;
      while(i<0){

        if(i%3==0 || i%5==0){
          sum+=i;
          i++;
        }
      }
      System.out.println(sum);

    }
}
