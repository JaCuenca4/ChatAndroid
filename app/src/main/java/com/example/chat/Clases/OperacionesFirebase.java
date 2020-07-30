package com.example.chat.Clases;

import androidx.annotation.NonNull;

import com.example.chat.Interfaces.InterfacesLogin;
import com.example.chat.Interfaces.InterfacesRegistro;
import com.example.chat.Modelo.ModeloRegistro;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class OperacionesFirebase {

    FirebaseAuth auth;
    DatabaseReference reference;
    boolean resultRegister = false;
    boolean resultLogin = false;
    InterfacesRegistro.Modelo modeloRegistro;
    InterfacesLogin.Modelo modeloLogin;

    public OperacionesFirebase(InterfacesRegistro.Modelo modelo) {
        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();
        this.modeloRegistro = modelo;
    }

    public OperacionesFirebase(InterfacesLogin.Modelo modelo) {
        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();
        this.modeloLogin = modelo;
    }

    public void registro(final String username, String email, String pass){
        auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            String userid = firebaseUser.getUid();
                            reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("username", username);
                            hashMap.put("imageURL", "default");

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    modeloRegistro.concederAcceso();
                                }
                            });
                        }
                    }
                });
    }

    public void login(String email, String pass){
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    modeloLogin.concederAcceso();
                }
            }
        });
    }
}
