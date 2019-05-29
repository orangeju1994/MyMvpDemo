package com.orange.mymvpdemo.okhttp;

import android.content.Context;

import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * <p>
 * Created by zhangjian on 2019/5/29.
 */
public class OkHttpManager {
    private static final byte[] LOCKER = new byte[0];
    private static OkHttpManager mInstance;
    private Context mContext;

    private OkHttpManager(Context context) {
        this.mContext = context.getApplicationContext();
        OkHttpClient.Builder ClientBuilder = new OkHttpClient.Builder();
        ClientBuilder.readTimeout(20, TimeUnit.SECONDS);//读取超时
        ClientBuilder.connectTimeout(10, TimeUnit.SECONDS);//连接超时
        ClientBuilder.writeTimeout(60, TimeUnit.SECONDS);//写入超时
    }

    public static void init(Context context) {
        if (mInstance == null) {
            synchronized (LOCKER) {
                if (mInstance == null) {
                    mInstance = new OkHttpManager(context.getApplicationContext());
                }
            }
        }
    }

    public static OkHttpManager getInstance() {
        return mInstance;
    }

    /**
     * GET请求
     */
    public void doGetRequest(String url, Map<String, String> params, final HttpRequestCallBack myCallBack) {
        //todo 做网络请求 成功调用myCallBack.onResponse 失败同理
    }

    public static abstract class HttpRequestCallBack<T> {
        Type mType;

        public HttpRequestCallBack() {
            mType = getSuperclassTypeParameter(getClass());
        }

        static Type getSuperclassTypeParameter(Class<?> subclass) {
            Type superclass = subclass.getGenericSuperclass();
            if (superclass instanceof Class) {
                throw new RuntimeException("Missing type parameter.");
            }
            ParameterizedType parameterized = (ParameterizedType) superclass;
            return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
        }

        public abstract void onError(Exception e);

        public abstract void onResponse(T response);
    }
}
