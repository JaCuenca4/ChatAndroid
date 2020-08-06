package com.example.chat.Clases;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.chat.Interfaces.InterfacesLogin;
import com.example.chat.Interfaces.InterfacesMain;
import com.example.chat.Interfaces.InterfacesMessage;
import com.example.chat.Interfaces.InterfacesRegistro;
import com.example.chat.Interfaces.InterfacesStart;
import com.example.chat.Modelo.ModeloRegistro;
import com.example.chat.R;
import com.example.chat.Vista.MessageActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OperacionesFirebase {

    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    DatabaseReference reference;
    InterfacesRegistro.Modelo modeloRegistro;
    InterfacesLogin.Modelo modeloLogin;
    InterfacesStart.Modelo modeloStart;
    InterfacesMain.Modelo modeloMain;
    InterfacesMessage.Modelo modeloMessage;

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

    public OperacionesFirebase(InterfacesStart.Modelo modelo){
        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();
        this.modeloStart = modelo;
    }

    public OperacionesFirebase(InterfacesMain.Modelo modelo){
        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();
        this.modeloMain = modelo;
    }

    public OperacionesFirebase(InterfacesMessage.Modelo modelo){
        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();
        this.modeloMessage = modelo;
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
                            hashMap.put("status","offline");
                            hashMap.put("search",username.toLowerCase());

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

    public void verificarSesion(){
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser != null){
            modeloStart.concederInicio();
        }
    }

    public void obtenerUsuario(){
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                modeloMain.enviarUsuario(user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void cargarChat(String userid){
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                modeloMessage.mostrarChat(user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void sendMessage(String receiver, String message){
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sender", firebaseUser.getUid());
        hashMap.put("receiver", receiver);
        hashMap.put("message", message);
        hashMap.put("isseen", false);

        reference.child("Chats").push().setValue(hashMap);
    }

    public void readMessages(final String userid, final String imageurl){
        final List<Chat> mChat = new ArrayList<>();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Chats");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mChat.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    Chat chat = snapshot.getValue(Chat.class);
                    if(chat.getReceiver().equals(firebaseUser.getUid()) && chat.getSender().equals(userid) ||
                            chat.getReceiver().equals(userid) && chat.getSender().equals(firebaseUser.getUid())){
                        mChat.add(chat);
                    }
                }
                modeloMessage.enviarMensajes(mChat, imageurl);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void cerrarSesion() {
        FirebaseAuth.getInstance().signOut();
        modeloMain.permitirCerrarSesion();
    }
}
