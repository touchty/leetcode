package trie;

class Trie {

    class TrieNode {
        public TrieNode[] nodes = new TrieNode[26];
        public boolean isLeaf = false;
        public TrieNode() {}
    }

    public TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(char ch:word.toCharArray()) {
            if(cur.nodes[ch-'a']==null) cur.nodes[ch-'a'] = new TrieNode();
            cur = cur.nodes[ch-'a'];
        }
        cur.isLeaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(char ch:word.toCharArray()) {
            if(cur.nodes[ch-'a']==null) return false;
            cur = cur.nodes[ch-'a'];
        }
        if(cur.isLeaf) return true;
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char ch:prefix.toCharArray()) {
            if(cur.nodes[ch-'a']==null) return false;
            cur = cur.nodes[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
