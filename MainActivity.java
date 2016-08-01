package adliano.com.demosimplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.*;

public class MainActivity extends AppCompatActivity
{
    ListView listView;
    List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list_view);
        String strs[] = {"Good","Bag","Cute","Ugly","Hot","Cold","ETC"};

        mList = Arrays.asList(strs);

        listView.setAdapter(new MyCustomAdapter());

    }
    /*** Custom Adapter ***/
    private class MyCustomAdapter extends ArrayAdapter<String>
    {

        public MyCustomAdapter()
        {
            super(MainActivity.this,R.layout.item_layout,mList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if(convertView==null) convertView = getLayoutInflater().inflate(R.layout.item_layout,parent,false);

            TextView textViewAtCustomLayout = (TextView)convertView.findViewById(R.id.text_view_at_custom_layout);
            textViewAtCustomLayout.setText(mList.get(position));

            return convertView;
        }
    }
}
