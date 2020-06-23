package com.dfzt.kotlinnetwork.manager

import java.util.ArrayList
import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.collections.ArrayList

class ThreadPoolManager {

    //定义核心线程数
    private val corePoolSize = 3
    //定义最大线程数
    private val maximumPoolSize = Runtime.getRuntime().availableProcessors() * 2
    //非核心线程空闲时间
    private val keepTime = 5
    //非核心线程空闲线程等待时间单位
    private val unit = TimeUnit.SECONDS
    //阻塞队列
    private val blockingQueue: BlockingQueue<Runnable> = ArrayBlockingQueue(maximumPoolSize)
    //定义一个线程的工厂
    private val threadFactory = object : ThreadFactory {
        var integer = AtomicInteger()
        override fun newThread(runnable: Runnable): Thread {
            return Thread(runnable, "生成线程的编号为：" + integer.getAndIncrement())
        }
    }
    private var mThreadPoolExecutor: ThreadPoolExecutor? = null
    private constructor(){
        //创建线程池
        if (mThreadPoolExecutor == null || mThreadPoolExecutor!!.isShutdown() || mThreadPoolExecutor!!.isTerminated()) {
            synchronized(ThreadPoolManager::class.java) {
                if (mThreadPoolExecutor == null || mThreadPoolExecutor!!.isShutdown() || mThreadPoolExecutor!!.isTerminated()) {
                    mThreadPoolExecutor = ThreadPoolExecutor(
                        corePoolSize,
                        maximumPoolSize,
                        keepTime.toLong(),
                        unit,
                        blockingQueue,
                        threadFactory
                    )
                }
            }
        }
    }

    companion object{
        @Volatile
        private var mThreadPoolManager: ThreadPoolManager? = null

        fun getInstance(): ThreadPoolManager?{
            if (mThreadPoolManager == null){
                synchronized(ThreadPoolManager::class.java){
                    if (mThreadPoolManager == null){
                        mThreadPoolManager = ThreadPoolManager()
                    }
                }
            }
            return mThreadPoolManager
        }



    }
    //开始任务
    fun execute(runnable: Runnable){
        mThreadPoolExecutor?.execute(runnable)
    }
}
