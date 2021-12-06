package co.vinni.itsadn.itsadn.logic;
/**
 *
 * @author Vinni - vinni_@yahoo.com
 */
public class CheckedDna {
    /**
     * Function checked structure and response "Mutant" or "Human"
     * @param dna String[]
     * @return int values 1 = Mutant 2 Human 3 Error
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
        return validateExclude(matrix);
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

    private boolean validateExclude(String[][] matrix) {
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
        for (String[] strings : matrix) {
            for (int y = 0; y < matrix.length - 3; y++) {
                if (strings[y].equals(strings[y + 1]) &&
                        strings[y].equals(strings[y + 2]) &&
                        strings[y].equals(strings[y + 3])) {
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
