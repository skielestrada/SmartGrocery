package com.skielcorp.smartgrocery.item;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.skielcorp.smartgrocery.R;
import com.skielcorp.smartgrocery.model.ItemModel;


public class AddItemActivity extends Activity {

    private EditText textName;
    private ItemModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_items_add);

        model = new ItemModel(this);

        textName = (EditText)findViewById(R.id.textName);
    }

    public void addItem(View view) {
        String name = textName.getText().toString();

        if(name.isEmpty()) {
            Toast.makeText(getBaseContext(), getString(R.string.error_name_value),Toast.LENGTH_SHORT).show();
        } else {
            model.addItem(name);

            finish();
        }
    }
}
