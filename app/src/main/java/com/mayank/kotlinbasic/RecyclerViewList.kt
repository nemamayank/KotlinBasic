package com.mayank.kotlinbasic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import kotlinx.android.synthetic.main.recylerview.*

/**
 *  Initializing & Populating data to Recycler View
 */
class RecyclerViewList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recylerview)
        init()
    }

    /**
     *  function for initializing & populating data to RecyclerListAdapter
     */
    fun init() {

        /**
         *  setting up toolbar stuff's
         */
        title = getString(R.string.title_recycler_view)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        listItems.layoutManager = LinearLayoutManager(this)
        listItems.hasFixedSize()
        listItems.adapter = RecyclerListAdapter(this, getListItems())
    }

    /**
     *  function for adding items to the array list
     */
    fun getListItems(): ArrayList<String> {
        var lists = ArrayList<String>()
        lists.addAll(resources.getStringArray(R.array.framework_list))
        return lists
    }

    /**
     *  core function for handling action bar
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Respond to the action bar's Up/Home button
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
