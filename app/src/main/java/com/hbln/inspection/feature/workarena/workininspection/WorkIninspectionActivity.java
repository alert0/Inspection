package com.hbln.inspection.feature.workarena.workininspection;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cmcc.lib_network.model.WorkTypeModel;
import com.cmcc.lib_utils.utils.LogUtils;
import com.hbln.inspection.R;
import com.hbln.inspection.feature.main.MainActivity;
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

public class WorkIninspectionActivity extends MVPBaseActivity<WorkIninspectionContract.View, WorkIninspectionPresenter> implements WorkIninspectionContract.View, RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener, RUAdapter.OnItemClickListener {
    public static String TITLE = "派驻纪检组";
    /** 纪律审查榜 */
    private RadioButton mRvWorkIn0;
    /** 信息数量榜 */
    private RadioButton mRvWorkIn1;
    /** 外宣数量榜 */
    private RadioButton mRvWorkIn2;
    private RadioGroup mRgWorkIn;

    private RUAdapter<WorkTypeModel.InfoBean> mAdapter0;
    private List<WorkTypeModel.InfoBean> mList0 = new ArrayList<>();
    private ListFragment<WorkTypeModel.InfoBean> mFragment0 = new ListFragment<>();
    private RUAdapter<WorkTypeModel.InfoBean> mAdapter1;
    private List<WorkTypeModel.InfoBean> mList1 = new ArrayList<>();
    private ListFragment<WorkTypeModel.InfoBean> mFragment1 = new ListFragment<>();
    private RUAdapter<WorkTypeModel.InfoBean> mAdapter2;
    private List<WorkTypeModel.InfoBean> mList2 = new ArrayList<>();
    private ListFragment<WorkTypeModel.InfoBean> mFragment2 = new ListFragment<>();
    private ViewPager mVpWorkIn;
    /** 索引 */
    private int index = 0;

    public static void start(Context context) {
        Intent starter = new Intent(context, WorkIninspectionActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected WorkIninspectionPresenter createPresenter() {
        return new WorkIninspectionPresenter();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_in_inspection);
        initView();
        mPresenter.loadData(0);
        mPresenter.loadData(1);
        mPresenter.loadData(2);
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
                .setRightDrawable(R.drawable.icon_work_dynamic, 0, 0, 0)
                .setRightClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        WorkDynamicActivity.start(getContext());
                    }
                })
                .setTitle(TITLE);
        mRvWorkIn0 = (RadioButton) findViewById(R.id.rv_work_in_0);
        mRvWorkIn1 = (RadioButton) findViewById(R.id.rv_work_in_1);
        mRvWorkIn2 = (RadioButton) findViewById(R.id.rv_work_in_2);
        mRgWorkIn = (RadioGroup) findViewById(R.id.rg_work_in);
        mRgWorkIn.setOnCheckedChangeListener(this);
        mVpWorkIn = (ViewPager) findViewById(R.id.vp_work_in);
        mVpWorkIn.addOnPageChangeListener(this);
        onCheckedChanged(mRgWorkIn, R.id.rv_work_in_0);

        initViewPager();
    }

    private void initViewPager() {
        mAdapter0 = new RUAdapter<WorkTypeModel.InfoBean>(getContext(), mList0, R.layout.item_work_in) {
            @Override
            protected void onInflateData(RUViewHolder holder, WorkTypeModel.InfoBean data, int position) {
                setItemData(holder, data, position);
            }
        };
        mFragment0.setAdapter(mAdapter0);
        mFragment0.setOnItemClickListener(this);

        mAdapter1 = new RUAdapter<WorkTypeModel.InfoBean>(getContext(), mList1, R.layout.item_work_in) {
            @Override
            protected void onInflateData(RUViewHolder holder, WorkTypeModel.InfoBean data, int position) {
                setItemData(holder, data, position);
            }
        };
        mFragment1.setAdapter(mAdapter1);
        mFragment1.setOnItemClickListener(this);

        mAdapter2 = new RUAdapter<WorkTypeModel.InfoBean>(getContext(), mList2, R.layout.item_work_in) {
            @Override
            protected void onInflateData(RUViewHolder holder, WorkTypeModel.InfoBean data, int position) {
                setItemData(holder, data, position);
            }
        };
        mFragment2.setAdapter(mAdapter2);
        mFragment2.setOnItemClickListener(this);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(mFragment0);
        fragmentList.add(mFragment1);
        fragmentList.add(mFragment2);
        mVpWorkIn.setAdapter(new FragmentViewPagerAdapter(getSupportFragmentManager(), fragmentList));
    }

    private void setItemData(RUViewHolder holder, WorkTypeModel.InfoBean data, int position) {
//        holder.setText(R.id.tv_item_work_in_name, data);
//        if (position == 0) {
//            holder.setBackgroundResource(R.id.iv_work_in_rank, R.drawable.img_work_in_num_0);
//            holder.setText(R.id.tv_item_work_in_num, 6 + "");
//            holder.setImageView(R.id.iv_work_in_status, R.drawable.ic_work_in_up);
//            return;
//        }
//        if (position == 1) {
//            holder.setBackgroundResource(R.id.iv_work_in_rank, R.drawable.img_work_in_num_1);
//            holder.setText(R.id.tv_item_work_in_num, 7 + "");
//            holder.setImageView(R.id.iv_work_in_status, R.drawable.ic_work_in_down);
//            TextView name = holder.getViewById(R.id.tv_item_work_in_name);
//            ViewUtils.setTextDrawable(name, 0, 0, 0, 0, getContext());
//            return;
//        }
//        if (position == 2) {
//            holder.setBackgroundResource(R.id.iv_work_in_rank, R.drawable.img_work_in_num_2);
//            holder.setText(R.id.tv_item_work_in_num, 9 + "");
//            holder.setImageView(R.id.iv_work_in_status, R.drawable.ic_work_in_up);
//            TextView name = holder.getViewById(R.id.tv_item_work_in_name);
//            ViewUtils.setTextDrawable(name, 0, 0, 0, 0, getContext());
//            return;
//        }
//
//        holder.setBackgroundResource(R.id.iv_work_in_rank, R.drawable.img_work_in_num_3);
//        holder.setText(R.id.iv_work_in_rank, (position + 1) + "");
//        holder.setText(R.id.tv_item_work_in_num, (position + 8) + "");
//        holder.setVisibility(R.id.iv_work_in_status, View.GONE);
//        TextView name = holder.getViewById(R.id.tv_item_work_in_name);
//        ViewUtils.setTextDrawable(name, 0, 0, 0, 0, getContext());
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rv_work_in_0:
                index = 0;
                break;
            case R.id.rv_work_in_1:
                index = 1;
                break;
            case R.id.rv_work_in_2:
                index = 2;
                break;
            default:
                break;
        }
        mVpWorkIn.setCurrentItem(index);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        index = position;
        switch (index) {
            case 0:
                mRvWorkIn0.setChecked(true);
                break;
            case 1:
                mRvWorkIn1.setChecked(true);
                break;
            case 2:
                mRvWorkIn2.setChecked(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void setData(WorkTypeModel data, int type) {
        data.initModel();
        LogUtils.e(data);

        if (type == 0) {
            mList0 = data.info;
            mAdapter0.setData(mList0);
        } else if (type == 1) {
            mList1 = data.info;
            mAdapter1.setData(mList1);
        } else {
            mList2 = data.info;
            mAdapter2.setData(mList2);
        }
    }

    @Override
    public void onItemClick(View view, int itemType, int position) {

    }
}
