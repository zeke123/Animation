package com.zhoujian.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zhoujian on 2016/12/12.
 */

public class ThiredActivity extends Activity {


    private ArrayList<Person> list;

    @InjectView(R.id.list_person)
    ListView mListPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thired);
        ButterKnife.inject(this);
        //加载动画
        Animation animation = AnimationUtils.loadAnimation(ThiredActivity.this,R.anim.animation_item);
        //创建LayoutAnimationController
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        //延迟
        controller.setDelay(0.5f);
        //播放顺序
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        //给ListView设置动画
        mListPerson.setLayoutAnimation(controller);

        list = new ArrayList<Person>();
        Person person1 = new Person("贾宝玉");
        list.add(person1);
        list.add(person1);
        Person person2 = new Person("林黛玉");
        list.add(person2);
        list.add(person2);
        Person person3 = new Person("薛宝钗");
        list.add(person3);
        list.add(person3);
        Person person4 = new Person("王熙凤");
        list.add(person4);
        list.add(person4);
        Person person5 = new Person("史湘云");
        list.add(person5);
        list.add(person5);
        Person person6 = new Person("贾探春");
        list.add(person6);
        list.add(person6);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount()
            {
                return list.size();
            }

            @Override
            public Object getItem(int i)
            {
                return null;
            }

            @Override
            public long getItemId(int i)
            {
                return 0;
            }
            @Override
            public View getView(int position, View convertView, ViewGroup group) {
                View view;
                final ViewHolder holder;
                if (convertView != null) {
                    view = convertView;
                    holder = (ViewHolder) view.getTag();
                } else {
                    view = View.inflate(ThiredActivity.this, R.layout.list_item, null);
                    holder = new ViewHolder();
                    holder.tv_name = (TextView) view.findViewById(R.id.tv_name);
                    view.setTag(holder);
                }
                if (list != null && list.size() > 0) {
                    holder.tv_name.setText(list.get(position).getName());
                }
                return view;
            }
        };
        mListPerson.setAdapter(adapter);

    }

    class ViewHolder {
        TextView tv_name;

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
