package com.jess.camp.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jess.camp.databinding.TodoFragmentBinding

class TodoFragment : Fragment() {


    companion object {
        fun newInstance() = TodoFragment()
    }

    private var _binding: TodoFragmentBinding? = null
    private val binding get() = _binding!!

    //데이터 추가
    private val listAdapter by lazy {
        TodoListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TodoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

//        // for test
//        val testList = arrayListOf<TodoModel>()
//        for (i in 0 until 100) {
//            testList.add(
//                TodoModel(
//                    id = i,
//                    "Todo Title $i"
//                )
//            )
//        }
//
//        listAdapter.addItem(testList)
    }

    private fun initView() = with(binding) {
        todoList.adapter = listAdapter
    }

    fun handleInput(title: String?, content: String?) {
        if (title != null && content != null) {
            val newTodoModel = TodoModel(
                id = listAdapter.itemCount, // 새로운 아이템의 ID를 리스트 크기로 설정
                title = title,
                content=content
            )
            listAdapter.addItem(newTodoModel)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}