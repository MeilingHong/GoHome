package com.quanjiakan.gohome.util;

import android.util.Log;

/**
 * Created by Administrator on 2017/5/31 0031.
 */

public class LogUtil {
    private static final String TAG = "GoHome";


    public static final void e(String msg){
        Log.e(TAG,msg+"");
    }

//    public static final void e(String tag,String msg){
//        if(tag!=null && tag.length()>0){
//            Log.e(tag,msg+"");
//        }else{
//            Log.e(TAG,msg+"");
//        }
//    }

}
