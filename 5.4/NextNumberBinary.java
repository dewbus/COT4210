package com.company;

/**
 * Louis Alvarez
 * Finds the next higher and lower number that shares the same number of 1 bits
 * LM: 2/4/2021
 * Chapter 5
 * Question 5.4
 */
public class NextNumberBinary {

    /**
     * Takes a number, converts it to binary, and finds the next highest and lower number that when converted
     * to binary, contains the same number of 1 bits.
     * @param args
     */
    public static void main(String[] args) {
        int number = 10;
        StringBuilder numberBinary = toBinary(number); //StringBuilder array of number bits
        int numberOnes = countOnes(numberBinary); //Count of 1's from binary form
        System.out.println("The default number is: " + number + " and its binary form: " + numberBinary);


        int larger = number; // next, higher number
        StringBuilder largerBinary;
        int largerOnes;

        //increments starting from number + 1 to find a int that contains the same number of 1's in binary form
        //as number
        while(true){
            larger++;
            largerBinary = toBinary(larger);

            largerOnes = countOnes(largerBinary);

            if(numberOnes == largerOnes){
                System.out.println("The next largest number: " + larger + " and its binary form: " + largerBinary);

                break;
            }
        }

        int shorter = number; // next, lower number
        StringBuilder shorterBinary;
        int shorterOnes;

        //decrements starting from number - 1 to find a int that contains the same number of 1's in binary form
        //as number
        while(true){
            shorter--;
            shorterBinary = toBinary(shorter);

            shorterOnes = countOnes(shorterBinary);

            if(numberOnes == shorterOnes){
                System.out.println("The next smallest number: " + shorter + " and its binary form: " + shorterBinary);
                break;
            }

            if(shorter < 0){
                System.out.println("N/a.");
                break;
            }
        }
    }

    /**
     * Converts an Integer to a StringBuilder array of binary form
     * @param number
     * @return
     */
    public static StringBuilder toBinary(Integer number) {
        StringBuilder defaultString = new StringBuilder();
        defaultString.append(0);

        if (number == 0) {
            return defaultString;
        }

        StringBuilder binaryNumber = new StringBuilder();
        Integer quotient = number;

        while (quotient > 0) {
            int remainder = quotient % 2;
            binaryNumber.append(remainder);
            quotient /= 2;
        }

        binaryNumber = binaryNumber.reverse();
        return binaryNumber;
    }

    /**
     * Takes a StringBuilder object and counts the amount of 1 bits
     * @param string
     * @return
     */
    public static int countOnes(StringBuilder string){
        int ones = 0;

        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == '1'){

                ones++;
            }
        }
        return ones;
    }

}
