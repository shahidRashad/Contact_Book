package com.example.contactbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    ArrayList<ContactModel> contactModelArrayList;
    Context context;
    public CourseAdapter(ArrayList<ContactModel> contactModelArrayList, Context context) {
        this.context = context;
        this.contactModelArrayList = contactModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_view_custom,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactModel model = contactModelArrayList.get(position);
        holder.cname.setText(model.getContactName());
        holder.cno.setText(model.getContactNo());
        holder.cmail.setText(model.getContactEmail());
    }

    @Override
    public int getItemCount() {
        return contactModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView cname, cno, cmail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cname = (TextView) itemView.findViewById(R.id.tvCname);
            cno = (TextView) itemView.findViewById(R.id.tvCno);
            cmail = (TextView) itemView.findViewById(R.id.tvCmail);
        }
    }
}
