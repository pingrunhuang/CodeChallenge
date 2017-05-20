package CodeChallenge;


import org.junit.Test;

public class Prime {
    private int id = 12;

    private boolean isPrime(int value){
        // if a value can only be divided by itself or 1
        // 1 is not prime

//        /*method 1*/
//        if (value<2)
//            return true;
//        for (int i=2;i<value;i++){
//            if (value%i==0)
//                return false;
//        }
//        return true;

//        /*method 2*/
//        if (value<2){
//            return false;
//        }
//        if (value == 2){
//            return true;
//        }
//        if (value%2==0){
//            return false;
//        }
//        // get rid of the even num
//        for (int i=3;i<value;i += 2){
//            if (value%i==0){
//                return false;
//            }
//        }
//        return true;

       /*method 3*/
        if (value < 2){
            return false;
        }
        if (value == 2){
            return true;
        }
        for (int i = 2; i * i < value;i++){
            if (value%i==0)
                return false;
        }
        return true;

       /*method 4*/
       /*if exist value % d !=0, then value % (d*i) !=0*/

    }

    private int getMaxPrime(int n){
        // get the max prime that is less then the given value
        int maxPrime = 1;

        for (int i=2;i<=n;i++){
            if (isPrime(i)){
                maxPrime = i;
            }
        }
        return maxPrime;
    }

    @Override
    public int hashCode(){
//        除留余数法
        int result = getMaxPrime(this.id);
        result = this.id % result;
        return result;
    }

    @Test
    public void testHashCode() throws Exception {
        Prime prime = new Prime();
        System.out.println(prime.hashCode());
    }
    @Test
    public void testGetMaxPrime(){
        System.out.println(getMaxPrime(this.id));
    }
    @Test
    public void testIsPrime(){
        System.out.println(this.isPrime(this.id));
    }
}
