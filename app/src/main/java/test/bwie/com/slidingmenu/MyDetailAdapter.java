package test.bwie.com.slidingmenu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * @ Description:
 * @ Date:2017/4/15
 * @ Author:刘刚
 */

public class MyDetailAdapter extends BaseAdapter {
    private Context mContext;
    private List<Data.DataBean> list;

    public MyDetailAdapter(List<Data.DataBean> list, Context context) {
        this.list = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView=View.inflate(mContext,R.layout.detail,null);
            holder=new ViewHolder();
            holder.text= (TextView) convertView.findViewById(R.id.text_name);
         convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
          holder.text.setText(list.get(position).getName());
        return convertView;
    }
    class ViewHolder{
        TextView text;
    }
}
