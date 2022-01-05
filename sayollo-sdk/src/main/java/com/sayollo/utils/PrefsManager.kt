package com.sayollo.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.sayollo.model.UserInfo
import java.util.*


internal object PrefsManager {

    private var appContext: Context? = null
    private val PREFS_NAME: String = PrefsManager::class.java.simpleName

    fun init(context: Context) {
        this.appContext = context.applicationContext
    }

    fun uniqueID(): String? {
        appContext?.let {
            var uniqueID = getElement(it, UNIQUE_ID)
            return if (uniqueID.isNullOrEmpty()) {
                uniqueID = UUID.randomUUID().toString()
                saveElement(it, UNIQUE_ID, uniqueID)
                uniqueID
            }else {
                uniqueID
            }
        }
        return null
    }

    fun collectUserInfo(info: UserInfo) {
        info.toCollectedData()
        appContext?.let {
            saveElement(it, USER_INFO, info.toJson())
        }
    }

    fun extractUserInfo(): UserInfo? {
        appContext?.let {
            return getElement(it, USER_INFO)?.toUserInfo()
        }
        return null
    }

    fun collectGameLevels(level: String?) {
        appContext?.let {
            saveElement(it, GAME_LEVEL, level)
        }
    }

    fun extractGameLevels(): String? {
        appContext?.let {
            return getElement(it, GAME_LEVEL)
        }
        return null
    }

    fun collectGamePoints(points: String?) {
        appContext?.let {
            saveElement(it, GAME_POINTS, points)
        }
    }

    fun extractGamePoints(): String? {
        appContext?.let {
            return getElement(it, GAME_POINTS)
        }
        return null
    }

    fun collectGamePlayedTime(time: String?) {
        appContext?.let {
            saveElement(it, PLAYED_TIME, time)
        }
    }

    fun extractGamePlayedTime(): String {
        appContext?.let {
            return getElement(it, PLAYED_TIME)
        }
        return ""
    }

    fun collectGameLeaderboard(leader: String?) {
        appContext?.let {
            saveElement(it, LEADERBOARD, leader)
        }
    }

    fun extractGameLeaderboard(): String? {
        appContext?.let {
            return getElement(it, LEADERBOARD)
        }
        return null
    }

    fun collectGameAchievements(achieved: String?) {
        appContext?.let {
            saveElement(it, ACHIEVEMENTS, achieved)
        }
    }

    fun extractGameAchievements(): String? {
        appContext?.let {
            return getElement(it, ACHIEVEMENTS)
        }
        return null
    }

    private fun saveElement(context: Context, element: String, value: String?) {
        context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).apply {
            edit().putString(element, value).apply()
        }
    }

    private fun getElement(context: Context, element: String): String {
        context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).apply {
            return getString(element, null) ?: ""
        }
    }
}