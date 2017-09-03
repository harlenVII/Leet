class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(res, num, 0, target, 0, 0, "");
        return res;
    }
    private void helper(List<String> res, String num, int pos, int target, long val, long last, String cur) {
        if (pos == num.length()) {
            if (val == target)
                res.add(cur);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long thisVal = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(res, num, i + 1, target, thisVal, thisVal, cur + thisVal);
            } else {
                helper(res, num, i + 1, target, val + thisVal, thisVal, cur + "+" + thisVal);
                helper(res, num, i + 1, target, val - thisVal, -thisVal, cur + "-" + thisVal);
                helper(res, num, i + 1, target, val - last + last * thisVal, last * thisVal,  cur + "*" + thisVal);
            }
        }
    }
}
