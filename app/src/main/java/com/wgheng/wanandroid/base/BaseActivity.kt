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

    var viewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if (savedInstanceState != null) {
//            val fragments = supportFragmentManager.fragments
//            if (fragments.isNotEmpty()) {
//                val transaction = supportFragmentManager.beginTransaction()
//                for (fragment in fragments) {
//                    transaction.remove(fragment)
//                }
//                transaction.commitAllowingStateLoss()
//            }
//        }
        viewModel = createViewModel()
        val binding = DataBindingUtil.setContentView<B>(this, getLayoutId())
        bindingViewModel(binding)
        setupView(savedInstanceState)
        setListener()
        viewModel?.start()
        initData()
    }

    abstract fun createViewModel(): VM?

    protected open fun initData() {

    }


    abstract fun getLayoutId(): Int

    abstract fun bindingViewModel(binding: B)

    protected open fun setupView(savedInstanceState: Bundle?) {

    }

    protected open fun setListener() {

    }
}
