package com.example.assignment_7_quiz_app.data

import android.content.Context
import android.provider.CalendarContract.Instances
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quiz::class], version = 2, exportSchema = false)
abstract class QuizDb : RoomDatabase(){
    abstract fun quizDao(): QuizDao


    companion object{
        @Volatile
        private var INSTANCE: QuizDb?=null

        fun getDatabase (context:Context):QuizDb{
            val tempInstance = INSTANCE

            if(tempInstance !=null){
                return  tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuizDb::class.java,
                    "QuizDb"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                INSTANCE=instance
                return  instance
            }
        }
    }



    /*
    companion object {
        // meaning that writes to this field
        // * are immediately made visible to other threads
        @Volatile
        private var instance: QuizDb? = null
        private val LOCK = Any() // The root of the Kotlin class hierarchy. Every Kotlin class has

        //        [Any] as a superclass.
        // Invoke check if the instance is not null return the instance, if it is null
        // synchronized block work, inside this also check null or not and call the function
//        buildDatabase
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {

            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        // Function to build database
        private fun buildDatabase(context: Context): QuizDb {
            return Room.databaseBuilder(
                context.applicationContext,
                QuizDb::class.java,
                "QuizDb"
            ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        }
    }


     */

}