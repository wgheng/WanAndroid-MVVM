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

    var viewModel: VM? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = createViewModel()
        val binding = DataBindingUtil.inflate<B>(inflater, getLayoutId(), container, false)
        setViewModel(binding)
        return binding.root
    }

    abstract fun createViewModel(): VM?

    abstract fun setupView()

    abstract fun setViewModel(binding: B)

    abstract fun getLayoutId(): Int

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupView()
        setListener()
        viewModel?.start()
        initData()
    }

    protected open fun setListener() {

    }

    protected open fun initData() {

    }


}