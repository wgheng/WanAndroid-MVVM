package com.wgheng.wanandroid.ui.my

import com.wgheng.wanandroid.R
import com.wgheng.wanandroid.base.BaseFragment
import com.wgheng.wanandroid.databinding.FragmentMyBinding

/**
 * Created by wgheng on 2019/5/18.
 * Description :
 */
class MyFragment : BaseFragment<MyViewModel,FragmentMyBinding>() {
    override val viewModel: MyViewModel?
        get() = MyViewModel()

    override fun setupView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setViewModel(binding: FragmentMyBinding) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_my
    }

    fun refreshPager() {


    }

}