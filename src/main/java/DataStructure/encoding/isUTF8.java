package DataStructure.encoding;

/**
 * Remember there is an opensource framework cpdetector for complex encoding detection
 */
public class isUTF8 {
    public static void isUTF8(String file_path){
        java.io.File file = new java.io.File(file_path);
        try{
            java.io.InputStream inputStream = new java.io.FileInputStream(file);
            byte[] b = new byte[3];
            inputStream.read(b);
            inputStream.close();
            if (b[0] == -17 && b[1] == -69 && b[2] == -65)
                System.out.println(String.format("{} is encoded with utf-8", file_path));
            else
                System.out.println(String.format("{} might be encoded with GBK"));
        }catch (Exception e){
            System.out.println(e);
        }
    }


}
