package com.sayollo

import android.content.Context
import com.sayollo.model.UserInfo
import com.sayollo.repository.Repository
import com.sayollo.utils.PrefsManager

object SayolloSdk {

    private val repository = Repository()

    @Synchronized
    fun sdkInitialize(context: Context) {
        PrefsManager.init(context)
    }

    fun fetchData() {
        repository.fetchData()
    }

    fun sendData(info: UserInfo) {
        repository.sendData(info)
    }

    fun sendCollectedData() {
        repository.sendCollectedData()
    }

    fun collectUserInfo(info: UserInfo) {
       repository.collectUserInfo(info)
    }

    fun extractUserInfo(infoListener: UserInfoListener) {
        infoListener.onUserInfo(repository.extractUserInfo())
    }

    fun collectGameLevels(level: String) {
        repository.collectGameLevels(level)
    }

    fun extractGameLevels(): String? {
        return repository.extractGameLevels()
    }

    fun collectGamePoints(points: String) {
        repository.collectGamePoints(points)
    }

    fun extractGamePoints(): String? {
        return repository.extractGamePoints()
    }

    fun collectGamePlayedTime(time: String) {
        repository.collectGamePlayedTime(time)
    }

    fun extractGamePlayedTime(): String? {
        return repository.extractGamePlayedTime()
    }

    fun collectGameLeaderboard(leader: String?) {
        repository.collectGameLeaderboard(leader)
    }

    fun extractGameLeaderboard(): String? {
        return repository.extractGameLeaderboard()
    }

    fun collectGameAchievements(achieved: String) {
        repository.collectGameAchievements(achieved)
    }

    fun extractGameAchievements(): String? {
        return repository.extractGameAchievements()
    }
}