package com.wgheng.wanandroid.ui.home

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.wgheng.wanandroid.base.BaseViewModel
import com.wgheng.wanandroid.bean.ArticleBean

/**
 * Created by wgheng on 2019/5/20.
 * Description :
 */
class HomeViewModel : BaseViewModel() {

    var articleList: ObservableList<ArticleBean.Data> = ObservableArrayList()



}