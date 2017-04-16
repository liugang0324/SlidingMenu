package test.bwie.com.slidingmenu;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description:
 * @ Date:2017/4/15
 * @ Author:刘刚
 */

public class MyXutils {
  private ListView lv;
    private Context mContext;
    private TextView text;
    private FragmentManager fm;
    private List<String>mList=new ArrayList<>();
    public MyXutils(ListView lv, Context context) {
        this.lv = lv;
        mContext = context;
    }

    public MyXutils(FragmentManager fm, ListView lv, Context context, TextView text) {
        this.fm = fm;
        this.lv = lv;
        mContext = context;
        this.text = text;
    }

    private  void initData(){
        mList.add(UrL.title1);
        mList.add(UrL.title2);
        mList.add(UrL.title3);
    }
   public  void getDataUtil(String uri){
       RequestParams params = new RequestParams(uri);
       x.http().get(params, new Callback.CommonCallback<String>() {

           @Override
           public void onSuccess(String result) {
               Gson gson = new Gson();
               initData();
               Data bean = gson.fromJson(result, Data.class);
               final List<Data.DataBean> data = bean.getData();
               lv.setAdapter(new MyDetailAdapter(data,mContext));
               lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       UserFragment userFragment = new UserFragment();
                       userFragment.category=mList.get(position);
                       text.setText(data.get(position).getName());
                        fm.beginTransaction().replace(R.id.zhuye,userFragment).commit();
                   }
               });
           }

           @Override
           public void onError(Throwable ex, boolean isOnCallback) {

           }

           @Override
           public void onCancelled(CancelledException cex) {

           }

           @Override
           public void onFinished() {

           }
       });
   }
    public  void  getXutils(String uri){
        RequestParams params = new RequestParams(uri);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Bean bean = gson.fromJson(result, Bean.class);
                List<Bean.DataBean> data = bean.getData();
                lv.setAdapter(new MyAdapter(data,mContext));
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
