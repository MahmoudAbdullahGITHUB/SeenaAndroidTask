package com.example.seenataskjava.Ui.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seenataskjava.Model.Book;
import com.example.seenataskjava.R;
import com.example.seenataskjava.Ui.Activity.InfoActivity.InfoActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private ArrayList<Book> booksList = new ArrayList<>();
    Context context;

    public BookAdapter(Context context, ArrayList<Book> booksList) {
        this.context = context;
        this.booksList = booksList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new BookViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.text1.setText(booksList.get(position).title);
        holder.text2.setText(booksList.get(position).description);

        Picasso.get()
                .load(booksList.get(position).book_image)
                .into(holder.imageItemId);

        holder.myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(context, InfoActivity.class);

                intent.putExtra("book", booksList.get(holder.getAdapterPosition()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView imageItemId;
        TextView text1;
        TextView text2;
        View myView;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            myView = itemView;
            imageItemId = itemView.findViewById(R.id.image_item_id);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
        }
    }
}