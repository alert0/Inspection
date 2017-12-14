package com.cmcc.inspection.feature.school.answer;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;

import com.cmcc.inspection.R;
import com.cmcc.inspection.mvp.MVPBaseActivity;
import com.cmcc.inspection.utils.TitleUtil;
import com.hbln.lib_views.BottomPopupDialog;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AnswerActivity extends MVPBaseActivity<AnswerContract.View, AnswerPresenter> implements AnswerContract.View, View.OnClickListener {
    private ImageButton mIbShaoolDetailFont;
    private ImageButton mIbShaoolDetailShare;
    
    @Override
    protected AnswerPresenter createPresenter() {
        return new AnswerPresenter();
    }
    
    public static void start(Context context) {
        Intent starter = new Intent(context, AnswerActivity.class);
        context.startActivity(starter);
    }
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        initView();
        TitleUtil.attach(this).setLeftDrawable(R.drawable.icon_back, 0, 0, 0)
            .setLeftClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            })
            .setColor(Color.WHITE, 255);
    }
    
    private void initView() {
        mIbShaoolDetailFont = (ImageButton) findViewById(R.id.ib_shaool_detail_font);
        mIbShaoolDetailFont.setOnClickListener(this);
        mIbShaoolDetailShare = (ImageButton) findViewById(R.id.ib_shaool_detail_share);
        mIbShaoolDetailShare.setOnClickListener(this);
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
        }
    }
}
