package com.dfzt.kotlinnetwork.api

import com.dfzt.kotlinnetwork.entity.PhotoBean
import com.dfzt.kotlinnetwork.entity.PhotoData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 请求图片的一个api接口
 */
interface GankIOApi {
    /**
     * 采用注解的方式来拼接Url
     * baseUrl ==  http://gank.io/api
     *
     * 请求的接口  /data/%E7%A6%8F%E5%88%A9/10/20
     *
     * 这种情况是get请求的接口中直接携带参数就要使用@Path注解来改url的参数
     *
     */
    @GET("data/%E7%A6%8F%E5%88%A9/{pageSize}/{page}")
    fun getPhotos(@Path("pageSize") pageSize: Int,@Path("page") page: Int)
            : Observable<PhotoBean<PhotoData>>

}