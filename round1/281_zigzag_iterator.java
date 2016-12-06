public class ZigzagIterator {
    private List<Integer> v;
    private int index;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        v = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < v1.size() && j < v2.size()) {
            v.add(v1.get(i++));
            v.add(v2.get(j++));
        }
        while (i < v1.size()) {
            v.add(v1.get(i++));
        }
        while (j < v2.size()) {
            v.add(v2.get(j++));
        }
        index = 0;
        System.out.println(v.size());
    }

    public int next() {
        return v.get(index++);
    }

    public boolean hasNext() {
        return index < v.size();
    }
}
