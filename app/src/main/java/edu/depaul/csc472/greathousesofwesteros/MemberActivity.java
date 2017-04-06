package edu.depaul.csc472.greathousesofwesteros;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Marco on 10/31/16.
 */

public class MemberActivity extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_layout);

    }

    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        if (intent != null) {
            TextView name = (TextView) findViewById(R.id.name);
            TextView description = (TextView) findViewById(R.id.description);
            ImageView icon = (ImageView) findViewById(R.id.sigil);
            name.setText(intent.getCharSequenceExtra("MemberName"));
            description.setText(intent.getCharSequenceExtra("MemberDescription"));
            icon.setImageResource(intent.getIntExtra("Sigil", -1));
        }
    }







}
