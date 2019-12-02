package com.xunayuan.demo

import java.io.File
import java.util.*

/**
 * 作者：罗发新
 * 时间：2019/10/10 0010    星期四
 * 邮件：424533553@qq.com
 * 说明：https://www.kotlincn.net/docs/reference/inline-functions.html
 * Kotlin 文档接着集合目录开始看
 *
修饰符：如果一个声明有多个修饰符，请始终按照以下顺序安放：
public / protected / private / internal
expect / actual
final / open / abstract / sealed / const
external
override
lateinit
tailrec
vararg
suspend
inner
enum / annotation
companion
inline
infix
operator
data


运算符运算
shl(bits) – 有符号左移  <<
shr(bits) – 有符号右移 >>
ushr(bits) – 无符号右移 >>>
and(bits) – 位与   &
or(bits) – 位或    \
xor(bits) – 位异或  ^
inv() – 位非    !
 */


/**
 * 主函数
 */
fun main() {

    val a: String? = null
    val b: String? = null
    println(b?.length)
    println(a?.length) // 无需安全调用
    val kot = KotlinMain("时间")
    //时间功能
}


/**
 *  类布局
 * 通常，一个类的内容按以下顺序排列：
 * 1)属性声明与初始化块
 * 2)次构造函数
 * 3)方法声明
 * 4)伴生对象
 */
class KotlinMain(str: String) {
    /**
    /*测试求和的方法*/
     * 可以双层注释
     */
    private fun printSum(a: Any?, b: Int): Int {
        //如果a不为null,则返回a,如果a==null，return b
        val l = a ?: b
        println("sum of $a and $b is $(a+b),and the l is $l")
        return if (a != null) {
            b
        } else {
            b * 10
        }
    }

    private fun maxOf(a: Int, b: Int) = if (a > b) a else b

    fun whenWay(x: Any, y: Int) {
        when (x) {
            in 1..10 -> println("x is in the range ")
            in 20..40 -> println("x is in the range 20-40 ")
            !in 30..50 -> println("x is out  the range 20-40 ")
            is Int -> println("x is Int type ")
            else -> print("none of the obove")
        }

        val asc = Array(5) { i -> (i * i).toString() }
        asc.forEach { println(it) }
    }

    fun whenWay2(x: Int, y: Int): Any = when (printSum(x, y)) {
        10, 11, 12 -> 20
        maxOf(x, y) -> "还是你厉害"
        else -> false
    }

    fun whenWay3(x: Int, y: Int) = when {
        x > y -> 1
        x == y -> 10
        else -> 15
    }

    fun forWay() {
        for (i in 1..9)
            println("i value is $i")

        for (i in 18 downTo 1 step 3)
            println("i value is $i")

        val list = listOf("1", "2", 5, '6', 56f)
        for (i in list.indices step 2)
            println("i value is ${list[i]}")
        for (i in 0..list.size step 2)
            println("i value is ${list[i]}")

        // 标签，标签名随意定义
        lo@ for (i in 1 until 100) {//开区间不包含100
            for ((index, value) in list.withIndex()) {
                println("the element at $index is $value")
                if (value == 50) {
                    break@lo
                }
            }
        }
    }

    fun whileWay(a: Int) {
        var x = a
        while (x > 0) {
            x--
        }

        var y = a + 1
        do {
            y++
        } while (y < 30) // y 在此处可见
    }

    /**
     * filter 过滤条件
     */
    fun filterWay() {
        val fruits = listOf("banana", "avocado", "apple", "appleo", "kiwifruit")
        // in 也可以当做 contains用
        fruits.contains("banana") == "banana" in fruits
        fruits.filter {
            it.startsWith("a")
            it.endsWith("o")
        }
                .sortedBy { it }
                .map { it.toUpperCase(Locale.CHINA) }
                .forEach { println(it) }
    }

    /**
     * String.compare 是一种扩展函数
     */
    fun String.compare() {
        println(this)
    }

    fun collectionWay() {
        val fruits = listOf("banana", "avocado", "apple", "appleo", "kiwifruit")
        val firstObject = fruits.firstOrNull()
    }


}


