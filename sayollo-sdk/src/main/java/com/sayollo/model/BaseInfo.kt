package com.sayollo.model

import com.sayollo.utils.PrefsManager

abstract class BaseInfo(
    val unique: String? = PrefsManager.uniqueID(),
)
