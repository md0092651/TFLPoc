package com.tfl.poc.utility

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.tfl.poc.BuildConfig


object Logger {
    const val TAG = "TFL Poc"

    @JvmOverloads
    @JvmStatic
    fun v(tag: String = TAG, msg: String, throwable: Throwable? = null) {
        if (BuildConfig.DEBUG) {
            try {
                Log.v(tag, msg, throwable)
            } catch (e: RuntimeException) {
                println("v: $tag: $msg")
            }
        }
    }

    @JvmOverloads
    @JvmStatic
    fun d(tag: String = TAG, msg: String, throwable: Throwable? = null) {
        if (BuildConfig.DEBUG) {
            try {
                Log.d(tag, msg, throwable)
            } catch (e: RuntimeException) {
                // Unit test
                println("d: $tag: $msg")
                throwable?.printStackTrace()
            }
        }
    }

    @JvmOverloads
    @JvmStatic
    fun i(tag: String = TAG, msg: String, throwable: Throwable? = null) {
        if (BuildConfig.DEBUG) {
            try {
                Log.i(tag, msg, throwable)
            } catch (e: RuntimeException) {
                // Unit test
                println("i: $tag: $msg")
                throwable?.printStackTrace()
            }
        } else {
            reportCrashlyticsBreadCrumb(tag, msg, throwable)
        }
    }

    @JvmOverloads
    @JvmStatic
    fun w(tag: String = TAG, msg: String? = null, throwable: Throwable? = null) {
        val message = msg ?: throwable?.localizedMessage ?: "?"
        if (BuildConfig.DEBUG) {
            try {
                Log.w(tag, message, throwable)
            } catch (e: RuntimeException) {
                // Unit test
                println("w: $tag: $message")
                throwable?.printStackTrace()
            }
        } else {
            reportCrashlyticsError(tag, message, throwable)
        }
    }

    @JvmOverloads
    @JvmStatic
    fun e(tag: String = TAG, msg: String? = null, throwable: Throwable? = null) {
        val message = msg ?: throwable?.localizedMessage ?: "?"
        reportCrashlyticsError(tag, "Debug Build - $message", throwable)
        try {
            Log.e(tag, message, throwable)
        } catch (e: RuntimeException) {
            // Unit test
            println("e: $tag: $message")
            throwable?.printStackTrace()
        }
    }

    private fun reportCrashlyticsBreadCrumb(
        tag: String,
        msg: String,
        throwable: Throwable? = null
    ) {
        if (throwable == null) {
            FirebaseCrashlytics.getInstance().log("$tag: $msg")
        } else {
            reportCrashlyticsError(tag, msg, throwable)
        }
    }

    private fun reportCrashlyticsError(tag: String, msg: String, throwable: Throwable? = null) {
        FirebaseCrashlytics.getInstance().apply {
            this.log("$tag: $msg")
            if (throwable != null) {
                this.recordException(throwable)
            }
        }
    }
}
