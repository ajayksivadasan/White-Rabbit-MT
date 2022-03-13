package com.aks.whiterabbitmt.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aks.whiterabbitmt.R;
import com.aks.whiterabbitmt.data.remote.EmployeeDetailsRemote;
import com.bumptech.glide.Glide;

import java.util.List;

public class RvMainAdapter extends RecyclerView.Adapter<RvMainAdapter.RvViewHolder> {
    Context context;
    List<EmployeeDetailsRemote> employeeDetailsRemoteList;

    public RvMainAdapter(Context context, List<EmployeeDetailsRemote> employeeDetailsRemoteList) {
        this.context = context;
        this.employeeDetailsRemoteList = employeeDetailsRemoteList;
    }

    public void updateAdapter(List<EmployeeDetailsRemote> employeeDetailsRemoteList) {
        this.employeeDetailsRemoteList = employeeDetailsRemoteList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RvViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_main_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewHolder holder, int position) {
        holder.tvName.setText(employeeDetailsRemoteList.get(position).getName());
        holder.tvCompanyName.setText(employeeDetailsRemoteList.get(position).getCompany().getName());
        Glide.with(context).load(employeeDetailsRemoteList.get(position).getProfileImage()).into(holder.ivProfileImage);
    }

    @Override
    public int getItemCount() {
        return employeeDetailsRemoteList.size();
    }

    public static class RvViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvCompanyName;
        ImageView ivProfileImage;

        public RvViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvCompanyName = itemView.findViewById(R.id.tvCompanyName);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
        }
    }
}
