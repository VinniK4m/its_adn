package co.vinni.itsadn.itsadn.logica;
/**
 *
 * @author Vinni - vinni_@yahoo.com
 */
public class VerificadorAdn {
    /**
     * Funcion que verifica si el Adn corresponde a un Mutante o Humano
     * @param dna String[]
     * @return int valores 1 = Mutante 2 Humano 3 Error
     */
    public Boolean isMutant(String[] dna){
        if (dna == null){
            return null;
        }
        String[][] matriz = construirMatriz(dna);
        if (matriz == null)
        {
            return null;
        }
        if(  validarExcluyente(matriz)){
            return true;
        }else{
            return false;
        }
    }

    private String[][] construirMatriz(String[] dna) {
        String matriz[][] = new String[dna.length][dna.length];
        int n =0;
        for (String dato : dna) {
            String[] fila = dato.split("");
            if (fila.length == dna.length){
                matriz[n]=fila;
                n++;
            }
            else
            {
                return null;
            }
        }
        return matriz;
    }

    private boolean verificarContenido(String[][] matriz){
        for (String[] strings : matriz) {
            for (int y = 0; y < matriz.length; y++) {
                if (!(strings[y].equals("A") ||
                        strings[y].equals("T") ||
                        strings[y].equals("C") ||
                        strings[y].equals("G"))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validarExcluyente(String[][] matriz) {
        if(!verificarContenido(matriz)){
            return false;
        }
        if (validarHorizontal(matriz)){
            return true;
        }else if (validarVertical(matriz)){
            return true;
        }else return validarDiagonal(matriz);
    }
    public boolean validarIncluyente(String[][] matriz) {
        if(!verificarContenido(matriz)){
            return false;
        }
        if (validarHorizontal(matriz)) {
            if (validarVertical(matriz) && validarDiagonal(matriz)) {
                return true;
            }
        }
        return false;
    }

    private boolean validarHorizontal(String[][] matriz) {
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz.length-3; y++) {
                if (matriz[x][y].equals(matriz[x][y+1]) &&
                        matriz[x][y].equals(matriz[x][y+2]) &&
                        matriz[x][y].equals(matriz[x][y+3])){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean validarVertical(String[][] matriz) {

        for (int y = 0; y < matriz.length; y++) {
            for (int x = 0; x < matriz.length-3; x++) {

                if (matriz[x][y].equals(matriz[x+1][y]) &&
                        matriz[x][y].equals(matriz[x+2][y]) &&
                        matriz[x][y].equals(matriz[x+3][y])){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean validarDiagonal(String[][] matriz) {
        for (int x = 0; x < matriz.length-3; x++) {
            for (int y = 0; y < matriz.length-3; y++) {
                if (matriz[x][y].equals(matriz[x+1][y+1]) &&
                        matriz[x][y].equals(matriz[x+2][y+2]) &&
                        matriz[x][y].equals(matriz[x+2][y+3])){
                    return true;
                }
            }
        }
        return false;
    }
}
