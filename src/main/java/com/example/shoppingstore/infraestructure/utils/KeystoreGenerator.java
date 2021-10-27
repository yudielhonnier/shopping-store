package com.example.shoppingstore.infraestructure.utils;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Component
public class KeystoreGenerator {

    @Bean
    public KeyStore createKeystore() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
//        KeyStore ks=KeyStore.getInstance(KeyStore.getDefaultType());

        KeyStore ks=KeyStore.getInstance("JKS");
        char[] pwdArray ="password".toCharArray();
        ks.load(null,pwdArray);
        try (FileOutputStream fos=new FileOutputStream("newKeyStoreFileName.jks")){
            ks.store(fos,pwdArray);
        }
        return ks;
    }



}
