package com.example.jet_compose_live_data;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        listView.setAdapter(adapter);

        ListManager.getInstance().getListLiveData().observe(this, updatedList -> {
            adapter.clear();
            adapter.addAll(updatedList);
            adapter.notifyDataSetChanged();
        });

        findViewById(R.id.addButton).setOnClickListener(v -> ListManager.getInstance().addItem("New Item"));

        findViewById(R.id.removeButton).setOnClickListener(v -> ListManager.getInstance().removeItem("New Item"));

        findViewById(R.id.nextActivityButton).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }

}