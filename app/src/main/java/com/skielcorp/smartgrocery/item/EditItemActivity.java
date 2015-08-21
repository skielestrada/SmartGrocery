package com.skielcorp.smartgrocery.item;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.skielcorp.smartgrocery.R;
import com.skielcorp.smartgrocery.model.ItemModel;


public class EditItemActivity extends Activity {

    private int item_id;
    private ItemModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_items_edit);

        model = new ItemModel(this);

        item_id = Integer.parseInt(getIntent().getStringExtra("item_id"));
        String item_name = getIntent().getStringExtra("item_name");

        TextView labelItemID = (TextView) findViewById(R.id.labelItemID);
            labelItemID.setText(String.valueOf(item_id));

        EditText textItemName = (EditText) findViewById(R.id.textItemtName);
            textItemName.setText(item_name);

    }

    public void updateItem(View view) {
        EditText textItemtName = (EditText) findViewById(R.id.textItemtName);

        String itemname = textItemtName.getText().toString();

        if(itemname.isEmpty()) {
            Toast.makeText(getBaseContext(), getString(R.string.error_name_value), Toast.LENGTH_SHORT).show();
        } else {
            model.updateItem(item_id, itemname);

            finish();
        }
    }

    public void deleteItem(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure?");
            builder.setNegativeButton("NO", null);
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    model.deleteItem(item_id);
                    finish();
                }
            });

        AlertDialog alert = builder.create();
            alert.show();
    }
}
