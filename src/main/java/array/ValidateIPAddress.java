package array;

public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if(isValidIPv4(IP)) return "IPv4";
        else if(isValidIPv6(IP)) return "IPv6";
        else return "Neither";
    }

    public boolean isValidIPv4(String ip) {
        if(ip.length()<7) return false;
        if(ip.charAt(0)=='.') return false;
        if(ip.charAt(ip.length()-1)=='.') return false;
        String[] tokens = ip.split("\\.");
        if(tokens.length!=4) return false;
        for(String token:tokens) {
            if(!isValidIPv4Token(token)) return false;
        }
        return true;
    }
    public boolean isValidIPv4Token(String token) {
        if(token.startsWith("0") && token.length()>1) return false;
        try {
            int parsedInt = Integer.parseInt(token);
            if(parsedInt<0 || parsedInt>255) return false;
            if(parsedInt==0 && token.charAt(0)!='0') return false;
        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isValidIPv6(String ip) {
        if(ip.length()<15) return false;
        if(ip.charAt(0)==':') return false;
        if(ip.charAt(ip.length()-1)==':') return false;
        String[] tokens = ip.split(":");
        if(tokens.length!=8) return false;
        for(String token: tokens) {
            if(!isValidIPv6Token(token)) return false;
        }
        return true;
    }
    public boolean isValidIPv6Token(String token) {
        if(token.length()>4 || token.length()==0) return false;
        char[] chars = token.toCharArray();
        for(char c:chars) {
            boolean isDigit = c>=48 && c<=57;
            boolean isUppercaseAF = c>=65 && c<=70;
            boolean isLowerCaseAF = c>=97 && c<=102;
            if(!(isDigit || isUppercaseAF || isLowerCaseAF))
                return false;
        }
        return true;
    }

    //Opt
    class Solution {
        public String validIPAddress(String IP) {
            if (isValidIPv4(IP)) return "IPv4";
            else if (isValidIPv6(IP)) return "IPv6";
            else return "Neither";
        }

        private boolean isValidIPv4(String IP) {
            if (IP.length() < 7) return false;
            if (IP.charAt(0) == '.') return false;
            if (IP.charAt(IP.length() - 1) == '.') return false;
            String[] tokens = IP.split("\\.");
            if (tokens.length != 4) return false;
            for (String token : tokens) if (!isValidIPv4Token(token)) return false;
            return true;
        }

        private boolean isValidIPv6(String IP) {
            if (IP.length() < 15) return false;
            if (IP.charAt(0) == ':') return false;
            if (IP.charAt(IP.length() - 1) == ':') return false;
            String[] tokens = IP.split(":");
            if (tokens.length != 8) return false;
            for (String token : tokens) if (!isValidIPv6Token(token)) return false;
            return true;
        }

        private boolean isValidIPv4Token(String token) {
            if (token.length() == 0 || token.length() > 3) return false;
            if (token.startsWith("0") && token.length() > 1) return false;
            if (!isNumeric(token)) return false;
            int parsedInt = Integer.parseInt(token);
            return parsedInt >= 0 && parsedInt <= 255;
        }

        private boolean isValidIPv6Token(String token) {
            return token.length() != 0 && token.length() <= 4 && isStringHasHexaDecimalChars(token);
        }

        private boolean isNumeric(String str) {
            for (char c : str.toCharArray()) if (!Character.isDigit(c)) return false;
            return true;
        }

        private boolean isStringHasHexaDecimalChars(String str) {
            for (char c : str.toCharArray()) {
                if ((c < 'a' || c > 'f') && (c < 'A' || c > 'F') && !Character.isDigit(c)) return false;
            }
            return true;
        }
    }
}
