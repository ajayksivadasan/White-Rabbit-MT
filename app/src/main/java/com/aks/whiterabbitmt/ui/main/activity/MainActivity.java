package com.aks.whiterabbitmt.ui.main.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aks.whiterabbitmt.R;
import com.aks.whiterabbitmt.data.remote.EmployeeDetailsRemote;
import com.aks.whiterabbitmt.databinding.ActivityMainBinding;
import com.aks.whiterabbitmt.ui.main.adapter.RvMainAdapter;
import com.aks.whiterabbitmt.ui.main.view_model.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private Context context;
    private MainViewModel viewModel;
    private List<EmployeeDetailsRemote> employeeDetailsRemoteList = new ArrayList<>();
    private RvMainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initItems();
        viewModel.makeApiCall();
        observers();
        mainBinding.ivSyncData.setOnClickListener(view -> viewModel.makeApiCall());
    }

    private void initItems() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        adapter = new RvMainAdapter(context, employeeDetailsRemoteList);
        mainBinding.rvListEmployees.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        mainBinding.rvListEmployees.setLayoutManager(new LinearLayoutManager(context));
        mainBinding.rvListEmployees.setAdapter(adapter);
    }

    private void observers() {
        viewModel.getListMutableLiveData().observe(this, remoteList -> {
            employeeDetailsRemoteList = remoteList;
            adapter.updateAdapter(remoteList);
        });
    }

}