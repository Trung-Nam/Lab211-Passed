/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS G731G
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String choice = "Y";
        ConvertBaseNumber convert = new ConvertBaseNumber();
        // loop until user choice N (no repetive)
        while (choice.equalsIgnoreCase("Y")) {
            // step1: Required user choose the base number input ( example 1 is binary, 2 is decimal,  3 is hexadecimal)
            int numberBaseInput = Inputter.ChoiceNumberBaseInput();
            // step2: Required user choose the base number output( example 1 is binary, 2 is decimal,  3 is hexadecimal)
            int numberBaseOutput = Inputter.ChoiceNumberBaseOutput();
            // step3: Required user enter the input value;
            String valueBaseInput = convert.EnterValue(numberBaseInput);
            // step4: Program process
            String valueBaseOutput = convert.ProgramProcess(numberBaseInput, numberBaseOutput, valueBaseInput);
            // step5: print output value
            convert.PrintOutputValue(numberBaseOutput, valueBaseOutput);
            // step6: user enter choice to repetitive program or not
            choice = Inputter.ChoiceRepetitiveProgramOrNot();
        }
    }

}
