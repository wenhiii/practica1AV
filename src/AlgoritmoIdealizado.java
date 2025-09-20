public class AlgoritmoIdealizado {

    /**
     * Selecciona actividades compatibles usando un algoritmo voraz.
     *
     * @param c array con los tiempos de inicio de las actividades
     * @param f array con los tiempos de fin de las actividades
     * @return un array booleano que indica qué actividades han sido seleccionadas
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

        // PRECONDICIÓN: c y f ya están ordenados por f ascendente
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
