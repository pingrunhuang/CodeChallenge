package CodeChallenge;

/*
* this is a function to convert string to binary and binary back to string
* */
public class ToBinary {


    public static String stringToBinary(String str){
        char[] charArray = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<charArray.length;i++){
            stringBuilder.append(Integer.toBinaryString(charArray[i]) + " ");
        }
        return stringBuilder.toString();
    }

    public static String binaryStrToString(String str){
        String[] strings = str.split(" ");
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i=0;i<strings.length;i++){
//            stringBuilder.append(binaryStrToChar(strings[i]));
//        }
//        return stringBuilder.toString();

        char[] tempChar=new char[strings.length];
        for(int i=0;i<strings.length;i++) {
            tempChar[i]=binaryStrToChar(strings[i]);
        }
        return String.valueOf(tempChar);
    }

    public static char binaryStrToChar(String binStr){
        int[] temp=binaryStrToIntArray(binStr);
        int sum=0;
        for(int i=0; i<temp.length;i++){
            sum +=temp[temp.length-1-i]<<i;
        }
        return (char) sum;
    }

    public static int[] binaryStrToIntArray(String binstr){
        char[] charArray = binstr.toCharArray();
        int[] result = new int[charArray.length];
        for (int i=0;i<result.length;i++){
            result[i] = charArray[i] - '0';
        }
        return result;
    }

    public static void main(String[] args){
        String s = "n 55!W !";
        String bin = stringToBinary(s);
        System.out.println(bin);
        System.out.println(binaryStrToString(bin));
    }
}
