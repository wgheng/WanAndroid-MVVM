package com.wgheng.wanandroid.ui.wxcolumn

import com.wgheng.wanandroid.R
import com.wgheng.wanandroid.base.BaseFragment
import com.wgheng.wanandroid.databinding.FragmentWxColumnBinding

/**
 * Created by wgheng on 2019/5/18.
 * Description :
 */
class WxColumnFragment : BaseFragment<WxColumnViewModel, FragmentWxColumnBinding>() {

    override fun createViewModel(): WxColumnViewModel? {
        return WxColumnViewModel()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_wx_column
    }

    override fun setupView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setViewModel(binding: FragmentWxColumnBinding) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun refreshPager() {


    }
}