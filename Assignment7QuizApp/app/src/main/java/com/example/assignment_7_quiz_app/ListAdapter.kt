package com.example.assignment_7_quiz_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_7_quiz_app.data.Quiz
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder> (){

    private var quizList = emptyList<Quiz>()

    class MyViewHolder (itemView:View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = quizList[position]
        holder.itemView.textView.text = currentItem.question.toString()
    }

    override fun getItemCount(): Int {
        return  quizList.size
    }

    fun setData(quiz:List<Quiz>){
        this.quizList = quiz
        notifyDataSetChanged()
    }
}