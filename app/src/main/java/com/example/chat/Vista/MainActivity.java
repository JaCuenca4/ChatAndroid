package com.example.chat.Vista;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chat.Clases.User;
import com.example.chat.Fragments.ChatsFragment;
import com.example.chat.Fragments.ProfileFragment;
import com.example.chat.Fragments.UsersFragment;
import com.example.chat.Interfaces.InterfacesMain;
import com.example.chat.Presentador.MainPresentador;
import com.example.chat.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity implements InterfacesMain.Vista {

    /**
     * The Profile image.
     */
    CircleImageView profile_image;
    /**
     * The Username.
     */
    TextView username;

    /**
     * The Presentador.
     */
    InterfacesMain.Presentador presentador;
    /**
     * The Tab loyout.
     */
    TabLayout tabLoyout;
    /**
     * The View pager.
     */
    ViewPager viewPager;
    /**
     * The View pager adapter.
     */
    ViewPagerAdapter viewPagerAdapter;

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presentador = new MainPresentador(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        findElement();
        solicitarUsuario();
    }

    /**
     * On create options menu boolean.
     *
     * @param menu the menu
     * @return the boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * On options item selected boolean.
     *
     * @param item the item
     * @return the boolean
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                presentador.solicitarCerrarSesion();
                return true;
        }
        return false;
    }

    @Override
    public void findElement() {
        profile_image = findViewById(R.id.profile_iamge);
        username = findViewById(R.id.username);
        tabLoyout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new ChatsFragment(),"Chats");
        viewPagerAdapter.addFragment(new UsersFragment(), "Usuarios");
        viewPagerAdapter.addFragment(new ProfileFragment(), "Profile");

        viewPager.setAdapter(viewPagerAdapter);
        tabLoyout.setupWithViewPager(viewPager);
    }

    @Override
    public void mostrarUsuario(User user) {
        username.setText(user.getUsername());
        if(user.getImageURL().equals("default")){
            profile_image.setImageResource(R.mipmap.ic_launcher);
        }else{
            Glide.with(getApplicationContext()).load(user.getImageURL()).into(profile_image);
        }
    }

    @Override
    public void solicitarUsuario() {
        presentador.solicitarUsuario();
    }

    @Override
    public void cerrar() {
        startActivity(new Intent(this, StartActivity.class));
        finish();
    }

    /**
     * The type View pager adapter.
     */
    class ViewPagerAdapter extends FragmentPagerAdapter{

        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;

        /**
         * Instantiates a new View pager adapter.
         *
         * @param fm the fm
         */
        ViewPagerAdapter(FragmentManager fm){
            super(fm);
            this.fragments = new ArrayList<>();
            this.titles = new ArrayList<>();
        }

        /**
         * Gets item.
         *
         * @param position the position
         * @return the item
         */
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        /**
         * Gets count.
         *
         * @return the count
         */
        @Override
        public int getCount() {
            return fragments.size();
        }

        /**
         * Add fragment.
         *
         * @param fragment the fragment
         * @param title    the title
         */
        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            titles.add(title);
        }

        /**
         * Gets page title.
         *
         * @param position the position
         * @return the page title
         */
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
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
        status("offline");
    }
}