/*
 * Name:        Roby Ferrer Soriano
 * Schedule:    MTH 2:30 - 4:00 PM
 * Room:        D528
 *
 * Instructor:  Dalos D. Miguel
 * Program:     Programming 2
 */

import java.lang.*;
import java.util.Random;

public class Secret implements Encryptable {
    private String message;
    private boolean encrypted;
    private int shift;
    private Random generator;

    public Secret(String givenMessage) {
        message = givenMessage; // assign givenMessage to message
        encrypted = false; // assign encrypted to false;
        generator = new Random(); // construct an object of Random and assign it ti generator
        shift = generator.nextInt(10) + 5; // use generator to produce an integer that is at most 9, add 5 to the generated random number and assign the sum to shift
    }

    /**
     * Replaces the value of message to its encrypted form by applying the Caesar Cipher encryption algorithm
     */
    public void encrypt() {
        if (!encrypted) {
            String encryptedMessage = "";
            for (int index = 0; index < message.length(); index++) {
                encryptedMessage = encryptedMessage + (char) (message.charAt(index) + shift);
            }
            message = encryptedMessage;
            encrypted = true;
        }
    }

    /**
     * Returns the unencrypted form of the value of the message
     */
    public String decrypt() {
        if (encrypted) {
            String decryptedMessage = "";
            for (int index = 0; index < message.length(); index++) {
                decryptedMessage = decryptedMessage + (char) (message.charAt(index) - shift);
            }
            message = decryptedMessage;
            encrypted = false;
        }
        return message;
    }

    /**
     * Returns in value of encrypted
     */
    public boolean isEncrypted() {
        return encrypted;
    }

    /**
     * Returns the vale of message
     */
    public String toString() {
        return message;
    }
}
