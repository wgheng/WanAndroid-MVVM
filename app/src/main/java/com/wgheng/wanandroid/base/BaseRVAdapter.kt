package com.wgheng.wanandroid.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableList
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.logger.Logger

/**
 * Created by wgheng on 2019/5/20.
 * Description :
 */
abstract class BaseRVAdapter<B : ViewDataBinding, T>(
    var context: Context,
    var items: ObservableList<T>
) : RecyclerView.Adapter<BaseRVAdapter.ViewHolder>() {
    private val dataChangeObserver: ObservableList.OnListChangedCallback<ObservableList<T>>

    init {
        //设置ObservableList变化监听
        dataChangeObserver = DataChangeObserver()
        Logger.e("$items")
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        items.addOnListChangedCallback(dataChangeObserver)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        items.removeOnListChangedCallback(dataChangeObserver)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<B>(LayoutInflater.from(context), getItemLayoutId(), parent, false)
        return ViewHolder(binding.root)
    }

    /**
     * 获取item布局id
     */
    abstract fun getItemLayoutId(): Int

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = DataBindingUtil.getBinding<B>(holder.itemView)
        onItemBind(binding, items[position])
        binding?.executePendingBindings()
    }

    /**
     * 绑定item
     */
    abstract fun onItemBind(binding: B?, itemModel: T)


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class DataChangeObserver<T> : ObservableList.OnListChangedCallback<ObservableList<T>>() {
        override fun onChanged(sender: ObservableList<T>?) {
            notifyDataSetChanged()
        }

        override fun onItemRangeRemoved(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
            notifyItemRangeRemoved(positionStart, itemCount)
        }

        override fun onItemRangeMoved(sender: ObservableList<T>?, fromPosition: Int, toPosition: Int, itemCount: Int) {
            notifyItemMoved(fromPosition, toPosition)
        }

        override fun onItemRangeInserted(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
            notifyItemRangeInserted(positionStart, itemCount)
        }

        override fun onItemRangeChanged(sender: ObservableList<T>?, positionStart: Int, itemCount: Int) {
            notifyItemRangeChanged(positionStart, itemCount)
        }

    }
}