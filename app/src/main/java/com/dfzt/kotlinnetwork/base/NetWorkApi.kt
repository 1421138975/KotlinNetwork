package com.dfzt.kotlinnetwork.base

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class NetWorkApi {

    /**
     * Retrofit 里面需要什么参数
     * 1. baseUrl
     * 2. okhttclient
     */
    private var mBaseUrl: String? = null
    //定一个OkhttpClient
    private var mOkHttpClient: OkHttpClient? = null
    //定义一个map集合 相同的网络请求就不再去创建Retrofit对象
    private var mCacheRetrofit: HashMap<String,Retrofit>  = HashMap()

    protected constructor(mBaseUrl: String?){
        this.mBaseUrl = mBaseUrl
    }

    protected fun <T> getRetrofit(cls: Class<T>): Retrofit{
        //1.先去map集合里面取  如果有 直接返回 没有就创建
        var mRetrofit = mCacheRetrofit.get(mBaseUrl + cls.name);
        if (mRetrofit != null){
            return mRetrofit
        }
        mRetrofit = Retrofit.Builder().baseUrl(mBaseUrl)
            //设置Okhttp的请求
            .client(getOkhttpClient())
            //设置GSON解析
            .addConverterFactory(GsonConverterFactory.create())
            //设置返回的适配器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return mRetrofit
    }


    fun getOkhttpClient(): OkHttpClient{
        //双重加锁校验
        if (mOkHttpClient == null){
            synchronized(NetWorkApi::class.java){
                if (mOkHttpClient == null){
                    val okHttpClient = OkHttpClient.Builder()
                        .retryOnConnectionFailure(true)
                        .connectTimeout(15, TimeUnit.SECONDS)
                        .readTimeout(45, TimeUnit.SECONDS)
                        .writeTimeout(55, TimeUnit.SECONDS)
                    //设置一个拦截器 (请求的拦截器里面如果需要添加头部信息 可以加在这个拦截器里面)
                    okHttpClient.addInterceptor(getInterceptor())
                    mOkHttpClient = okHttpClient.build()
                }
            }
        }

        return mOkHttpClient!!
    }

    //设置域名的拦截器
    protected abstract fun getInterceptor(): Interceptor

    companion object {
        /**
         * 定义一个切换线程的方法
         */
        fun <T> applySchedulers(observer: Observer<T>): ObservableTransformer<T, T> {
            return object : ObservableTransformer<T, T> {
                override fun apply(upstream: Observable<T>): ObservableSource<T> {
                    val observable = upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                    observable.subscribe(observer)
                    return observable
                }

            }
        }
    }
}