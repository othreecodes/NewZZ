package com.envelope.pickyapp.ui.newshome

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import com.envelope.pickyapp.R
import com.envelope.pickyapp.data.dto.NewsItem
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.StackFrom
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.news_home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewsHomeViewModel::class.java)
        // TODO: Use the ViewModel

        toolbar.inflateMenu(R.menu.menu_news_home)
        val search_menu = toolbar.menu.findItem(R.id.app_bar_search).actionView as SearchView

        val searchImgId = resources.getIdentifier("android:id/search_button", null, null)
        val v = search_menu.findViewById(searchImgId) as ImageView
        v.setImageResource(R.drawable.ic_search)

        search_menu.setOnQueryTextListener(this)

        manager = CardStackLayoutManager(context,this)
        manager.setStackFrom(StackFrom.Top)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(false)
        adapter = NewsCardAdapter(listOf(
            NewsItem("Messi Quits football","Messi finally quits footbal after 20 years","https://source.unsplash.com/Xq1ntWruZQI/600x800","CNN"),
            NewsItem("Messi Quits football","Messi finally quits footbal after 20 years","https://source.unsplash.com/Xq1ntWruZQI/600x800","CNN"),
            NewsItem("Messi Quits football","Messi finally quits footbal after 20 years","https://source.unsplash.com/Xq1ntWruZQI/600x800","CNN"),
            NewsItem("Messi Quits football","Messi finally quits footbal after 20 years","https://source.unsplash.com/Xq1ntWruZQI/600x800","CNN")
        ))

        card_stack_view.layoutManager = manager

        card_stack_view.adapter = adapter



    }

}
