package com.threetabsapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 21/04/2016.
 */
public class MusicFragment extends Fragment {
    private ImageAdapter mAdapter;
    private List<Integer> mMusicItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.music_fragment, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.music_items);
        setStaticData();
        mAdapter = new ImageAdapter(getActivity(), mMusicItems);
        gridView.setAdapter(mAdapter);
        return rootView;
    }

    public void setStaticData() {
        mMusicItems = new ArrayList<>();
        mMusicItems.add(R.drawable.music1);
        mMusicItems.add(R.drawable.music2);
        mMusicItems.add(R.drawable.music3);
        mMusicItems.add(R.drawable.music4);
        mMusicItems.add(R.drawable.music5);
        mMusicItems.add(R.drawable.music6);
        mMusicItems.add(R.drawable.music7);
        mMusicItems.add(R.drawable.music8);
    }

    public class ImageAdapter extends ArrayAdapter {

        public ImageAdapter(Context context, List<Integer> resource) {
            super(context, R.layout.music_item, resource);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Integer image = (Integer) getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.music_item, parent, false);
            }
            ImageView imageView = (ImageView) convertView.findViewById(R.id.music_image);
            imageView.setImageResource(image);
            return convertView;
        }
    }
}
