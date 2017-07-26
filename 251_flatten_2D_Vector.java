public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> i;
    Iterator<Integer> j;
    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
        if (i.hasNext())
            j = i.next().iterator();
    }

    @Override
    public Integer next() {
        hasNext();
        return j.next();
    }

    @Override
    public boolean hasNext() {
        if (j == null)
            return false;
        while (!j.hasNext() && i.hasNext())
            j = i.next().iterator();
        return j.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
