package test;
// 哈夫曼编码
import edu.princeton.cs.algs4.MinPQ;

public class HuffmanDemo {
    // alphabet size of extended ASCII
    private static final int R = 256;
    String trieStr;

    // Do not instantiate.
    private HuffmanDemo() {
    }

    // Huffman trie node
    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        // is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    /**
     * Reads a sequence of 8-bit bytes from standard input; compresses them
     * using Huffman codes with an 8-bit alphabet; and writes the results
     * to standard output.
     */
    public String[] compress(String s) {
        String[] res = new String[2];
        char[] input = s.toCharArray();

        // tabulate frequency counts
        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++)
            freq[input[i]]++;

        // build Huffman trie
        Node root = buildTrie(freq);

        // build code table
        String[] st = new String[R];
        buildCode(st, root, "");

        // print trie for decoder
        StringBuilder builderTrie = new StringBuilder();
        writeTrie(root, builderTrie);
        this.trieStr = builderTrie.toString();

        // print number of bytes in original uncompressed message
        System.out.println(input.length);

        // use Huffman code to encode input
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            StringBuilder b = new StringBuilder();
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '0') {
//                    BinaryStdOut.write(false);
                    b.append(0);
                } else if (code.charAt(j) == '1') {
//                    BinaryStdOut.write(true);
                    b.append(1);
                } else throw new IllegalStateException("Illegal state");
            }
            System.out.println(input[i] + ": " + b.toString());
            compressed.append(b.toString());
        }
        res[0] = trieStr;
        res[1] = compressed.toString();
        return res;
    }

    // build the Huffman trie given frequencies
    private static Node buildTrie(int[] freq) {

        // initialze priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<Node>();
        for (char i = 0; i < R; i++)
            if (freq[i] > 0)
                pq.insert(new Node(i, freq[i], null, null));

        // special case in case there is only one character with a nonzero frequency
        if (pq.size() == 1) {
            if (freq['\0'] == 0) pq.insert(new Node('\0', 0, null, null));
            else pq.insert(new Node('\1', 0, null, null));
        }

        // merge two smallest trees
        while (pq.size() > 1) {
            Node left = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }


    // write bitstring-encoded trie to standard output
    private void writeTrie(Node x, StringBuilder s) {
        if (x.isLeaf()) {
//            BinaryStdOut.write(true);
            s.append('1');
//            BinaryStdOut.write(x.ch, 8);
            s.append(x.ch);
            return;
        }
//        BinaryStdOut.write(false);
        s.append('0');
        writeTrie(x.left, s);
        writeTrie(x.right, s);
    }

    // make a lookup table from symbols and their encodings
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left, s + '0');
            buildCode(st, x.right, s + '1');
        } else {
            st[x.ch] = s;
        }
    }

    /**
     * Reads a sequence of bits that represents a Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    int triePos = 0;

    public String expand(String trieIn, String compressed) {
        this.triePos = 0;
        StringBuilder expand = new StringBuilder();
        // read in Huffman trie from input stream
        Node root = readTrie(trieIn);

        // number of bytes to write
        int length = compressed.length();

        // decode using the Huffman trie
        int i = 0;
        while (i < length) {
            Node x = root;
            while (!x.isLeaf()) {
                char bit = compressed.charAt(i++);
                if (bit == '1') x = x.right;
                else x = x.left;
            }
            expand.append(x.ch);
        }
        return expand.toString();
    }


    private Node readTrie(String s) {
        if (triePos >= s.length())
            return null;
        boolean isLeaf = s.charAt(triePos) == '1';
        triePos++;
        if (isLeaf) {
            return new Node(s.charAt(triePos++), -1, null, null);
        } else {
            return new Node('\0', -1, readTrie(s), readTrie(s));
        }
    }

    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "-" an {@code expand()} if it is "+".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        HuffmanDemo demo = new HuffmanDemo();
        String txt = "aaaaaaaabbbbccd";
        String[] res = demo.compress(txt);
        String expand = demo.expand(res[0], res[1]);
        System.out.println(txt);
        System.out.println(expand);
    }
}
