package ru.magzyumov.party.ui.fragments



import android.os.Bundle

import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_party_detail.*
import ru.magzyumov.party.R
import ru.magzyumov.party.data.entity.PartyEntity
import ru.magzyumov.party.ui.adapter.MemberAdapter
import ru.magzyumov.party.ui.main.MainViewModel
import ru.magzyumov.party.util.ImageLoader


class PartyDetailFragment: Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private lateinit var party: PartyEntity
    private lateinit var membersAdapter: MemberAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        party = PartyEntity()
        return inflater.inflate(R.layout.fragment_party_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        observerLiveData()
    }

    private fun observerLiveData() {
        viewModel.getParty().observe(viewLifecycleOwner, Observer {
            it?.let {
                party = it
                membersAdapter.swap(party.members)
                ImageLoader.loadImage(imageViewParty, party.picture)
            }
        })
    }
    private fun initRecyclerView() {
        recyclerViewMembers.apply {
            membersAdapter = MemberAdapter(
                party.members
            )
            layoutManager = LinearLayoutManager(this@PartyDetailFragment.context)
            adapter = membersAdapter
        }
    }

}