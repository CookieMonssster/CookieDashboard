package com.android.kotlinutils

val String.Companion.Empty: String
    get() = ""

val Int.Companion.InvalidValue: Int
    get() = -1