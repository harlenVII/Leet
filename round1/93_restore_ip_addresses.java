public class Solution {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        restoreHelper(s, new ArrayList<>(), 0);
        return result;
    }
    public void restoreHelper(String s, ArrayList<String> list, int pos){
        if (s.length() == pos && list.size() == 4){
            result.add(list.get(0) + "." + list.get(1) + "." + list.get(2) +
                        "." + list.get(3));
            return;
        }
        if (list.size() > 4 || s.length() == pos - 1){
            return;
        }
        for (int i = 1; i <= 3; i++){
            if (s.length() - pos >= i){
                String subs = s.substring(pos, pos + i);
                if (subs.length() > 1 && subs.startsWith("0")){
                    continue;
                }
                int temp = Integer.parseInt(subs);
                if (temp >= 0 && temp < 256){
                    list.add(String.valueOf(temp));
                    restoreHelper(s, list, pos + i);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
