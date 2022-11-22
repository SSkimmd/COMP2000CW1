package com.example.comp200cw1.ui.slideshow;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.comp200cw1.R;
import com.example.comp200cw1.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;
import java.util.Random;

public class SlideshowFragment extends Fragment {
    private FragmentSlideshowBinding binding;
    public ArrayList<Employee> Employees = new ArrayList();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Employee e1 = new Employee("Employee Name", 1, false);
        Employee e2 = new Employee("Employee Name", 2, true);
        Employee e3 = new Employee("Employee Name", 3, false);
        Employee e4 = new Employee("Employee Name", 4, true);
        Employee e5 = new Employee("Employee Name", 5, false);
        Employee e6 = new Employee("Employee Name", 6, true);
        Employee e7 = new Employee("Employee Name", 7, false);
        Employee e8 = new Employee("Employee Name", 8, true);
        Employee e9 = new Employee("Employee Name", 9, false);
        Employee e10 = new Employee("Employee Name", 10, true);
        Employee e11 = new Employee("Employee Name", 11, false);
        Employee e12 = new Employee("Employee Name", 12, true);

        Employees.add(e1);
        Employees.add(e2);
        Employees.add(e3);
        Employees.add(e4);
        Employees.add(e5);
        Employees.add(e6);
        Employees.add(e7);
        Employees.add(e8);
        Employees.add(e9);
        Employees.add(e10);
        Employees.add(e11);
        Employees.add(e12);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        for(int i = 0; i < Employees.size(); i++) {
            LinearLayout layout = binding.getRoot().findViewById(R.id.testLayout1);

            int employeeID = i;

            Button employeeToggle = new AppCompatButton(binding.getRoot().getContext());
            employeeToggle.setTextSize(16);
            employeeToggle.setHeight(260);
            employeeToggle.setBackground(getContext().getDrawable(R.drawable.button_border));
            employeeToggle.setText("" + Employees.get(i).name + " - " + approvedToString(Employees.get(i).approved));

            employeeToggle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickEmployee(employeeToggle, employeeID);
                }
            });

            layout.addView(employeeToggle);
        }

        return root;
    }

    public void onClickEmployee(Button button, int id) {
        Employee employee = Employees.get(id);
        employee.approved = !employee.approved;

        button.setText("" + employee.name + " - " + approvedToString(employee.approved));
    }

    String approvedToString(boolean approved) {
        String r = approved == true ? "Approved" : "Denied";
        return r;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}