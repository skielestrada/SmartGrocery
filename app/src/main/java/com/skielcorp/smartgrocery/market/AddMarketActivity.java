package com.skielcorp.smartgrocery.market;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.skielcorp.smartgrocery.R;
import com.skielcorp.smartgrocery.model.MarketModel;

public class AddMarketActivity extends Activity {

    private MarketModel model;

    private EditText textMarketName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_markets_add);

        model = new MarketModel(this);

        textMarketName = (EditText) findViewById(R.id.textMarketName);
    }

    public void addMarket(View view) {
        String name = textMarketName.getText().toString();

        if(name.isEmpty()) {
            Toast.makeText(getBaseContext(), getString(R.string.error_name_value), Toast.LENGTH_SHORT).show();
        } else {
            model.addMarket(name);
            finish();
        }
    }
}
