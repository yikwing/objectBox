package com.rongyi.objectbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class MainActivity extends AppCompatActivity {

    private Box<Bean> beanBox;
    private Button mAdd;
    private Button mQuery;
    private Button mDelect;
    private Button mPut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdd = findViewById(R.id.btn_add);
        mQuery = findViewById(R.id.btn_query);
        mDelect = findViewById(R.id.btn_delect);
        mPut = findViewById(R.id.btn_put);


        mAdd.setOnClickListener(v -> {
            Bean bean = new Bean("1234", "fuck");
            if (beanBox != null) {
                beanBox.put(bean);
            }
        });

        mQuery.setOnClickListener(v -> {
            if (beanBox != null) {
                List<Bean> beanList = beanBox.query().equal(Bean_.uuid, "1234").build().find();
                Toast.makeText(this, beanList.get(0).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mDelect.setOnClickListener(v -> {
            if (beanBox != null) {
                beanBox.remove(1);
            }
        });

        mPut.setOnClickListener(v -> {

            update(beanBox);

        });


        BoxStore boxStore = ((MyApplication) getApplication()).getBoxStore();
        beanBox = boxStore.boxFor(Bean.class);


    }


    //增
    private void add(Box<Bean> beanBox) {
        Bean bean = new Bean("1234", "fuck");
        if (beanBox != null) {
            beanBox.put(bean);
        }
    }

    //查
    private Bean query(Box<Bean> beanBox) {
        if (beanBox != null) {
            List<Bean> beanList = beanBox.query().equal(Bean_.uuid, "1234").build().find();
            return beanList.get(0);
        }
        return null;
    }

    //删
    private void delete(Box<Bean> beanBox) {
        Bean bean = query(beanBox);
        if (beanBox != null) {
            beanBox.remove(bean);
        }
    }

    //改
    private void update(Box<Bean> beanBox) {
        Bean bean = query(beanBox);
        bean.setToken("FUCK YOU");
        if (beanBox != null) {
            beanBox.put(bean);
        }
    }
}
