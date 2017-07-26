public class ZigzagIterator {
    Iterator<Integer> i;
    Iterator<Integer> j;
    boolean first;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        first = true;
        i = v1.iterator();
        j = v2.iterator();
    }

    public int next() {
        if (!i.hasNext())
            return j.next();
        if (!j.hasNext())
            return i.next();
        if (first) {
            first = false;
            return i.next();
        } else {
            first = true;
            return j.next();
        }
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
