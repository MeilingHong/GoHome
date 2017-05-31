package com.quanjiakan.gohome.module.net_result;

/**
 * Created by Administrator on 2017/5/22 0022.
 */

public class Login_Result {

    /**
     * code : 200
     * message : 11303
     * token : e515e0cac0028789346848e78506ebe6
     * nickname : 小小莫
     */

    private String code;
    private String message;
    private String token;
    private String nickname;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Login_Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", token='" + token + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
