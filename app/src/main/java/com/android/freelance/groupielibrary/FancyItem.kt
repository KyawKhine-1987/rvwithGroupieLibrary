package com.android.freelance.groupielibrary

import android.support.annotation.ColorInt
import android.util.Log
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_fancy.*

class FancyItem(
    @ColorInt private val color: Int,
    private val number: Int
) : Item() {

    private val LOG_TAG = FancyItem::class.java!!.getName()

    override fun bind(viewHolder: ViewHolder, position: Int) {
        Log.i(LOG_TAG, "Test: bind() is called...")

        viewHolder.cvItemFancy.setCardBackgroundColor(color)
        viewHolder.numberItemFancy.text = number.toString()
    }

    override fun getLayout() = R.layout.item_fancy

    override fun getSpanSize(spanCount: Int, position: Int) = spanCount / 3
}