package com.example.myapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.lifecycle.LifecycleObserver
import com.example.myapplication.MyApplication
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.LoadingStateLayoutBinding
import javax.inject.Inject
import kotlin.math.log

class MainActivity : AppCompatActivity(), LifecycleObserver {

    @Inject
    lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.headerTextView.text = Html.fromHtml(getString(R.string.header))
        setContentView(binding.root)
        //инжектирую все зависимости, помеченные в данном классе аннотацией @Inject
        (applicationContext as MyApplication).appComponent.inject(this)
        viewModel.subscribeToScreenStateChanges().observe(this) { state -> showState(state) }
    }

    private fun showState(state: MainScreenState) {
        when (state) {
            is MainScreenState.Loading -> showLoadingState()
            is MainScreenState.Working -> showWorkingState(state)
            is MainScreenState.Error -> showErrorState(state)
        }
    }

    private fun showLoadingState() {
        binding.apply {
            includeLoadingStateLayout.loadingLayout.visibility = View.VISIBLE
            includeErrorStateLayout.errorLayout.visibility = View.GONE
        }
    }

    private fun showWorkingState(state: MainScreenState.Working) {
        binding.apply {
            includeLoadingStateLayout.loadingLayout.visibility = View.GONE
            includeErrorStateLayout.errorLayout.visibility = View.GONE
            tasksRecyclerView.adapter = TasksAdapter(state.data.data)
        }
    }

    private fun showErrorState(error: MainScreenState.Error) {
        binding.apply {
            includeLoadingStateLayout.loadingLayout.visibility = View.GONE
            includeErrorStateLayout.errorLayout.visibility = View.VISIBLE
            includeErrorStateLayout.exceptionMessageTextView.text = error.e.message
        }
    }
}
