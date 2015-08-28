package com.skielcorp.smartgrocery.grocerylist;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.skielcorp.smartgrocery.R;
import com.skielcorp.smartgrocery.db.TABLE_GROCERYLIST;
import com.skielcorp.smartgrocery.model.GroceryListModel;

import java.util.HashMap;
import java.util.Map;

public class FillGroceryListFragment extends Fragment {

    private String TAG = "SmartGrocery";

    private String grocerylist_id;

    private ListViewAdapter adapter;
    private AutoCompleteTextView newItem;

    private ListView list;
    private Map<String,String> mapitemsListed;

    private GroceryListModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        model = new GroceryListModel(getActivity());

        View rootView = inflater.inflate(R.layout.layout_grocerylist_fill, container, false);

        Intent i = getActivity().getIntent();

        grocerylist_id = i.getStringExtra("grocerylist_id");
        String grocerylist_name = i.getStringExtra("grocerylist_name");
        String grocerylist_date = i.getStringExtra("grocerylist_date");

        TextView labelName = (TextView) rootView.findViewById(R.id.grocerylist_name);
            labelName.setText(grocerylist_name);

        TextView labelDate = (TextView) rootView.findViewById(R.id.grocerylist_date);
            labelDate.setText(grocerylist_date);

        mapitemsListed = model.getAllItemsGroceryList(grocerylist_id);

        adapter = new ListViewAdapter(getActivity(), mapitemsListed);
        list = (ListView)rootView.findViewById(R.id.GroceryList);
            list.setAdapter(adapter);

        String[] from = {TABLE_GROCERYLIST.NAME};
        int[] to = {R.id.textAutocomplete};

        SimpleCursorAdapter adapterAutocomplete = new SimpleCursorAdapter(getActivity(), R.layout.format_items_autocomplete, null, from, to, SimpleCursorAdapter.NO_SELECTION);
        adapterAutocomplete.setFilterQueryProvider(new FilterQueryProvider() {
            @Override
            public Cursor runQuery(CharSequence constraint) {
                return model.getAllMatchingItems(constraint.toString());
            }
        });

        newItem = (AutoCompleteTextView) rootView.findViewById(R.id.itemListedName);
            newItem.setAdapter(adapterAutocomplete);
            newItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Cursor cursor = (Cursor) parent.getItemAtPosition(position);
                    String idItem = cursor.getString(cursor.getColumnIndexOrThrow(TABLE_GROCERYLIST.ID));
                    String nameItem = cursor.getString(cursor.getColumnIndexOrThrow(TABLE_GROCERYLIST.NAME));
                    if (mapitemsListed.containsValue(nameItem)) {
                        Toast.makeText(getActivity(), getString(R.string.error_item_listed), Toast.LENGTH_SHORT).show();
                    } else {
                        mapitemsListed.put(idItem, nameItem);
                        adapter.notifyDataSetChanged();
                    }
                    newItem.setText("");
                }
            });


        Button buttonAddGroceryList = (Button)rootView.findViewById(R.id.buttonEditGroceryList);
        buttonAddGroceryList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0; i<list.getCount(); i++) {
                    View view = list.getChildAt(i);
                    TextView item = (TextView) view.findViewById(R.id.itemListedId);

                    model.addItemsGroceryList(grocerylist_id, item.getText().toString());
                }
            }
        });

        return rootView;
    }
}
