package com.wgheng.wanandroid.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.wgheng.wanandroid.R
import com.wgheng.wanandroid.base.BaseActivity
import com.wgheng.wanandroid.databinding.ActivityMainBinding
import com.wgheng.wanandroid.ui.home.HomeFragment
import com.wgheng.wanandroid.ui.my.MyFragment
import com.wgheng.wanandroid.ui.wxcolumn.WxColumnFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {


    companion object {
        const val HOME_FRAG = "home"
        const val WX_COLUMN_FRAG = "wx_column"
        const val MY_FRAG = "my"
    }

    override fun createViewModel(): MainViewModel? {
        return MainViewModel()
    }

    var position: Int = 0
    private lateinit var fragments: ArrayList<Fragment>

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun bindingViewModel(binding: ActivityMainBinding) {
        binding.viewModel = viewModel
    }

    override fun setupView(savedInstanceState: Bundle?) {
        super.setupView(savedInstanceState)
        fragments = ArrayList()
        fragments.add(supportFragmentManager.findFragmentByTag(HOME_FRAG) ?: HomeFragment())
        fragments.add(supportFragmentManager.findFragmentByTag(WX_COLUMN_FRAG) ?: WxColumnFragment())
        fragments.add(supportFragmentManager.findFragmentByTag(MY_FRAG) ?: MyFragment())
        switchFragment(position)
    }

    override fun setListener() {
        this.navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navHome -> position = 0
                R.id.navWXColumn -> position = 1
                R.id.navMy -> position = 2
            }
            switchFragment(position)
            true
        }
        this.navigationView.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.navHome -> (fragments[position] as HomeFragment).refreshPager()
                R.id.navWXColumn -> (fragments[position] as WxColumnFragment).refreshPager()
                R.id.navMy -> (fragments[position] as MyFragment).refreshPager()
            }
        }
    }

    private fun switchFragment(position: Int) {
        val ft = supportFragmentManager.beginTransaction()
        val fragment = fragments[position]
        fragments.forEach {
            if (it.isAdded) {
                ft.hide(it)
            }
        }
        if (fragment.isAdded) {
            ft.show(fragment)
        } else {
            ft.add(R.id.flMain, fragment, getFragmentTagByPosition(position))
        }
        ft.commit()
    }

    private fun getFragmentTagByPosition(position: Int): String? {
        return when (position) {
            0 -> HOME_FRAG
            1 -> WX_COLUMN_FRAG
            2 -> MY_FRAG
            else -> null
        }
    }

}
