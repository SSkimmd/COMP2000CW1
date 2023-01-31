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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    public void onClickEmployee(Button button, int id) {

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