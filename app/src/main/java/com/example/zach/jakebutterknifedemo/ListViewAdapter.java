package com.example.zach.jakebutterknifedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangwenpurdue on 8/20/2017.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Student> studentList;

    public ListViewAdapter(Context context, List<Student> list) {
        this.context = context;
        this.studentList = list;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int i) {
        return studentList != null ? studentList.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (holder == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
            holder = new ViewHolder(view);
            view.setTag(view);
        } else {
           holder = (ViewHolder) view.getTag();
        }
        Student student = studentList.get(i);
        holder.itemUsername.setText(student.getName());
        holder.itemUserage.setText(student.getAge());
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.item_username)
        TextView itemUsername;
        @BindView(R.id.item_userage)
        TextView itemUserage;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
