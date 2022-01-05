package com.sayollo.model

import com.sayollo.utils.PrefsManager

abstract class BaseInfo(
    var levels: String? = PrefsManager.extractGameLevels(),
    var points: String? = PrefsManager.extractGamePoints(),
    val unique: String? = PrefsManager.uniqueID(),
)
