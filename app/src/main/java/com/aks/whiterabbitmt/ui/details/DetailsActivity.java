package com.aks.whiterabbitmt.ui.details;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aks.whiterabbitmt.R;
import com.aks.whiterabbitmt.data.remote.EmployeeDetailsRemote;
import com.aks.whiterabbitmt.databinding.ActivityDetailsBinding;
import com.bumptech.glide.Glide;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding detailsBinding;
    EmployeeDetailsRemote employeeDetailsRemote = new EmployeeDetailsRemote();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        context = this;
        Intent intent = getIntent();
        if (intent != null) {
            employeeDetailsRemote = (EmployeeDetailsRemote) intent.getSerializableExtra("dataItem");
            initialiseData();
        }
    }

    @SuppressLint("SetTextI18n")
    private void initialiseData() {
        Glide.with(context).load(employeeDetailsRemote.getProfileImage()).into(detailsBinding.ivProfileImage);
        detailsBinding.tvProfileName.setText(employeeDetailsRemote.getName());
        detailsBinding.tvEmail.setText(employeeDetailsRemote.getEmail());
        detailsBinding.tvPhoneNo.setText(employeeDetailsRemote.getPhone());
        detailsBinding.tvUserName.setText(employeeDetailsRemote.getUsername());
        detailsBinding.tvAddress.setText(employeeDetailsRemote.getAddress().getSuite() + "\n"
                + employeeDetailsRemote.getAddress().getCity() + "\n"
                + employeeDetailsRemote.getAddress().getStreet() + "\n"
                + employeeDetailsRemote.getAddress().getZipcode());
        detailsBinding.tvCompanyDetails.setText(employeeDetailsRemote.getCompany().getName() + "\n"
                + employeeDetailsRemote.getCompany().getBs() + "\n"
                + employeeDetailsRemote.getCompany().getCatchPhrase());
    }
}