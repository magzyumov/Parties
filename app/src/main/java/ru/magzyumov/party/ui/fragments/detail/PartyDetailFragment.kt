package ru.magzyumov.party.ui.fragments.detail

import android.os.Bundle

import android.view.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_party_detail.*
import ru.magzyumov.party.R
import ru.magzyumov.party.data.entity.PartyEntity
import ru.magzyumov.party.ui.adapter.MemberAdapter
import ru.magzyumov.party.ui.fragments.base.BaseFragment
import ru.magzyumov.party.util.ImageLoader
import java.lang.String.format


class PartyDetailFragment: BaseFragment() {

    override val layoutRes = R.layout.fragment_party_detail

    private val viewModel: PartyDetailViewModel by lazy {
        ViewModelProviders.of(this).get(PartyDetailViewModel::class.java)
    }

    private lateinit var party: PartyEntity
    private lateinit var membersAdapter: MemberAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        party = PartyEntity()

        fragmentWorker.changePageTitle(getString(R.string.title_party))

        initRecyclerView()
        observerLiveData()
    }

    private fun observerLiveData() {
        viewModel.getParty().observe(viewLifecycleOwner, Observer {
            it?.let {
                party = it
                membersAdapter.swap(party.members)
                ImageLoader.loadImage(imageViewParty, party.picture)
                ImageLoader.loadImage(imageViewOrganizer, party.organizer.avatar)
                textViewPartyName.text = party.name
                textViewOrganizer.text = format(getString(R.string.text_sample_organizer), party.organizer.name)
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