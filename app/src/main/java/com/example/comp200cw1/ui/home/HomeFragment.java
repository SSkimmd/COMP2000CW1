package com.example.comp200cw1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.comp200cw1.APIController;
import com.example.comp200cw1.Employee;
import com.example.comp200cw1.EmployeeController;
import com.example.comp200cw1.R;
import com.example.comp200cw1.RequestController;
import com.example.comp200cw1.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private EditText Forename;
    private EditText Surname;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Forename = root.findViewById(R.id.username);
        Surname = root.findViewById(R.id.password);

        APIController.SetRequestQueue(this.getContext().getApplicationContext());
        UpdateDB();

        Button loginButton = root.findViewById(R.id.button4);
        loginButton.setOnClickListener(view -> {
            Login();
        });

        Button createButton = root.findViewById(R.id.button5);
        createButton.setOnClickListener(view -> {
            Create();
        });

        return root;
    }

    private void UpdateDB() {
        String url = "http://web.socem.plymouth.ac.uk/COMP2000/api/Employees";
        RequestQueue requests = APIController.queue;

        APIController.GETEmployees(requests, url);
    }

    public void Login() {
        String forename = Forename.getText().toString();
        String surname = Surname.getText().toString();

        if(EmployeeController.Login(forename, surname)) {
            Toast.makeText(getContext(), "Logged In", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Incorrect Forename/Surname", Toast.LENGTH_SHORT).show();
        }
    }

    public void Create() {
        String forename = Forename.getText().toString();
        String surname = Surname.getText().toString();

        if(EmployeeController.CreateEmployee(forename, surname)) {
            Toast.makeText(getContext(), "Created Account", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Couldn't Create Account", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}