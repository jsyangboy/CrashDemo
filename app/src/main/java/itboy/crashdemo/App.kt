package itboy.crashdemo

import android.app.Application
import android.util.Log
import itboy.crashdemo.crash.CrashHandler

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("yqy", "Application onCreate");
        CrashHandler.getInstall()
    }
}