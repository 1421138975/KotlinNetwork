package com.dfzt.kotlinnetwork.base

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        initData()
    }

    //获取布局文件
    abstract fun getLayoutId(): Int

    /**
     *
     * 加了open 就是 == java的  public void initView()
     * 不加open 就是 == java的 public final void initView()
     */
    open fun initView(){

    }

    open fun initData(){

    }

    protected fun toast(msg: String){
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show()
    }
}