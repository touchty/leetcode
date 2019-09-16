package test;

import java.util.Scanner;

class LCIPIPIP {
    public static String ip(String IP) {
        if (IP == null || IP.length() <= 0) {
            return "Neither";
        }
        if (isIPV4(IP)) {
            return "IPv4";
        }
        if (isIPV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private static boolean isIPV4(String IP) {
        if (IP.charAt(IP.length() - 1) == '.') {
            return false;
        }


        String[] AAA = IP.split("\\.");
        if (AAA.length != 4) {
            return false;
        }
        for (String temp : AAA) {
            if ("".equals(temp) || temp.length() > 3 || (temp.length() > 1 && temp.charAt(0) == '0')) {
                return false;
            }
            for (int i = 0; i < temp.length(); i++) {
                if (!(temp.charAt(i) >= '0' && temp.charAt(i) <= '9')) {
                    return false;
                }
            }
            if (Integer.parseInt(temp) > 255) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIPV6(String IP) {
        if (IP.charAt(IP.length() - 1) == ':') {
            return false;
        }
        String[] AAA = IP.toLowerCase().split("\\:");
        if (AAA.length != 8) {
            return false;
        }
        for (String temp : AAA) {
            if (temp.length() <= 0 || temp.length() > 4) {
                return false;
            }
            for (int i = 0; i < temp.length(); i++) {
                char c = temp.charAt(i);
                if (c < '0' || (c > '9' && c < 'a') || c > 'f') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String ip = in.nextLine();
            System.out.println(ip(ip));
        }
    }
}