package com.example.admin.albumsviewer;

import android.media.Image;
import android.widget.ImageView;

public class Album {
    String title;
    String band;
    String genre;
    int price;
    int publicationDate;
    ImageView albumCover;
    ImageView bandLogo;

    Album(){

    }

    public Album(String title, String band, String genre, int price, int publicationDate, ImageView albumCover, ImageView bandLogo) {
        this.title = title;
        this.band = band;
        this.genre = genre;
        this.price = price;
        this.publicationDate = publicationDate;
        this.albumCover = albumCover;
        this.bandLogo = bandLogo;
    }

    public String getTitle() {
        return title;
    }

    public String getBand() {
        return band;
    }

    public String getGenre() {
        return genre;
    }

    public int getPrice() {
        return price;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public ImageView getAlbumCover() {
        return albumCover;
    }

    public ImageView getBandLogo() {
        return bandLogo;
    }
}
