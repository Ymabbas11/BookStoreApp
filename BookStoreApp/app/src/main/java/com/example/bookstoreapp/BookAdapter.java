package com.example.bookstoreapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.bookviewholder> {

    Context context;
    List<Book> mdata;
    BookCallback callback;


    public BookAdapter(Context context,List<Book> mdata ,BookCallback callback) {
        this.context = context;
        this.mdata = mdata;
        this.callback = callback ;
    }


    @NonNull
    @Override
    public bookviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book,parent,false);

        return new bookviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bookviewholder holder,int position) {

        holder.title.setText(mdata.get(position).getTitle());
        holder.author.setText(mdata.get(position).getAuthor());
        holder.pages.setText(mdata.get(position).getPages());
        holder.rate.setText(mdata.get(position).getScore());
        holder.ratingBar.setRating(mdata.get(position).getRating());
        Glide.with(holder.itemView.getContext())
                .load(mdata.get(position).getDrawableResource()) // set the img book Url
                .into(holder.imgBook); // destination path

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class bookviewholder extends RecyclerView.ViewHolder {


        ImageView imgBook;
        TextView title,author,pages,rate;
        RatingBar ratingBar;

        public bookviewholder(@NonNull View itemView) {
            super(itemView);


            imgBook = itemView.findViewById(R.id.item_book_img);
            title = itemView.findViewById(R.id.item_book_title);
            author = itemView.findViewById(R.id.item_book_author);
            pages = itemView.findViewById(R.id.item_book_pagesrev);
            rate = itemView.findViewById(R.id.item_book_score);
            ratingBar = itemView.findViewById(R.id.item_book_ratingbar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onBookItemClick(getAdapterPosition(),
                            imgBook,
                            title,
                            author,
                            pages,
                            rate,
                            ratingBar);
                }
            });

        }
    }
}
