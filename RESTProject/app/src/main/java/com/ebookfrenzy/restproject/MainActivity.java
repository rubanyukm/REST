package com.ebookfrenzy.restproject;

import android.os.Bundle;
import android.util.Log;

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

        //CREATE AN INSTANCE OF GSON
        final Gson gson = new Gson();

        //CREATE AN INSTANCE OF REQUEST QUEUE
        RequestQueue queue = Volley.newRequestQueue(this);

        //GET THE URL STRING TO THE JASON FILE
        String url = "http://198.199.80.235/cps276/cps276_examples/datasources/names_json_251v2.json";


        // CREATES AN INSTANCE OF A JSONOBJECT REQUEST
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(

                //WE ARE SENDING A GET REQUEST (WE ARE GETTING A FILE)
                Request.Method.GET,

                //THIS IS THE URL
                url,

                null,

                new Response.Listener<JSONObject>() {

                    //THIS LISTENS FOR THE RESPONSE
                    @Override
                    public void onResponse(JSONObject response) {

                        // USE METHOD fromJson TO DESERALIZE THE SPECIFED JSON INTO AN OBJECT OF THE SPECIFIED CLASS.                  // of the specified class
                        Names names = gson.fromJson(response.toString(), Names.class);


                        //GETS THE COUPON LIST FROM COUPONSWRAPPER AND PUTS IT INTO cpnlst AND ADDS IT AS A PARAMTER
                        //TO THE RecyclerViewAdaptor() CONSTRUCTOR

                        ArrayList<Names> nameList = names.getNameList();
                        RecyclerViewAdapter adapter = new RecyclerViewAdapter(nameList);
                        recyclerView.setAdapter(adapter);

                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (null != error.networkResponse)
                        {

                        }
                    }
                }
        );

        //ADDS OUR REQUEST TO THE QUE FOR PROCESSING.
        queue.add(jsonObjectRequest);
    }
}