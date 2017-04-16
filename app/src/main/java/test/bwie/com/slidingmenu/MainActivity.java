package test.bwie.com.slidingmenu;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity  {

    private TextView mText_title;
    private ListView mLv;

    private FragmentTransaction mTransaction;
    private UserFragment mUserFragment;
    private FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mManager = getSupportFragmentManager();
        UserFragment userFragment = new UserFragment();
        userFragment.category=UrL.title1;
        mManager.beginTransaction().replace(R.id.zhuye,userFragment).commit();

        initView();
        initSildMenu();


    }


    private void initView() {
        mText_title = (TextView) findViewById(R.id.text_title);
        mLv = (ListView) findViewById(R.id.lv);
    }

    private void initSildMenu() {
        SlidingMenu side_drawer = new SlidingMenu(this);
        WindowManager wm = getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        side_drawer.setBehindWidth(displayMetrics.widthPixels / 5 * 4);

        //设置侧滑模式为向左侧滑
        side_drawer.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        side_drawer.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

        side_drawer.setShadowWidthRes(R.dimen.shadow_width);
        side_drawer.setShadowDrawable(R.color.black);

        // 设置滑动菜单视图的宽度

        side_drawer.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        side_drawer.setFadeDegree(0.65f);

        side_drawer.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        side_drawer.setMenu(R.layout.left_drawer_fragment);

        ListView listView= (ListView) side_drawer.findViewById(R.id.mlv);
        new MyXutils(mManager,listView,MainActivity.this, mText_title).getDataUtil(UrL.title);

       /* TextView text_all= (TextView) side_drawer.findViewById(R.id.text_all);
        TextView text_zy= (TextView) side_drawer.findViewById(R.id.text_zy);
        TextView text_xy= (TextView) side_drawer.findViewById(R.id.text_xy);*/

        /*text_all.setOnClickListener(this);
        text_zy.setOnClickListener(this);
        text_xy.setOnClickListener(this);*/
    }

   /* @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_all:
                mUserFragment = new UserFragment();
                mUserFragment.category=mList.get(0);
                mTransaction.replace(R.id.zhuye, mUserFragment).commit();
                break;
            case R.id.text_zy:
                mUserFragment.category=mList.get(1);
                mTransaction.replace(R.id.zhuye, mUserFragment).commit();
                break;
            case R.id.text_xy:
                mUserFragment.category=mList.get(2);
                mTransaction.replace(R.id.zhuye, mUserFragment).commit();
                break;
        }
    }*/
}
