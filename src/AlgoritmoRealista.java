public class AlgoritmoRealista {

    /**
     * Selecciona el conjunto de actividades que pueden realizarse
     * sin solapamiento temporal, utilizando un algoritmo voraz.
     *
     * @param c Array con los tiempos de comienzo de las actividades.
     * @param f Array con los tiempos de finalización de las actividades.
     * @return Array booleano donde true indica que la actividad ha sido seleccionada.
     */
    public static boolean[] seleccionarActividades(int[] c, int[] f) {
        if (c == null || f == null) {
            throw new IllegalArgumentException("Los arrays c y f no pueden ser null.");
        }
        if (c.length != f.length) {
            throw new IllegalArgumentException("Los arrays c y f deben tener la misma longitud.");
        }

        boolean[] s = new boolean[c.length];
        if (c.length == 0)
            return s;

        // Orden de índices por tiempo de finalización (de menor a mayor)
        int[] orden = ordenarIndicesPorFinalizacion(f);

        // Seleccionamos la primera según ese orden
        s[orden[0]] = true;
        int ultimaSeleccionada = orden[0];

        for (int k = 1; k < c.length; k++) {
            int actual = orden[k];
            if (c[actual] >= f[ultimaSeleccionada]) {
                s[actual] = true;
                ultimaSeleccionada = actual;
            } else {
                s[actual] = false;
            }
        }
        return s;
    }

    /**
     * Ordena los índices de las actividades en función de su tiempo de finalización
     * (de menor a mayor).
     *
     * @param f Array con los tiempos de finalización de las actividades.
     * @return Array de índices ordenados según los tiempos de finalización.
     */
    private static int[] ordenarIndicesPorFinalizacion(int[] f) {
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
