package com.example.bookstoreapp;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class BookDetailsActivity extends AppCompatActivity {

    ImageView imgbook;
    TextView title,description,author,pages,rate;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        imgbook = findViewById(R.id.item_book_img);
        ratingBar = findViewById(R.id.item_book_ratingbar);
        title = findViewById(R.id.item_book_title);
        description = findViewById(R.id.details_desc);
        author = findViewById(R.id.item_book_author);
        pages = findViewById(R.id.item_book_pagesrev);
        rate = findViewById(R.id.item_book_score);

        Book item = (Book) getIntent().getExtras().getSerializable("bookObject");
        loadBookData(item);

    }

    private void loadBookData(Book item) {

        Glide.with(this).load(item.getDrawableResource()).into(imgbook);
        title.setText(item.getTitle());
        description.setText(item.getDescription());
        author.setText(item.getAuthor());
        pages.setText(item.getPages());
        rate.setText(item.getScore());
        ratingBar.setRating(item.getRating());

    }

}