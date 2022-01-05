package com.sayollo.model

data class UserInfo(
    @Transient var playedTime: String = "",
    @Transient var leaderboard: String? = "",
    @Transient var achievements: String? = ""
): BaseInfo() {

    val vars = Vars(levels, points, playedTime, leaderboard, achievements)

    data class Vars(
        var levels: String?,
        var points: String?,
        var playedTime: String,
        var leaderboard: String?,
        var achievements: String?
    )
}
