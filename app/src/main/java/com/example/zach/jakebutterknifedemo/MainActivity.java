package com.example.zach.jakebutterknifedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textview)
    TextView tv_one;
    @BindView(R.id.button)
    Button bt_one;
    @BindView(R.id.radiobutton)
    RadioButton rb_one;
    @BindView(R.id.switch1)
    Switch sw_one;

    @BindView(R.id.longPress)
    Button longPressButton;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.listview)
    ListView listview;

    List<Student> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student s = new Student();
            s.setName("Student :" + i);
            s.setAge("age :" + i );
            list.add(s);
        }
        Toast.makeText(this, list.size() + "", Toast.LENGTH_SHORT).show();
        listview.setAdapter(new ListViewAdapter(MainActivity.this, list));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, list.get(i).getName() + ":" + list.get(i).getAge(), Toast.LENGTH_SHORT).show();
            }
        });


    }


    @OnClick({R.id.textview, R.id.button, R.id.radiobutton, R.id.switch1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.textview:
                Toast.makeText(this, "Text view clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button:
                Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radiobutton:
                Toast.makeText(this, "Radiobutton clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.switch1:
                Toast.makeText(this, "switch clicked", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @OnLongClick(R.id.longPress)
    boolean buttonLongClick() {
        Toast.makeText(MainActivity.this, "Button is long clicked", Toast.LENGTH_SHORT).show();
        return false;
    }
    //    @OnLongClick(R.id.button)
//    boolean buttonLongClick(Button button){
//        Toast.makeText(MainActivity.this, "Button的长按事件触发。。。(TextView)", Toast.LENGTH_SHORT).show();
//        return false;
//    }

    //    @OnLongClick(R.id.button)
//    boolean buttonLongClick(View view){
//        Toast.makeText(MainActivity.this, "Button的长按事件触发。。。(View)", Toast.LENGTH_SHORT).show();
//        return false;
//    }
    @OnCheckedChanged(R.id.checkbox)
    void radioButtonCheckChange(boolean is1) {
        Toast.makeText(MainActivity.this, "CheckBox。。。(无参)" + is1, Toast.LENGTH_SHORT).show();
    }

}
