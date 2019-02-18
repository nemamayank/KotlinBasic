package com.mayank.kotlinbasic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         *  In Kotlin there is no need to define findViewById's,
         *  you can use it directly
         *
         */

        /**
         * You can declare here the button click listener here itself
         * w/o any boiler plate id's reference
         *
         */
        btnCompare.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                /**
                 *  You can get a reference to your MainActivity object in Kotlin by using a qualified this.
                 *  as shown below you can use the method declared in other class (in my case it's [Utility.kt])
                 */
                hideKeyboard(this@MainActivity)

                //Your code here
                if (!TextUtils.isEmpty(etInput01.text) && !TextUtils.isEmpty(etInput02.text))
                    compareInput(etInput01.text.toString().trim(), etInput02.text.toString().trim())
                else
                    Toast.makeText(applicationContext, getString(R.string.enter_input), Toast.LENGTH_SHORT).show()

            }
        })
    }

    /**
     * Function declaration is simple by just using keyword 'fun' followed by modifier as in java
     *
     * Function to compare input's
     */
    private fun compareInput(input01: String, input02: String) {

        /**
         * Method 01: Compare the input's
         *
         * == operator is used to compare the data of two variables.
         * == operator in Kotlin only compares the data or variables,
         * whereas in Java or other languages == is generally used to compare the references.
         *
         */
        if (input01 == input02) {

            /**
             *
             * Instead of findViewById<TextView>(R.id.textView) just simply use your view id
             *
             * Here you can see CONCAT of two string by using '.plus()' property of kotlin
             *
             * Set Text from input field's by using just '.text'
             */
            tvResult01.text = getString(R.string.result_01).plus("\nStrings '$input01' and '$input02' are equal.")

        } else {

            tvResult01.text = getString(R.string.result_01).plus("\nStrings '$input01' and '$input02' are not equal.")
        }


        /**
         * Method 02: Compare the input's
         *
         *  equals(other: Any?) method is implemented in Any class and can be overridden in any extending class.
         *  .equals method also compares the content of the variables or objects just like == operator
         *  but it behaves differently in case of Float and Double comparison.
         *
         */
        if (input01.equals(input02)) {

            tvResult02.text = getString(R.string.result_02).plus("\nStrings '$input01' and '$input02' are equal.")

        } else {

            tvResult02.text = getString(R.string.result_02).plus("\nStrings '$input01' and '$input02' are not equal.")
        }


        /**
         * Method 03: Compare the input's
         *
         * === operator is used to compare the reference of two variable or object.
         * It will only be true if both the objects or variables pointing to the same object,
         *
         */
        if (input01 === input02) {

            tvResult03.text = getString(R.string.result_03).plus("\nStrings '$input01' and '$input02' are equal.")

        } else {

            tvResult03.text = getString(R.string.result_03).plus("\nStrings '$input01' and '$input02' are not equal.")
        }
    }
}
