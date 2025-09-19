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
        int n = c.length;
        boolean[] seleccionadas = new boolean[n];

        // 1. Ordenar las actividades por su tiempo de finalización
        int[] orden = ordenarIndicesPorFinalizacion(f);

        // 2. Seleccionar la primera actividad (la que termina antes)
        seleccionadas[orden[0]] = true;
        int ultimaSeleccionada = orden[0];

        // 3. Recorrer las actividades restantes en el orden correcto
        for (int k = 1; k < n; k++) {
            int actual = orden[k];
            if (c[actual] >= f[ultimaSeleccionada]) {
                seleccionadas[actual] = true;
                ultimaSeleccionada = actual;
            } else {
                seleccionadas[actual] = false;
            }
        }

        return seleccionadas;
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
