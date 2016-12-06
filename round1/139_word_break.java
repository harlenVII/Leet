c class Solution {
    // public boolean wordBreak(String s, Set<String> wordDict) {
    //     if (s == null || wordDict == null)
    //         return false;
    //     return helper(s, wordDict);
    // }
    // private boolean helper(String s, Set<String> wordDict) {
    //     if (s.equals(""))
    //         return true;
    //     for (String word : wordDict) {
    //         if (s.startsWith(word)) {
    //             if (helper(s.substring(word.length()), wordDict) == true)
    //                 return true;
    //         }
    //     }
    //     return false;
    // }
    
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || wordDict == null)
            return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
