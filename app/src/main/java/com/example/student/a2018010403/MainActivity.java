package com.example.student.a2018010403;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //String str[]={"A","B","C"};
    ArrayAdapter<String> adapter;
    ArrayList<String> data;
    Spinner sp,sp2;
    TextView tv,tv2,tv3;
    EditText et;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.textView);
        et=(EditText)findViewById(R.id.editText);
        btn=(Button)findViewById(R.id.button);
        tv2=(TextView)findViewById(R.id.textView2);
        tv3=(TextView)findViewById(R.id.textView3);

        //Spinner sp=(Spinner)findViewById(R.id.spinner);
        sp=(Spinner)findViewById(R.id.spinner);
        sp2=(Spinner)findViewById(R.id.spinner2);
        data=new ArrayList();
        data.add("A");
        data.add("B");
        data.add("C");

        adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        //參數依序是：作用的頁面，要長甚麼樣子，要填入甚麼資料
        sp.setAdapter(adapter);//把sp裡面填入剛剛設的變數adapter
       sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//項目被選取時候產生的動作
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               tv.setText(data.get(i));//項目被選取時取得data裡面第i個字料並填入tv裡面
           }
           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {  }
       });
       sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()  {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str[]=getResources().getStringArray((R.array.cities));
                tv3.setText(str[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    void click1(View v){
        data.add(et.getText().toString());
        //adapter.notifyDataSetChanged();
    }
    void click2(View v){
        int pos=sp.getSelectedItemPosition();//取得被選中的資料的位置
        tv2.setText(data.get(pos));//把tv2設為data資料裡面索引POS位置的資料
    }
    public void clickdelete(View v){


        data.remove(sp.getSelectedItemPosition());
        adapter.notifyDataSetChanged();
    }

}
