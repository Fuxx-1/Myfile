package ltd.newimg

import java.util.*
import kotlin.*

class Test() {
    fun testA(a: Int, b: Int): Int {
        return a + b
    }

    fun testB(a: Int, b: Int) = a + b

    public fun testC(a: Int, b: Int): Int = a + b

    fun vars(vararg v: Int) {
        for (vt in v) {
            print("test")
            print("test")
        }
    }

    fun main(args:Array<String>){
        println("Hello World!")
    }
}

fun main(args:Array<String>){
    var test: Test = Test()
    print("Test: " + test.testA(1, 2) + "\n")
    print("Hello World!")
}