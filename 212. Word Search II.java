class Solution {
    class trie{
        trie [] next = new trie[26];
        String w;
    }

    trie buildtrie(String [] words){
         trie root = new trie();
         for(String s : words){
            trie p = root;
            for(char c :s.toCharArray()){
                int i =c-'a';
                if(p.next[i] == null) p.next[i] = new trie();
                p= p.next[i];
            }
            p.w= s;
         }
         return root;
    }
    void dfs(char [][] board, int i, int j ,trie t, List<String>ans){

        char c = board[i][j];
        if(c=='#' || t.next[c-'a']==null) return ;

         t = t.next[c-'a'];
         if(t.w != null){
             ans.add(t.w);
             t.w = null;
         }

         board[i][j] = '#';
         if(i>0) dfs(board,i-1,j ,t, ans);
         if(j>0) dfs(board, i , j-1,t, ans);
         if(i<board.length-1) dfs(board, i+1,j ,t , ans);
         if(j<board[0].length -1) dfs(board,i,j+1, t,ans);
         board[i][j] = c;
     
    }

    

    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> ans = new ArrayList<>();

        trie t = buildtrie(words);

        for(int i=0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                dfs(board,i, j , t ,ans);
            }

        }
        return ans;
    }
}