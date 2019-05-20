package com.wgheng.wanandroid.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by wgheng on 2019/5/18.
 * Description :
 */
abstract class BaseActivity<VM : BaseViewModel, B : ViewDataBinding> : AppCompatActivity() {

    abstract val viewModel: VM?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<B>(this, getLayoutId())
        bindingViewModel(binding)
        setupView()
        setListener()
        viewModel?.start()
        initData()
    }

    protected open fun initData() {

    }


    abstract fun getLayoutId(): Int

    abstract fun bindingViewModel(binding: B)

    protected open fun setupView() {

    }

    protected open fun setListener(){

    }
}
