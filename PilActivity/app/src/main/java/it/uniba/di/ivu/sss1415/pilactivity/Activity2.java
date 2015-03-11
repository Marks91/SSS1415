package it.uniba.di.ivu.sss1415.pilactivity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity2 extends ActionBarActivity {
    private static final String TEXT_ACTIVITY_1 = "TEXT_ACTIVITY_1";
    private TextView textViewActivity2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        textViewActivity2 = (TextView) findViewById(R.id.textViewActivity2);
        Intent intent = getIntent();
        textViewActivity2.setText(intent.getStringExtra(TEXT_ACTIVITY_1));

        Button btnActivity2Obj=(Button)findViewById(R.id.buttonActivity3);
        btnActivity2Obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //prima definisco l'intenzione di aprire un'altra activity
                Intent openActivity3 = new Intent(Activity2.this, Activity3.class);
                //faccio partire l'Intent
                startActivity(openActivity3);
            }
        });
        if (savedInstanceState != null) {
            textViewActivity2.setText(savedInstanceState.getString(TEXT_ACTIVITY_1));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
