package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sayollo.SayolloSdk
import com.sayollo.UserInfoListener
import com.sayollo.model.UserInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        SayolloSdk.sdkInitialize(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playedTime.setOnClickListener {
            val time = (0..60).random()
            SayolloSdk.collectGamePlayedTime(time.toString())
        }

        gameLevel.setOnClickListener {
            val level = (0..160).random()
            SayolloSdk.collectGameLevels(level.toString())
        }

        gamePoints.setOnClickListener {
            val points = (0..100000).random()
            SayolloSdk.collectGamePoints(points.toString())
        }

        gameLeaderboard.setOnClickListener {
            val leader = (0..400).random()
            SayolloSdk.collectGameLeaderboard(leader.toString())
        }

        gameAchievements.setOnClickListener {
            val achieved = (0..300).random()
            SayolloSdk.collectGameAchievements(achieved.toString())
        }

        sendCollectedData.setOnClickListener {
            SayolloSdk.sendCollectedData()
        }

        extractUserInfo.setOnClickListener {
            SayolloSdk.extractUserInfo(object: UserInfoListener {
                override fun onUserInfo(info: UserInfo) {
                    userInfo.text = ""
                    userInfo.append("Level ${info.levels} \n\n")
                    userInfo.append("Points ${info.points} \n\n")

                    userInfo.append("Time played ${info.playedTime} \n\n")
                    userInfo.append("Leaderboard ${info.leaderboard} \n\n")
                    userInfo.append("Achievements ${info.achievements} \n\n")
                    userInfo.append("Unique ID ${info.unique} \n\n")
                }
            })
        }
    }
}