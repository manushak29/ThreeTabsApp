package com.threetabsapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Anna on 21/04/2016.
 */
public class BooksFragment extends Fragment {
    private BookListAdapter adapter;
    private List<BookListItem> bookList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.books_fragment, container, false);
        setStaticData();
        adapter = new BookListAdapter(getActivity(), bookList);
        ListView listview = (ListView) rootView.findViewById(R.id.book_list);
        listview.setAdapter(adapter);
        return rootView;
    }


    public void setStaticData(){
        bookList = new ArrayList<>();
        bookList.add(new BookListItem(R.drawable.book1, "Comfort Zone", "Lindsay Tanner"));
        bookList.add(new BookListItem(R.drawable.book2, "Iris and the Tiger", "Leanne Hall"));
        bookList.add(new BookListItem(R.drawable.book3, "Spirits of the Ghan", "Judy Nunn"));
        bookList.add(new BookListItem(R.drawable.book4, "The River House", "Janita Cunnington"));
        bookList.add(new BookListItem(R.drawable.book5, "The Grass is Greener", "Loretta Hill"));
    }


    public class BookListAdapter extends ArrayAdapter {

        public BookListAdapter(Context context, List<BookListItem> resource) {
            super(context, R.layout.book_list_item, resource);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.book_list_item, parent, false);
            }

            BookListItem item = bookList.get(position);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.poster);
            imageView.setImageResource(item.getPoster());
            TextView title = (TextView) convertView.findViewById(R.id.book_title);
            title.setText(item.getTitle());
            TextView author = (TextView) convertView.findViewById(R.id.book_author);
            author.setText(item.getAuthor());
            return convertView;
        }


    }


    public class BookListItem {
        private int poster;
        private String title;
        private String author;

        public BookListItem(int poster, String title, String author) {
            this.poster = poster;
            this.title = title;
            this.author = author;
        }

        public int getPoster() {
            return poster;
        }


        public String getTitle() {
            return title;
        }


        public String getAuthor() {
            return author;
        }


    }
}
