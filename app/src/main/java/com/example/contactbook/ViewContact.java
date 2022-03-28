package com.example.contactbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewContact extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyHandler myHandler;
    private ArrayList<ContactModel> contactModelArrayList;
    private CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerContact);
        contactModelArrayList = new ArrayList<>();
        myHandler = new MyHandler(ViewContact.this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewContact.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        contactModelArrayList = myHandler.readContact();
        courseAdapter = new CourseAdapter(contactModelArrayList,ViewContact.this);
        recyclerView.setAdapter(courseAdapter);


    }
}