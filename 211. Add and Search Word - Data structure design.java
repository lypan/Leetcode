class WordDictionary {
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(!node.containsKey(ch)) {
                System.out.println(ch);
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int charIdx) {
        if(word.length() == charIdx) {
            return node.isEnd();
        }
        char ch = word.charAt(charIdx);
        if(ch != '.') {
            if(!node.containsKey(ch))return false;
            node = node.get(ch);
            return dfs(node, word, charIdx + 1);
        }
        else {
            for(char i = 'a'; i <= 'z'; i ++) {
                if(node.containsKey(i)) {
                    TrieNode childNode = node.get(i);
                    if(dfs(childNode, word, charIdx + 1))return true;
                }
            }
            return false;
        }
    }
}

class TrieNode {
    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }
    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
