
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS G731G
 */
class ConvertBaseNumber {

    public static String EnterValue(int numberBaseInput) {
        System.out.println("***************************************");
        //if user choose base binary
        if (numberBaseInput == 1) {
            System.out.print("Enter value Binary:");
            String valueBinary = Inputter.EnterValueBinary();
            System.out.println(valueBinary + "(BIN)");
            return valueBinary;
        }

        //if user choose base demical
        if (numberBaseInput == 2) {
            System.out.println("Enter value Demical:");
            String valueDecimal = Inputter.EnterValueDecimal();
            System.out.print(valueDecimal + "(DEC)");
            return valueDecimal;
        }

        // if user choose base hexadecimal
        if (numberBaseInput == 3) {
            System.out.print("Enter value Hexadecimal: ");
            String valueHexadecimal = Inputter.EnterValueHexadecimal();
            System.out.print(valueHexadecimal + "(HEX)");
            return valueHexadecimal;
        }
        return null;
    }

    public static String ProgramProcess(int numberBaseInput, int numberBaseOutput, String valueBaseInput) {
        // if user want to convert from binary
        if (numberBaseInput == 1) {
            // if user want convert to decimal
            if (numberBaseOutput == 2) {
                String decimal = ConvertBinaryToDemical(valueBaseInput);
                return decimal;
            }
            // if user want convert to hexadecimal
            if (numberBaseOutput == 3) {
                String decimal = ConvertBinaryToDemical(valueBaseInput);
                String hexadecimal = ConvertDecimalToHexadecimal(decimal);
                return hexadecimal;
            }
        }
        // if user want to convert from decimal
        if (numberBaseInput == 2) {
            // if user want convert to binary
            if (numberBaseOutput == 1) {
                String binary = ConvertDecimalToBinary(valueBaseInput);
                return binary;
            }
            // if user want convert to hexadecimal
            if (numberBaseOutput == 3) {
                String hexadecimal = ConvertDecimalToHexadecimal(valueBaseInput);
                return hexadecimal;
            }
        }
        // if user want to convert from hexadecimal
        if (numberBaseInput == 3) {
            // if user want convert to binary
            if (numberBaseOutput == 1) {
                String decimal = ConvertHexadeToDecimal(valueBaseInput);
                String binary = ConvertDecimalToBinary(decimal);
                return binary;
            }
            // if user want convert to decimal
            if (numberBaseOutput == 2) {
                String decimal = ConvertHexadeToDecimal(valueBaseInput);
                return decimal;
            }
        }
        return "";
    }

    public static String ConvertBinaryToDemical(String binary) {
        BigInteger decimal = new BigInteger("0");
        BigInteger numberTwo = new BigInteger("2");
        int index = binary.length() - 1;
        // loop traversal all element of string binary
        for (int i = 0; i < binary.length(); i++) {
            String[] strBinary = binary.split("");
            BigInteger valueOfIndex = new BigInteger(strBinary[i]);
            BigInteger valueAfterConver = new BigInteger(String.valueOf(valueOfIndex.multiply(numberTwo.pow(index))));
            decimal = decimal.add(valueAfterConver);
//            System.out.print(valueOfIndex + "*" + "2^" + index + " + ");
            index--;
        }
        return String.valueOf(decimal);
    }
    
    // program convert decimal to bnary
    public static String ConvertDecimalToBinary(String decimal) {
        String binaryBeforeReverse = "";
        String binary = "";
        BigInteger intDecimal = new BigInteger(decimal);
        BigInteger baseTwo = new BigInteger("2");
        BigInteger remainder = new BigInteger("0");
        // loop until value of decimal number equal 0
        while (intDecimal.longValue() != 0) {
            remainder = intDecimal.mod(baseTwo);
            binaryBeforeReverse = binaryBeforeReverse + String.valueOf(remainder);
//            System.out.println(intDecimal + " : 2 = " + intDecimal.divide(baseTwo) + " remainder " + remainder );
            intDecimal = intDecimal.divide(baseTwo);
        }

        // loop index descending from last index to index equal 0
        for (int i = binaryBeforeReverse.length() - 1; i >= 0; i--) {
            // reserver the string
            binary = binary + String.valueOf(binaryBeforeReverse.charAt(i));
        }

        return String.valueOf(binary);
    }

    public static String ConvertCharracterInTwoBase(String character) {
        String[] digits = {"10", "11", "12", "13", "14", "15"};
        String[] characters = {"A", "B", "C", "D", "E", "F"};
        // loop travelse from index 0 to the last index
        for (int i = 0; i < characters.length; i++) {
            //hexa to decimal
            if (character.equalsIgnoreCase(characters[i])) {
                return digits[i];
            }
            //decimal to hexa
            if (character.equalsIgnoreCase(digits[i])) {
                return characters[i];
            }
        }
        return null;
    }

    // program convert decimal to hexadecimal
    public static String ConvertDecimalToHexadecimal(String decimal) {
        String hexaBefore = "";
        String hexadecimal = "";
        BigInteger intDecimal = new BigInteger(decimal);
        BigInteger baseHexa = new BigInteger("16");
        long remainder;
        // loop until value of long decimal number equal 0
        while (intDecimal.longValue() != 0) {
            remainder = intDecimal.mod(baseHexa).longValue();
            //convert long to string
            String Remainder = String.valueOf(remainder);

            // if convert character in decimal to hexadecimal correct
            if (ConvertCharracterInTwoBase(Remainder) != null) {
                Remainder = ConvertCharracterInTwoBase(Remainder);
            }

            hexaBefore = hexaBefore + Remainder;
//            System.out.println(intDecimal + " : 16 = " + intDecimal.divide(baseHexa) + " remainder " + Remainder);
            intDecimal = intDecimal.divide(baseHexa);
        }

        // loop index descending from last index to index equal 0
        for (int i = hexaBefore.length() - 1; i >= 0; i--) {
            // reserve the string hexabefore
            hexadecimal = hexadecimal + String.valueOf(hexaBefore.charAt(i));
        }
        return hexadecimal;
    }

    //program convert hexadecimal to decimal
    public static String ConvertHexadeToDecimal(String hexadecimal) {
        BigDecimal decimal = new BigDecimal("0");
        BigDecimal baseHexa = new BigDecimal("16");
        int index = hexadecimal.length() - 1;
        // loop traverse all element in the string hexadecimal
        for (int i = 0; i < hexadecimal.length(); i++) {
            String[] strHexadecimal = hexadecimal.split("");
            // if convert character in hexadecimal to decimal is correct
            if (ConvertCharracterInTwoBase(strHexadecimal[i]) != null) {
                strHexadecimal[i] = ConvertCharracterInTwoBase(strHexadecimal[i]);
            }
            BigDecimal valueOfIndex = new BigDecimal(strHexadecimal[i]);
            BigDecimal valueAfterConvert = new BigDecimal(String.valueOf(valueOfIndex.multiply(baseHexa.pow(index))));
            decimal = decimal.add(valueAfterConvert);
//        System.out.print(strHexadecimal[i] + "*" + "16^" + index + " + ");
            index--;
        }
        return String.valueOf(decimal);
    }

    public static void PrintOutputValue(int numberBaseOutput, String valueBaseOutput) {
        // if user want convert to binary
        if (numberBaseOutput == 1) {
            System.out.print("=" + valueBaseOutput + "(BIN)");
        }
        // if user want convert to decimal
        if (numberBaseOutput == 2) {
            System.out.print("=" + valueBaseOutput + "(DEC)");
        }
        // if user want convert to hexadecimal
        if (numberBaseOutput == 3) {
            System.out.print("=" + valueBaseOutput + "(HEX)");
        }
        System.out.println("");
    }

}
