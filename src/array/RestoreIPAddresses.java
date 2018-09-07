package array;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIp(s, res, 0, "", 0);
        return res;
    }

    private void restoreIp(String s, List<String> res, int idx, String restoredIp, int count) {
        if (count > 4) return;

        if (count == 4 && idx == s.length()) {
            res.add(restoredIp);
        }

        for (int i = 1; i < 4; i++) {
            if (idx + i > s.length()) break;
            String str = s.substring(idx, idx + i);
            if (str.startsWith("0") && str.length() > 1 || i == 3 && Integer.valueOf(str) >= 256)
                break;
            restoreIp(s, res, idx + i, restoredIp + str + (count == 3 ? "" : "."),
                    count + 1);
        }

    }

    public static void main(String[] args) {
        String s = "25525511135";

        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        List<String> res = restoreIPAddresses.restoreIpAddresses(s);

        for (String ip : res)
            System.out.println(ip);
    }
}