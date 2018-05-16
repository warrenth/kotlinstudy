package com.study.kotlinstudy.basic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.study.kotlinstudy.R

/**
 * Created by warrenth on 2018-04-26.
 */
class Step4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step4)

        /**
         * 코틀린 표준 라이브러리
         * 4.1 조건 확인 함수
         *
         * check, require 함수는 인자로 받은 표현식이 참이 아닌 경우 예외를 발생 (IllergalSateteException)
         */
        //showMessage(true, "메세지메세지메세지메세지메세지")
        //showMessage2(true, null)

        /**
         * 4.2 컬렉션 생성 함수
         */
        println("4.2")
        /**
         * 1. 배열
         */
        println("1. 배열")
        //함수의 인자로 받은 값으로 구성된 배열을 반환합니다.
        val cities = arrayOf("Seoul", "Tokyo", "San Francisco")

        //String 타입의 빈 배열을 생성합니다. emptyarray는 타입추론이 불가함으로 타입을 꼭 지정 하기!!
        val emptyStringArray = emptyArray<String>()

        //배열의 각 값들은 모두 널 값으로 초기화되어 있고, 인자로 받은 size만큼 크기를 갖는 배열을 반환.
        val nullStoreableArray = arrayOfNulls<String>(3)
        nullStoreableArray[1] = "Korea"
        println(nullStoreableArray[0] + "," + nullStoreableArray[1] + "," + nullStoreableArray[2])

        // 여러타입
        val chars = charArrayOf('a', 'b', 'c')
        val numbers = intArrayOf(1, 2, 3, 4, 5)
        val float = floatArrayOf(0.1f, 0.2f, 0.3f)

        //arrayof  여러가지 타입 존재...확인..


        /**
         * 2. 리스트
         */
        println("2. 리스트")
        /** 읽기만 가능한 리스트 생성*/
        // null 값이 아닌 인자가 아무것도 없으므로, 빈 리스트가 생성
        val listOfCountries = listOfNotNull(null)
        // null 값인 인자는 무시하므로, Seoul 과 San Francisco 만을 요소로 갖는 리스트가 생성.
        val listOfCities = listOfNotNull("Seoul", null, "San Francisco", null)

        //읽기전용
        val immutableList = listOf("a", "b", "c")
        println("immutableList:  " + immutableList)
        //수정가능
        val mutableList = mutableListOf<String>("a", "b", "c")

        //immutableList[1] = "a" // immutableList 수정불가. 에러를 잡아준다.
        mutableList[1] = "a"   // mutableList  수정가능

        //보통 android 에서 많이 사용!!
        val userList = arrayListOf<String>("git", "github", "bitbucket")
        userList.add("a")
        println("userList size:  " + userList.size)
        // val type은 수정 불가라 했는데? 재할당이 안되는거구나!!!
        // userList = arrayListOf("android","ios","kotlin")
        // val str = "aaa"
        // str = "aaa"


        /**
         * 3. 맵
         */
        println("3. 맵")
        //세팅방법
        val citiesMap = mapOf(Pair("001", "Seoul"), Pair("002", "Seoul"), Pair("003", "Seoul"))
        val citeisMap2 = mapOf("001" to "Seoul", "002" to "Seoul")

        //수정가능
        val mutableMap = mutableMapOf("001" to "Seoul", "002" to "Seoul")

        //mapof 여러가지 타입존재 확인

        /**
         * 4. 집합
         *
         *  특징: 순서없음. 중복데이터 X (중복되지 않은 숫자를 구혈할 때 사용하면 유용하다)
         */
        println("4. 집합")
        val aSet = setOf("a", "b")                          //순서없음. 중복데이터 X
        val hashSet = hashSetOf("a", "b", "c")              //순서없음. 중복데이터 X
        val linkedSet = linkedSetOf("a", "b", "c", "bb")    //순서있음.(입력된순서) 중복데이터 X
        val sortSet = sortedSetOf("a", "b", "c", "bb")      //순서있음(오름차순). 중복데이터 X (=TreeSet)
        print("집합 linkedSet : ")
        for (link in linkedSet) {
            print(link + ", ")
        }
        println()
        print("집합 sortedSet : ")
        for (sort in sortSet) {
            print(sort + ", ")
        }
        println()

        /**
         * 4.3 스트림 함수
         */
        println("4.3")
        /**
         * 1. 변환
         */
        println("1. 변환")
        // 컬렉션 내 인자를 다른 값 혹은 타입으로 변환할 때 사용합니다.
        println("1) map : ")
        val languageType = listOf("java", "kotlin", "swift", "object C")
        languageType.map { language -> language.toUpperCase() }
                .forEach { println(it) }

        // 컬렉션 내 포함된 인자의 인덱스 값을 변환 함수내서 사용할 수있다.
        println("2) mapIndexed : ")
        val nums = 0..4
        nums.mapIndexed { index, i -> index * i }   //디버깅은 걸리지만 값이 표기 안됌!!!!
                .forEach { println("$it") }
        // index는 순서, i는 nums 의 값.
        //========================= val nums = 0..4
        // index 0, i 0  = 0
        // index 1, i 1  = 1
        // index 2, i 2  = 4
        // index 3, i 3  = 9
        //========================= val nums = 1..4
        // index 0, i 1  = 0
        // index 1, i 2  = 2
        // index 2, i 3  = 6
        // index 3, i 4  = 12

        // 컬렉션 내 각 인자를 변환함과 동시에, 변환한 결과가 널 값인 경우 이를 무시합니다.
        println("3) mapNotNull : ")
        languageType.mapNotNull { language -> if (language.length <= 5) language else null }
                .forEach { println(it) }

        //하나의 인자에서 여러개의 인자로 매핑이 필요한 경우에 사용
        //변환함수에서 각 인자를 끝으로 하는 새로운 범위를 반환하였으므로, 이 범위에 해당하는 정수들이
        // ★새롭게 스트림에 추가됩니다★
        println("4) flatMap : ")
        val nums2 = 0..3
        nums2.flatMap { num -> 1..num }
                .forEach { println("$it ") }

        println("flatMap EX 1): ")
        val strings = listOf("abc", "def")
        println(strings.map { it })
        println(strings.map { it.toList() })
        println(strings.flatMap { it.toList() })


        println("flatMap EX 2): ")
        // 책의 저자가 N명이 될 수 있다. 모든 저자를 중복되지 않게 list 로 만드시오!!
        val books = listOf(Book("Thursday Next", listOf("Jasper Fforde")),
                Book("Mort", listOf("Terry Pratchett")),
                Book("Good Omens", listOf("Terry Pratchett",
                        "Neil Gaiman")))
        println(books.map { it.authors }.toSet())
        println(books.flatMap { it.authors }.toSet())

        /**
         * 2. 필터
         */
        println("2. 필터")
        println("1) filter")
        val list = listOf(1, 2, 3, 4)
        println(list.filter { it % 2 == 0 })

        val people = listOf(Person("Alice", 29), Person("Bob", 31))
        println(people.filter { it.age > 30 })

        println("2) take")
        // take로 받은 인자로 받은 개수만큼을 인자로 같는 리스트를 반환한다.
        //val languageType = listOf("java", "kotlin", "swift", "object C")
        println(languageType.take(1))
        println(languageType.take(2))
        println(languageType.takeLast(1))
        println(languageType.takeWhile { lang -> lang.length < 7 })
        println(languageType.takeLastWhile { lang -> lang.length > 7 })

        println("3) drop")
        // drop으로 받은 인자로 받은 개수만큼을 빼고 리스트를 반환
        println(languageType.drop(1))
        println(languageType.drop(2))
        println(languageType.dropLast(1))
        println(languageType.dropWhile { lang -> lang.length < 7 })
        println(languageType.dropLastWhile { lang -> lang.length > 7 })

        println("4) first")
        // 첫번째 인자를 반환하라. 조건이 있으면 조건을 만족하는 첫번째 인자는 반환.
        //val languageType = listOf("java", "kotlin", "swift", "object C")
        println(languageType.first())
        println(languageType.last())
        println(languageType.first{lang -> lang.length > 5})
        println(languageType.last { lang -> lang.length < 7 })

        //조건을 만족하는 첫 번 째 인자를 반환하며, 없을 경우 널 값을 반환한다.
        try {
            languageType.first { lang -> lang.isEmpty() }
        } catch (e: NoSuchElementException) {
            println("!!! not Found !!")
        }
        // Caused by: java.util.NoSuchElementException: Collection contains no element matching the predicate.
        //println(languageType.first { lang -> lang.isEmpty() })

        println(languageType.firstOrNull { lang -> lang.isEmpty() })
        println(null)

        println("4) distinct")
        // 컬랙션내에 포함된 항목 중 중복된 항목을 걸너낸 결과를 반환
        val distanctList = listOf("java", "kotlin", "java", "ruby")
        println(distanctList.distinct())
        println(distanctList.distinctBy { dis -> dis.length })


        /**
         * 3. 조합 및 합계
         */
        println("3. 조합 및 합계")
        println("1) zip")
        // 두 컬랙션 내의 자료들을 조합하여 새로운 자료를 만들 때 사용합니다.
        // - 컬랙션의 자료수는 조합에 사용하는 컬렉션의 자료의 수중 더 적은 쪽을 따라 간다.
        // - 조합된 결과로 Pair 를 만들어 준다.
        val cityCodes = listOf("SEO","TOK")
        val cityNames = listOf("Seoul","Tokyo", "Mountain View")
        cityCodes.zip(cityNames)
                .forEach { pair -> println("${pair.first} : ${pair.second}") }
        //조합 이름 바꾸기.
        cityCodes.zip(cityNames) { cityCode, cityName -> "$cityCode ($cityName)"}
                .forEach { println(it) }

        println("2) joinToString")
        //val languageType = listOf("java", "kotlin", "swift", "object C")
        println(languageType.joinToString())
        println(languageType.joinToString(separator = "|"))

        println("3) count")
        // 컬렉션 내 포함된 자료의 개수를 반환, 별도 조건식을 추가하면 해당 조건을 만족하는 개수 반환.
        //val languageType = listOf("java", "kotlin", "swift", "object C")
        println(languageType.count())
        println(languageType.count{lang -> lang.length > 5})

        println("4) reduce")
        // 컬렉션 내 자료들을 모두 합쳐 하나의 값으로 만들어 주는 역할을 합니다.
        //val languageType = listOf("java", "kotlin", "swift", "object C")
        println(languageType.reduce{acc, s -> "$acc, $s"})
        println(languageType.reduceRight{acc, s -> "$acc, $s"})
        // acc에는 지금까지 조합된 결과가, s에는 새로 조합할 자료가 들어있다.

        println("4) fold")
        println(languageType.fold("init"){acc, s -> "$acc, $s"})
        println(languageType.foldRight("init"){acc, s -> "$acc, $s"})

        /**
         * 4. 기타
         */
        println("1) any")
        println("2) none")
        println("3) max")
        println("4) min")
        println("5) average")

        /**
         * 5. 범위지정함수
         */
        println("1) let")
        //let()은 함수를 호출하는 객체를 이어지는 블록의 인자로 넘기고, 블록의 결과값을 반환합니다.
       /**
       기존
        val padding = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics).toInt()
        // 왼쪽, 오른쪽 padding 설정
        setPadding(padding, 0, padding, 0)
        */
       /**
       let 사용.
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f,
                resources.displayMetrics).toInt().let {
            // padding 대신 it 사용
            setPadding(it, 0, it, 0)
        }
        */

        println("2) apply")
        //apply()는 함수를 호출하는 객체를 이어지는 블록의 리시버 로 전달하고, 객체 자체를 반환합니다.
        //리시버란, 바로 이어지는 블록 내에서 메서드 및 속성에 바로 접근할 수 있도록 할 객체를 의미합니다. (접근 제어자에 따라 접근 가능한 범위에 한함)

        /**
         기존
         val param = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT)
         param.gravity = Gravity.CENTER_HORIZONTAL
         param.weight = 1f
         param.topMargin = 100
         param.bottomMargin = 100
         */
        /**
        apply 사용
        val param = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT).apply {
        gravity = Gravity.CENTER_HORIZONTAL
        weight = 1f
        topMargin = 100
        bottomMargin = 100
        }
         */


        println("3) run")
        //run() 함수는 인자가 없는 익명 함수처럼 동작하는 형태와 객체에서 호출하는 형태 총 두 가지가 있습니다.
        //객체 없이 run() 함수를 사용하면 인자 없는 익명 함수처럼 사용할 수 있습니다.

        // apply() 와 run() 의 차이점
        // apply()와 적용 예가 유사하지만, apply()는 새로운 객체를 생성함과 동시에 연속된 작업이 필요할 때
        // 사용하고 run()은 이미 생성된 객체에 연속된 작업이 필요할 때 사용한다는 점이 조금 다릅니다.
        /**
        override fun onCreate(savedInstanceState: Bundle?) {
        ...
            supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_clear_white)
            }
        ...
        }
        run {
            if (firstTimeView) introView else normalView
        }.show()

        webview.settings?.run {

            javaScriptEnabled = true
            databaseEnabled = true

        }
         */

        println("4) with")
        //with() 함수는 인자로 받는 객체를 이어지는 블록의 리시버로 전달하며, 블록의 결과값을 반환합니다.
        //with() 함수는 사실상 run()함수와 기능이 거의 동일하며, 리시버로 전달할 객체가 어디에 위치하는지만 다릅니다.
        //run() 함수는 with() 함수를 좀 더 편리하게 사용하기 위해 let()함수와 with()함수를 합쳐놓은 형태라 보아도 무방합니다.
        /**
         * supportActionBar?.let {
            with(it) {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_clear_white)
            }
        }
         */

    }

    class Book(val title: String, val authors: List<String>)
    data class Person(val name: String, val age :Int) //data toString()제공.


    fun showMessage(isPrepared: Boolean, message: String) {
        check(isPrepared)  //IllergalSateteException
        require(message.length > 10) // 문자열 길이가 10이상이 아니면 IllergalSateteException
        println(message)
    }

    fun showMessage2(isPrepared: Boolean, message: String?) {
        check(isPrepared)  //RuntimeException

        val msg = requireNotNull(message)  // null 이면 IllegalArgumentException
        require(msg.length > 10)
        println(message)
    }
}