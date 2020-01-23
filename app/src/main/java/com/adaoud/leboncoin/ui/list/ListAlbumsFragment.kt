package com.adaoud.leboncoin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.adaoud.leboncoin.R
import com.adaoud.leboncoin.ui.list.AlbumAdapter
import com.adaoud.leboncoin.ui.list.AlbumViewData
import com.adaoud.leboncoin.ui.list.ListAlbumsViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject
import androidx.lifecycle.ViewModelProviders
import com.deezer.util.addLoadMoreListener

class ListAlbumsFragment : Fragment() {

    companion object {
        fun newInstance() = ListAlbumsFragment()
    }

    @Inject
    lateinit var viewModel: ListAlbumsViewModel

    private lateinit var adapter: AlbumAdapter
    private var albumsList = mutableListOf<AlbumViewData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        observeViewModel()

        initRecyclerView()

        viewModel.getAlbums()



    }

    private fun observeViewModel() {
        viewModel = ViewModelProviders.of(this).get(ListAlbumsViewModel::class.java)

        viewModel.getIsLoading().observe(this, androidx.lifecycle.Observer {show ->
            showProgress(show)
        })


        viewModel.getAlbumsResponse().observe(this, Observer { list ->

            adapter.notifyItemInserted(albumsList.size)

        })

    }

    private fun showProgress(show: Boolean?) {
        if (show == true){
            if (albumsList.isNotEmpty()) {
                fragment_list_progress_load_more.visibility = View.VISIBLE
            }else {
                fragment_list_layout_progress.visibility = View.VISIBLE
            }
        }else{
            fragment_list_layout_progress.visibility = View.GONE
            fragment_list_progress_load_more.visibility = View.GONE
        }
    }

    private fun initRecyclerView() {
        fragment_list_rc_albums.setLayoutManager(GridLayoutManager(context, 2))
        adapter = AlbumAdapter(this.requireContext(), albumsList)
        fragment_list_rc_albums.adapter = adapter

        fragment_list_rc_albums.addLoadMoreListener {

            showProgress(true)

             viewModel.getAlbums()
        }

    }

}
