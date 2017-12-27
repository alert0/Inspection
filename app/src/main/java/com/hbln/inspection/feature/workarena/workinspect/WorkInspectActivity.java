package com.hbln.inspection.feature.workarena.workinspect;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.cmcc.lib_network.model.WorkTypeModel;
import com.cmcc.lib_utils.utils.TimeUtils;
import com.hbln.inspection.R;
import com.hbln.inspection.feature.workarena.workdynamic.WorkDynamicActivity;
import com.hbln.inspection.mvp.MVPBaseActivity;
import com.hbln.inspection.ui.adapter.FragmentViewPagerAdapter;
import com.hbln.inspection.ui.adapter.RUAdapter;
import com.hbln.inspection.ui.adapter.RUViewHolder;
import com.hbln.inspection.ui.fragment.ListFragment;
import com.hbln.inspection.utils.TitleUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class WorkInspectActivity extends MVPBaseActivity<WorkInspectContract.View, WorkInspectPresenter> implements WorkInspectContract.View, RadioGroup.OnCheckedChangeListener, View.OnClickListener, ViewPager.OnPageChangeListener {
    /** 巡查报告 */
    private RadioButton mRbWorkInspection0;
    /** 移交线索 */
    private RadioButton mRbWorkInspection1;
    /** 信息数量 */
    private RadioButton mRbWorkInspection2;
    /** 外宣数量 */
    private RadioButton mRbWorkInspection3;
    private RadioGroup mRgWorkInspection;
    
    private RUAdapter<WorkTypeModel.InfoBean> mAdapter0;
    private List<WorkTypeModel.InfoBean> mList0 = new ArrayList<>();
    private ListFragment<WorkTypeModel.InfoBean> mFragment0 = new ListFragment<>();
    private RUAdapter<WorkTypeModel.InfoBean> mAdapter1;
    private List<WorkTypeModel.InfoBean> mList1 = new ArrayList<>();
    private ListFragment<WorkTypeModel.InfoBean> mFragment1 = new ListFragment<>();
    private RUAdapter<WorkTypeModel.InfoBean> mAdapter2;
    private List<WorkTypeModel.InfoBean> mList2 = new ArrayList<>();
    private ListFragment<WorkTypeModel.InfoBean> mFragment2 = new ListFragment<>();
    private RUAdapter<WorkTypeModel.InfoBean> mAdapter3;
    private List<WorkTypeModel.InfoBean> mList3 = new ArrayList<>();
    private ListFragment<WorkTypeModel.InfoBean> mFragment3 = new ListFragment<>();
    
    private ViewPager mVpWork;
    /** 索引 */
    private int index = 0;
    /** 2017年12月 */
    private TextView mTvWorkMonth;
    private String[] month;
    
    @Override
    protected WorkInspectPresenter createPresenter() {
        return new WorkInspectPresenter();
    }
    
    public static void start(Context context) {
        Intent starter = new Intent(context, WorkInspectActivity.class);
        context.startActivity(starter);
    }
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_inspection);
        initView();
        mPresenter.loadData(0, null);
        mPresenter.loadData(1, null);
        mPresenter.loadData(2, null);
        mPresenter.loadData(3, null);
    }
    
    private void initView() {
        TitleUtil.attach(this).setLeftDrawable(R.drawable.icon_home, 0, 0, 0)
            .setColor(Color.WHITE, 255)
            .setRightDrawable(R.drawable.icon_work_dynamic, 0, 0, 0)
            .setRightClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WorkDynamicActivity.start(getContext());
                }
            })
            .setTitle("巡察机构");
        mTvWorkMonth = (TextView) findViewById(R.id.tv_work_month);
        mVpWork = (ViewPager) findViewById(R.id.vp_work);
        mVpWork.addOnPageChangeListener(this);
        mTvWorkMonth.setOnClickListener(this);
        mTvWorkMonth.setText(TimeUtils.getNowTimeString("yyyy年MM月"));
        mRbWorkInspection0 = (RadioButton) findViewById(R.id.rb_work_inspection_0);
        mRbWorkInspection1 = (RadioButton) findViewById(R.id.rb_work_inspection_1);
        mRbWorkInspection2 = (RadioButton) findViewById(R.id.rb_work_inspection_2);
        mRbWorkInspection3 = (RadioButton) findViewById(R.id.rb_work_inspection_3);
        mRgWorkInspection = (RadioGroup) findViewById(R.id.rg_work_inspection);
        mRgWorkInspection.setOnCheckedChangeListener(this);
        onCheckedChanged(mRgWorkInspection, R.id.rv_work_in_0);
        
        initViewPager();
        
    }
    
    private void initViewPager() {
        mAdapter0 = new RUAdapter<WorkTypeModel.InfoBean>(getContext(), mList0, R.layout.item_work_in) {
            @Override
            protected void onInflateData(RUViewHolder holder, WorkTypeModel.InfoBean data, int position) {
                setItemData(holder, data, position);
                holder.setText(R.id.tv_item_work_in_type, "报告数量");
                ProgressBar bar = holder.getViewById(R.id.pb_item_work_in);
                bar.setProgress((data.nums * 100 / mList0.get(0).nums));
            }
        };
        mFragment0.setAdapter(mAdapter0);
        
        mAdapter1 = new RUAdapter<WorkTypeModel.InfoBean>(getContext(), mList1, R.layout.item_work_in) {
            @Override
            protected void onInflateData(RUViewHolder holder, WorkTypeModel.InfoBean data, int position) {
                setItemData(holder, data, position);
                holder.setText(R.id.tv_item_work_in_type, "线索数量");
                ProgressBar bar = holder.getViewById(R.id.pb_item_work_in);
                bar.setProgress((data.nums * 100 / mList1.get(0).nums));
            }
        };
        mFragment1.setAdapter(mAdapter1);
        
        mAdapter2 = new RUAdapter<WorkTypeModel.InfoBean>(getContext(), mList2, R.layout.item_work_in) {
            @Override
            protected void onInflateData(RUViewHolder holder, WorkTypeModel.InfoBean data, int position) {
                setItemData(holder, data, position);
                holder.setText(R.id.tv_item_work_in_type, "信息数量");
                ProgressBar bar = holder.getViewById(R.id.pb_item_work_in);
                bar.setProgress((data.nums * 100 / mList2.get(0).nums));
            }
        };
        mFragment2.setAdapter(mAdapter2);
        
        mAdapter3 = new RUAdapter<WorkTypeModel.InfoBean>(getContext(), mList3, R.layout.item_work_in) {
            @Override
            protected void onInflateData(RUViewHolder holder, WorkTypeModel.InfoBean data, int position) {
                setItemData(holder, data, position);
                holder.setText(R.id.tv_item_work_in_type, "外宣数量");
                ProgressBar bar = holder.getViewById(R.id.pb_item_work_in);
                bar.setProgress((data.nums * 100 / mList2.get(0).nums));
            }
        };
        mFragment3.setAdapter(mAdapter3);
        
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(mFragment0);
        fragmentList.add(mFragment1);
        fragmentList.add(mFragment2);
        fragmentList.add(mFragment3);
        mVpWork.setAdapter(new FragmentViewPagerAdapter(getSupportFragmentManager(), fragmentList));
    }
    
    private void setItemData(RUViewHolder holder, WorkTypeModel.InfoBean data, int position) {
        holder.setText(R.id.tv_item_work_in_name, data.danwei);
        TextView diff = holder.getViewById(R.id.tv_item_work_in_diff);
        if (data.diff >= 0) {
            diff.setText("+" + data.diff + "");
            diff.setTextColor(Color.parseColor("#3C7F7D"));
        } else {
            diff.setText("-" + (-data.diff) + "");
            diff.setTextColor(Color.parseColor("#FF0041"));
        }
        holder.setText(R.id.tv_item_work_in_num, data.nums + "");
        
        if (data.paiming == 1) {
            holder.setBackgroundResource(R.id.iv_work_in_rank, R.drawable.img_work_in_num_0);
        } else if (data.paiming == 2) {
            holder.setBackgroundResource(R.id.iv_work_in_rank, R.drawable.img_work_in_num_1);
        } else if (data.paiming == 3) {
            holder.setBackgroundResource(R.id.iv_work_in_rank, R.drawable.img_work_in_num_2);
        } else {
            holder.setBackgroundResource(R.id.iv_work_in_rank, R.drawable.img_work_in_num_3);
            holder.setText(R.id.iv_work_in_rank, (position + 1) + "");
        }
    }
    
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_work_inspection_0:
                index = 0;
                break;
            case R.id.rb_work_inspection_1:
                index = 1;
                break;
            case R.id.rb_work_inspection_2:
                index = 2;
                break;
            case R.id.rb_work_inspection_3:
                index = 3;
                break;
            default:
                break;
        }
        mVpWork.setCurrentItem(index);
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_work_month:
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                
                int mm = Integer.valueOf(TimeUtils.getNowTimeString("MM"));
                month = new String[mm];
                for (int i = 0; i < mm; i++) {
                    month[i] = TimeUtils.getNowTimeString("yyyy年") + (i + 1) + "月";
                }
                builder.setItems(month, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mTvWorkMonth.setText(month[which]);
                        String date = TimeUtils.date2String(TimeUtils.string2Date(month[which], "yyyy年MM月"), "yyyy-MM");
                        mPresenter.loadData(0, date);
                        mPresenter.loadData(1, date);
                        mPresenter.loadData(2, date);
                    }
                });
                builder.create().show();
                break;
            default:
                break;
        }
    }
    
    @Override
    public void setData(WorkTypeModel data, int type) {
        data.initModel();
        if (type == 0) {
            mList0 = data.info;
            mAdapter0.setData(mList0);
        } else if (type == 1) {
            mList1 = data.info;
            mAdapter1.setData(mList1);
        } else if (type == 2) {
            mList2 = data.info;
            mAdapter2.setData(mList2);
        } else {
            mList3 = data.info;
            mAdapter3.setData(mList3);
        }
    }
    
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        
    }
    
    @Override
    public void onPageSelected(int position) {
        index = position;
        switch (index) {
            case 0:
                mRbWorkInspection0.setChecked(true);
                break;
            case 1:
                mRbWorkInspection1.setChecked(true);
                break;
            case 2:
                mRbWorkInspection2.setChecked(true);
                break;
            case 3:
                mRbWorkInspection3.setChecked(true);
                break;
            default:
                break;
        }
    }
    
    @Override
    public void onPageScrollStateChanged(int state) {
        
    }
}
