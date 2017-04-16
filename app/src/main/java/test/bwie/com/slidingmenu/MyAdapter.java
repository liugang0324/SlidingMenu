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

public class MyAdapter extends BaseAdapter {
  private Context mContext;
    private List<Bean.DataBean>list;

    public MyAdapter(List<Bean.DataBean> list, Context context) {
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
            convertView=View.inflate(mContext,R.layout.item,null);
            holder=new ViewHolder();
            holder.text1= (TextView) convertView.findViewById(R.id.textView);
            holder.text2= (TextView) convertView.findViewById(R.id.textView2);
            holder.text3= (TextView) convertView.findViewById(R.id.textView3);
         convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.text1.setText(list.get(position).getTitle());
        holder.text2.setText(list.get(position).getApply());
        holder.text3.setText(list.get(position).getBuy_price());

        return convertView;
    }

    class ViewHolder{
        TextView text1;
        TextView text2;
        TextView text3;
    }
}
