package com.example.chat.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.chat.R;

public class MainActivity extends AppCompatActivity {

    CircleImageView profile_image;
    TextView username;
    FirebaseUser firebaseUser;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profile_image=findViewyId(R.id.profile_image);
        username=findViewById(R.id.username);
        FirebaseUser =FirebaseAuth.getInstance.getCurrentUser();
        reference= FireDatabase.getInstance.getReeference(s:"Users").child(firebaseUser.getUid)));
        referene.addValueEventListener(new ValueEventListener){
            @Override
            publoc void onDataChange(@NonNull DataSnapshot dataSnapshot){
                User user= dataSnapshot.getValue(User.class);
                username.setText(user.getUsername());
                if(user.getImageURL().equals("default")){
                    profile_image.setImageResource(R.mipmap.ic_launcher);
                }else {
                    Glide.with(activity: MainActivity.this).load(user.getImageURL()).into(profile_image)

                }
            }
        }
    }

}