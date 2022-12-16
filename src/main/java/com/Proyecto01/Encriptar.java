
package com.Proyecto01;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        var claveLarissa = encoder.encode("123");
         var claveKael = encoder.encode("456");
          var claveJoel = encoder.encode("789");
          System.out.println("Larissa(123): "+ claveLarissa);
          System.out.println("Kael(456): "+ claveKael);
          System.out.println("Joel(789): "+ claveJoel);
          

//para encriptar las claves
    }
   
}
