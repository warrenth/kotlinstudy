package com.study.kotlinstudy.basic

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.View
import com.study.kotlinstudy.R
import kotlinx.android.synthetic.main.activity_step5.*

/**
 * Created by warrenth on 2018-04-26.
 */
class Step1Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_step1)
        /**
         * Null 안전성
         */
        var nullValue : String? = null  //null을 가지고 싶으면 자료형우측에 ? 를 넣는다
        var nullValue2 : String = ""


        /**
         * 자료형
         */
        var value = 100
        var sum : Int = 100
        var floatSum : Float
        var doubleValue : Double = 100.1
        var floatValue = 100.0f

        floatSum = sum.toFloat();
        println(floatSum)

        /**
         * 문자
         */
        //아스키 코드값   [val c : Char = 65] 불가
        var code : Int = 65
        var c : Char = code.toChar();
        println(c)

        /**
         * 논리
         */
        var boolA = true
        var boolB : Boolean = false
        println(boolB)

        /**
         * 문자열
         */
        //[1]
        val count = 3000
        var ch1 : String = String.format("abc %d defc", count)
        println("문자열[1] : "+ ch1)
        //[2] + 특수문자
        var price = 1000
        val priceText = "Price : ${'$'} $price"
        println("문자열[2] : "+ priceText)

        /**
         * 배열
         */
        var word = arrayOf("a1","b2","c3")
        println("배열[1] : " + word[0])
        println("배열[1] : " + word.size)

        aa(word)
        bb(*word)

        /**
         * 컬랙션
         * 컬랙션 내 자료를 수정할 수 있는 가변타입 ( mutable )
         * 수정이 불가한 불변 타입 ( imuutable)
         *
         */
        var mutableList = listOf("a","b","c")       //listOf 는 수정불가
        var imumutableList : MutableList<String> = arrayListOf("a","b","c")  //ArrayList 는 수정가능
        //mutableList[0] = "b" complie error
        imumutableList[0] ="b"


        /**
         * 클래스 생성
         */
        var classA = ClassA()
        val classAA = object : BaseClass() {
            override fun init() {
            }
        }
        println(classA.address)

        var classB = ClassB()


        /**
         * android 버튼 리스너 달기.
         */
        button.setOnClickListener(this)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

            }
        })

        /**
         * 팩토리 메서드
         */
        var classC = ClassC.create("a")


        /**
         * 싱글톤
         */
        var classSingleone = ClassSingletone
        classSingleone.a = "c";
        println("싱글톤[1] : " + classSingleone.a)
        var classSingleone2 = ClassSingletone
        println("싱글톤[2] : " + classSingleone2.a)
        println("싱글톤[3] : " + ClassSingletone.a)


    }


    override fun onClick(v: View?) {

    }



    /**
     *  배열 함수 1
     */
    fun aa(arrs : Array<String>) {
        for(a in arrs) {
            print(""+ a + ", ")
        }
        println()
    }
    fun bb(vararg args : String) {
        for(a in args) {
            print(""+ a + ", ")
        }
        println()
    }


    abstract class BaseClass {
        abstract fun init()
    }

    open class ParentClassA : BaseClass() {
        override fun init() {}
        open fun loadData(){}
    }

    //ParentClassA를 상속받으려면 open 키워드를 붙여야 한다.
    class ClassA : ParentClassA() {
        var address : String? = null
        lateinit var name : String      //초기에 값을 세팅하지 않아도 된다.


        /**
         * 접근 제한자
         * val a = 1  접근제한자가 없으면 public 으로 간주
         */
        public var a = 1
        protected var b = 2
        private var c = 3

        init { //생성자

        }

        //부모의 메서드를 오버라이딩 하려면 메서드에 open을 붙여야 한다.
        override fun loadData() {
            super.loadData()
        }
    }

    /**
     *  constructor 키워드.
     *  추가 생성자를 정의하는 경우 주 생성자를 반드시 호출해야 한다.
     */
    class ClassB internal constructor(var a: Int, var b:Int) {
        constructor(a : Int) : this(a, 0)
        constructor() : this(0,0)

    }

    /**
     * View 의 단축키로 secondary construcotr를 생성.
     */
    class MyView : View {
        constructor(context: Context?) : super(context)
        constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
        constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
        constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)
    }

    class MyActivity : AppCompatActivity(), View.OnClickListener {


        override fun onClick(v: View?) {

        }

    }


    /**
     * 팩토리 메서드
     */
    class ClassC (name: String, currentTimeMillis: Long) {
        companion object { //동반객체
            fun create(name: String) : ClassC {
                return ClassC(name, System.currentTimeMillis())
            }
        }
    }


    object ClassSingletone {
        var a : String? = null
    }

}