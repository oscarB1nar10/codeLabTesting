package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnHundredZero(){
        //Create an active task
        val tasks = listOf(
                Task("title","desc", isCompleted = false),
                Task("title2","desc2", isCompleted = false)
        )
        //Call your function
        val result = getActiveAndCompletedStats(tasks)
        //Check the result
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_oneComplete_returnActiveZero(){
        //create a completed task
        val tasks = listOf(
                Task("title","desc", isCompleted = true)
        )
        //call your function
        val result = getActiveAndCompletedStats(tasks)

        //check result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_TwoComplete_returnActiveFifty(){
        //create a completed task
        val tasks = listOf(
                Task("title","desc1", isCompleted = true),
                Task("title2","desc2", isCompleted = true),
                Task("title3","desc3", isCompleted = false),
                Task("title3","desc3", isCompleted = false)
        )
        //call your function
        val result = getActiveAndCompletedStats(tasks)

        //check result
        assertThat(result.activeTasksPercent, `is`(50f))
        assertThat(result.completedTasksPercent, `is`(50f))
    }

    @Test
    fun getActiveAndCompletedStats_emptyList_returnActAndComZero(){
        //call your function
        val result = getActiveAndCompletedStats(emptyList())

        //check result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnActAndComZero(){
        //call your function
        val result = getActiveAndCompletedStats(null)

        //check result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

}