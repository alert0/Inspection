package com.cmcc.inspection.feature.school.school;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cmcc.inspection.R;
import com.cmcc.inspection.feature.main.MainActivity;
import com.cmcc.inspection.feature.school.item.SchoolItemActivity;
import com.cmcc.inspection.mvp.MVPBaseActivity;
import com.cmcc.inspection.ui.Activity.BusnissListActivity;
import com.cmcc.inspection.ui.adapter.RUAdapter;
import com.cmcc.inspection.ui.adapter.RUViewHolder;
import com.cmcc.inspection.utils.TitleUtil;
import com.cmcc.lib_utils.utils.LogUtils;
import com.cmcc.lib_utils.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * <p> 清风讲堂 </p><br>
 *
 * @author lwc
 * @date 2017/12/15 20:24
 * @note -
 * -------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @note -
 */
public class SchoolActivity extends MVPBaseActivity<SchoolContract.View, SchoolPresenter> implements SchoolContract.View, RadioGroup.OnCheckedChangeListener {
    public static final String INTENT_INDEX = "index";
    public static final int INTENT_INDEX_SCHOOL = 0;
    public static final int INTENT_INDEX_ANSWER = 1;
    /** 清风讲坛 */
    private RadioButton mRbSchool0;
    /** 业务练兵 */
    private RadioButton mRbSchool1;
    private RadioGroup mRgSchool;
    private RecyclerView mRvSchool;
    
    private RUAdapter<Integer> mAdapter_0;
    private RUAdapter<Integer> mAdapter_1;
    private List<Integer> mList_0 = new ArrayList<>();
    private List<Integer> mList_1 = new ArrayList<>();
    private int index;
    
    public static void start(Context context) {
        start(context, 0);
    }
    
    public static void start(Context context, int index) {
        Intent starter = new Intent(context, SchoolActivity.class);
        starter.putExtra(INTENT_INDEX, index);
        context.startActivity(starter);
    }
    
    @Override
    protected SchoolPresenter createPresenter() {
        return new SchoolPresenter();
    }
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        initView();
        initData();
    }
    
    
    private void initView() {
        TitleUtil.attach(this).setLeftDrawable(R.drawable.icon_home, 0, 0, 0)
            .setLeftClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.start(getContext());
                }
            })
            .setColor(Color.WHITE, 255)
            .setTitle("反腐讲习所");
        mRbSchool0 = (RadioButton) findViewById(R.id.rb_school_0);
        mRbSchool1 = (RadioButton) findViewById(R.id.rb_school_1);
        mRgSchool = (RadioGroup) findViewById(R.id.rg_school);
        mRvSchool = (RecyclerView) findViewById(R.id.rv_school);
        
        mRgSchool.setOnCheckedChangeListener(this);
        
        initRecylerView();
        
    }
    
    private void initData() {
        index = getIntent().getIntExtra(INTENT_INDEX, -1);
        LogUtils.e(index);
        if (index != -1) {
            if (index == INTENT_INDEX_SCHOOL) {
                mRbSchool0.performClick();
            }
            if (index == INTENT_INDEX_ANSWER) {
                mRbSchool1.performClick();
            }
        }
    }
    
    private void initRecylerView() {
        mRvSchool.setLayoutManager(new LinearLayoutManager(getContext()));
        mList_0.add(R.drawable.img_shcool_2);
        mList_0.add(R.drawable.img_shcool_1);
        mList_0.add(R.drawable.img_shcool_0);
        mAdapter_0 = new RUAdapter<Integer>(getContext(), mList_0, R.layout.item_school_0) {
            @Override
            protected void onInflateData(RUViewHolder holder, Integer data, int position) {
                holder.setImageView(R.id.iv_item_shcool_0, data);
                holder.setText(R.id.tv_item_school_date, "最新更新时间：" + TimeUtils.getNowTimeString("yyyy-MM-dd"));
            }
        };
        mAdapter_0.setOnItemClickListener(new RUAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int itemType, int position) {
                SchoolItemActivity.start(getContext(), position);
            }
        });
        
        mList_1.add(R.drawable.img_school_answer_0);
        mList_1.add(R.drawable.img_school_answer_1);
        mList_1.add(R.drawable.img_school_answer_2);
        mAdapter_1 = new RUAdapter<Integer>(getContext(), mList_1, R.layout.item_school_answer_0) {
            @Override
            protected void onInflateData(RUViewHolder holder, Integer data, int position) {
                holder.setImageView(R.id.iv_item_shcool_answer_1, data);
                if (position == 1) {
                    holder.setText(R.id.tv_item_shcool_answer_1_title, "在线测试");
                }
                if (position == 2) {
                    holder.setText(R.id.tv_item_shcool_answer_1_title, "体会交流");
                    //holder.setImageView(R.id.iv_item_shcool_answer_1_status, R.drawable.icon_shchool_answer_press);
                }
            }
        };
        mAdapter_1.setOnItemClickListener(new RUAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int itemType, int position) {
                BusnissListActivity.start(getContext(), position);
            }
        });
    }
    
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_school_0:
                mRvSchool.setAdapter(mAdapter_0);
                break;
            case R.id.rb_school_1:
                mRvSchool.setAdapter(mAdapter_1);
                break;
            default:
                break;
        }
    }
}
