package com.company;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Main {
    static char[] sign = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
    static StringBuffer hexString = new StringBuffer();
    static Thread mythread=new Thread();
    static String hash1 = "1115dd800feaacefdf481f1f9070374a2a81e27880f187396db67958b207cbad";
    static String hash2 = "3a7bd3e2360a3d29eea436fcfb7e44c735d117c42d1c1835420b6b9942dd4f1b";
    static String hash3 = "74e1bb62f8dabb8125a58852b63bdf6eaef667cb56ac7f7cdba6d7305c50a22f";
    public static void main(String[] args) throws InterruptedException {
        mythread.start();
        String password = "";
            for (int i1=0;i1<sign.length;i1++) {
                for (int i2 = 0; i2 < sign.length; i2++) {
                    for (int i3 = 0; i3 < sign.length; i3++) {
                        for (int i4 = 0; i4 < sign.length; i4++) {
                            for (int i5 = 0; i5 < sign.length; i5++) {
                                password = password + sign[i1] + sign[i2] + sign[i3] + sign[i4] + sign[i5];
                                xeh(password);
                                password = "";
                            }
                        }
                    }
                }
            }
    }
    public static void xeh(String password) {
            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            messageDigest.update(password.getBytes());

            byte[] digest = messageDigest.digest();
            for (int i = 0; i < digest.length; i++) {
                String s = Integer.toHexString(0xFF & digest[i]);
                s = (s.length() == 1) ? "0" + s : s;
                hexString.append(s);
            }
            if (hash1.equals(hexString.toString())==true || hash2.equals(hexString.toString())==true || hash3.equals(hexString.toString())==true) {
                System.out.println("Password: " + password + "      hex: " + hexString.toString());
            }
        }
    }
class MyThread extends Thread {
    char[] sign = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
    StringBuffer hexString = new StringBuffer();
    private String password="";
    String hash1 = "1115dd800feaacefdf481f1f9070374a2a81e27880f187396db67958b207cbad";
    String hash2 = "3a7bd3e2360a3d29eea436fcfb7e44c735d117c42d1c1835420b6b9942dd4f1b";
    String hash3 = "74e1bb62f8dabb8125a58852b63bdf6eaef667cb56ac7f7cdba6d7305c50a22f";
    public void run() {
        for (int i1=sign.length;i1>=0;i1--) {
            for (int i2=sign.length;i1>=0;i1--) {
                for (int i3=sign.length;i1>=0;i1--) {
                    for (int i4=sign.length;i1>=0;i1--) {
                        for (int i5=sign.length;i1>=0;i1--) {
                            password = password + sign[i1] + sign[i2] + sign[i3] + sign[i4] + sign[i5];
                            xeh(password);
                            password = "";
                        }
                    }
                }
            }
        }
    }
    public void xeh(String password) {
            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            messageDigest.update(password.getBytes());

            byte[] digest = messageDigest.digest();
            for (int i = 0; i < digest.length; i++) {
                String s = Integer.toHexString(0xFF & digest[i]);
                s = (s.length() == 1) ? "0" + s : s;
                hexString.append(s);
            }
        if (hash1.equals(hexString.toString())==true || hash2.equals(hexString.toString())==true || hash3.equals(hexString.toString())==true) {
                System.out.println("Password: " + password + "      hex: " + hexString.toString());
            }
        }
    }

