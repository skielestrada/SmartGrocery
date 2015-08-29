package com.skielcorp.smartgrocery.item;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.skielcorp.smartgrocery.R;
import com.skielcorp.smartgrocery.db.TABLE_ITEMS;
import com.skielcorp.smartgrocery.model.ItemModel;

/**
 * Created by ezequiel.estrada on 15/08/2015.
 */
public class ListItemFragment extends Fragment {

    private ItemModel model;
    private ListView itemslist;

    @Override
    public void onStart() {
        super.onStart();

        Cursor cursor = model.getAllItems();
        String[] from = {TABLE_ITEMS.ID, TABLE_ITEMS.NAME};
        int[] to = {R.id.item_id,R.id.item_name};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity(), R.layout.format_items_list, cursor, from, to, 0);
        itemslist.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_items_list, container, false);

        model = new ItemModel(getActivity());

        itemslist = (ListView)rootView.findViewById(R.id.listView);
        itemslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv_itemid = (TextView) view.findViewById(R.id.item_id);
                TextView tv_itemname = (TextView) view.findViewById(R.id.item_name);

                String itemid = tv_itemid.getText().toString();
                String itemname = tv_itemname.getText().toString();

                Intent intent = new Intent(getActivity(), EditItemActivity.class);
                intent.putExtra("item_id", itemid);
                intent.putExtra("item_name", itemname);

                startActivity(intent);
            }
        });


        Button buttonAdd = (Button)rootView.findViewById(R.id.buttonAddNewItem);
            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), AddItemActivity.class);
                    startActivity(intent);
                }
            });

        return rootView;
    }
}
