/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariado;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author csant
 */
public class Conexion {
    public static Firestore db;
    
    public static void conectarfirebase() throws IOException{
        try{
            FileInputStream refreshToken = new FileInputStream("inventario.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .build();

            FirebaseApp.initializeApp(options);
            db=FirestoreClient.getFirestore();
            System.out.println("Conexion a firebase exitosa");
        }catch(IOException e){
            System.err.println("Error al conectar a firebase"+e.getMessage());
        }
    }
}
