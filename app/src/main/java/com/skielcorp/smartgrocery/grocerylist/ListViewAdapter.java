package com.skielcorp.smartgrocery.grocerylist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.skielcorp.smartgrocery.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ezequiel.estrada on 21/08/2015.
 */
public class ListViewAdapter extends BaseAdapter {

    private String TAG = "SmartGrocery";

    private Context ctx;
    private Map<String, String> mapItems;

    public ListViewAdapter(Context ctx, Map<String, String> mapItems) {
        this.ctx = ctx;
        this.mapItems = mapItems;
    }

    @Override
    public int getCount() {
        return mapItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.format_groceryitems_list, parent, false);

        TextView pos = (TextView) view.findViewById(R.id.textView7);
            pos.setText(String.valueOf(position + 1));

        String[] itemValue = getItemdbyPosition(position);

        EditText item = (EditText) view.findViewById(R.id.itemListedName);
            item.setText(itemValue[1]);
            item.setEnabled(false);

        TextView id = (TextView) view.findViewById(R.id.itemListedId);
            id.setText(itemValue[0]);

        return view;
    }

    private String[] getItemdbyPosition(int position) {
        Iterator myVeryOwnIterator = mapItems.keySet().iterator();
        int counter = 0;
        while(myVeryOwnIterator.hasNext()) {
            String key = (String)myVeryOwnIterator.next();
            if(counter == position)
            {
                String[] item = {key, mapItems.get(key)};
                return item;
            }
            counter++;
        }

        return null;
    }
}
