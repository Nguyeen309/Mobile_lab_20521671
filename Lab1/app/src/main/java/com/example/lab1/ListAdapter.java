package com.example.lab1;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    public ListAdapter(Context ctx)
    {
        context = ctx;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.active_custom_listview, null);
        return view;
    }
}
