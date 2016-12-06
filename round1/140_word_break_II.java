// // time limit exceeded
// public class Solution {
//     public List<String> wordBreak(String s, Set<String> wordDict) {
//         List<String> res = new ArrayList<>();
//         Iterator<String> it = wordDict.iterator();
//         int shortLen = Integer.MAX_VALUE;
//         int longLen = 0;
//         while (it.hasNext()) {
//             String temp = it.next();
//             shortLen = Math.min(shortLen, temp.length());
//             longLen = Math.max(longLen, temp.length());
//         }
//         helper(s, "", 0, wordDict, res, shortLen, longLen);
//         return res;
//     }
    
//     private void helper(String s, String temp, int cur, Set<String> wordDict, List<String> res, int shortLen, int longLen) {
//         if (cur == s.length()) {
//             res.add(temp.substring(0, temp.length() - 1));
//             return;
//         }else if (s.length() - cur < shortLen) {
//             return;
//         }
//         for (int i = shortLen; cur + i <= s.length() && i <= longLen; i++) {
//             String sub = s.substring(cur, cur + i);
//             if (wordDict.contains(sub)) {
//                 helper(s, temp + sub + " ", cur + i, wordDict, res, shortLen, longLen);
//             }    
//         }
//     }
// }

//backtracking with memorization
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || wordDict == null)
            return null;
        HashMap<Integer, List<String>> memo = new HashMap<>();
        return dfs(memo, s, wordDict, 0);
    }
    private List<String> dfs(HashMap<Integer, List<String>> memo, String s, Set<String> dict, int start) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
            return res;
        }
        String sub = s.substring(start);
        for (String sd : dict) {
            if (sub.startsWith(sd)) {
                List<String> nextRes = dfs(memo, s, dict, start + sd.length());
                for (String temps : nextRes) {
                    res.add(sd + (temps.isEmpty() ? "" : " ") + temps);
                }
            }
        }
        memo.put(start, res);
        return res;
    }
}
