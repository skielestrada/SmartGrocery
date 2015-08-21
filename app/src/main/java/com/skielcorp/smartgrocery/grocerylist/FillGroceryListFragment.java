package com.skielcorp.smartgrocery.grocerylist;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skielcorp.smartgrocery.R;

public class FillGroceryListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.layout_grocerylist_fill, container, false);

        Intent i = getActivity().getIntent();

        int grocerylist_id = Integer.parseInt(i.getStringExtra("grocerylist_id"));
        String grocerylist_name = i.getStringExtra("grocerylist_name");
        String grocerylist_date = i.getStringExtra("grocerylist_date");

        TextView labelName = (TextView) rootView.findViewById(R.id.grocerylist_name);
            labelName.setText(grocerylist_name);

        TextView labelDate = (TextView) rootView.findViewById(R.id.grocerylist_date);
            labelDate.setText(grocerylist_date);


        return rootView;
    }
}
