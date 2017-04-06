package edu.depaul.csc472.greathousesofwesteros;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 10/31/16.
 */

public class HouseActivity extends Activity{
    ArrayList<NotableMember> members = new ArrayList<>();
    int firstSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_layout);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();

        if (intent != null) {
            TextView name = (TextView) findViewById(R.id.house_name);
            TextView description = (TextView) findViewById(R.id.description);
            ImageView icon = (ImageView) findViewById(R.id.sigil);
            name.setText("House "+intent.getCharSequenceExtra("HouseName"));
            description.setText(intent.getCharSequenceExtra("HouseHistory"));
            icon.setImageResource(intent.getIntExtra("Sigil", -1));
            members = intent.getParcelableArrayListExtra("Members");
        }


        List<String> list = new ArrayList<>();
        for(NotableMember m:members){
            list.add(m.getName());
        }
        list.add("Notable Members");

        final int listsize = list.size() - 1;
        firstSelection = listsize;

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list) {
            @Override
            public int getCount() {
                return(listsize); // Truncate the list
            }
        };

        Spinner dropDown = (Spinner)findViewById(R.id.spinner);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDown.setAdapter(dataAdapter);
        dropDown.setSelection(listsize);
        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(firstSelection == position){
                    return;
                }else {
                    Intent intent = new Intent(HouseActivity.this, MemberActivity.class);
                    intent.putExtra("MemberName", members.get(position).getName());
                    intent.putExtra("MemberDescription", members.get(position).getDescription());
                    intent.putExtra("Sigil", House.getIconResource(members.get(position).getLastName()));
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
