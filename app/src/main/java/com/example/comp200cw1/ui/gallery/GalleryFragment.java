package com.example.comp200cw1.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.comp200cw1.R;
import com.example.comp200cw1.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {
    private FragmentGalleryBinding binding;
    private boolean toggleWarning = false;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button selectDateButton = root.findViewById(R.id.button);
        selectDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleWarning) {
                    Toast warning = Toast.makeText(root.getContext(), "Date(s) Unavailable", Toast.LENGTH_SHORT);
                    warning.show();
                } else {
                    Toast applied = Toast.makeText(root.getContext(), "Application Submitted", Toast.LENGTH_SHORT);
                    applied.show();
                }

                toggleWarning = !toggleWarning;
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}