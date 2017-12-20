package com.cmcc.inspection.ui.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cmcc.inspection.R;
import com.cmcc.inspection.feature.school.answer.AnswerActivity;
import com.cmcc.inspection.ui.adapter.RUAdapter;
import com.cmcc.inspection.ui.adapter.RUViewHolder;
import com.cmcc.inspection.utils.TitleUtil;
import com.cmcc.lib_common.base.BaseActivity;
import com.cmcc.lib_network.http.HttpComplete;
import com.cmcc.lib_network.http.HttpError;
import com.cmcc.lib_network.http.HttpRequest;
import com.cmcc.lib_network.http.HttpResult;
import com.cmcc.lib_network.http.NetWorkInterceptor;
import com.cmcc.lib_network.model.KaoShiModel;
import com.trello.rxlifecycle.android.ActivityEvent;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * <p>describe</p><br>
 *
 * @author - lwc
 * @date - 2017/12/19
 * @note -
 * -------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @note -
 */
public class BusnissListActivity extends BaseActivity implements RUAdapter.OnItemClickListener {
    public static final String INTENT_TYPE = "type";
    public static final int TYPE_XUEXI = 0;
    public static final int TYPE_CESHI = 1;
    public static final int TYPE_TIHUI = 2;
    public static boolean hasSearch = true;
    public int mType = 0;
    
    private LinearLayout mLlListSeach;
    private EditText mEtListSeach;
    private ImageView mIvlistSearch;
    private RecyclerView mRvList;
    private RUAdapter<KaoShiModel.InfoBean> mAdapter;
    private List<KaoShiModel.InfoBean> mList = new ArrayList<>();
    
    public static void start(Context context, int type) {
        Intent starter = new Intent(context, BusnissListActivity.class);
        starter.putExtra(INTENT_TYPE, type);
        context.startActivity(starter);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mType = getIntent().getIntExtra(INTENT_TYPE, 0);
        initView();
        loadData();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        hasSearch = true;
    }
    
    private void initView() {
        String title;
        if (mType == TYPE_XUEXI) {
            title = "学习资料";
        } else if (mType == TYPE_CESHI) {
            title = "在线测试";
        } else {
            title = "体会交流";
        }
        TitleUtil.attach(this)
            .setTitle(title)
            .setBack(true);
        mLlListSeach = (LinearLayout) findViewById(R.id.ll_search);
        mEtListSeach = (EditText) findViewById(R.id.et_search);
        mIvlistSearch = (ImageView) findViewById(R.id.iv_search);
        mRvList = (RecyclerView) findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new RUAdapter<KaoShiModel.InfoBean>(getContext(), mList, R.layout.item_school_item) {
            @Override
            protected void onInflateData(RUViewHolder holder, KaoShiModel.InfoBean data, int position) {
                holder.setText(R.id.tv_item_shcool_item_title, data.title);
                if (TextUtils.isEmpty(data.pic)) {
                    holder.setVisibility(R.id.iv_item_shcool_item, View.GONE);
                } else {
                    holder.setVisibility(R.id.iv_item_shcool_item, View.VISIBLE);
                    holder.setImageNet(R.id.tv_item_fortress_name, data.pic);
                }
                holder.setText(R.id.tv_item_shcool_item_data, data.times);
            }
        };
        mAdapter.setOnItemClickListener(this);
        mRvList.setAdapter(mAdapter);
    }
    
    public void loadData() {
        Observable<KaoShiModel> request;
        if (mType == TYPE_XUEXI) {
            request = HttpRequest.getKaoShiService().index("学习资料");
        } else if (mType == TYPE_CESHI) {
            request = HttpRequest.getKaoShiService().index("在线测试");
        } else {
            request = HttpRequest.getKaoShiService().tihuijiaoliu();
        }
        
        showLoading("");
        request.compose(NetWorkInterceptor.<KaoShiModel>retrySessionCreator())
            .compose(getBaseActivity().<KaoShiModel>applySchedulers(ActivityEvent.DESTROY))
            .subscribe(new HttpResult<KaoShiModel>() {
                @Override
                public void result(KaoShiModel objectModel) {
                    setKaoShiData(objectModel);
                }
            }, new HttpError(this), new HttpComplete(this));
    }
    
    public void setKaoShiData(KaoShiModel kaoShiData) {
        mList = kaoShiData.info;
        mAdapter.setData(mList);
    }
    
    @Override
    public void onItemClick(View view, int itemType, int position) {
        if (mType == TYPE_XUEXI || mType == TYPE_CESHI) {
            AnswerActivity.start(getContext(), mList.get(position).id);
        } else {
            TiHuiActivity.start(getContext(), mList.get(position).id);
        }
    }
}
