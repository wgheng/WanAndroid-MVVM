package com.wgheng.wanandroid.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.wgheng.wanandroid.utils.SpDelegate

/**
 * Created by wgheng on 2019/5/18.
 * Description :
 */
class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        Logger.addLogAdapter(AndroidLogAdapter())

        SpDelegate.setContext(this)
        initDebugTools()
    }

    /**
     * 初始化调试工具
     */
    private fun initDebugTools() {
        Stetho.initializeWithDefaults(this)
    }

}