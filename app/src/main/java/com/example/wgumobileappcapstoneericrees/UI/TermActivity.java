package com.example.wgumobileappcapstoneericrees.UI;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wgumobileappcapstoneericrees.Database.WGUMobileAppCapstoneDB;
import com.example.wgumobileappcapstoneericrees.Entity.Term;
import com.example.wgumobileappcapstoneericrees.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TermActivity extends AppCompatActivity {
    WGUMobileAppCapstoneDB db;
    FloatingActionButton FABAddTerm;
    RecyclerView rvTerm;
    EditText searchTerm;
    LinearLayoutManager linearLayoutManager;
    TermAdapter adapter;
    private List<Term> mTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);
        db = WGUMobileAppCapstoneDB.getInstance(getApplicationContext());
        FABAddTerm = findViewById(R.id.FAB_addTerm);
        rvTerm = findViewById(R.id.rv_terms);
        searchTerm = findViewById(R.id.searchTerm);
        mTerms = db.termDAO().getAllTerms();

        setTermAdapter();

        // Set add term floating action button
        FABAddTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TermActivity.this, AddTermActivity.class);
                startActivity(intent);
            }
        });

        // Set search term
        searchTerm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    // Set term adapter for recycler view
    private void setTermAdapter() {
        // Initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(this);
        // Set layout manager
        rvTerm.setLayoutManager(linearLayoutManager);
        // Initialize adapter
        adapter = new TermAdapter(mTerms, this);
        // Set adapter
        rvTerm.setAdapter(adapter);
        adapter.setWords(db.termDAO().getAllTerms());
    }

    // Method to filter search terms text
    private void filter(String text) {
        ArrayList<Term> filteredList = new ArrayList<>();
        for (Term term : mTerms) {
            if (term.getTermName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(term);
            }
        }
        adapter.filterList(filteredList);
    }

    // Menu setup
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // WGU icon sends to home screen
        if (id == R.id.home) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}