package basics;

import java.io.*;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) throws IOException {

        URL url = new URL("http://www.baidu.com");

        /* 字节流 */
        InputStream is = url.openStream();

        /* 字符流 */
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("C:\\tmp\\baidu.html"));
        /* 提供缓存功能 */
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            //System.out.println(line);
            osw.write(line);
        }
        osw.flush();
        osw.close();
        br.close();
    }
}
