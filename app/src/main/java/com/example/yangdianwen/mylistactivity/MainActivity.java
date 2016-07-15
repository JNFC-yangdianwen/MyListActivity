package com.example.yangdianwen.mylistactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity {


 private Button bt_add;
    private EditText et_item;
    private ArrayList<HashMap<String, Object>> listItems;    //存放文字、图片信息
    private SimpleAdapter listItemAdapter;           //适配器
    @Override
    public void onCreate(Bundle icicle)   {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        bt_add = (Button)findViewById(R.id.bt_add);
        et_item = (EditText)findViewById(R.id.et_item);
        initListView();
        this.setListAdapter(listItemAdapter);
        bt_add.setOnClickListener(new ClickEvent());
    }
    /**
     * 设置适配器内容
     */
    private void initListView()   {
        listItems = new ArrayList<HashMap<String, Object>>();
        for(int i=0;i<10;i++)    {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemTitle", "Music： "+i);    //文字
            map.put("ItemImage", R.drawable.ic_card_travel_black_24dp);   //图片
            listItems.add(map);
        }
        //生成适配器的Item和动态数组对应的元素
        listItemAdapter = new SimpleAdapter(this,listItems,   // listItems数据源
                R.layout.list_item,  //ListItem的XML布局实现
                new String[] {"ItemTitle", "ItemImage"},     //动态数组与ImageItem对应的子项
                new int[ ] {R.id.ItemTitle, R.id.ItemImage}      //list_item.xml布局文件里面的一个ImageView的ID,一个TextView 的ID
        );
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)  {
        // TODO Auto-generated method stub
        Log.d("position", "" + position);
        setTitle("你点击第"+position+"行");
    }
class ClickEvent implements View.OnClickListener {
    @Override
    public void onClick (View v)  {
        // 向ListView里添加一项
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("ItemTitle", "Music： "+ et_item.getText().toString());
        map.put("ItemImage", R.drawable.ic_card_travel_black_24dp);     //每次都放入同样的图片资源ID
        listItems.add(map);
        //重新设置适配器
        MainActivity.this.setListAdapter(listItemAdapter);
    }
}
}
