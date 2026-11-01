class WordDictionary {

    private class TrieNode{
        Map<Character, TrieNode> map = new HashMap<>();
        boolean word = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            curr.map.putIfAbsent(c, new TrieNode());
            curr = curr.map.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int i){
        if(i == word.length()){
            return node.word;
        }
        if(node == null){
            return false;
        }
        char c = word.charAt(i);
        if(c == '.'){
            for(Map.Entry<Character, TrieNode> e: node.map.entrySet()){
                if(dfs(e.getValue(),word, i+1)){
                    return true;
                }
            }
            return false;
        }else if(node.map.get(c) == null){
            return false;
        }else{
            return dfs(node.map.get(c), word, i+1);
        }
    }
}
