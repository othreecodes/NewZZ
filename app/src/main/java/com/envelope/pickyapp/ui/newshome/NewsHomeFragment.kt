package com.envelope.pickyapp.ui.newshome

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.envelope.pickyapp.R
import com.envelope.pickyapp.data.dto.NewsItem
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.StackFrom
import kotlinx.android.synthetic.main.content_news_card.*
import kotlinx.android.synthetic.main.news_home_fragment.*


class NewsHomeFragment : Fragment(), SearchView.OnQueryTextListener, CardStackListener {
    override fun onCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun onCardSwiped(direction: Direction?) {
    }

    override fun onCardCanceled() {
    }

    override fun onCardRewound() {
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }

    companion object {
        fun newInstance() = NewsHomeFragment()
    }

    private lateinit var viewModel: NewsHomeViewModel
    lateinit var adapter: NewsCardAdapter
    lateinit var manager: CardStackLayoutManager
    var mUserVisibleHint = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.news_home_fragment, container, false)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        if (isVisibleToUser) {

        }
        else {
        }
    }

    override fun onResume() {
        super.onResume()

//            updateUI()

    }

    private fun updateUI() {
        val data = viewModel.newsItems.observe(this, Observer {

        })
        manager = CardStackLayoutManager(context, this)
        manager.setStackFrom(StackFrom.Top)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)

        manager.setMaxDegree(50.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(false)
        adapter = NewsCardAdapter(
            listOf(
                NewsItem("",
                    "Messi Quits football",
                    "Messi finally quits footbal after 20 years",
                    "https://cdn2.theweek.co.uk/sites/theweek/files/2018/03/lionel_messi_release_clause_barcelona_transfer_news_getty_images_927115406.jpg",
                    "CNN"
                ),
                NewsItem("",
                    "Messi Quits football",
                    "Messi finally quits footbal after 20 years",
                    "https://source.unsplash.com/Xq1ntWruZQI/600x800",
                    "CNN"
                ),
                NewsItem("",
                    "Messi Quits football",
                    "Messi finally quits footbal after 20 years",
                    "https://source.unsplash.com/Xq1ntWruZQI/600x800",
                    "CNN"
                ),
                NewsItem("",
                    "Messi Quits football",
                    "Messi finally quits footbal after 20 years",
                    "https://cdn2.theweek.co.uk/sites/theweek/files/2018/03/lionel_messi_release_clause_barcelona_transfer_news_getty_images_927115406.jpg",
                    "CNN"
                )
            )
        )

        if (card_stack_view.adapter == null) {
            card_stack_view.layoutManager = manager

            card_stack_view.adapter = adapter


        }
    }





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("errrrr","created eoekekeoke")
        viewModel = ViewModelProviders.of(this).get(NewsHomeViewModel::class.java)
        // TODO: Use the ViewModel

        toolbar.inflateMenu(R.menu.menu_news_home)
        val search_menu = toolbar.menu.findItem(R.id.app_bar_search).actionView as SearchView

        val searchImgId = resources.getIdentifier("android:id/search_button", null, null)
        val v = search_menu.findViewById(searchImgId) as ImageView
        v.setImageResource(R.drawable.ic_search)

        search_menu.setOnQueryTextListener(this)

        try {
            updateUI()
        }catch (err:Exception){}

    }


}
