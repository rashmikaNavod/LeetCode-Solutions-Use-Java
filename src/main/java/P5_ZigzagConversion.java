import java.util.ArrayList;

/**

 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R

 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);

*/

public class P5_ZigzagConversion {
    public static String convert(String s, int numRows) {

        if(s.length()==1 || numRows==1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        boolean goingDown = false;
        int currentRow = 0;

        for (int i = 0; i < s.length(); i++) {
            if(currentRow == numRows-1 || currentRow == 0){
                goingDown = !goingDown;
            }

            rows[currentRow].append(s.charAt(i));

//            if (goingDown){
//                currentRow++;
//            } else if (!goingDown) {
//                currentRow--;
//            }

            currentRow += goingDown ? 1 : -1;

        }

        StringBuilder result = new StringBuilder();

        for(StringBuilder row : rows){
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String output = convert("PAYPALISHIRING", 3);
        System.out.println(output);
    }

}
