package com.example.stepappv2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.stepappv2.R;
import com.example.stepappv2.databinding.FragmentHomeBinding;
import com.google.android.material.progressindicator.CircularProgressIndicator;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TextView stepCountsView;
    private CircularProgressIndicator progressBar;
    private int counter = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        stepCountsView = (TextView) root.findViewById(R.id.counter);
        stepCountsView.setText(Integer.toString(counter));

        progressBar = (CircularProgressIndicator) root.findViewById(R.id.progressBar);
        progressBar.setMax(6000);
        progressBar.setProgress(counter);

        return root;
    }

    public void countUp(View view) {

        counter++;
        stepCountsView.setText(Integer.toString(counter));
        progressBar.setProgress(counter);
    }

    public void resetCount(View view) {

        counter = 0;
        stepCountsView.setText(Integer.toString(counter));
        progressBar.setProgress(counter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}