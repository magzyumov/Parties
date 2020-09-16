package ru.magzyumov.party.ui.main

interface FragmentWorker {
    fun changePageTitle(title: String)
    fun returnFragment()
    fun showMessage(message: String)
}