package com.android.freelance.groupielibrary

import android.util.Log
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_expandable_header.*

class ExpandableHeaderItem(private val title: String) : Item(), ExpandableItem {

    private val LOG_TAG = ExpandableHeaderItem::class.java!!.getName()
    private lateinit var expandableGroup: ExpandableGroup

    override fun bind(viewHolder: ViewHolder, position: Int) {
        Log.i(LOG_TAG, "Test: bind() is called...")

        viewHolder.itemExpandableHeaderTitle.text = title
        viewHolder.itemExpandableHeaderIcon.setImageResource(getRotatedIconResId())

        viewHolder.itemExpandableHeaderRoot.setOnClickListener {
            expandableGroup.onToggleExpanded()
            viewHolder.itemExpandableHeaderIcon.setImageResource(getRotatedIconResId())
        }
    }

    override fun getLayout() = R.layout.item_expandable_header

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        Log.i(LOG_TAG, "Test: setExpandableGroup() is called...")

        expandableGroup = onToggleListener
    }

    private fun getRotatedIconResId() = if (expandableGroup.isExpanded) R.drawable.ic_keyboard_arrow_up
        else R.drawable.ic_keyboard_arrow_down
}