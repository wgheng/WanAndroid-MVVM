package com.wgheng.wanandroid.ui.home

import android.content.Context
import androidx.databinding.ObservableList
import com.wgheng.wanandroid.R
import com.wgheng.wanandroid.base.BaseRVAdapter
import com.wgheng.wanandroid.bean.ArticleBean
import com.wgheng.wanandroid.databinding.ItemArticleListBinding

/**
 * Created by wgheng on 2019/5/20.
 * Description :
 */
class ArticleListAdapter(context: Context, items: ObservableList<ArticleBean.Data>) :
    BaseRVAdapter<ItemArticleListBinding, ArticleBean.Data>(context, items) {

    override fun onItemBind(binding: ItemArticleListBinding?, itemModel: ArticleBean.Data) {
        binding?.item = itemModel
    }

    override fun getItemLayoutId(): Int {
        return R.layout.item_article_list
    }
}