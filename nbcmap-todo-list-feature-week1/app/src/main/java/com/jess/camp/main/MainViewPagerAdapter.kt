package com.jess.camp.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jess.camp.R
import com.jess.camp.bookmark.BookmarkFragment
import com.jess.camp.todo.TodoFragment

class MainViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = ArrayList<MainTabs>()

    init {
        fragments.add(
            MainTabs(TodoFragment.newInstance(), R.string.main_tab_todo_title)
        )
        fragments.add(
            MainTabs(BookmarkFragment.newInstance(), R.string.main_tab_bookmark_title),
        )
    }

    //Todo프래그먼트 가져오기
    fun getFragment():TodoFragment{
        //TodoFragment
        return fragments[0].fragment as TodoFragment
    }

    fun getTitle(position: Int): Int {
        return fragments[position].titleRes
    }


    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position].fragment
    }
}