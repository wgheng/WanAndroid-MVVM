package com.wgheng.wanandroid.ui

import androidx.fragment.app.Fragment
import com.wgheng.wanandroid.base.BaseActivity
import com.wgheng.wanandroid.R
import com.wgheng.wanandroid.databinding.ActivityMainBinding
import com.wgheng.wanandroid.ui.home.HomeFragment
import com.wgheng.wanandroid.ui.my.MyFragment
import com.wgheng.wanandroid.ui.wxcolumn.WXColumnFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    var position: Int = 0
    private lateinit var fragments: ArrayList<Fragment>

    override val viewModel: MainViewModel?
        get() = MainViewModel()


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun bindingViewModel(binding: ActivityMainBinding) {
        binding.viewModel = viewModel
    }

    override fun setupView() {
        super.setupView()
        fragments = ArrayList()
        fragments.add(HomeFragment())
        fragments.add(WXColumnFragment())
        fragments.add(MyFragment())
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
            when(it.itemId){
                R.id.navHome -> (fragments[position] as HomeFragment).refreshPager()
                R.id.navWXColumn -> (fragments[position] as WXColumnFragment).refreshPager()
                R.id.navMy -> (fragments[position] as MyFragment).refreshPager()
            }
        }
    }

    private fun switchFragment(position: Int) {
        val ft = supportFragmentManager.beginTransaction()
        val fragment = fragments.get(position)
        fragments.forEach {
            if (it.isAdded) {
                ft.hide(it)
            }
        }
        if (fragment.isAdded) {
            ft.show(fragment)
        } else {
            ft.add(R.id.flMain, fragment)
        }
        ft.commit()
    }

}
