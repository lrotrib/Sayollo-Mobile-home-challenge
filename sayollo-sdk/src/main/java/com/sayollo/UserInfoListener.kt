package com.sayollo

import com.sayollo.model.UserInfo

interface UserInfoListener {
    fun onUserInfo(info: UserInfo)
}