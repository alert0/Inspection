package com.cmcc.inspection.feature.inspect.visitanswer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.cmcc.inspection.R;
import com.cmcc.inspection.mvp.MVPBaseActivity;
import com.cmcc.inspection.utils.TitleUtil;
import com.cmcc.lib_network.model.JfShiTiModel;
import com.cmcc.lib_network.model.JiafangModel;
import com.cmcc.lib_utils.utils.LogUtils;
import com.cmcc.lib_utils.utils.TimeUtils;
import com.cmcc.lib_utils.utils.ToastUtils;
import com.hbln.lib_views.BottomPopupDialog;

import java.util.ArrayList;
import java.util.List;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class VisitAnswerActivity extends MVPBaseActivity<VisitAnswerContract.View, VisitAnswerPresenter> implements VisitAnswerContract.View, View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private static final String INTENT_KEY = "jiafangInfoBean";
    
    /** 纪检干部培训调查问卷 */
    private TextView mTvAnswerTitle;
    /** 2017-01-01    答题量：1234人 */
    private TextView mTvAnswerDate;
    /** 单选题 */
    private TextView mTvAnswerType;
    /** 中央改进工作作风、密切联系群众八项规定出台后，各地严格执行公务接待制度，严格落实各项节约措施，坚决杜  绝公款浪费现象。我国政府狠杀浪费之风有利于？ */
    private TextView mTvAnswerContent;
    /** 践行政府宗旨，用手中权力造福人民 */
    private RadioButton mRbAnswer0;
    /** 加强廉政建设，以清廉党风带好民风 */
    private RadioButton mRbAnswer1;
    /** 广泛吸收民智，增强决策公众参与度 */
    private RadioButton mRbAnswer2;
    /** 提升德行操守，树立政府威信 */
    private RadioButton mRbAnswer3;
    private RadioGroup mRgAnswer;
    /** 下一题 */
    private Button mBtnAnswerNext;
    
    private ImageButton mIbShaoolDetailFont;
    private ImageButton mIbShaoolDetailShare;
    private JiafangModel.JiafangInfoBean mBean;
    private JfShiTiModel mJfShiTiModel;
    private int danXuanIndex = 0;
    private int duoXuanIndex = 0;
    private int wenDaIndex = 0;
    private int index = 0;
    
    private List<String> stids = new ArrayList<>();
    private List<String> daids = new ArrayList<>();
    
    @Override
    protected VisitAnswerPresenter createPresenter() {
        return new VisitAnswerPresenter();
    }
    
    public static void start(Context context, JiafangModel.JiafangInfoBean jiafangInfoBean) {
        Intent starter = new Intent(context, VisitAnswerActivity.class);
        starter.putExtra(INTENT_KEY, jiafangInfoBean);
        context.startActivity(starter);
    }
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        mBean = getIntent().getParcelableExtra(INTENT_KEY);
        mPresenter.loadData(mBean);
        initView();
        TitleUtil.attach(this).setLeftDrawable(R.drawable.icon_back, 0, 0, 0)
            .setLeftClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            })
            .setTitle("线上家访")
            .setColor(Color.WHITE, 255);
    }
    
    private void initView() {
        mIbShaoolDetailFont = (ImageButton) findViewById(R.id.ib_shaool_detail_font);
        mIbShaoolDetailFont.setOnClickListener(this);
        mIbShaoolDetailShare = (ImageButton) findViewById(R.id.ib_shaool_detail_share);
        mIbShaoolDetailShare.setOnClickListener(this);
        mTvAnswerTitle = (TextView) findViewById(R.id.tv_answer_title);
        mTvAnswerDate = (TextView) findViewById(R.id.tv_answer_date);
        mTvAnswerType = (TextView) findViewById(R.id.tv_answer_type);
        mTvAnswerContent = (TextView) findViewById(R.id.tv_answer_content);
        mRbAnswer0 = (RadioButton) findViewById(R.id.rb_answer_0);
        mRbAnswer1 = (RadioButton) findViewById(R.id.rb_answer_1);
        mRbAnswer2 = (RadioButton) findViewById(R.id.rb_answer_2);
        mRbAnswer3 = (RadioButton) findViewById(R.id.rb_answer_3);
        mRgAnswer = (RadioGroup) findViewById(R.id.rg_answer);
        mRgAnswer.setOnCheckedChangeListener(this);
        mBtnAnswerNext = (Button) findViewById(R.id.btn_answer_next);
        mBtnAnswerNext.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_shaool_detail_font:
                final BottomPopupDialog fontDialog = new BottomPopupDialog(getContext(), R.layout.dialog_font, true);
                fontDialog.findViewById(R.id.btn_dialog_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fontDialog.cancel();
                    }
                });
                fontDialog.show();
                break;
            case R.id.ib_shaool_detail_share:
                final BottomPopupDialog shareDialog = new BottomPopupDialog(getContext(), R.layout.dialog_share, true);
                shareDialog.findViewById(R.id.btn_dialog_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shareDialog.cancel();
                    }
                });
                shareDialog.show();
                break;
            case R.id.btn_answer_next:
                if (index == 0) {
                    stids.add(mJfShiTiModel.info.danxuan.get(danXuanIndex - 1).id + ",");
                    if (TextUtils.isEmpty(getRbIndex())) {
                        ToastUtils.showShortToastSafe("请选择一个选项");
                        return;
                    }
                    daids.add(getRbIndex() + ",");
                } else if (index == 1) {
                    stids.add(mJfShiTiModel.info.danxuan.get(danXuanIndex - 1).id + ",");
                    if (TextUtils.isEmpty(getRbIndex())) {
                        ToastUtils.showShortToastSafe("请至少选择一个选项");
                        return;
                    }
                    daids.add(getRbIndex() + ",");
                } else {
                    stids.add(mJfShiTiModel.info.danxuan.get(danXuanIndex - 1).id + ",");
                    daids.add("问答,");
                }
                if (mJfShiTiModel.info.danxuan != null && danXuanIndex < mJfShiTiModel.info.danxuan.size()) {
                    LogUtils.e(danXuanIndex, mJfShiTiModel.info.danxuan.size());
                    resetDanXuanData(mJfShiTiModel.info.danxuan.get(danXuanIndex++));
                } else if (mJfShiTiModel.info.duoxuan != null && duoXuanIndex < mJfShiTiModel.info.duoxuan.size()) {
                    index = 1;
                    resetDanXuanData(mJfShiTiModel.info.danxuan.get(duoXuanIndex++));
                } else {
                    LogUtils.e(stids);
                    LogUtils.e(daids);
                    index = 2;
                    resetWenDaData(mJfShiTiModel.info.wenda.get(wenDaIndex++));
                }
                break;
        }
    }
    
    @Override
    public void setData(JfShiTiModel jfShiTiModel) {
        mJfShiTiModel = jfShiTiModel;
        mTvAnswerTitle.setText(mJfShiTiModel.info.title);
        mTvAnswerDate.setText(TimeUtils.millis2String(Long.valueOf(mJfShiTiModel.info.create_time) * 1000, "yyyy-MM-dd") + "\t\t" + "答题量" + mJfShiTiModel.info.duonums);
        
        resetDanXuanData(mJfShiTiModel.info.danxuan.get(danXuanIndex++));
    }
    
    public void resetDanXuanData(JfShiTiModel.ShiTiInfoBean.DanxuanBean danxuanBean) {
        mTvAnswerType.setText("单选题");
        mTvAnswerContent.setText(danXuanIndex + "、" + danxuanBean.title);
        
        for (int i = 0; i < danxuanBean.danan.size(); i++) {
            RadioButton button;
            
            if (i == 0) {
                button = mRbAnswer0;
            } else if (i == 1) {
                button = mRbAnswer1;
            } else if (i == 2) {
                button = mRbAnswer2;
            } else {
                button = mRbAnswer3;
            }
            if (TextUtils.isEmpty(danxuanBean.danan.get(i))) {
                button.setVisibility(View.GONE);
            } else {
                button.setVisibility(View.VISIBLE);
                button.setText(danxuanBean.danan.get(i));
            }
        }
    }
    
    public void resetDuoXuanData(JfShiTiModel.ShiTiInfoBean.DanxuanBean danxuanBean) {
        mTvAnswerType.setText("多选题");
        mTvAnswerContent.setText(danXuanIndex + "、" + danxuanBean.title);
        mRbAnswer0.setText(danxuanBean.danan.get(0));
        mRbAnswer1.setText(danxuanBean.danan.get(1));
        mRbAnswer2.setText(danxuanBean.danan.get(2));
        mRbAnswer3.setText(danxuanBean.danan.get(3));
    }
    
    public void resetWenDaData(JfShiTiModel.ShiTiInfoBean.WendaBean danxuanBean) {
        mTvAnswerType.setText("单选题");
        mTvAnswerContent.setText(danXuanIndex + "、" + danxuanBean.title);
        
    }
    
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_answer_0:
                break;
            case R.id.rb_answer_1:
                break;
            case R.id.rb_answer_2:
                break;
            case R.id.rb_answer_3:
                break;
            default:
                break;
        }
        
    }
    
    public String getRbIndex() {
        if (mRbAnswer0.isChecked()) {
            return "A";
        }
        if (mRbAnswer1.isChecked()) {
            return "B";
        }
        if (mRbAnswer2.isChecked()) {
            return "C";
        }
        if (mRbAnswer3.isChecked()) {
            return "D";
        }
        return "";
    }
    
}
