package com.example.admin.albumsviewer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AlbumsList extends AppCompatActivity {

    Toolbar toolbar;
    ListView lvAlbumsList;
    DatabaseReference databaseReference;
    List<Album> albumsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.albums_list);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("albums");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("Biblioteka albumów");
        setSupportActionBar(toolbar);

        lvAlbumsList = (ListView) findViewById(R.id.lvAlbumsList);
        albumsList = new ArrayList<>();
    }


    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                albumsList.clear();

                for(DataSnapshot albumSnapshot : dataSnapshot.getChildren()){
                    Album album = albumSnapshot.getValue(Album.class);
                    albumsList.add(album);
                }

                ListOfAlbums adapter = new ListOfAlbums(AlbumsList.this, albumsList);
                lvAlbumsList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.logout,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int resID = item.getItemId();
        if (resID == R.id.logout){
            // mechanizm wylogowania z firebase
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(AlbumsList.this, "Wylogowałeś się!", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(AlbumsList.this, MainActivity.class));
        }

        return true;
    }
}
