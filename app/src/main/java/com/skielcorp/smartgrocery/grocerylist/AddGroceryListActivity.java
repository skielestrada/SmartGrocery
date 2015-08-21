package com.skielcorp.smartgrocery.grocerylist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.skielcorp.smartgrocery.R;
import com.skielcorp.smartgrocery.model.GroceryListModel;

public class AddGroceryListActivity extends Activity {

    private EditText textName;
    private EditText textDate;
    private GroceryListModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_grocerylist_add);

        model = new GroceryListModel(this);

        textName = (EditText)findViewById(R.id.textName);
        textDate = (EditText)findViewById(R.id.textDate);
    }

    public void addGroceryList(View view) {
        String name = textName.getText().toString();
        String date = textDate.getText().toString();

        if(name.isEmpty()) {
            Toast.makeText(getBaseContext(), getString(R.string.error_name_value), Toast.LENGTH_SHORT).show();
        } else if(date.isEmpty()) {
            Toast.makeText(getBaseContext(), getString(R.string.error_date_value), Toast.LENGTH_SHORT).show();
        } else {
            model.addGroceryList(name, date);

            finish();
        }
    }

}
