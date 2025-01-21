package com.example.bookstoreapp;

import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public interface BookCallback {
    void onBookItemClick(int pos,
                         ImageView imgBook,
                         TextView title,
                         TextView authorName,
                         TextView pages,
                         TextView score,
                         RatingBar ratingBar);
}
