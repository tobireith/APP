package com.example.uebungrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.annotations.NotNull
import java.util.*

class ListAdapter internal constructor(
    context: Context?,
    list: LinkedList<String>
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private val mList: LinkedList<String>
    private val mInflater: LayoutInflater

    init {
        mInflater = LayoutInflater.from(context);
        this.mList = list;
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        // TODO: Inflate item view
        val mItemView = mInflater.inflate(R.layout.row_recycler_view, parent, false)
        return ViewHolder(mItemView)
    }

    override fun onBindViewHolder(
        @NotNull viewHolder: ViewHolder,
        position: Int
    ) {
        // TODO: Set text depending on the current position
        val mCurrent = mList[position]
        viewHolder.mCheckBox!!.setText(mCurrent);
    }

    override fun getItemCount(): Int {
        // TODO: Return size of data set
        return mList.size
    }

    inner class ViewHolder internal constructor(
        @NotNull itemView: View
    )
        : RecyclerView.ViewHolder(itemView) {
        lateinit var mCheckBox : CheckBox;

        init {
            mCheckBox = itemView.findViewById<CheckBox>(R.id.checkBox);
        }
    }

}