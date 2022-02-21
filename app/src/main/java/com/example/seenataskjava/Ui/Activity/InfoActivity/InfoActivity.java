package com.example.seenataskjava.Ui.Activity.InfoActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.seenataskjava.Model.Book;
import com.example.seenataskjava.R;
import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {
    ImageView imageItemInfo;
    Book book;
    TextView title;
    TextView publishedBy;
    TextView rating;
    TextView summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageItemInfo = findViewById(R.id.ImageInfo);
        title = findViewById(R.id.title);
        publishedBy = findViewById(R.id.published_by);
        rating = findViewById(R.id.rating);
        summary = findViewById(R.id.summary);


        book = getIntent().getParcelableExtra("book");


        Picasso.get()
                .load(book.book_image)
                .into(imageItemInfo);

        title.setText(book.title);
        publishedBy.setText(book.publisher);
        rating.setText(book.rank+"");
        summary.setText(book.description);

    }

}
