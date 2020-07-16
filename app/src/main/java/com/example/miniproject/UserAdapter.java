package com.example.miniproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ListViewHolder> {

    private Context context;
    private User[] data;
    public UserAdapter(Context context,User[] data){
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_pessanger_detail,parent,false);
        return new ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final User user=data[position];
        holder.tvName.setText(user.getPassengerName());
        holder.tvPNR.setText(user.getPNR());
        /*holder.tvDate.setText(user.get);*/
        holder.tvFrom.setText(user.getBoardingFrom());
        holder.tvTo.setText(user.getBoardingUpto());
        holder.tvAge.setText(user.getAge());
        holder.tvBookingStatus.setText(user.getConfirmationStatus());
        holder.tvTrainName.setText((user.getTrainNumber()));


        if(user.getIsBoarded()==0 && user.getConfirmationStatus().equals("CNF"))
        {
            holder.bCheck.setVisibility(View.VISIBLE);
        }else{
            holder.bCheck.setVisibility(View.GONE);
        }
        if(user.getConfirmationStatus().equals("WL"))
        {
            holder.btnAllocate.setVisibility(View.VISIBLE);
        }else{
            holder.btnAllocate.setVisibility(View.GONE);
        }


        holder.tvTrainID.setText("("+(user.getTrainID())+")");
        //holder.bCheck.setText(user.getPassengerID());
        holder.tvQuota.setText("/"+(user.getCoachNo())+"-"+(user.getSeatNo()));


        holder.bCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String PID=user.getPassengerID();
                final ProgressDialog progressDialog=new ProgressDialog(context);
                progressDialog.setMessage("Updating");
                progressDialog.show();
                StringRequest request= new StringRequest( "http://192.168.43.229:8080/ApiIRCTC/CheckUpdate.php?PassengerID="+PID, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context,response,Toast.LENGTH_SHORT).show();
                        /*Intent i=new Intent(context,List_Pessanger.class);
                        startActivity(i);*/
                        context.startActivity(new Intent(context.getApplicationContext(),List_Pessanger.class));
                        ((Activity)context).finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.getMessage(),Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });
                RequestQueue queue= Volley.newRequestQueue(context);
                queue.add(request);
            }
        });

        holder.btnAllocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String PID=user.getPassengerID();
                final ProgressDialog progressDialog=new ProgressDialog(context);
                progressDialog.setMessage("Updating");
                progressDialog.show();

                StringRequest request= new StringRequest( "http://192.168.43.229:8080/ApiIRCTC/Check.php?PassengerID="+PID, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context,response,Toast.LENGTH_SHORT).show();
                        context.startActivity(new Intent(context.getApplicationContext(),List_Pessanger.class));
                        ((Activity)context).finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.getMessage(),Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });

                RequestQueue queue= Volley.newRequestQueue(context);
                queue.add(request);
            }
        });



    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvPNR;
       /* TextView tvDate;*/
        TextView tvFrom;
        TextView tvTo;
        TextView tvAge;
        TextView tvBookingStatus;
        TextView tvTrainName;
        TextView tvTrainID;
        TextView tvQuota;
        ToggleButton bCheck,btnAllocate;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txtName);
            tvPNR = itemView.findViewById(R.id.txtPNR);
           /* tvDate = itemView.findViewById(R.id.txtDate);*/
            tvFrom = itemView.findViewById(R.id.txtFrom);
            tvTo = itemView.findViewById(R.id.txtTo);
            tvAge = itemView.findViewById(R.id.txtAge);
            tvBookingStatus = itemView.findViewById(R.id.txtBookingStatus);
            tvTrainName = itemView.findViewById(R.id.txtTrainNo);
            bCheck =itemView.findViewById(R.id.BtnCheck);
            btnAllocate=itemView.findViewById(R.id.BtnAllocateSeat);
            tvTrainID =itemView.findViewById(R.id.txtTID);
            tvQuota=itemView.findViewById(R.id.txtQuota);

        }
    }


}
