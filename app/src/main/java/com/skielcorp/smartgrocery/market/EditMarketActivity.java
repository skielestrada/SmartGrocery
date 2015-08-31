package com.skielcorp.smartgrocery.market;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.skielcorp.smartgrocery.R;
import com.skielcorp.smartgrocery.model.MarketModel;

public class EditMarketActivity extends Activity {

    private MarketModel model;
    private String marketId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_markets_edit);

        model = new MarketModel(this);

        marketId = getIntent().getStringExtra("market_id");
        String marketName = getIntent().getStringExtra("market_name");

        TextView textViewMarketId = (TextView) findViewById(R.id.textViewMarketId);
        textViewMarketId.setText(String.valueOf(marketId));

        EditText textMarketName = (EditText) findViewById(R.id.textMarketName);
        textMarketName.setText(marketName);
    }

    public void updateMarket(View view) {
        EditText textMarketName = (EditText) findViewById(R.id.textMarketName);
        String marketName = textMarketName.getText().toString();

        if(marketName.isEmpty()) {
            Toast.makeText(getBaseContext(), getString(R.string.error_name_value), Toast.LENGTH_SHORT).show();
        } else {
            model.updateMarket(marketId, marketName);

            finish();
        }
    }

    public void deleteMerket(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?");
        builder.setNegativeButton("NO", null);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                model.deleteMarket(marketId);
                finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
