package com.example.seenataskjava.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Book implements Parcelable {
    public int rank;
    public int rank_last_week;
    public int weeks_on_list;
    public int asterisk;
    public int dagger;
    public String primary_isbn10;
    public String primary_isbn13;
    public String publisher;
    public String description;
    public String price;
    public String title;
    public String author;
    public String contributor;
    public String contributor_note;
    public String book_image;
    public int book_image_width;
    public int book_image_height;
    public String amazon_product_url;
    public String age_group;
    public String book_review_link;
    public String first_chapter_link;
    public String sunday_review_link;
    public String article_chapter_link;
    public ArrayList<Isbn> isbns;
    public ArrayList<BuyLink> buy_links;
    public String book_uri;



    /**
     * these only for parcelable
     */

    protected Book(Parcel in) {
        rank = in.readInt();
        rank_last_week = in.readInt();
        weeks_on_list = in.readInt();
        asterisk = in.readInt();
        dagger = in.readInt();
        primary_isbn10 = in.readString();
        primary_isbn13 = in.readString();
        publisher = in.readString();
        description = in.readString();
        price = in.readString();
        title = in.readString();
        author = in.readString();
        contributor = in.readString();
        contributor_note = in.readString();
        book_image = in.readString();
        book_image_width = in.readInt();
        book_image_height = in.readInt();
        amazon_product_url = in.readString();
        age_group = in.readString();
        book_review_link = in.readString();
        first_chapter_link = in.readString();
        sunday_review_link = in.readString();
        article_chapter_link = in.readString();
        book_uri = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(rank);
        parcel.writeInt(rank_last_week);
        parcel.writeInt(weeks_on_list);
        parcel.writeInt(asterisk);
        parcel.writeInt(dagger);
        parcel.writeString(primary_isbn10);
        parcel.writeString(primary_isbn13);
        parcel.writeString(publisher);
        parcel.writeString(description);
        parcel.writeString(price);
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(contributor);
        parcel.writeString(contributor_note);
        parcel.writeString(book_image);
        parcel.writeInt(book_image_width);
        parcel.writeInt(book_image_height);
        parcel.writeString(amazon_product_url);
        parcel.writeString(age_group);
        parcel.writeString(book_review_link);
        parcel.writeString(first_chapter_link);
        parcel.writeString(sunday_review_link);
        parcel.writeString(article_chapter_link);
        parcel.writeString(book_uri);
    }
}
