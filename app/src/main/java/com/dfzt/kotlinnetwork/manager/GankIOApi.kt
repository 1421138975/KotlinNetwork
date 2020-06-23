package com.dfzt.kotlinnetwork.manager

import com.dfzt.kotlinnetwork.base.NetWorkApi
import com.dfzt.kotlinnetwork.interceptor.GankIORequestInterceptor
import okhttp3.Interceptor

/**
 * 就是通过retrofit 动态代理GankIOApi接口返回结果
 */
class GankIOApi : NetWorkApi{

    //双重加锁校验


    //这里就是返回一个baseurl给 NetWorkApi
    private constructor(): super("http://gank.io/api/")

    companion object{
        @Volatile //保证变量的原子性 (就是别的地方一改变这个值 ，这个值就改变了)
        private var mGankIOApi: GankIOApi? = null

        //通过传递一个接口对象 我要返回这个接口的实例给你
        fun <T> getServiceApi(cls: Class<T>): T?{
            return getInstence()?.getRetrofit(cls)?.create(cls)
        }


        fun getInstence(): GankIOApi?{
            if (mGankIOApi == null){
                synchronized(GankIOApi::class.java){
                    if (mGankIOApi == null){
                        mGankIOApi = GankIOApi()
                    }
                }
            }
            return mGankIOApi
        }

    }



    //这个是自己定义个一个拦截器
    override fun getInterceptor(): Interceptor {
        return GankIORequestInterceptor()
    }
}