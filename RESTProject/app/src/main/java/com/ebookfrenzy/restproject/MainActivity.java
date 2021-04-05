package com.ebookfrenzy.restproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import com.google.gson.Gson;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.coupons_rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        final Gson gson = new Gson();

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://198.199.80.235/cps276/cps276_examples/datasources/names_json_251v2.json";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(

                Request.Method.GET,

                url,

                null,

                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        Names names = gson.fromJson(response.toString(), Names.class);

                        ArrayList<Names> nameList = names.getNameList();
                        RecyclerViewAdapter adapter = new RecyclerViewAdapter(nameList);
                        recyclerView.setAdapter(adapter);

                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (null != error.networkResponse) {

                        }
                    }
                }
        );

        queue.add(jsonObjectRequest);
    }
}