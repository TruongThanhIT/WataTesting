package com.thanht.watatesting.login.presenter

import com.thanht.watatesting.base.BasePresenter
import com.thanht.watatesting.base.BaseView
import com.thanht.watatesting.constants.passwordDefault
import com.thanht.watatesting.constants.userNameDefault
import com.thanht.watatesting.login.ui.LoginView

class LoginPresenter : BasePresenter() {

    private lateinit var view: LoginView

    override fun onAttachView(T: BaseView) {
        this.view = T as LoginView
    }

    fun login(userName: String, password: String) {
        view.showLoading()
        if (userName.toLowerCase() == userNameDefault && password.toLowerCase() == passwordDefault) {
            view.hideLoading()
            view.loginSuccess()
        } else {
            view.showError()
        }
    }

}