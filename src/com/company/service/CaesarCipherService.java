package com.company.service;

public class CaesarCipherService {

    public static char[] decryption(String textForDecryption, int encryptionKey, final char[] LOWERCASE_ALPHABET_ARRAY, final char[] UPPERCASE_ALPHABET_ARRAY) {
        char[] textChar = textForDecryption.toCharArray();

        for (int i = 0; i < textChar.length; i++) {
            if (Character.isLetter(textChar[i])) {
                if (Character.isLowerCase(textChar[i])) {
                    textChar[i] = getMatchingCharacterFromArray(textChar[i], encryptionKey, LOWERCASE_ALPHABET_ARRAY);
                } else {
                    textChar[i] = getMatchingCharacterFromArray(textChar[i], encryptionKey, UPPERCASE_ALPHABET_ARRAY);
                }
            }
        }
        return textChar;
    }

    private static char getMatchingCharacterFromArray(char textChar, int encryptionKey, char[] ALPHABET_ARRAY) {
        int maxAlphabetIndex = ALPHABET_ARRAY.length-1;
        int indexForAlphabet = 0;
        while (textChar != ALPHABET_ARRAY[indexForAlphabet]) {
            indexForAlphabet++;
        }
        indexForAlphabet += encryptionKey;
        if (indexForAlphabet > maxAlphabetIndex) {
            indexForAlphabet -= maxAlphabetIndex + 1;
        }
        return ALPHABET_ARRAY[indexForAlphabet];
    }


}
