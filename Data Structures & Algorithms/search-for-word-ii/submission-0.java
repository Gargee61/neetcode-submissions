class Solution {
    private PrefixTree trie = new PrefixTree();
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        for (String word : words) {
            trie.insert(word);
        }

        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                explore(board, i, j, trie.root);
            }
        }

        return result;
    }

    private void explore(char[][] board, int i, int j, Node curr) {

        if (curr == null || i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == '#') {
            return;
        }

        char tmp = board[i][j];
        Node nextNode = curr.children[tmp - 'a'];
        if (nextNode == null) {
            return;
        }

        if(nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; // if another path leads to the same word, do not count it
            // do not return here as there many be more words down the tree
        }

        board[i][j] = '#';
        
        explore(board, i-1, j, nextNode);
        explore(board, i, j+1, nextNode);
        explore(board, i+1, j, nextNode);
        explore(board, i, j-1, nextNode);
        
        board[i][j] = tmp;
    }
}

class PrefixTree {
    public Node root = null;

    public PrefixTree() {
        root = new Node('\0');
    }

    public void insert(String word) {
        Node curr = root;
        for (int i=0; i < word.length(); i++){
            char ch = word.charAt(i);

            if (curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new Node(ch);
            }

            curr = curr.children[ch-'a'];
        }

        curr.word = word;
    }

}

class Node {
    char ch;
    Node[] children = new Node[26];
    String word;

    public Node(char ch) {
        this.ch = ch;
    }
}

