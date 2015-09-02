package com.skielcorp.smartgrocery.market;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.skielcorp.smartgrocery.R;
import com.skielcorp.smartgrocery.db.TABLE_MARKETS;
import com.skielcorp.smartgrocery.model.MarketModel;

public class ListMarketFragment extends Fragment {

    private MarketModel model;
    private ListView marketsList;

    @Override
    public void onStart() {
        super.onStart();

        Cursor cursor = model.getAllMarkets();
        String[] from = {TABLE_MARKETS.ID, TABLE_MARKETS.NAME};
        int[] to = {R.id.market_id,R.id.market_name};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity(), R.layout.format_markets_list, cursor, from, to, 0);
        marketsList.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_market_list, container, false);

        model = new MarketModel(getActivity());

        marketsList = (ListView) view.findViewById(R.id.listView_Martkets);
        marketsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView market_id = (TextView) view.findViewById(R.id.market_id);
                TextView market_name = (TextView) view.findViewById(R.id.market_name);

                Intent intent = new Intent(getActivity(), EditMarketActivity.class);
                intent.putExtra("market_id", market_id.getText().toString());
                intent.putExtra("market_name", market_name.getText().toString());

                startActivity(intent);
            }
        });

        Button button = (Button) view.findViewById(R.id.button_addMarket);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddMarketActivity.class);
                startActivity(intent);
                }
            });

        return view;
    }
}
