package test.bwie.com.slidingmenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * @ Description:
 * @ Date:2017/4/15
 * @ Author:刘刚
 */
@ContentView(R.layout.lv)
public class UserFragment extends Fragment {
    @ViewInject(R.id.lv)
    private ListView mLv;
    public String category;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  x.view().inject(this,inflater,container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MyXutils myXUtil = new MyXutils(mLv, getActivity());
        myXUtil.getXutils(category);
    }
}
