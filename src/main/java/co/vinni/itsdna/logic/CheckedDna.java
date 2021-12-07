package co.vinni.itsdna.logic;
/**
 * Class to perform DNA strand validations and determine Mutant
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
        if (!verifyContent(matrix)){
            return null;
        }
        return validateExclude(matrix);
    }

    /**
     * Method to build the array from JSON object
     * @param dna [] String
     * @return String[][]
     */
    public String[][] buildMatrix(String[] dna) {
        if (dna == null){
            return null;
        }
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
        if (matrix.length ==0)
        {
            return null;
        }
        return matrix;
    }

    /**
     * Method to verify that a character other than "A", "T", "C", "G" is not entered
     * @param matrix String[][]
     * @return boolean
     */
    public boolean verifyContent(String[][] matrix){
        for (String[] row : matrix) {
            for (int y = 0; y < matrix.length; y++) {
                if (!(row[y].equals("A") ||
                        row[y].equals("T") ||
                        row[y].equals("C") ||
                        row[y].equals("G"))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method to verify consecutive chains horizontally, vertically and / or diagonally exclusively
     * @param matrix String[][]
     * @return boolean
     */
    public boolean validateExclude(String[][] matrix) {
        if (validateHorizontal(matrix)){
            return true;
        }else if (validateVertical(matrix)){
            return true;
        }else return validateDiagonal(matrix);
    }

    /**
     * Method to check consecutive strings horizontally
     * @param matrix String[][]
     * @return boolean
     */
    public boolean validateHorizontal(String[][] matrix) {
        for (String[] row : matrix) {
            for (int y = 0; y < matrix.length - 3; y++) {
                if (row[y].equals(row[y + 1]) &&
                        row[y].equals(row[y + 2]) &&
                        row[y].equals(row[y + 3])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method to check consecutive strings vertically
     * @param matrix String[][]
     * @return boolean
     */
    public boolean validateVertical(String[][] matrix) {

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

    /**
     * Method to check consecutive strings diagonally
     * @param matrix String[][]
     * @return boolean
     */
    public boolean validateDiagonal(String[][] matrix) {
        for (int x = 0; x < matrix.length-3; x++) {
            for (int y = 0; y < matrix.length-3; y++) {
                if (matrix[x][y].equals(matrix[x+1][y+1]) &&
                        matrix[x][y].equals(matrix[x+2][y+2]) &&
                        matrix[x][y].equals(matrix[x+3][y+3])){
                    return true;
                }
            }
        }
        return false;
    }
}
