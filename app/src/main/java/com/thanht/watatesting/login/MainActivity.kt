package com.thanht.watatesting.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.thanht.watatesting.R
import com.thanht.watatesting.login.presenter.LoginPresenter
import com.thanht.watatesting.login.ui.LoginView
import com.thanht.watatesting.userlist.UserListActivity
import com.thanht.watatesting.utils.hideKeyboard
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginView {

    private val presenter: LoginPresenter = LoginPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
        initEvents()
    }

    private fun initUI() {
        presenter.onAttachView(this)
    }

    private fun initEvents() {
        edtPassword.setOnEditorActionListener { _, actionId, event ->
            if (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER || actionId == EditorInfo.IME_ACTION_DONE) {
                signIn()
                return@setOnEditorActionListener true
            }
            false
        }

        btnSignIn.setOnClickListener {
            signIn()
        }
    }

    override fun loginSuccess() {
        startActivity(Intent(this, UserListActivity::class.java))
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
        tvError.text = this.resources.getString(R.string.txt_user_password_invalid)
    }

    private fun signIn() {
        tvError.visibility = View.GONE
        if (validateLogin()) {
            hideKeyboard(this)

            val userName = edtUserName.text.toString()
            val password = edtPassword.text.toString()

            presenter.login(userName, password)
        }
    }

    private fun validateLogin(): Boolean {
        val userName = edtUserName.text.toString()
        val password = edtPassword.text.toString()

        if (TextUtils.isEmpty(userName)) {
            edtUserName.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake))
            Toast.makeText(this, this.resources.getString(R.string.txt_user_invalid), Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(password)) {
            edtPassword.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake))
            Toast.makeText(this, this.resources.getString(R.string.txt_password_invalid), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}
