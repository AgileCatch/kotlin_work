package com.jess.camp.todo.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jess.camp.databinding.TodoItemBinding

class TodoListAdapter(private val itemClickListener: (TodoModel) -> Unit) : RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {

    private val list = ArrayList<TodoModel>()

    fun addItem(todoModel: TodoModel?) {
        if (todoModel == null) {
            return
        }

        list.add(todoModel)
        notifyItemChanged(list.size - 1)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TodoItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        //클릭 이벤트가 발생한 아이템에 관련된 작업을 수행
        holder.itemView.setOnClickListener {
            itemClickListener(item) // 클릭된 아이템의 데이터를 전달
        }
    }

    class ViewHolder(
        private val binding: TodoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TodoModel) = with(binding) {
            title.text = item.title
            description.text = item.description
        }
    }

}