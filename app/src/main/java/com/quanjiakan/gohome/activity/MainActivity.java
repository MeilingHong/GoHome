package com.quanjiakan.gohome.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.quanjiakan.gohome.R;
import com.quanjiakan.gohome.activity.lostchild.LostChildFragment;
import com.quanjiakan.gohome.activity.main.IndexFragment;
import com.quanjiakan.gohome.activity.myinfo.MyInfoFragment;
import com.quanjiakan.gohome.activity.task.TaskFragment;
import com.quanjiakan.gohome.base.BaseActivity;
import com.quanjiakan.gohome.module.net_result.Login_Result;
import com.quanjiakan.gohome.net.RetrofitUtil;
import com.quanjiakan.gohome.net.rx_service.RxLoginService;
import com.quanjiakan.gohome.util.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 使用Fragment形式
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.main)
    TextView main;
    @BindView(R.id.lost_child)
    TextView lostChild;
    @BindView(R.id.myinfo)
    TextView myinfo;
    @BindView(R.id.task)
    TextView task;
    @BindView(R.id.publish)
    RelativeLayout publish;

    private final int INDEX = 1;
    private final int LOSTCHILD = 2;
    private final int TASK = 3;
    private final int MYINFO = 4;
    private final String TAB_INDEX = "index";
    private final String TAB_LOSTCHILD = "lost_child";
    private final String TAB_TASK = "task";
    private final String TAB_MYINFO = "myinfo";

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    private int currentIndex = 0;

    private Fragment fragmentIndex;
    private Fragment fragmentLostchild;
    private Fragment fragmentTask;
    private Fragment fragmentMyInfo;
    private Fragment lastFragment;//记录上一个可见的Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setFragment(INDEX);
    }

    @OnClick({R.id.main, R.id.lost_child, R.id.myinfo, R.id.task, R.id.publish})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main:
                setFragment(INDEX);
                break;
            case R.id.lost_child:
                setFragment(LOSTCHILD);
                break;
            case R.id.myinfo:
                setFragment(MYINFO);
                break;
            case R.id.task:
                setFragment(TASK);
                break;
            case R.id.publish:
                break;
        }
    }

    public void setFragment(int motionType){
        if(fragmentManager==null){
            fragmentManager = getFragmentManager();
        }
        transaction = fragmentManager.beginTransaction();
        switch (motionType){
            case INDEX: {
                if(currentIndex==INDEX){
                    //TODO 控制重复刷新问题
                    LogUtil.e("刷新--  INDEX  ");
                    return;
                }else{
                    if(currentIndex!=0){
                        hideFragment(transaction,currentIndex);
                    }

                    LogUtil.e("载入--  INDEX  ");
                    currentIndex = INDEX;
                }

                //------

                //TODO 是否需要向Fragment中插入一些必要的数据
                //TODO 复用已有的Fragment,使Fragment中原有的数据能够保持
                if(fragmentIndex==null){
                    fragmentIndex = new IndexFragment();
                    transaction.add(R.id.container,fragmentIndex,TAB_INDEX);
                }else{
                    fragmentIndex = fragmentManager.findFragmentByTag(TAB_INDEX);
                    transaction.show(fragmentIndex);
                }
                transaction.commit();

                break;
            }
            case LOSTCHILD: {
                if(currentIndex==LOSTCHILD){
                    //TODO 控制重复刷新问题
                    LogUtil.e("刷新--  LOSTCHILD  ");
                    return;
                }else{
                    if(currentIndex!=0){
                        hideFragment(transaction,currentIndex);
                    }

                    LogUtil.e("载入--  LOSTCHILD  ");
                    currentIndex = LOSTCHILD;
                }



                //TODO 是否需要向Fragment中插入一些必要的数据
                if(fragmentLostchild==null){
                    fragmentLostchild = new LostChildFragment();
                    transaction.add(R.id.container,fragmentLostchild,TAB_LOSTCHILD);
                }else{
                    fragmentLostchild = fragmentManager.findFragmentByTag(TAB_LOSTCHILD);
                    transaction.show(fragmentLostchild);
                }
                transaction.commit();
                break;
            }
            case TASK: {
                if(currentIndex==TASK){
                    //TODO 控制重复刷新问题
                    LogUtil.e("刷新--  TASK  ");
                    return;
                }else{
                    if(currentIndex!=0){
                        hideFragment(transaction,currentIndex);
                    }

                    LogUtil.e("载入--  TASK  ");
                    currentIndex = TASK;
                }


                //TODO 是否需要向Fragment中插入一些必要的数据
                if(fragmentTask==null){
                    fragmentTask = new TaskFragment();
                    transaction.add(R.id.container,fragmentTask,TAB_TASK);
                }else{
                    fragmentTask = fragmentManager.findFragmentByTag(TAB_TASK);
                    transaction.show(fragmentTask);
                }
                transaction.commit();
                break;
            }
            case MYINFO: {
                if(currentIndex==MYINFO){
                    //TODO 控制重复刷新问题
                    LogUtil.e("刷新--  MYINFO  ");
                    return;
                }else{
                    if(currentIndex!=0){
                        hideFragment(transaction,currentIndex);
                    }

                    LogUtil.e("载入--  MYINFO  ");
                    currentIndex = MYINFO;
                }


                //TODO 是否需要向Fragment中插入一些必要的数据
                if(fragmentMyInfo==null){
                    fragmentMyInfo = new MyInfoFragment();
                    transaction.add(R.id.container,fragmentMyInfo,TAB_MYINFO);
                }else{
                    fragmentMyInfo = fragmentManager.findFragmentByTag(TAB_MYINFO);
                    transaction.show(fragmentMyInfo);
                }
                transaction.commit();
                break;
            }
        }
    }

    //隐藏指定的Fragment，在type变更前进行调用
    public void hideFragment(FragmentTransaction transaction,int type){
        switch (type){
            case INDEX: {
                lastFragment = fragmentManager.findFragmentByTag(TAB_INDEX);
                break;
            }
            case LOSTCHILD: {
                lastFragment = fragmentManager.findFragmentByTag(TAB_LOSTCHILD);
                break;
            }
            case TASK: {
                lastFragment = fragmentManager.findFragmentByTag(TAB_TASK);
                break;
            }
            case MYINFO: {
                lastFragment = fragmentManager.findFragmentByTag(TAB_MYINFO);
                break;
            }
        }

        transaction.hide(lastFragment);
    }


    public Object getParamter(int type) {
        switch (type) {
        }
        return null;
    }

    public void showMyDialog(int type) {
    }

    public void dismissMyDialog(int type) {
    }

    public void onSuccess(int type, int httpResponseCode, Object result) {
        switch (type) {
        }
    }

    public void onError(int type, int httpResponseCode, Object errorMsg) {
        switch (type) {
        }
    }



    /*
    TYPE_POST_DATA_PARAMS
    http://app.quanjiakan.com/familycare/api?devicetype=0&platform=2&client=1&m=member&a=signin
    Params:{"password":"8ABF29D717E0399C65BCA88F819DC795","client":"1","mobile":"18011935659"}
    Request Result:{"code":"200","message":"11303","token":"e515e0cac0028789346848e78506ebe6","nickname":"小小莫"}
     */
    //TODO 测试使用Retrofit
    public void netAccess() {
        Retrofit retrofit = RetrofitUtil.getRetrofit();
        RxLoginService loginService = retrofit.create(RxLoginService.class);
        loginService.doLogin("8ABF29D717E0399C65BCA88F819DC795", "1", "18011935659")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Login_Result>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("LOGUTIL", "Error:" + e.getMessage());
                    }

                    @Override
                    public void onNext(Login_Result response) {
                        Log.e("LOGUTIL", "Result:" + response.toString());
                    }
                });

    }

}
