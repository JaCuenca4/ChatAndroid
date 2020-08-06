package com.example.chat.Vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.chat.Adapter.MessageAdapter;
import com.example.chat.Clases.Chat;
import com.example.chat.Clases.User;
import com.example.chat.Fragments.APIService;
import com.example.chat.Interfaces.InterfacesMessage;
import com.example.chat.Notificaciones.Client;
import com.example.chat.Notificaciones.Data;
import com.example.chat.Notificaciones.MyResponse;
import com.example.chat.Notificaciones.Sender;
import com.example.chat.Notificaciones.Token;
import com.example.chat.Presentador.MessagePresentador;
import com.example.chat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The type Message activity.
 */
public class MessageActivity extends AppCompatActivity implements InterfacesMessage.Vista, View.OnClickListener {

    /**
     * The Profile image.
     */
    CircleImageView profile_image;
    /**
     * The Username.
     */
    TextView username;

    /**
     * The Firebase user.
     */
    FirebaseUser firebaseUser;
    /**
     * The Reference.
     */
    DatabaseReference reference;

    /**
     * The Btn send.
     */
    ImageButton btn_send;
    /**
     * The Text send.
     */
    EditText text_send;

    /**
     * The Intent.
     */
    Intent intent;
    /**
     * The Userid.
     */
    String userid;

    /**
     * The Message adapter.
     */
    MessageAdapter messageAdapter;
    /**
     * The M chat.
     */
    List<Chat> mChat;
    /**
     * The Recycler view.
     */
    RecyclerView recyclerView;

    /**
     * The Presentador.
     */
    InterfacesMessage.Presentador presentador;

    /**
     * The Seen listener.
     */
    ValueEventListener seenListener;

    /**
     * The Api service.
     */
    APIService apiService;

    /**
     * The Notify.
     */
    boolean notify = false;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MessageActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        presentador = new MessagePresentador(this);
        findelement();
        userid = intent.getStringExtra("userid");
        presentador.enviarUserId(userid);
        seenMessage(userid);
        apiService = Client.getClient("https://fcm.google.com/").create(APIService.class);
    }


    @Override
    public void findelement() {
        profile_image = findViewById(R.id.profile_image);
        username = findViewById(R.id.username);
        btn_send = findViewById(R.id.btn_send);
        text_send = findViewById(R.id.text_send);
        intent = getIntent();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);



        btn_send.setOnClickListener(this);

    }

    @Override
    public void desplegarChat(User user) {
        username.setText(user.getUsername());
        if(user.getImageURL().equals("default")){
            profile_image.setImageResource(R.mipmap.ic_launcher);
        }else{
            Glide.with(getApplicationContext()).load(user.getImageURL()).into(profile_image);
        }
        presentador.obtenerMensajes(userid,user.getImageURL());
    }

    @Override
    public void mostrarMensajes(List<Chat> chats, String imageurl) {
        messageAdapter = new MessageAdapter(MessageActivity.this, chats, imageurl);
        recyclerView.setAdapter(messageAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send:
                notify = true;
                String msg = text_send.getText().toString();
                if(!msg.equals("")){
                    presentador.enviarMensaje(userid,msg);
                    notificacion(msg);
                }else{
                    Toast.makeText(this, "No puedes enviar un mensaje vacío", Toast.LENGTH_SHORT).show();
                }
                text_send.setText("");
                break;
        }


    }

    private void sendNotification(String reciever, final String username, final String msg) {
        DatabaseReference tokens = FirebaseDatabase.getInstance().getReference("Tokens");
        Query query = tokens.orderByKey().equalTo(reciever);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Token token = snapshot.getValue(Token.class);
                    Data data = new Data(firebaseUser.getUid(), R.mipmap.ic_launcher, username+": "+msg, "Nuevo Mensaje", userid );
                    Sender sender = new Sender(data, token.getToken());

                    apiService.sendNotification(sender)
                            .enqueue(new Callback<MyResponse>() {
                                @Override
                                public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                                    if(response.code() == 200){
                                        if(response.body() != null){
                                            Toast.makeText(MessageActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<MyResponse> call, Throwable t) {

                                }
                            });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    /**
     * Notificacion.
     *
     * @param message the message
     */
    public void notificacion(String message){
        final String msg = message;
        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                if(notify){
                    sendNotification(userid, user.getUsername(), msg);
                }
                notify = false;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void seenMessage(final String userid){
        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        seenListener = reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Chat chat = snapshot.getValue(Chat.class);
                if(chat.getReceiver().equals(firebaseUser.getUid()) && chat.getSender().equals(userid)){
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("isseen", true);
                    snapshot.getRef().updateChildren(hashMap);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void status(String status){
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status", status);

        reference.updateChildren(hashMap);
    }

    /**
     * On resume.
     */
    @Override
    protected void onResume() {
        super.onResume();
        status("online");
    }

    /**
     * On pause.
     */
    @Override
    protected void onPause() {
        super.onPause();
        reference.removeEventListener(seenListener);
        status("offline");
    }
}