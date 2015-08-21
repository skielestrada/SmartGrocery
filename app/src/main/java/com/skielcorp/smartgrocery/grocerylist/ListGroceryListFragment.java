package com.skielcorp.smartgrocery.grocerylist;


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
import com.skielcorp.smartgrocery.db.TABLE_GROCERYLIST;
import com.skielcorp.smartgrocery.model.GroceryListModel;

public class ListGroceryListFragment extends Fragment {

    private ListView GroceryList;
    private GroceryListModel model;

    @Override
    public void onStart() {
        super.onStart();

        Cursor cursor = model.getAllGroceryLists();
        String[] from = {TABLE_GROCERYLIST.ID, TABLE_GROCERYLIST.NAME, TABLE_GROCERYLIST.DATE};
        int[] to = {R.id.grocerylist_id, R.id.grocerylist_name, R.id.grocerylist_date};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity(), R.layout.format_grocerylist_list, cursor, from, to, 0);
        GroceryList.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_grocerylist_list, container, false);

        model = new GroceryListModel(getActivity());

        GroceryList = (ListView)rootView.findViewById(R.id.listViewGroceryList);
        GroceryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv_grocerylist_id = (TextView) view.findViewById(R.id.grocerylist_id);
                TextView tv_grocerylist_name = (TextView) view.findViewById(R.id.grocerylist_name);
                TextView tv_grocerylist_date = (TextView) view.findViewById(R.id.grocerylist_date);

                String grocerylistid = tv_grocerylist_id.getText().toString();
                String grocerylistname = tv_grocerylist_name.getText().toString();
                String grocerylistdate = tv_grocerylist_date.getText().toString();

                Intent intent = new Intent(getActivity(), FillGroceryListActivity.class);
                    intent.putExtra("grocerylist_id", grocerylistid);
                    intent.putExtra("grocerylist_name", grocerylistname);
                    intent.putExtra("grocerylist_date", grocerylistdate);

                startActivity(intent);
            }
        });

        Button buttonAddGroceryList = (Button)rootView.findViewById(R.id.buttonAddGroceryList);
        buttonAddGroceryList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddGroceryListActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
