public class AlgoritmoIdealizado {

    /**
     * Selects compatible activities using a greedy algorithm.
     *
     * @param c array with the start times of the activities
     * @param f array with the end times of the activities
     * @return a boolean array indicating which activities have been selected
     */
    public static boolean[] selectActivities(int[] c, int[] f) {
        if (c == null || f == null) {
            throw new IllegalArgumentException("The arrays c and f cannot be null.");
        }
        if (c.length != f.length) {
            throw new IllegalArgumentException("The arrays c and f must have the same length.");
        }
        boolean[] s = new boolean[c.length];
        if (c.length == 0)
            return s;

        // PRECONDITION: c and f are already sorted by f ascending
        s[0] = true;
        int i = 0;

        for (int j = 1; j < c.length; j++) {
            if (c[j] >= f[i]) {
                s[j] = true;
                i = j;
            } else {
                s[j] = false;
            }
        }
        return s;
    }
}
