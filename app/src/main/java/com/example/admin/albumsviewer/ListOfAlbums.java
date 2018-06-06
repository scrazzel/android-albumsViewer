package com.example.admin.albumsviewer;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class ListOfAlbums extends ArrayAdapter<Album> {

    Activity context;
    List<Album> albumsList;

    public ListOfAlbums(Activity context, List<Album> albumsList){
        super(context, R.layout.list_of_albums,albumsList);
        this.context = context;
        this.albumsList = albumsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_of_albums,null,true);

        TextView tvTitle = (TextView) listViewItem.findViewById(R.id.tvTitle);
        TextView tvBand = (TextView) listViewItem.findViewById(R.id.tvBand);

        Album album = albumsList.get(position);

        tvTitle.setText(album.getTitle());
        tvBand.setText(album.getBand());

        tvTitle.setText("Nie dziala");
        tvBand.setText("Dupa");

        return listViewItem;

    }
}
