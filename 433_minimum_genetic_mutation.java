public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || bank == null || bank.length == 0)
            return -1;
        Set<Character> gene = new HashSet<>();
        gene.add('A');
        gene.add('C');
        gene.add('G');
        gene.add('T');
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Set<String> geneBank = new HashSet<String>(Arrays.asList(bank));
        set.add(start);
        int len = 1;
        while (!set.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String str : set) {
                char[] s = str.toCharArray();
                for (int i = 0; i < s.length; i++) {
                    for (char ch : gene) {
                        if (s[i] == ch)
                            continue;
                        char old = s[i];
                        s[i] = ch;
                        String newS = String.valueOf(s);
                        if (geneBank.contains(newS) && !visited.contains(newS)) {
                            if (newS.equals(end))
                                return len;
                            temp.add(newS);
                            visited.add(newS);
                        }
                        s[i] = old;
                    }
                }
            }
            len++;
            set = temp;
        }
        return -1;
    }
}
