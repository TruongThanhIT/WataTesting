package com.thanht.watatesting.userlist.ui

import com.thanht.watatesting.base.BaseView
import com.thanht.watatesting.userlist.models.UserModel

interface UserView : BaseView {

    fun getUserListSuccess(userList: List<UserModel>)

}