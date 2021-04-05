package com.ebookfrenzy.restproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Names> namesList;

    public RecyclerViewAdapter(ArrayList<Names> nlst) {
        namesList = nlst;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);

        RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        Names names = namesList.get(position);
        viewHolder.Name.setText(names.getName());
        viewHolder.Address.setText(names.getAddress());
        viewHolder.Phone.setText(names.getPhone());
        viewHolder.Age.setText(names.getAge());
        viewHolder.EyeColor.setText(names.getEyeColor());
        viewHolder.Company.setText(names.getCompany());
        viewHolder.Email.setText(names.getEmail());
        viewHolder.CardNumber.setText(String.valueOf(position + 1));
        if (names.getGender().equals("male")) {
            viewHolder.GenderImage.setImageResource(R.drawable.male);
        } else if (names.getGender().equals("female")) {
            viewHolder.GenderImage.setImageResource(R.drawable.female);
        }
    }

    @Override
    public int getItemCount() {

        return namesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView Name;
        public TextView Address;
        public TextView Phone;
        public TextView Age;
        public TextView EyeColor;
        public TextView Company;
        public TextView CardNumber;
        public TextView Email;
        public ImageView GenderImage;

        public ViewHolder(View view) {
            super(view);
            Name = view.findViewById(R.id.Name);
            Address = view.findViewById(R.id.Address);
            Phone = view.findViewById(R.id.Phone);
            Age = view.findViewById(R.id.Age);
            EyeColor = view.findViewById(R.id.Eye);
            Company = view.findViewById(R.id.Company);
            CardNumber = view.findViewById(R.id.CardNumber);
            Email = view.findViewById(R.id.Email);
            GenderImage = view.findViewById(R.id.GenderImage);

        }

    }

}