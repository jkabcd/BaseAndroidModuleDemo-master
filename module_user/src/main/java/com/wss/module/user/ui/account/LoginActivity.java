package com.wss.module.user.ui.account;

import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wss.common.base.ActionBarActivity;
import com.wss.common.bean.Event;
import com.wss.common.bean.User;
import com.wss.common.constants.ARouterConfig;
import com.wss.common.constants.EventAction;
import com.wss.common.utils.ActivityToActivity;
import com.wss.common.utils.EventBusUtils;
import com.wss.common.utils.ToastUtils;
import com.wss.common.utils.UserInfoUtils;
import com.wss.common.widget.ObserverButton;
import com.wss.module.user.R;
import com.wss.module.user.R2;
import com.wss.module.user.ui.account.mvp.LoginPresenter;
import com.wss.module.user.ui.account.mvp.contract.LoginContract;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Describe：登录
 * Created by 吴天强 on 2018/11/13.
 */
@Route(path = ARouterConfig.USER_LOGIN)
public class LoginActivity extends ActionBarActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R2.id.edt_name)
    EditText edtName;

    @BindView(R2.id.edt_pwd)
    EditText edtPwd;

    @BindView(R2.id.ob_login)
    ObserverButton obLogin;

    @BindView(R2.id.ob_register)
    TextView obRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.user_activity_login;
    }

    @Override
    protected void initView() {
        setTitleText("登录");
        obLogin.observer(edtName, edtPwd);
    }


    @OnClick({R2.id.ob_login, R2.id.ob_register})
    public void onViewClicked(View view) {
//        int i = view.getId();
//        if (i == R.id.ob_login) {
//            presenter.login();
//        } else if (i == R.id.ob_register) {
//            ActivityToActivity.toActivity(mContext, RegisterActivity.class);
//        }
                int i = view.getId();
        if (i == R.id.ob_login) {
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                File file = new File(Environment.getExternalStorageDirectory().toString()+"/user.txt");
                try {
                    FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write("我叫,张李四");
                    bufferedWriter.close();
                    ToastUtils.showToast(mContext,"完成");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                ToastUtils.showToast(mContext,"SD卡无法使用");
            }
        } else if (i == R.id.ob_register) {
            StringBuilder stringBuilder = new StringBuilder();
            File file = new File(Environment.getExternalStorageDirectory().toString()+"/user.txt");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = null;
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String text;
                try {
                    while ((text=bufferedReader.readLine())!=null){
                        stringBuilder.append(text);
                    }
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ToastUtils.showToast(mContext,stringBuilder.toString());
        }

    }

    @Override
    public void loginSuccess(User user) {
        UserInfoUtils.saveUser(user);
        EventBusUtils.sendEvent(new Event(EventAction.EVENT_LOGIN_SUCCESS));
        finish();
    }


    @Override
    public void onError(Object tag, String errorMsg) {
        super.onError(tag, errorMsg);
        ToastUtils.showToast(mContext, errorMsg);
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void onEventBus(Event event) {
        super.onEventBus(event);
        if (TextUtils.equals(event.getAction(), EventAction.EVENT_REGISTER_SUCCESS)) {
            finish();
        }
    }

    @Override
    protected boolean regEvent() {
        return true;
    }

    @Override
    public User getUserInfo() {
        return new User(edtName.getText().toString().trim(), edtPwd.getText().toString().trim());
    }
}
