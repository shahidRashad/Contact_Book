package com.example.contactbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateContact extends AppCompatActivity {

    EditText NameContact, NoCOntact, EmailContact;
    Button addSqlite;
    ImageView showCont;
    MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        NameContact = (EditText) findViewById(R.id.editTextContactName);
        NoCOntact = (EditText) findViewById(R.id.editTextContactNo);
        EmailContact = (EditText) findViewById(R.id.editTextContactEmail);
        addSqlite = (Button) findViewById(R.id.AddSql);
        showCont = (ImageView)findViewById(R.id.message);

        myHandler = new MyHandler(CreateContact.this);

        addSqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ContactName = NameContact.getText().toString();
                String ContactNo = NoCOntact.getText().toString();
                String ContactEmail = EmailContact.getText().toString();

                if (ContactName.isEmpty() || ContactNo.isEmpty() || ContactEmail.isEmpty()){
                    Toast.makeText(CreateContact.this, "Please enter the datas", Toast.LENGTH_SHORT).show();
                    return;
                }
                myHandler.addContact(ContactName, ContactNo, ContactEmail);
                Toast.makeText(CreateContact.this, "Contact has been added", Toast.LENGTH_SHORT).show();
                NameContact.getText().clear();
                NoCOntact.getText().clear();
                EmailContact.getText().clear();
            }
        });

        showCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateContact.this,ViewContact.class);
                startActivity(intent);
            }
        });
    }
}