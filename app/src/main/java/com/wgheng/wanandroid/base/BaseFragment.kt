package com.wgheng.wanandroid.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Created by wgheng on 2019/5/18.
 * Description :
 */
abstract class BaseFragment<VM : BaseViewModel, B : ViewDataBinding> : Fragment() {

    abstract val viewModel: VM?

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<B>(inflater, getLayoutId(), container, false)
        setViewModel(binding)
        setupView()
        return binding.root
    }

    abstract fun setupView()

    abstract fun setViewModel(binding: B)

    abstract fun getLayoutId(): Int

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel?.start()
        initData()
    }

    protected open fun initData() {

    }


}