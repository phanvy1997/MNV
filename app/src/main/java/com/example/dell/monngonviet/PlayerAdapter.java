package com.example.dell.monngonviet;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phan Vy on 10/10/2017.
 */

public class PlayerAdapter extends ArrayAdapter<player> {
    Context mContext;
    ArrayList<player> mLstContact=new ArrayList<player>();
    public PlayerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<player> objects) {
        super(context, resource, objects);
        this.mContext= context;
        this.mLstContact= new ArrayList<player>(objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView= convertView;
        ViewHolder viewHolder;
        if (rowView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView= inflater.inflate(R.layout.layoutcustom,null);
            viewHolder= new ViewHolder();
            viewHolder.txtName=(TextView) rowView.findViewById(R.id.textView4);
            viewHolder.txtgioithieu=(TextView) rowView.findViewById(R.id.textView5);
            viewHolder.imgmon=(ImageView) rowView.findViewById(R.id.imageView);
            rowView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder)convertView.getTag();
        }
        player contact = mLstContact.get(position);
        viewHolder.txtName.setText(contact.getName());
        viewHolder.txtgioithieu.setText(contact.getGioithieu());
        viewHolder.imgmon.setImageResource(contact.getAnh());
        return rowView;
    }

    static class ViewHolder{
        TextView txtName;
        TextView txtgioithieu;
        ImageView imgmon;
    }
}
