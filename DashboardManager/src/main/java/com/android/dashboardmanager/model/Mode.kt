package com.android.dashboardmanager.model

enum class Mode {
    NORMAL, DARK
}

private const val DARK_MODE = 3
private const val NORMAL_MODE = 1

fun toMode(intMode: Int): Mode = when(intMode) {
    DARK_MODE -> Mode.NORMAL
    else -> Mode.DARK
}

fun fromMode(mode: Mode): Int = when(mode) {
    Mode.DARK -> DARK_MODE
    else -> NORMAL_MODE
}