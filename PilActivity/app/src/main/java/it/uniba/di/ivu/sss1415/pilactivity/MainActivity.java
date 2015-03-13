package it.uniba.di.ivu.sss1415.pilactivity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    private static final String TEXT_ACTIVITY_1 = "TEXT_ACTIVITY_1";
    private EditText editTextActivity1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextActivity1 = (EditText) findViewById(R.id.editTextActivity1);
        Button btnHome = (Button) findViewById(R.id.buttonActivity2);

        if (savedInstanceState != null){
            editTextActivity1.setText(savedInstanceState.getString(TEXT_ACTIVITY_1));
        }

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //prima definisco l'intenzione di aprire un'altra activity
                Intent apriActivity2 = new Intent(MainActivity.this, Activity2.class);

                //passo il valore di editTextActivity1 all'Activity2 identificata dall'Intent
                apriActivity2.putExtra(TEXT_ACTIVITY_1, editTextActivity1.getText().toString());

                //faccio partire l'Intent
                startActivity(apriActivity2);
            }
        });

    }

    //salva i valori del totale e della percentuale attuale
    @Override
    protected void onSaveInstanceState(Bundle statoDaSalvare){
        super.onSaveInstanceState(statoDaSalvare);
        statoDaSalvare.putString(TEXT_ACTIVITY_1, editTextActivity1.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
