package trie;

import java.util.*;

/*
966. Vowel Spellchecker
Medium

53

106

Favorite

Share
Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.

For a given query word, the spell checker handles two categories of spelling mistakes:

Capitalization: If the query matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the case in the wordlist.
Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel individually, it matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the match in the wordlist.
Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)
In addition, the spell checker operates under the following precedence rules:

When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
When the query matches a word up to capitlization, you should return the first such match in the wordlist.
When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
If the query has no matches in the wordlist, you should return the empty string.
Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].



Example 1:

Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]


Note:

1 <= wordlist.length <= 5000
1 <= queries.length <= 5000
1 <= wordlist[i].length <= 7
1 <= queries[i].length <= 7
All strings in wordlist and queries consist only of english letters.
 */


public class VowelSpellchecker {
    class TrieNode {
        TrieNode[] children;
        List<String> val;

        TrieNode() {
            children = new TrieNode[26];
            val = new ArrayList<>(1);
        }
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        // build the trie
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        Set<String> set = new HashSet<>(wordlist.length);
        for (String s : wordlist) {
            set.add(s);
        }
        TrieNode root = new TrieNode();
        for (String w : wordlist) {
            char[] charArr = w.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                charArr[i] = Character.toLowerCase(charArr[i]);
            }
            TrieNode node = root;
            for (char c : charArr) {

                if (Arrays.binarySearch(vowels, c) >= 0) {
                    if (node.children[0] == null) {
                        TrieNode tempNode = new TrieNode();
                        node.children[0] = tempNode;
                    }
                    node = node.children[0];
                } else {
                    if (node.children[c - 'a'] == null) {
                        TrieNode tempNode = new TrieNode();
                        node.children[c - 'a'] = tempNode;
                    }
                    node = node.children[c - 'a'];
                }
            }
            if (node.val.size() == 0)
                node.val.add(w);
        }

        // find

        String[] res = new String[queries.length];
        Arrays.fill(res, "");
        for (int i = 0; i < queries.length; i++) {
            String w = queries[i];
            if (set.contains(w)) {
                res[i] = w;
                continue;
            }
            char[] charArr = w.toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                charArr[j] = Character.toLowerCase(charArr[j]);
            }
            res[i] = find(root, charArr, 0, vowels);
        }
        return res;
    }

    String find(TrieNode root, char[] arr, int i, char[] vowels) {
        if (i == arr.length) {
            if (root != null) {
                return (root.val.size() > 0 ? root.val.get(0) : "");
            }
            return "";
        }
        for (int j = i; j < arr.length; j++) {
            if (root.children[arr[j] - 'a'] != null)
                root = root.children[arr[j] - 'a'];
            else if (Arrays.binarySearch(vowels, arr[j]) >= 0) {
                if (root.children[0] != null)
                    return find(root.children[0], arr, j + 1, vowels);
                else return "";
            } else {
                return "";
            }
        }
        return (root.val.size() > 0 ? root.val.get(0) : "");
    }


    public String[] spellcheckerOpt(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String, String> cap = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();
        for (String w : wordlist) {
            String lower = w.toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            cap.putIfAbsent(lower, w);
            vowel.putIfAbsent(devowel, w);
        }
        for (int i = 0; i < queries.length; ++i) {
            if (words.contains(queries[i])) continue;
            String lower = queries[i].toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
            } else if (vowel.containsKey(devowel)) {
                queries[i] = vowel.get(devowel);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }

    // trie solution
    public static class Solution {
        class Node {
            Node[] next;
            char now;
            boolean flag;//标志这里是否是一个完整的单词
            int index;//标志这个单词在字典里的顺序

            public Node(char now) {
                this.now = now;
                this.next = new Node[52];
            }
        }

        public String[] spellchecker(String[] wordlist, String[] queries) {
            Node root = new Node(' ');
            buildTree(wordlist, root);
            String[] res = new String[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                int match = matchSearch(queries[i], root);
                if (match >= 0) {//精准匹配上了
                    res[i] = wordlist[match];
                    continue;
                }
                char[] chars = queries[i].toCharArray();
                match = likeSearch(chars, root, 0);
                if (match != Integer.MAX_VALUE) {//模糊匹配上了
                    res[i] = wordlist[match];
                    continue;
                }
                match = vowelSearch(chars, root, 0);
                if (match != Integer.MAX_VALUE) {//元音匹配上了
                    res[i] = wordlist[match];
                    continue;
                }
                res[i] = "";//没有匹配上
            }
            return res;
        }

        //构造字典树
        private void buildTree(String[] wordlist, Node root) {
            Node now = root;
            for (int i = 0; i < wordlist.length; ++i) {
                char[] chars = wordlist[i].toCharArray();
                for (int j = 0; j < chars.length; ++j) {
                    int id = 0;
                    if (chars[j] >= 'a') id = 26 + chars[j] - 'a';
                    else id = chars[j] - 'A';
                    Node next = now.next[id];
                    if (next == null) {
                        now.next[id] = new Node(chars[j]);
                        next = now.next[id];
                    }
                    now = next;
                }
                if (!now.flag) {//检查是否已经被初始化
                    now.flag = true;
                    now.index = i;
                }
                now = root;//重新组织下一个单词
            }

        }

        //完全匹配
        private int matchSearch(String word, Node root) {
            Node now = root;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                int id = c >= 'a' ? 26 + c - 'a' : c - 'A';
                Node next = now.next[id];
                if (next == null) return -1;//表示没有匹配上
                now = next;
            }
            return now.flag ? now.index : -1;//如果这个词是单词 就返回下标 否则没有匹配上
        }

        //模糊替换
        private int likeSearch(char[] word, Node root, int index) {
            //如果这个词是单词 就返回下标 否则没有匹配上
            if (index == word.length) return root.flag ? root.index : Integer.MAX_VALUE;
            int may = word[index] >= 'a' ? word[index] - 'a' : word[index] - 'A' + 26; // change to the other case
            int now = word[index] >= 'a' ? word[index] - 'a' + 26 : word[index] - 'A'; // real case
            int res = Integer.MAX_VALUE;
            Node next = root.next[now];
            if (next != null) {//有这个节点
                res = likeSearch(word, next, index + 1);
            }
            next = root.next[may];
            if (next != null) {//有这个节点
                // choose the smaller index
                res = Math.min(res, likeSearch(word, next, index + 1));
            }
            return res;
        }

        //元音替换
        private int vowelSearch(char[] word, Node root, int index) {
            if (index == word.length) return root.flag ? root.index : Integer.MAX_VALUE;//如果这个词是单词 就返回下标 否则没有匹配上
            int res = Integer.MAX_VALUE;
            char[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
            if (Arrays.binarySearch(vowels, word[index]) >= 0) {
                int[] may = new int[]{26, 30, 34, 40, 46, 0, 4, 8, 14, 20};
                for (int i : may) {
                    Node next = root.next[i];
                    if (next != null) res = Math.min(res, vowelSearch(word, next, index + 1));
                }
            } else {//否则不是元音字母 仅触发大小写敏感匹配
                int may = word[index] >= 'a' ? word[index] - 'a' : word[index] - 'A' + 26;
                int now = word[index] >= 'a' ? word[index] - 'a' + 26 : word[index] - 'A';
                Node next = root.next[now];
                if (next != null) {
                    res = vowelSearch(word, next, index + 1);
                }
                next = root.next[may];
                if (next != null) {//有这个节点
                    res = Math.min(res, vowelSearch(word, next, index + 1));
                }
            }
            return res;
        }


    }

    public static void main(String[] args) {
        // String[] wordlist = {"aa", "ae"};
        // String[] query = {"UU"};
        String[] wordlist = {"kkk", "hrt", "fze", "awj", "dfn", "kec", "zss", "dkp", "pdx", "pgm", "ozl", "dhj", "uqm", "eks",
                "opv", "cxo", "okq", "wym", "fjp", "yyo", "awz", "lsp", "quk", "hhe", "sth", "mpo", "mbg", "smj", "cpm", "dno",
                "miq", "fld", "zxa", "fdu", "ige", "lmt", "gyh", "wcu", "wiv", "zad", "tjk", "ync", "voc", "gqw", "fzk", "ehs",
                "kgp", "hde", "kkp", "tko", "uae", "uax", "xhm", "anh", "oph", "lws", "amw", "vyi", "lec", "exq", "dbx", "gee", "cbp", "pfu", "uya", "loi", "zba", "qdo", "cfv", "oxg", "him", "aoj", "uob", "kxs", "odx", "qtu", "xbg", "bqy", "imr", "dzo", "ona", "hat", "jxd", "bae", "ops", "len", "fof", "wlt", "fxa", "ryu", "qay", "asd", "shj", "wbi", "moz", "gsi", "hdc", "abt", "yfd", "ptc", "dyj", "dhg", "qwj", "zme", "enn", "lfc", "pdn", "vcx", "aig", "ywr", "txj", "ngl", "mro", "rqc", "baf", "vbr", "box", "wgv", "ifa", "ogw", "ikg", "aai", "qeg", "bgs", "cmo", "prf", "trt", "rqq", "sep", "uqx", "xvn", "uzw", "fof", "mzz", "qug", "pnq", "kwd", "igf", "yly", "ecb", "bcz", "osc", "onq", "khy", "ubi", "iik", "cee", "ora", "iyt", "soa", "qdo", "cmr", "hty", "jap", "ghn", "gwh", "cqd", "tre", "hix", "ztg", "zhf", "mbx", "esc", "hzo", "tic", "mpi", "gvt", "gmm", "tnp", "qgb", "riv", "yrw", "bvu", "uia", "mnx", "lnh", "wao", "pxz", "haw", "bix", "qmr", "kga", "umh", "lmk", "noi", "mjx", "erj", "yda", "dny", "zsk", "qla", "ndq", "atn", "hkb", "svh", "tvi", "pyw", "foa", "zuo", "ort", "ous", "orx", "vfk", "vus", "fwz", "nfg", "vsd", "opn", "nqm", "hru", "jrt", "ymi", "xty", "dph", "etf", "kiu", "dpa", "paa", "oug", "vca", "ejn", "hrl", "auc", "idt", "vuz", "dxr", "dzc", "crg", "cyw", "eiq", "owp", "qye", "aiy", "rmb", "laf", "fmu", "csn", "ray", "ckd", "rhg", "dvf", "guk", "suw", "nfv", "poe", "qpj", "tlg", "rxv", "iuu", "adj", "sjh", "ocw", "ytn", "ptt", "kdg", "anu", "dsl", "nhb", "ywm", "bok", "nlb", "wcf", "tor", "hlr", "rvw", "xui", "hxc", "knm", "oyb", "dgz", "puu", "ovo", "obi", "neb", "zfo", "ouz", "mcc", "fcd", "xzd", "mtu", "dpg", "zre", "tba", "hsz", "lqv", "tfv", "pbp", "glf", "dhc", "dzw", "zso", "cuf", "jek", "gqd", "wyr", "gip", "wsp", "wus", "emv", "kbc", "ssg", "gvu", "eme", "fwa", "zeo", "ljy", "rkv", "iiw", "ljl", "iwn", "oqo", "kcd", "bhl", "dyo", "mho", "scr", "zfg", "iqr", "zxo", "unq", "omd", "vck", "cux", "ivh", "xrw", "ata", "jgd", "mtu", "zhb", "ahd", "zcl", "zvi", "fgq", "htq", "epe", "vgi", "khc", "mdm", "nwq", "bbx", "iqz", "eys", "irl", "ihz", "zhd", "nsa", "ele", "pst", "xyq", "kox", "qys", "tlv", "uwr", "boi", "fdt", "amb", "lyq", "nej", "xxr", "ixx", "ust", "hwe", "hla", "ykp", "qyf", "sny", "bci", "yid", "gii", "dci", "irn", "mjp", "wvk", "zys", "cxs", "hua", "uji", "oxn", "flj", "uac", "yoz", "qcx", "fsk", "wvp", "vtq", "zsw", "uvw", "zqi", "bgu", "udg", "dnb", "ehz", "dtu", "atp", "cop", "unj", "zse", "vzv", "mjx", "xwr", "mlv", "mlv", "vky", "dkl", "kat", "ufp", "hyi", "vzd", "zok", "bel", "saz", "aba", "jgx", "uvc", "yir", "lid", "zph", "uuh", "gti", "lcl", "oxf", "yib", "xpa", "bwf", "udc", "bom", "nkm", "lkz", "rqw", "ihl", "bwy", "jmf", "pfy", "hbu", "imn", "eyf", "nkz", "gje", "svc", "ovt", "HRQuestion", "ukl", "zxb", "mdr", "kzp", "oxi", "gtv", "raw", "shy", "cau", "vgx", "nrg", "bfg", "qzn", "knc", "srq", "qdx", "lij", "ixc", "ogc", "noj", "jxo", "usr", "ytl", "muv", "uti", "pbe", "dzb", "rvp", "fqt", "hhx", "mhe", "cga", "gtd", "yat", "zac", "lbt", "gke", "tuh", "obz", "vuv", "gmq", "dki", "skv", "qbm", "nbb", "ugv", "hxt", "uxn", "uaq", "qqa", "koe", "fxc", "sgj", "hvx", "nae", "wtp", "njm", "mnb", "rge"};

        String[] query = {"pue", "kZp", "hjs", "HBu", "rsp", "epp", "wsz", "AuC", "gsi", "yfz", "ohi", "huu", "xbu", "Xih", "bfg",
                "gap", "bvu", "okq", "ote", "jlp", "nij", "awz", "Zys", "nvf", "hdr", "ndo", "lkg", "zaq", "iyy", "xjk", "iik",
                "fom", "evp", "pEB", "arx", "jpd", "rqc", "ynt", "rka", "aWJ", "bdq", "qle", "btc", "ybs", "kjj", "dzW", "tka",
                "jnj", "rok", "aqm", "brn", "ztg", "bgU", "jpv", "tre", "two", "gih", "rja", "cyu", "ips", "qks", "uVw", "vog", "sjk", "dxv", "hqi", "ezw", "GWH", "jru", "ivm", "fPy", "iXc", "ckd", "swl", "knm", "EYs", "ibv", "ugn", "emv", "epi", "zia", "qsa", "hvx", "mNB", "wcz", "vcg", "ozl", "oar", "shj", "amd", "ibp", "ntw", "qno", "dfn", "bel", "nnm", "szu", "nqm", "fam", "zal", "osd", "uDc", "jzn", "xyq", "stu", "vum", "ShJ", "wvi", "aiy", "rcf", "gue", "lij", "fmn", "Mpo", "hwa", "khc", "qnn", "pni", "ust", "isr", "dzw", "aqg", "etd", "bhl", "Rpv", "Zeo", "xxr", "ups", "cxs", "ckd", "nAe", "fif", "oRX", "rnt", "llv", "xaf", "ais", "mlw", "obz", "wqq", "LkD", "oib", "FjP", "hoq", "zhf", "Foa", "kwi", "kji", "jpr", "vzv", "ans", "kvp", "uaq", "xxr", "lya", "msz", "zhd", "mdz", "qve", "rmb", "jjm", "srf", "nib", "non", "zPH", "zCl", "paa", "zos", "rej", "ubg", "xeq", "meq", "kbC", "fxa", "nse", "lnh", "khy", "qyz", "shj", "gtk", "MdM", "jdg", "gEe", "aza", "btt", "rQc", "edp", "egq", "tvI", "knb", "yir", "vge", "hau", "lws", "ahn", "dvf", "vfe", "miq", "nrt", "ypj", "mhn", "cwz", "wrc", "vna", "sof", "hyk", "hmw", "HIY", "aia", "mbx", "hqu", "vfd", "vkr", "MzZ", "dNy", "cnn", "paa", "ybj", "sgb", "vvl", "jtr", "ioi", "maz", "uui", "LWs", "kBc", "cuq", "plj", "qos", "wvk", "apn", "rlu", "icX", "cge", "opt", "jez", "eow", "VGx", "mhu", "bjx", "UUh", "fmv", "eqg", "fpa", "ckp", "bka", "Vck", "onQ", "pvo", "fkf", "uQM", "yoz", "vus", "amz", "aub", "zrE", "jfm", "zzm", "hlp", "lfl", "qtu", "lvo", "tsn", "ohp", "stq", "aWz", "zii", "jek", "vtq", "bVu", "ZQI", "rap", "ljy", "grj", "vum", "frp", "wus", "frx", "tkh", "qbM", "qlz", "nEb", "gky", "lsp", "qug", "HRQuestion", "khg", "CmO", "ngl", "IKg", "cfl", "qmR", "bol", "ebc", "yys", "sys", "pnq", "iqr", "vuz", "xxo", "btk", "tez", "pqw", "dzo", "kus", "lan", "xui", "HLA", "qpj", "sth", "FwZ", "ZsS", "vkc", "biw", "tko", "KYP", "tkr", "oli", "qvh", "mev", "lpq", "nsa", "hlk", "bgh", "giu", "gnp", "IKi", "jqe", "rav", "bch", "ztg", "cov", "pst", "fyu", "efm", "zth", "yqc", "nsa", "mro", "eyq", "Hty", "bKo", "MEh", "siu", "wzm", "nlb", "uae", "lba", "ioj", "ovT", "gYH", "pts", "drj", "eco", "cia", "xko", "mpo", "gvx", "qgb", "thd", "qef", "fqd", "gde", "mqg", "uqx", "mbg", "ocw", "pyw", "qol", "sKV", "imr", "gri", "QBG", "dlk", "ids", "eba", "qqi", "xew", "egc", "uqm", "rge", "itv", "baj", "cop", "jor", "bcz", "zkd", "fav", "pee", "qdd", "err", "any", "yzn", "nkc", "bmh", "hey", "lcb", "jgx", "mtz", "ecz", "aai", "bwy", "ckc", "zeu", "uum", "mao", "wvP", "svc", "nhs", "jeb", "upv", "noi", "crm", "bch", "nbj", "geh", "aia", "woq", "kel", "amw", "nhn", "hxv", "lxt", "hyf", "wSP", "iyz", "htw", "fnz", "zsx", "okq", "owp", "cqD", "eof", "hjm", "kOe", "gej", "CAz", "zba", "gyh", "beu", "isd", "gql", "miz", "xwm", "wxr", "foa", "ZtG", "wrb", "foo", "faf", "nsl", "prf", "dqi", "dkI", "hty", "kCd", "dzo", "gja", "rey", "unb", "zsw", "yhf", "xui", "kxs", "mag", "zpx", "fjp", "kob", "tnp", "afu", "zuv", "rbq", "qdr", "rvp", "hrt", "vzv", "MXN", "xcl", "wic", "wqm", "gir", "wfd", "JXo", "zss", "wnf", "opv", "rvk", "HRQuestion", "uvh", "GmQ", "FUm", "gyc", "veu", "pjj", "dnb", "ipp", "pla", "dci", "ldr", "eyi"};
        String correct = "yellow";
        VowelSpellchecker solution = new VowelSpellchecker();
        String[] res = solution.spellcheckerOpt(wordlist, query);
        /*for (String s : res)
            System.out.println(s);*/

        Solution solution1 = new Solution();
        String[] wl = {"AbC", "ABc"};
        String[] qr = {"ABC"};
        String[] res1 = solution1.spellchecker(wl, qr);
        System.out.println(res1[0]);
    }
}
