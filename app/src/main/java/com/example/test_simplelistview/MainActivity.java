package com.example.test_simplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ListView lt;
    private String [] data={"item_one","item_two","item_three","item_four","item_five","item_six",
            "item_seven","item_eight","item_nine","item_ten"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到listview 组件
        lt =(ListView)findViewById(R.id.list_item);

        //创建一个含有hanshMap 的列表(不要和自己写的ListView对象名称搞混)集合
        List<HashMap<String,String>> data = new ArrayList<>();
        for(int i =1;i<=10;i++){
            //创建 10  个 map 数据对象 ，每个map 对象 有两个键值数据
            //创建HashMap 对象,添加键值数据
            HashMap<String,String> map = new HashMap<>();
            //向map 对象添加两组键值对数据
            map.put("key_one","dataOne_" + i);
            map.put("key_two","dataTwo_" + i);

            //将 map 对象添加到data  集合
            data.add(map);
        }
        /**
         * SimpleAdapter 将数据和布局联系起来
         * 参数1 当前上下文环境
         * 参数2 当前绑定的数据
         * 参数3 当前引用的listView 的列表的布局
         * 参数4 String数组存储的map 的key
         * 参数5 int 数组保存的 组件的id
         *
         * 参数4 ，参数5 值是对应关系
         * */

        SimpleAdapter mSimpleAdapter = new SimpleAdapter(
                this,
                data,
                R.layout.listview_item,
                new String[]{"key_one","key_two","key_three","key_four"},
                new int[]{R.id.text_one,R.id.text_two});
        lt.setAdapter(mSimpleAdapter);
    }

}