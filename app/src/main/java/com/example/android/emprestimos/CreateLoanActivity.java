package com.example.android.emprestimos;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class CreateLoanActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private EditText loanDateEditText;
    private EditText devolutionDateEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_loan);
        setTitle("Adicionar Empréstimo");

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        loanDateEditText = (EditText) findViewById(R.id.loanDateEditText);
        devolutionDateEditText = (EditText) findViewById(R.id.devolutionDateEditText);

        setListeners();
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

    public void showDatePickerDialog(View v, int id) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setCallerId(id);
        newFragment.show(getFragmentManager(), "datePicker");
    }

    private void setListeners() {

        loanDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v, R.id.loanDateEditText);
            }
        });

        devolutionDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v, R.id.devolutionDateEditText);
            }
        });

    }
}
