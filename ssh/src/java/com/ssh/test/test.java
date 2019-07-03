/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssh.test;

import com.wzh.sms4.SMS4;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author Administrator
 */
public class test {

    public static String test (){
        String aa = "11";
        return aa;
    }
    public static void main(String[] args) {
        String bb = test();
        if(StringUtils.isNotBlank(bb)){
            
            String a = "3.0";
            System.out.println(Double.parseDouble(a));
            Double a1 = Double.parseDouble(a);
            Double b1 = 23.3;
            System.out.println(a1.intValue()+b1);
            System.out.println("111111111111");
            return;
        }
        
        
        String str = "9137020207 327474XT";
        System.out.println(SMS4.encode(str));

        String str2 = "YI9YsU2IVTL9D5sKQD7nURhIxSTqL9uRX7OmYdFd/1w%3D";
        System.out.println(SMS4.decode(str2) );

        System.out.println(new String(Base64.decodeBase64("PHJlcXVlc3Q+CTxzaWduPnpvWkJ5eER3QndMM0dDeEdHZGg4UWlwL0pqMi9xUzU0SWVJQ29DNzYyMm9pQXREcHByd3VzWElvc3Q2UHNpdkN5b2huY054NVBjLzUKazlrS05xQ2VBTmhqTHNkZ2dZMUNPYk8vN0I2YUNQZ2ZPOVF3WVc0VWZ4QVA3R0FqeGl2NE1zMmRPOWhza3Iybll3YlIxTHRTdGxzNwpkVEwwNklJS1gzbmtSWFJCYTdrSU9sc1ZDMVF1SUEyUVBKV0VpYjZsVlhsVFJ1aTdXdWJRY1lDVko1dGRFc1l4VVNZRFJaSVZVL2pqClplTG5XMkxpL2hibzJucFV6MFR1Ylk5U1lzR1N5WkxaSkg2OEN1cVlVQi90c25FRysvbGY1YXBQZTFLb1ZKdGEydlhuWGhWZHRjZkQKRjJ2VzhLNm1rc0dITmY0MVYyQTBRcHF6Q1A5K2FNV1RhYlIxWFE9PQo8L3NpZ24+CTxid25yPlBHSnZaSGsrQ1R4dWMzSnpZbWcrT1RFek56QXlNREl3TnpNeU56UTNORmhVUEM5dWMzSnpZbWcrQ1R4dWMzSnRZejdwblpMbHNwdmwKdnE3bW1icm1oYWZrdjZIbWdhL21uSW5wbVpEbGhhemxqN2c4TDI1emNtMWpQZ2s4Wm5KdFl6N290YlhwbGIvbXNaODhMMlp5YldNKwpDVHhtY25wcWFENHpOekF4TURJeE9UYzFNRGt5TWpNek1UWThMMlp5ZW1wb1BnazhaM042WTJScWFENHpOekF5TURJeU16QXhORFF4Ck5qWThMMmR6ZW1Oa2FtZytDVHh6Y1hob1BqSTNPREF4T0R3dmMzRjRhRDQ4TDJKdlpIaysKPC9id25yPjwvcmVxdWVzdD4=")));
        System.out.println(new String(Base64.decodeBase64("PGJvZHk+CTxuc3JzYmg+OTEzNzAyMDIwNzMyNzQ3NFhUPC9uc3JzYmg+CTxuc3JtYz7pnZLlspvl"
                + "vq7mmbrmhafkv6Hmga/mnInpmZDlhazlj7g8L25zcm1jPgk8ZnJtYz7otbXplb/msZ88L2ZybWM+"
                + "CTxmcnpqaD4zNzAxMDIxOTc1MDkyMjMzMTY8L2ZyempoPgk8Z3N6Y2RqaD4zNzAyMDIyMzAxNDQx"
                + "NjY8L2dzemNkamg+CTxzcXhoPjI3ODAxODwvc3F4aD48L2JvZHk+")));
    }
}
