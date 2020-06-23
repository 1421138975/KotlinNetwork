package com.dfzt.kotlinnetwork

import android.util.Log
import com.dfzt.kotlinnetwork.base.BaseActivity
import com.dfzt.kotlinnetwork.base.NetWorkApi
import com.dfzt.kotlinnetwork.entity.PhotoBean
import com.dfzt.kotlinnetwork.entity.PhotoData
import com.dfzt.kotlinnetwork.manager.GankIOApi
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private var mDisposable: Disposable? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()
        val mGankIOApi = GankIOApi.getServiceApi(com.dfzt.kotlinnetwork.api.GankIOApi::class.java)

        main_btn.setOnClickListener {
            mGankIOApi?.getPhotos(10,1)
                ?.compose(NetWorkApi.applySchedulers(object : Observer<PhotoBean<PhotoData>> {
                    override fun onComplete() {
                        Log.e("PPS","网络请求完成")
                    }

                    override fun onSubscribe(d: Disposable) {
                        mDisposable = d
                        Log.e("PPS","开始订阅")
                    }

                    override fun onNext(t: PhotoBean<PhotoData>) {
                        Log.e("PPS","获取到了请求结果" + t.toString())
                    }

                    override fun onError(e: Throwable) {
                        Log.e("PPS","获取失败")
                    }

                }))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mDisposable != null){
            if(!mDisposable!!.isDisposed){
                //这就是终止回调 防止内存泄漏
                mDisposable?.dispose()
            }
        }
    }

}
