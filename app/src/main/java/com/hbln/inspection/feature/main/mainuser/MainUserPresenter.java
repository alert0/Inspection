package com.hbln.inspection.feature.main.mainuser;

import com.cmcc.lib_network.http.HttpComplete;
import com.cmcc.lib_network.http.HttpError;
import com.cmcc.lib_network.http.HttpRequest;
import com.cmcc.lib_network.http.HttpResult;
import com.cmcc.lib_network.http.NetWorkInterceptor;
import com.cmcc.lib_network.model.LoginModel;
import com.cmcc.lib_network.model.ObjectModel;
import com.cmcc.lib_network.model.UserInfoModel;
import com.hbln.inspection.feature.accout.login.LoginActivity;
import com.hbln.inspection.mvp.BasePresenterImpl;
import com.trello.rxlifecycle.android.ActivityEvent;

import rx.functions.Action1;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MainUserPresenter extends BasePresenterImpl<MainUserContract.View> implements MainUserContract.Presenter {

    @Override
    public void loadUserInfo() {
        LoginModel.getUserInfo(new Action1<UserInfoModel.UserInfo>() {
            @Override
            public void call(UserInfoModel.UserInfo userInfo) {
                getView().resultUserInfo(userInfo);
            }
        });
    }

    @Override
    public void loadRead() {
        HttpRequest.getUserService().yuedulv()
                .compose(NetWorkInterceptor.<ObjectModel>retrySessionCreator())
                .compose(getView().getBaseActivity().<ObjectModel>applySchedulers(ActivityEvent.DESTROY))
                .subscribe(new HttpResult<ObjectModel>() {
                    @Override
                    public void result(ObjectModel ObjectModel) {
                        getView().resultRead(ObjectModel);
                    }
                }, new HttpError(getView()) {
                    @Override
                    public void call(Throwable throwable) {
                    }
                }, new HttpComplete(getView()));
    }

    @Override
    public void logout() {
        LoginModel.logout();
        LoginActivity.start(getView().getBaseActivity());
    }
}
