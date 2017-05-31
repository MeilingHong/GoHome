package com.quanjiakan.gohome.net.rx_service;

import com.quanjiakan.gohome.module.net_result.Login_Result;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/5/22 0022.
 */

public interface RxLoginService {

    @FormUrlEncoded
    @POST("/familycare/api?devicetype=0&platform=2&client=1&m=member&a=signin")
    rx.Observable<Login_Result> doLogin(@Field("password") String password,
                                        @Field("client") String clientType,
                                        @Field("mobile") String mobilephone);
}
