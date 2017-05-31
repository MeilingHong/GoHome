package com.quanjiakan.gohome.presenter;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

public interface IPresenterBusinessCode {
    //TODO 保存特定的业务代码【特定的业务代码在项目中唯一，相同业务使用同一业务代码，处理业务时，传入业务代码，作为参数】
    int NONE = 30000;//TODO 标识不进行处理的业务代码
    int LOGIN = 30001;
    int SMS_CODE = 30002;
    int SIGNUP = 30003;
}
