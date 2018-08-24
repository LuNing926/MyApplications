package com.example.root.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private GridLayout mGrid;
    private GridView mGridView;
    private ArrayList<ItemBean> mList = new ArrayList();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mGrid = (GridLayout) findViewById(R.id.grid_layout);
        initData();

//        initView1();

//        initView2();

//        initView3();

//        initView4();

        initView5();

//        initView6();
    }

    private void initView6() {
        mGridView = (GridView) findViewById(R.id.gridview);
        MyAdapter adapter = new MyAdapter();
        mGridView.setAdapter(adapter);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initView5() {
        mGrid.setColumnCount(4);
//        mGrid.setRowCount(10);
        LinearLayout layout = (LinearLayout) findViewById(R.id.parent_layout);
        layout.measure(0, 0);
        int measuredWidth = layout.getMeasuredWidth();
        Log.d("dddddd", "--------------grid-width-" + measuredWidth + "---height-" + layout.getMeasuredHeight()); // width = 0
        Log.d("dddddd", "--------------display-" + getWindowManager().getDefaultDisplay().getWidth());
        int tag = -1;
        int x = -1;
        int y = 0;
        for (int i = 0; i < mList.size(); i++) {
            Log.d("dddddd", "--------------" + mList.get(i).getName());
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            if (mList.get(i).getNum() != tag ) {
                x ++;
                y = 0;
                TextView textView = new TextView(this);
                tag = mList.get(i).getNum();
                textView.setText("Title " + tag);
//                params.rowSpec = GridLayout.spec(x, 1);
//                params.columnSpec = GridLayout.spec(y, 1);
                params.rowSpec = GridLayout.spec(x, 1f);
                params.columnSpec = GridLayout.spec(y, 1f);
//                params.setMargins(60, 20, 0, 20);
                params.setGravity(Gravity.CENTER);
                mGrid.addView(textView, params);
                i--;
                x ++;
                y = 0;
            } else {
                View item = LayoutInflater.from(this).inflate(R.layout.item_main5, null);
                TextView text = (TextView) item.findViewById(R.id.item_text);
                text.setText(mList.get(i).getName());
//                params.rowSpec = GridLayout.spec(x, 1);
//                params.columnSpec = GridLayout.spec(y++, 1);
                params.rowSpec = GridLayout.spec(x, 1f);
                params.columnSpec = GridLayout.spec(y++, 1f);
                params.setGravity(Gravity.CENTER);
                mGrid.addView(item, params);
            }
        }

        mGrid.measure(0, 0);
        Log.d("dddddd", "--------------grid-width-" + mGrid.getMeasuredWidth() + "---height-" + mGrid.getMeasuredHeight()); // width = 0
    }

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initView4() {
        mGrid.setColumnCount(4);
//        mGrid.setRowCount(10);

        for (int i = 0; i < mList.size(); i++) {
            Log.d("dddddd", "--------------" + mList.get(i).getName());
//            TextView textView = new TextView(this);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            if (i == 0) {
                params.rowSpec = GridLayout.spec(0, 1, 3f);
                params.columnSpec = GridLayout.spec(0, 4, 1f);
                TextView textView = new TextView(this);
                textView.setText("Title");
                mGrid.addView(textView, params);
            } else {
                View item = LayoutInflater.from(this).inflate(R.layout.item_main3, null);
                params.rowSpec = GridLayout.spec((i+3)/4, 1f);
                params.columnSpec = GridLayout.spec((i+3)%4, 1f);
                params.setGravity(Gravity.CENTER);
                mGrid.addView(item, params);
            }
//            textView.setText(mList.get(i).getName());
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initView3() {
        mGrid.setColumnCount(4);
//        mGrid.setRowCount(10);

        for (int i = 0; i < mList.size(); i++) {
            View item = LayoutInflater.from(this).inflate(R.layout.item_main3, null);
            Log.d("dddddd", "--------------" + mList.get(i).getName());
//            TextView textView = new TextView(this);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            if (i == 0) {
                params.rowSpec = GridLayout.spec(0, 1, 3f);
                params.columnSpec = GridLayout.spec(0, 4, 1f);
            } else {
                params.rowSpec = GridLayout.spec((i+3)/4, 1f);
                params.columnSpec = GridLayout.spec((i+3)%4, 1f);
                params.setGravity(Gravity.CENTER);
            }
//            textView.setText(mList.get(i).getName());
            mGrid.addView(item, params);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initView2() {
        mGrid.setColumnCount(4);
//        mGrid.setRowCount(10);

        for (int i = 0; i < mList.size(); i++) {
            Log.d("dddddd", "--------------" + mList.get(i).getName());
            TextView textView = new TextView(this);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
//            params.width = GridLayout.LayoutParams.MATCH_PARENT;
//            params.height = GridLayout.LayoutParams.MATCH_PARENT;
            if (i == 0) {
                params.rowSpec = GridLayout.spec(0, 1, 3f);
                params.columnSpec = GridLayout.spec(0, 4, 1f);
//                textView.setGravity(Gravity.BOTTOM | Gravity.RIGHT);
//                params.setMargins(20, 20, 2, 2);
//                textView.setForegroundGravity(Gravity.CENTER);
            } else {
                params.rowSpec = GridLayout.spec((i+3)/4, 1f);
                params.columnSpec = GridLayout.spec((i+3)%4, 1f);
//                textView.setGravity(Gravity.CENTER);
            }
            textView.setText(mList.get(i).getName());
            params.setGravity(Gravity.CENTER);
            mGrid.addView(textView, params);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initView1() {
        mGrid.setColumnCount(4);
//        mGrid.setRowCount(10);

        for (int i = 0; i < mList.size(); i++) {
            Log.d("dddddd", "--------------" + mList.get(i).getName());
            TextView textView = new TextView(this);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
//            params.width = 0;
//            params.height = 0;
            if (i == 0) {
                params.rowSpec = GridLayout.spec(0, 1, 3f);
                params.columnSpec = GridLayout.spec(0, 4, 1f);
                textView.setGravity(Gravity.CENTER);
            } else {
                params.rowSpec = GridLayout.spec((i+3)/4, 1f);
                params.columnSpec = GridLayout.spec((i+3)%4, 1f);
            }
            textView.setText(mList.get(i).getName());
            mGrid.addView(textView, params);
        }
    }

    private void initData() {
//        mList.add(new ItemBean("Title1", -1));
        mList.add(new ItemBean("DATA", 0));
        mList.add(new ItemBean("UserConfig", 0));
//        mList.add(new ItemBean("Title2", -1));
        mList.add(new ItemBean("Public", 1));
        mList.add(new ItemBean("Public", 1));
        mList.add(new ItemBean("Public", 1));
        mList.add(new ItemBean("Public", 1));
//        mList.add(new ItemBean("Title3", -1));
        mList.add(new ItemBean("Resource", 2));
        mList.add(new ItemBean("Resource", 2));
//        mList.add(new ItemBean("Resource", 2));
//        mList.add(new ItemBean("Resource", 2));
//        mList.add(new ItemBean("Resource", 2));
//        mList.add(new ItemBean("Resource", 2));
//        mList.add(new ItemBean("Resource", 2));
//        mList.add(new ItemBean("Resource", 2));
//        mList.add(new ItemBean("Resource", 2));
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int i) {
            return mList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_grid, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
                if (mList.get(position).getNum() >= 0) {
                    holder.text.setText(mList.get(position).getName());
                } else {
                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(mList.get(position).getName());
                    return textView;
                }
            }
            return convertView;
        }

        class ViewHolder {
            ImageView image;
            TextView text;

            public ViewHolder(View view) {
                text = (TextView) view.findViewById(R.id.item_text);
            }
        }
    }

    class MyFragment extends Fragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public void onResume() {
            super.onResume();
        }

        @Override
        public void onPause() {
            super.onPause();
        }
    }
}
