package com.example.myfood_10119099_if3;

// NIM   : 10119099
// Nama  : Sandi Komara
// Kelas : IF3

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;

public class Pager extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<Model> modelArrayList;
    private Adapter adapter;
    private MaterialButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        viewPager = findViewById(R.id.viewPager);
        loadCards();viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                String title = modelArrayList.get(position).getTitle();
                if(position == modelArrayList.size()-1){
                    button.setText("Mulai");
                }else {
                    button.setText("Lanjut");
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem()+1<modelArrayList.size()){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }else{
                    //kembali ke main activity
                    startActivity(new Intent(Pager.this, MainActivity.class));
                    finish();
                }
            }
        });
    }

    private void loadCards() {
        modelArrayList = new ArrayList<>();

        modelArrayList.add(new Model("What's My Food Apps?","List tempat makan favorit!",R.drawable.food_store));
        modelArrayList.add(new Model("Watch List Favorite Food!","Anda dapat melihat list tempat makanan favorit.",R.drawable.diet));
        modelArrayList.add(new Model("Know Your Location!","Anda bisa melihat posisi anda saat ini ketika mengakses My Food Apps.",R.drawable.placeholder));

        adapter = new Adapter(this,modelArrayList);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(100,0,100,0);
    }
}