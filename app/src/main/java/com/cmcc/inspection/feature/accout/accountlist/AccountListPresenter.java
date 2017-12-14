package com.cmcc.inspection.feature.accout.accountlist;

import com.cmcc.inspection.mvp.BasePresenterImpl;
import com.cmcc.lib_network.http.HttpComplete;
import com.cmcc.lib_network.http.HttpError;
import com.cmcc.lib_network.http.HttpRequest;
import com.cmcc.lib_network.http.HttpResult;
import com.cmcc.lib_network.model.MailModel;
import com.trello.rxlifecycle.android.ActivityEvent;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AccountListPresenter extends BasePresenterImpl<AccountListContract.View> implements AccountListContract.Presenter {
    
    @Override
    public void getMailData(final int index) {
        getView().showLoading("");
        String name = "";
        switch (index) {
            case 0:
                name = "科室";
                break;
            case 1:
                name = "派驻纪检组";
                break;
            case 2:
                name = "乡镇";
                break;
            case 3:
                name = "巡查机构";
                break;
            default:
                break;
        }
        HttpRequest.getUserService().tongxun(name)
            .compose(getView().getBaseActivity().<MailModel>applySchedulers(ActivityEvent.DESTROY))
            .subscribe(new HttpResult<MailModel>() {
                @Override
                public void result(MailModel mailModel) {
                    getView().setMailData(index, mailModel);
                }
            }, new HttpError(getView()), new HttpComplete(getView()));
    }
}
