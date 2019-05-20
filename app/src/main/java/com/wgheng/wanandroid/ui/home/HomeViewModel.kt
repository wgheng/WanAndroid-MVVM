package com.wgheng.wanandroid.ui.home

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.orhanobut.logger.Logger
import com.wgheng.wanandroid.base.BaseViewModel
import com.wgheng.wanandroid.bean.ArticleBean
import com.wgheng.wanandroid.net.ApiObserver
import com.wgheng.wanandroid.net.DataManager

/**
 * Created by wgheng on 2019/5/20.
 * Description :
 */
class HomeViewModel : BaseViewModel() {

    companion object {
        const val PAGE_INIT = 0
    }

    var page: Int = PAGE_INIT

    var articleList: ObservableList<ArticleBean.Data> = ObservableArrayList()

    override fun start() {
        getArticleListData()
    }

    private fun getArticleListData() {
        DataManager
            .remoteRepository()
            .getArticleList(page)
            .subscribe(object : ApiObserver<ArticleBean>() {
                override fun doOnSuccess(data: ArticleBean?, msg: String?) {
                    Logger.e("$articleList")
                    if (data != null) {
                        articleList.addAll(data.datas)
                    }
                }
            })
    }

}