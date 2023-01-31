package com.example.comp200cw1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EditDetailsFragment extends Fragment {
    public EditDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_edit_details, container, false);

        Button applyEditDetails = root.findViewById(R.id.updateEditDetails);
        applyEditDetails.setOnClickListener(view -> {
            EditText editForename = root.findViewById(R.id.editForename);
            EditText editSurname = root.findViewById(R.id.editSurname);
            EditText editID = root.findViewById(R.id.editForename2);

            int id = Integer.parseInt(editID.getText().toString());
            String forename = editForename.getText().toString();
            String surname = editSurname.getText().toString();

            EmployeeController.UpdateEmployee(id, forename, surname);
        });

        return root;
    }
}