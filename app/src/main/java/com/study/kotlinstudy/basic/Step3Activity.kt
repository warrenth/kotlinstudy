package com.study.kotlinstudy.basic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.study.kotlinstudy.R

/**
 * Created by warrenth on 2018-04-26.
 */
class Step3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step2)

        //한정클래스 언제 쓸까??.... 일단 패스..

        //이렇게 쓸거 같은데
        callBase(ClassA())
        callBase(ClassB())
        callInter(ClassA())
        callInter(ClassB())

        //프로퍼티
        var person = Person(19, "hoonihoon")
        println(person.adult)
        //person.address = "abcd"
        println(person.address)
    }

    class Person(val age: Int, val name : String) {
        val adult : Boolean
            get() = age >= 19 //return 이 아니라 get() 을 사용.

        var address : String = ""
            set(value) {
                field = value.substring(0..9)
            }
    }


    fun callBase(base : BaseClass) {
        base.a()
    }

    fun callInter(inter : BaseInterface) {
        inter.inter()
    }


    open class BaseClass {
        open fun a() {}
    }

    interface BaseInterface {
        fun inter()
    }

    class ClassA : BaseClass(), BaseInterface {
        override fun inter() {
            println("ClassA inter()")
        }

        override fun a() {
            println("ClassB a()")
        }
    }

    class ClassB : BaseClass(), BaseInterface {
        override fun inter() {
            println("ClassB inter()")
        }

        override fun a() {
            println("ClassB a()")
        }
    }
}