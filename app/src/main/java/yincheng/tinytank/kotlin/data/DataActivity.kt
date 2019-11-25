package yincheng.tinytank.kotlin.data

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import yincheng.tinytank.kotlin.IData

class DataActivity : AppCompatActivity() {
    private lateinit var lateInitString: String
    private var nullableString: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        println(name) //必须初始化
        println(nullableString)
        var sourceData = IData("一雄", 26)
        /**
         * 复制一个数据类并修改其中的属性
         */
        val replacedData = sourceData.copy(name = "音城")
        Log.i("replaceData", replacedData.toString())


        /**
         * 映射对象到变量中
         */
        val (replacedName, replacedAge) = replacedData
        Log.i("getDataFromDao", "$replacedName $replacedAge")


        /**
         * 循环打印一个Map中的键值对
         */
        var mapData = hashMapOf<String, String>()
        mapData["a"] = "1"
        mapData["b"] = "2"
        mapData["c"] = "3"
        for (mapDatum in mapData) {
            Log.i("forLoopMap", "old way : ${mapDatum.key} - ${mapDatum.value}")
        }
        for ((key, value) in mapData) {
            Log.i("forLoopMap", "new way : $key - $value")
        }

        testAlso()
        testLazy()
    }

    /**
     * also()方法
     */
    private fun testAlso() {
        var instance: IData
        val alsoDate = IData("yincheng", 26).also {
            instance = it
            Log.i("testAlso", instance.name)
        }
        Log.i("testAlso", "$instance ${instance.age} $alsoDate")
    }

    /**
     * by lazy
     */
    private fun testLazy() {
        for (i in 1..100) {
            Log.i("byLazyTest", lazyValue)
        }
    }

    private val lazyValue: String by lazy {
        Log.i("byLazyTest", "第一次初始化")
        "这里写初始化的值"
    }
}