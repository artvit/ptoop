package by.bsuir.oop.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Checksum {
    public String getChecksum(byte[] data) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            byte[] checksum = messageDigest.digest(data);
            return convertBytesToHexString(checksum);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String convertBytesToHexString(byte[] data) {
        final char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[data.length * 2];
        for ( int j = 0; j < data.length; j++ ) {
            int v = data[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
