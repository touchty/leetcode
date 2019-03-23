package string;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        String[] pathSplit = path.split("/");
        for (String element : pathSplit) {
            if (element.length() == 0 || element.equals("."))
                continue;
            if (element.equals("..") && !deque.isEmpty()) {
                deque.pop();
            } else if (!element.equals(".."))
                deque.push(element);
        }

        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append("/" + deque.removeLast());
        }

        if (builder.length() == 0)
            builder.append("/");

        return builder.toString();
    }

    public static void main(String[] args) {
        //String path = "/Hello";
        String path = "/abc/...";
        String res = simplifyPath(path);
        System.out.println(res);


        /*System.out.println("Hello" == "Hello");
        String str1 = "Java";
        String str2 = "Java";
        String str3 = new String("Java");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);*/
    }


}
