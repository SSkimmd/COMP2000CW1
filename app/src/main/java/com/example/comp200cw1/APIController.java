package com.example.comp200cw1;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.transform.ErrorListener;

public class APIController {
    public static RequestQueue queue;

    public static void SetRequestQueue(Context context) {
        queue = RequestController.getInstance(context).getRequestQueue();
    }

    public static void GETEmployees(RequestQueue queue, String url) {
        JsonArrayRequest GetEmployeeRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                EmployeeController.UpdateEmployees(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(GetEmployeeRequest);
    }

    public static void GETEmployee() {

    }

    public static void POSTEmployee(RequestQueue queue, String url, JSONObject body) {
        JsonObjectRequest PutEmployeeRequest = new JsonObjectRequest(Request.Method.POST, url, body, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.print(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(PutEmployeeRequest);
    }

    public static void PUTEmployee(RequestQueue queue, String url, JSONObject body) {
        JsonObjectRequest PutEmployeeRequest = new JsonObjectRequest(Request.Method.PUT, url, body, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.print(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(PutEmployeeRequest);
    }
}
