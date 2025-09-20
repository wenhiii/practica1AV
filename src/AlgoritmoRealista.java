public class AlgoritmoRealista {

    /**
     * Selects the set of activities that can be performed
     * without time overlap, using a greedy algorithm.
     *
     * @param c array with the start times of the activities
     * @param f array with the end times of the activities
     * @return boolean array where true indicates the activity has been selected
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

        // Order indices by finish time (ascending)
        int[] orden = sortIndicesByFinishTime(f);

        // Select the first activity according to that order
        s[orden[0]] = true;
        int lastSelected = orden[0];

        for (int k = 1; k < c.length; k++) {
            int current = orden[k];
            if (c[current] >= f[lastSelected]) {
                s[current] = true;
                lastSelected = current;
            } else {
                s[current] = false;
            }
        }
        return s;
    }

    /**
     * Sorts the indices of the activities based on their finish time
     * (ascending order).
     *
     * @param v1 array with the end times of the activities
     * @return array of indices sorted according to finish times
     */
    private static int[] sortIndicesByFinishTime(int[] v1) {
        int[] v2 = new int[v1.length];
        v2[0] = 0;

        for (int i = 1; i < v1.length; i++) {
            int aux = v1[i];
            int j;
            for (j = i - 1; j >= 0 && v1[v2[j]] > aux; j--) {
                v2[j + 1] = v2[j];
            }
            v2[j + 1] = i;
        }

        return v2;
    }
}
