package com.thanht.watatesting.userlist.presenter

import com.thanht.watatesting.base.BasePresenter
import com.thanht.watatesting.base.BaseView
import com.thanht.watatesting.userlist.models.UserModel
import com.thanht.watatesting.userlist.ui.UserView
import com.thanht.watatesting.utils.getRandom
import kotlin.random.Random

class UserPresenter : BasePresenter() {

    private lateinit var view: UserView

    fun getUserList() {
        view.showLoading()
        val users: List<UserModel> = fakeDataLager()
        view.hideLoading()
        view.getUserListSuccess(users)
    }

    override fun onAttachView(T: BaseView) {
        view = T as UserView
    }

    private fun fakeDataLager(): List<UserModel> {
        val users: ArrayList<UserModel> = ArrayList()
        for (i in 0..1000) {
            val user = UserModel(
                id = i.toString(),
                name = "Trần Văn Cao $i",
                age = Random.nextInt(18, 25),
                address =  "Đường số ${getRandom(10,100)}, phường ${getRandom(1,20)}, " +
                        "quận ${getRandom(1,14)}, TP.Hồ Chí Minh",
                url = "https://myhair.vn/wp-content/uploads/2018/02/j6-e1518163022453.jpg")
            users.add(user)
        }
        return users
    }

    private fun fakeData(): List<UserModel> {
        val users: ArrayList<UserModel> = ArrayList()

        val user = UserModel(
            id = Random.nextInt().toString(),
            name = "Trần Văn Cao",
            age = Random.nextInt(18, 25),
            address =  "Đường số ${getRandom(10,100)}, phường ${getRandom(1,20)}, " +
                    "quận ${getRandom(1,14)}, TP.Hồ Chí Minh",
            url = "https://upload.wikimedia.org/wikipedia/commons/c/cc/ESC_large_ISS022_ISS022-E-11387-edit_01.JPG")

        val user1 = UserModel(
            id = Random.nextInt().toString(),
            name = "Nguyễn Thị Ánh Hồng",
            age = Random.nextInt(18, 25),
            address =  "Đường số ${getRandom(10,100)}, phường ${getRandom(1,20)}, " +
                    "quận ${getRandom(1,14)}, TP.Hồ Chí Minh",
            url = "https://myhair.vn/wp-content/uploads/2018/02/j6-e1518163022453.jpg")

        val user2 = UserModel(
            id = Random.nextInt().toString(),
            name = "Phạm Hồng Thanh",
            age = Random.nextInt(18, 25),
            address =  "Đường số ${getRandom(10,100)}, phường ${getRandom(1,20)}, " +
                    "quận ${getRandom(1,14)}, TP.Hồ Chí Minh",
            url = "https://znews-photo.zadn.vn/w660/Uploaded/ohunua2/2017_04_10/duong8.jpg")

        val user3 = UserModel(
            id = Random.nextInt().toString(),
            name = "Nguyễn Tuyết Lan",
            age = Random.nextInt(18, 25),
            address =  "Đường số ${getRandom(10,100)}, phường ${getRandom(1,20)}, " +
                    "quận ${getRandom(1,14)}, TP.Hồ Chí Minh",
            url = "https://static2.yan.vn/YanNews/2167221/201710/20171030-081231-1-ohman-gai-hai-phong.jpg")

        val user4 = UserModel(
            id = Random.nextInt().toString(),
            name = "Phạm Hồng Thái",
            age = Random.nextInt(18, 25),
            address =  "Đường số ${getRandom(10,100)}, phường ${getRandom(1,20)}, " +
                    "quận ${getRandom(1,14)}, TP.Hồ Chí Minh",
            url = "https://znews-photo.zadn.vn/w660/Uploaded/ohunua2/2017_04_10/duong8.jpg")

        val user5 = UserModel(
            id = Random.nextInt().toString(),
            name = "Trương Lý Kiều",
            age = Random.nextInt(18, 25),
            address =  "Đường số ${getRandom(10,100)}, phường ${getRandom(1,20)}, " +
                    "quận ${getRandom(1,14)}, TP.Hồ Chí Minh",
            url = "https://www.upload.ee/image/8493734/das_str_2.png")

        users.add(user)
        users.add(user1)
        users.add(user2)
        users.add(user3)
        users.add(user4)
        users.add(user5)

        return users
    }

}