package com.example.chat.Vista;

import androidx.annotation.NonNull;
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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


        profile_image=findViewyId(R.id.profile_image);
        username=findViewById(R.id.username);
        FirebaseUser =FirebaseAuth.getInstance.getCurrentUser();
        reference= FireDatabase.getInstance.getReeference(s:"Users").child(firebaseUser.getUid)));
        referene.addValueEventListener(new ValueEventListener){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                User user= dataSnapshot.getValue(User.class);
                username.setText(user.getUsername());
                if(user.getImageURL().equals("default")){
                    profile_image.setImageResource(R.mipmap.ic_launcher);
                }else {
                    Glide.with(activity: MainActivity.this).load(user.getImageURL()).into(profile_image);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.logout:
                FirebaseAuth.getInstance().signout();
                startActivity(new Intent(packageContext:MainActivity.this,StartActivity.class));
                finish();
                return true;
        }
    }   return false;
}