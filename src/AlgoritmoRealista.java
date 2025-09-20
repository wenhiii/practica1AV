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
     * @param f array with the end times of the activities
     * @return array of indices sorted according to finish times
     */
    private static int[] sortIndicesByFinishTime(int[] f) {
        int[] orden = new int[f.length];
        orden[0] = 0;

        for (int i = 1; i < f.length; i++) {
            int finActual = f[i];
            int j;
            for (j = i - 1; j >= 0 && f[orden[j]] > finActual; j--) {
                orden[j + 1] = orden[j];
            }
            orden[j + 1] = i;
        }

        return orden;
    }
}
