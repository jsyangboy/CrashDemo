package itboy.crashdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import itboy.crashdemo.crash.CrashUnit

class MainActivity3 : AppCompatActivity() {

    private val button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_test).setOnClickListener {
            //CrashUnit.exceptionRunTimeText()
            //CrashUnit.nullPointerExceptionText()
            //CrashUnit.nullPointerExceptionText2(null)
            //CrashUnit.exceptionText()
            //CrashUnit.nullPointerExceptionText3()
            CrashUnit.nullPointerExceptionText4()
        }
    }
}
