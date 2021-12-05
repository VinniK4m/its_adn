package co.vinni.itsadn.itsadn.logic;
/**
 *
 * @author Vinni - vinni_@yahoo.com
 */
public class ChequedDna {
    /**
     * Funtion checked structure and response "Mutant" or "Human"
     * @param dna String[]
     * @return int valores 1 = Mutante 2 Humano 3 Error
     */
    public Boolean isMutant(String[] dna){
        if (dna == null){
            return null;
        }
        String[][] matrix = buildMatrix(dna);
        if (matrix == null)
        {
            return null;
        }
        return validateExclud(matrix);
    }

    private String[][] buildMatrix(String[] dna) {
        String[][] matrix = new String[dna.length][dna.length];
        int n =0;
        for (String data : dna) {
            String[] row = data.split("");
            if (row.length == dna.length){
                matrix[n]=row;
                n++;
            }
            else
            {
                return null;
            }
        }
        return matrix;
    }

    private boolean verifyContent(String[][] matrix){
        for (String[] strings : matrix) {
            for (int y = 0; y < matrix.length; y++) {
                if (!(strings[y].equals("A") ||
                        strings[y].equals("T") ||
                        strings[y].equals("C") ||
                        strings[y].equals("G"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validateExclud(String[][] matrix) {
        if(verifyContent(matrix)){
            return false;
        }
        if (validateHorizontal(matrix)){
            return true;
        }else if (validateVertical(matrix)){
            return true;
        }else return validateDiagonal(matrix);
    }


    private boolean validateHorizontal(String[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length-3; y++) {
                if (matrix[x][y].equals(matrix[x][y+1]) &&
                        matrix[x][y].equals(matrix[x][y+2]) &&
                        matrix[x][y].equals(matrix[x][y+3])){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean validateVertical(String[][] matrix) {

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length-3; x++) {

                if (matrix[x][y].equals(matrix[x+1][y]) &&
                        matrix[x][y].equals(matrix[x+2][y]) &&
                        matrix[x][y].equals(matrix[x+3][y])){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean validateDiagonal(String[][] matrix) {
        for (int x = 0; x < matrix.length-3; x++) {
            for (int y = 0; y < matrix.length-3; y++) {
                if (matrix[x][y].equals(matrix[x+1][y+1]) &&
                        matrix[x][y].equals(matrix[x+2][y+2]) &&
                        matrix[x][y].equals(matrix[x+2][y+3])){
                    return true;
                }
            }
        }
        return false;
    }
}
