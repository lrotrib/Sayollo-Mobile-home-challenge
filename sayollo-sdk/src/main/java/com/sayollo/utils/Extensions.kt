package com.sayollo.utils

import com.sayollo.model.UserInfo

fun UserInfo.toJson(): String {
    return gson.toJson(this)
}

fun UserInfo.toCollectedData() {
    PrefsManager.collectGameLevels(this.levels)
    PrefsManager.collectGamePoints(this.points)
    PrefsManager.collectGamePlayedTime(this.playedTime)
    PrefsManager.collectGameLeaderboard(this.leaderboard)
    PrefsManager.collectGameAchievements(this.achievements)
}

fun fromCollectedData(): UserInfo {
    return UserInfo(
        playedTime = PrefsManager.extractGamePlayedTime(),
        leaderboard = PrefsManager.extractGameLeaderboard(),
        achievements = PrefsManager.extractGameAchievements()
    )
}

fun String.toUserInfo(): UserInfo {
    return gson.fromJson(this, UserInfo::class.java)
}