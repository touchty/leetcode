package HRQuestion.vmware;

import java.util.Scanner;

public class Q3 {
    static int vm3(int anum, int bnum, int knum) {
        int counttt = 0;
        for (int t = anum; t <= bnum; t++) {
            if (t % knum == 0) {
                if (knum - 1 < 2)
                    counttt++;
                else {
                    boolean tmp = true;
                    for (int z = 2; z <= knum - 1; z++) {
                        if (t % z == 0) {
                            tmp = false;
                            break;
                        }
                    }
                    if (tmp)
                        counttt++;
                }

            }
        }
        return counttt;
    }

    public static void main(String[] args) {
        Scanner sss = new Scanner(System.in);
        while (sss.hasNextInt()) {
            int anum = sss.nextInt();
            int bnum = sss.nextInt();
            int knum = sss.nextInt();
            int results = vm3(anum, bnum, knum);
            System.out.println(results);
        }
    }
}
