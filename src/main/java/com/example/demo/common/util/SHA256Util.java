package com.example.demo.common.util;

import java.security.MessageDigest;

/**
 * SHA 256
 * : 복호화가 없으므로 별도의 키가 없다.
 *   키가 없으므로 SHA256 알고리즘을 돌려서는 항상 같은 결과가 떨어진다.
 *   적당한 길이와 복잡성을 가지도록 유도해서 패스워드를 유추하는데 어렵도록 해야 함.
 *   
 * 출처: http://18281818.tistory.com/83 
 *
 */
public class SHA256Util {
  public static String encrypt(String planText) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(planText.getBytes());
      byte byteData[] = md.digest();
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < byteData.length; i++) {
        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
      }
      StringBuffer hexString = new StringBuffer();
      for (int i = 0; i < byteData.length; i++) {
        String hex = Integer.toHexString(0xff & byteData[i]);
        if (hex.length() == 1) {
          hexString.append('0');
        }
        hexString.append(hex);
      }
      return hexString.toString();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

}
