package com.sayollo.repository

import com.sayollo.model.UserInfo
import com.sayollo.networking.NetworkService
import com.sayollo.networking.RequestCallback
import com.sayollo.utils.*
import com.sayollo.utils.PrefsManager

class Repository {
    private val prefsManager = PrefsManager
    private val networkService = NetworkService

    fun fetchData() {
        networkService.fetchData(callback = object: RequestCallback<String> {
            override fun onReceived(response: String?) {
                val data = response
            }
            override fun onFailure(t: Throwable?) {

            }
        })
    }

    fun sendData(info: UserInfo) {
        networkService.sendData(info.toJson(), callback = object: RequestCallback<String> {
            override fun onReceived(response: String?) {
                val data = response
            }
            override fun onFailure(t: Throwable?) {

            }
        })
    }

    fun sendCollectedData() {
        val info = fromCollectedData()
        networkService.sendData(info.toJson(), callback = object: RequestCallback<String> {
            override fun onReceived(response: String?) {
                val data = response
            }
            override fun onFailure(t: Throwable?) {

            }
        })
    }

    fun collectUserInfo(info: UserInfo) {
        info.toCollectedData()
    }

    fun extractUserInfo(): UserInfo {
       return fromCollectedData()
    }

    fun collectGameLevels(level: String) {
        prefsManager.collectGameLevels(level)
    }

    fun extractGameLevels(): String? {
        return prefsManager.extractGameLevels()
    }

    fun collectGamePoints(points: String) {
        prefsManager.collectGamePoints(points)
    }

    fun extractGamePoints(): String? {
        return prefsManager.extractGamePoints()
    }

    fun collectGamePlayedTime(time: String) {
        prefsManager.collectGamePlayedTime(time)
    }

    fun extractGamePlayedTime(): String? {
        return prefsManager.extractGamePlayedTime()
    }

    fun collectGameLeaderboard(leader: String?) {
        prefsManager.collectGameLeaderboard(leader)
    }

    fun extractGameLeaderboard(): String? {
      return prefsManager.extractGameLeaderboard()
    }

    fun collectGameAchievements(achieved: String) {
        prefsManager.collectGameAchievements(achieved)
    }

    fun extractGameAchievements(): String? {
       return prefsManager.extractGameAchievements()
    }
}