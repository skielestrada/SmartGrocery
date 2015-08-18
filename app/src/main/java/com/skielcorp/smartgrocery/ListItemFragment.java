package com.skielcorp.smartgrocery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.skielcorp.smartgrocery.db.*;

/**
 * Created by ezequiel.estrada on 15/08/2015.
 */
public class ListItemFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_items_list, container, false);

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
