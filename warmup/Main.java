package warmup;

public class Main {

    public static void main(String[] args) {
      int lastNum=4000000;
      int a=1;
      int b=2;
      int sum=0;
      while (a<=lastNum){
        if(a%2==0){
          sum+=a;
        }
        int NextVal=a+b;
        a=b;
        b=NextVal;
      }
      System.out.println(sum);

    }
}
