package com.ebookfrenzy.restproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Names> namesList;


    //CREATE CONSTRUCTORE AND ADD LIST
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
        //WE GET THE POSITION OF THE COUPON LIST AND THEN CAN GET THE VALUE OF ALL THE COUPONS FROM
        //THE ARRAYLIST
        Names names = namesList.get(position);
        viewHolder.storeTv.setText(names.getName());
        viewHolder.couponTv.setText(names.getAge());
        viewHolder.expiryDateTv.setText(names.getPhone());
        viewHolder.couponCodeTv.setText(names.getAddress());
        viewHolder.couponCategoryTv.setText(names.getEyeColor());
    }

    @Override
    public int getItemCount() {
        //WE ARE USING AN ARRAY LIST SO WE USE THE SIZE METHOD NOT LENGTH FROM THE ARRAY
        return namesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView storeTv;
        public TextView couponTv;
        public TextView expiryDateTv;
        public TextView couponCodeTv;
        public TextView couponCategoryTv;

        public ViewHolder(View view) {
            super(view);
            storeTv = view.findViewById(R.id.coupon_store);
            couponTv = view.findViewById(R.id.coupon_text);
            expiryDateTv = view.findViewById(R.id.coupon_expire_date);
            couponCodeTv = view.findViewById(R.id.coupon_code);
            couponCategoryTv = view.findViewById(R.id.coupon_category);

        }

    }

}