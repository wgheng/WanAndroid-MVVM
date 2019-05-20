package com.wgheng.wanandroid.ui.home

import androidx.recyclerview.widget.LinearLayoutManager
import com.wgheng.wanandroid.R
import com.wgheng.wanandroid.base.BaseFragment
import com.wgheng.wanandroid.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by wgheng on 2019/5/18.
 * Description :
 */
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {
    override val viewModel: HomeViewModel?
        get() = HomeViewModel()

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun setupView() {
        recyclerView.adapter = ArticleListAdapter(context!!, viewModel!!.articleList)
        recyclerView.layoutManager = LinearLayoutManager(context!!)
    }

    override fun setViewModel(binding: FragmentHomeBinding) {

    }

    fun refreshPager() {

    }

}