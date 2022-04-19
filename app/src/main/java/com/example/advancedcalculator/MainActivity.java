package com.example.advancedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView listView1;
    EditText edit1,edit2;
    Button add,update;

    ArrayList<String> foods = new ArrayList<>();
    ArrayAdapter myAdapter1;

    Integer indexVal;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1 = (ListView) findViewById(R.id.listview);
        edit1 =(EditText) findViewById(R.id.name);
        edit2 =(EditText) findViewById(R.id.age);
        add = (Button) findViewById(R.id.add);
        update = (Button) findViewById(R.id.update);

        foods.add("john");
        foods.add("bass");

        myAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,foods);
        listView1.setAdapter(myAdapter1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = edit1.getText().toString();
                int birth = Integer.parseInt(edit2.getText().toString());
                int y = Calendar.getInstance().get(Calendar.YEAR);
                int age = y - birth;
                String msg = "Welcome "+ val + ", you are "+ age + " years old.";
                foods.add(msg);

                myAdapter1.notifyDataSetChanged();
                edit1.setText("");
                edit2.setText("");
            }
        });

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + " has been selected";
                indexVal =i;
                Toast.makeText(MainActivity.this,item,Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = edit1.getText().toString();
                int y = Integer.parseInt(edit2.getText().toString());
                int age = 2022 -y;
                String msg = "Welcome "+ val + " you are "+ age + " years old.";
                foods.set(indexVal,msg);

                myAdapter1.notifyDataSetChanged();

            }
        });

        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + " has been deleted";
                Toast.makeText(MainActivity.this,item,Toast.LENGTH_SHORT).show();


                foods.remove(i);
                myAdapter1.notifyDataSetChanged();
                return true;
            }
        });









    }
}