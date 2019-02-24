package com.thanht.watatesting.userlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.thanht.watatesting.R
import com.thanht.watatesting.userlist.models.UserModel
import com.thanht.watatesting.userlist.presenter.UserPresenter
import com.thanht.watatesting.userlist.adapters.UserAdapter
import com.thanht.watatesting.userlist.ui.UserView
import kotlinx.android.synthetic.main.activity_user_list.*

class UserListActivity : AppCompatActivity(), UserView {

    private val presenter: UserPresenter = UserPresenter()
    private var userList: ArrayList<UserModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        initUI()
        initEvents()
        loadData()
    }

    private fun loadData() {
        presenter.getUserList()
    }

    private fun initUI() {
        presenter.onAttachView(this)
        rvUserList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvUserList.adapter = UserAdapter(keywordList = userList, context = this)
    }

    private fun initEvents() {
        tvError.setOnClickListener { loadData() }
    }

    override fun getUserListSuccess(userList: List<UserModel>) {
        this.userList.clear()
        this.userList.addAll(userList)
        rvUserList.adapter?.notifyDataSetChanged()
    }

    override fun showLoading() {
        pbLoading.visibility = View.VISIBLE
        tvError.visibility = View.GONE
    }

    override fun hideLoading() {
        pbLoading.visibility = View.GONE
        tvError.visibility = View.GONE
    }

    override fun showError() {
        pbLoading.visibility = View.GONE
        tvError.visibility = View.VISIBLE
        tvError.text = this.resources.getString(R.string.txt_keyword_msg_error)
    }
}
