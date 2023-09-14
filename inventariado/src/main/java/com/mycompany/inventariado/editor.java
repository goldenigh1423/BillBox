package com.mycompany.inventariado;

import com.google.cloud.firestore.DocumentReference;
import com.google.firebase.cloud.FirestoreClient;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.WriteResult;
import java.util.Map;


/**
 *
 * @author csant
 */
public class editor {
    CollectionReference reference;
    static Firestore db;
    
    public static boolean registrar(String coleccion, String documento, Map<String,Object> data){
        db=FirestoreClient.getFirestore();
        try {
            DocumentReference ref=db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result=ref.set(data);
            System.out.println("Los datos se han guardado");
            return true;
        } catch (Exception e) {
            System.err.println("Error al guardar los datos: "+e.getMessage());
        }
        return false;
    }
    
}
