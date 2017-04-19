package com.example.android.emprestimos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.emprestimos.models.Person;

public class CreatePersonActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button createButton;
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private String callingActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_person);
        setTitle("Adicionar Pessoa");

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        createButton = (Button) findViewById(R.id.createButton);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        phoneEditText = (EditText) findViewById(R.id.phoneEditText);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //checa qual activity/fragment está chamando e edita o necessário
        callingActivity = getIntent().getStringExtra("callingActivity");
        if(callingActivity.equals("PEOPLE_FRAGMENT")) {
            Person person = (Person) getIntent().getSerializableExtra("EDIT_PERSON");

            setTitle("Editar pessoa");
            createButton.setText("Atualizar");

            nameEditText.setText(person.getName());
            emailEditText.setText(person.getEmail());
            phoneEditText.setText(person.getPhone());
        }

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

    private void setListeners() {

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                Intent intent = new Intent();

                if(callingActivity.equals("PEOPLE_FRAGMENT")) {
                    person = (Person) getIntent().getSerializableExtra("EDIT_PERSON");
                    intent.putExtra("PRE_PERSON", person);
                }

                if ( !TextUtils.isEmpty(name) ) {

                    person.setName(name);
                    person.setEmail(email);
                    person.setPhone(phone);

                    intent.putExtra("PERSON", person);

                    setResult(RESULT_OK, intent);
                    finish();

                } else {

                    Toast.makeText(CreatePersonActivity.this, "Você precisa preencher o nome.",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}
