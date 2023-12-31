package br.edu.scl.ifsp.ads.contatospdm.model

interface ContactDao {
    fun createContact(contact: Contact)

    fun retrieveContact(id: Int): Contact?

    fun retrieveContacts(): MutableList<Contact>

    fun updateContact(contact: Contact): Int

    fun deleteContact(contact: Contact): Int
}