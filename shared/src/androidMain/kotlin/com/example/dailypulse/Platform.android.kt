package com.example.dailypulse

import android.content.res.Resources
import android.util.Log
import kotlin.math.round

//esse Platofrm esta declarado no commonMain
//preciso implementar no actual todos os membros declarados la
actual class Platform {
    actual val osName: String
        get() =  "Android"
    actual val osVersion: String
        get() = "${android.os.Build.VERSION.SDK_INT}"
    actual val deviceModel: String
        get() = android.os.Build.MODEL
    actual val density: Int
            get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logSystemInfo() {
        Log.d("Daily pulse", "deviceModel: $deviceModel osName: $osName osVersion: $osVersion density: $density")
    }

}