package itboy.crashdemo.crash

import java.lang.RuntimeException

object CrashUnit {


    fun exceptionText() {
        throw Exception("exceptionText")
    }

    fun exceptionRunTimeText() {
        throw RuntimeException("exceptionRunTimeText")
    }

    fun nullPointerExceptionText() {
        throw NullPointerException("NullPointerException")
    }

    fun nullPointerExceptionText3() {
        throw Error("nullPointerExceptionText3")
    }

    fun nullPointerExceptionText4() {
        throw OutOfMemoryError("eeedd")
    }

    fun nullPointerExceptionText2(myClass: MyClass?): Int {
        return myClass!!.get()
    }

    external fun getString(): String


    object MyClass {
        fun get(): Int {
            return 0
        }
    }
}