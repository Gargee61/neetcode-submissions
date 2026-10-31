class TrieNode {
    public TrieNode[] children;
    public boolean isEndOfWord;

    public TrieNode() {
       children = new TrieNode[26];
    }
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char letter : word.toCharArray()) {
            TrieNode next = curr.children[letter - 'a'];
            if (next == null) next = curr.children[letter - 'a'] = new TrieNode();
            curr = next;
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char letter : word.toCharArray()) {
            TrieNode next = curr.children[letter - 'a'];
            if (next == null) return false;
            curr = next;
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char letter : prefix.toCharArray()) {
            TrieNode next = curr.children[letter - 'a'];
            if (next == null) return false;
            curr = next;
        }
        return true;
    }
}