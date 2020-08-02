package shubhamji.com.newspaper.database.stack

import android.widget.Toast
import shubhamji.com.newspaper.database.entity.News
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList

class Stack{
    companion object{
        var stack:ArrayList<News> =ArrayList()
         fun push(element: News) {
            stack.add(element)
        }
         fun display(){
             Timber.i(stack.toString())
         }
         fun pop(): News {
            val poppedElement=top()
            stack.remove(poppedElement)
            return poppedElement
        }
         fun pushAll(news: List<News>)
        {
            stack.addAll(news)
        }
         fun top(): News {
            if(stack.isEmpty()){
                throw EmptyStackException()
            }
            return stack[stack.lastIndex]
        }

         fun isEmpty():Boolean {
            return stack.isEmpty()
        }

         fun size(): Int {
            return stack.size
        }
    }
    
}