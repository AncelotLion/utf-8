import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws IOException {
        copyFileUsingStream("src/fileutf8.txt", "UTF-8", "src/win1251.txt", "WINDOWS-1251");
    }
    private static void copyFileUsingStream(String source, String sourceEnc, String dest, String descEnc) throws IOException {
        Charset sEnc = Charset.forName(sourceEnc);
        Charset dEnc = Charset.forName(descEnc);
        Reader fis = new InputStreamReader(new FileInputStream(source), sEnc);
        Writer fos = new OutputStreamWriter(new FileOutputStream(dest), dEnc);
        char[] buffer = new char[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        fis.close();
        fos.close();
    }
}