package com.example.bnquotes;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private  String[] data;

public MyAdapter(String[] data){

    this.data=data;

}
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());

        View view=inflater.inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

final String mydata=data[position];
holder.textView.setText(mydata);
holder.button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,mydata);
        intent.setType("text/plain");
        intent=Intent.createChooser(intent,"Share By...");
        holder.itemView.getContext().startActivity(intent);

    }
});
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public  class MyViewHolder extends  RecyclerView.ViewHolder{

TextView textView;
Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.text);
            button=itemView.findViewById(R.id.share_btn);
        }
    }
}
