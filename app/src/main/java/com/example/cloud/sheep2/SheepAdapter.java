package com.example.cloud.sheep2;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

/**
 * Created by cloud on 2017/12/14.
 */

public class SheepAdapter extends RealmBaseAdapter<Item> {
    private static class ViewHolder{
        TextView name;
        TextView k;
        TextView id;
    }
    public SheepAdapter(@Nullable OrderedRealmCollection<Item> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView==null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(android.R.id.text1);
            viewHolder.k = convertView.findViewById(android.R.id.text2);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }

        Item item=adapterData.get(position);
        viewHolder.name.setText(item.getName());
        viewHolder.k.setText(item.getK());

        return convertView;
    }
}

