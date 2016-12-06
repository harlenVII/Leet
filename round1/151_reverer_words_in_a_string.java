public class Solution {
    public String reverseWords(String s) {
        if (s == null)
            return null;
        List<String> list = new LinkedList<String>(Arrays.asList(s.trim().split(" ")));
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).equals("")) {
                list.remove(i);
                i--;
            }
        return String.join(" ", list);
    }
}
