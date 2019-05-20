package com.wgheng.wanandroid.bean

/**
 * Created by wgheng on 2019/5/16.
 * Description :
 */
data class ArticleBean(
    val curPage: Int,
    val datas: List<Data>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
) {
    data class Data(

        val author: String,

        val chapterName: String

    )
}
