import java.util.*;
import java.math.*;
public class RSAlgorithm {
   
    public static void main(String[] args){
        Scanner s =new Scanner(System.in);
        System.out.println("Enter first prime no:");
        int a=s.nextInt();
        System.out.println("Enter second prime no:");
        int b=s.nextInt();
        System.out.println("Enter the msg that need to be encrypted:");
        int m=s.nextInt();

        int n=a*b;
        System.out.println("VAlue of n:"+n);
        int t=(a-1)*(b-1);
        System.out.println("VAlue pof phi(n):"+t);

        int e;
        for(e=2;e<t;e++){
            if(gcd(e,t)==1){
                break;
            }
        }
        System.out.println("value of e:"+e);

        BigInteger eBig = BigInteger.valueOf(e);
        BigInteger zBig = BigInteger.valueOf(t);
        BigInteger dBig = eBig.modInverse(zBig);
        int d = dBig.intValue();
        System.out.println("The value of (d) = " + d);

        BigInteger C = BigInteger.valueOf(m).modPow(BigInteger.valueOf(e), BigInteger.valueOf(n));
        System.out.println("the value of c is: " + C);

        BigInteger msg = C.modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
        System.out.println("Decrypted message is: " + msg);
    }
    static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

}
