package itboy.crashdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import itboy.crashdemo.crash.CrashUnit

class MainActivity : AppCompatActivity() {

    private val button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var vall = CrashUnit.initCrash(1, 80)
        Log.e("yqy", "vall=" + vall)


        findViewById<Button>(R.id.btn_test).setOnClickListener {
            //CrashUnit.exceptionRunTimeText()
            //CrashUnit.nullPointerExceptionText()
            //CrashUnit.nullPointerExceptionText2(null)
            //CrashUnit.exceptionText()
            //CrashUnit.nullPointerExceptionText3()
            //CrashUnit.nullPointerExceptionText4()
            //CrashUnit.getString()
            //CrashUnit.initCrash(1,80)
            val str: String? = CrashUnit.stringFromJNI()

            Log.e("yqy", "str=" + str)
        }
    }
}
