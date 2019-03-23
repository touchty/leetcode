package array;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int max = v1.length < v2.length ? v2.length : v1.length;
        for (int i = 0; i < max; i++) {
            int int1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int int2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;
            if (int1 < int2) {
                return -1;
            }
            if (int2 < int1) {
                return 1;
            }
        }

        return 0;
    }
}
