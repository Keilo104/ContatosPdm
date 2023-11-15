package br.edu.scl.ifsp.ads.contatospdm.model

import com.google.firebase.Firebase
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue

class ContactDaoRtDbFb : ContactDao {
    companion object {
        private const val CONTACT_LIST_ROOT_NODE = "contactList"
    }

    private val contactRtDbFbReference = Firebase.database.getReference(CONTACT_LIST_ROOT_NODE)

    // Simula uma consulta ao realtime database
    private val contactList: MutableList<Contact> = mutableListOf()

    init {
        contactRtDbFbReference.addChildEventListener(object: ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val contact: Contact? = snapshot.getValue<Contact>()

                contact?.also { _contact ->
                    if (!contactList.any { it.id == _contact.id }) {
                        contactList.add(_contact)
                    }
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                val contact: Contact? = snapshot.getValue<Contact>()

                contact?.also { _contact ->
                    contactList.apply {
                        this[indexOfFirst { it.id == _contact.id }] = _contact
                    }
                }
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                val contact: Contact? = snapshot.getValue<Contact>()

                contact?.also { _contact ->
                    contactList.remove(_contact)
                }
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                // NSA
            }

            override fun onCancelled(error: DatabaseError) {
                // NSA
            }
        })

        contactRtDbFbReference.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val contactMap = snapshot.getValue<Map<String, Contact>>()

                contactList.clear()

                contactMap?.values?.also {
                    contactList.addAll(it)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // NSA
            }
        })
    }

    private fun createOrUpdateContact(contact: Contact) {
        contactRtDbFbReference.child(contact.id.toString()).setValue(contact)
    }

    override fun createContact(contact: Contact) {
        createOrUpdateContact(contact)
    }

    override fun updateContact(contact: Contact): Int {
        createOrUpdateContact(contact)
        return 1
    }

    override fun retrieveContact(id: Int): Contact {
        return contactList[contactList.indexOfFirst { it.id == id }]
    }

    override fun retrieveContacts(): MutableList<Contact> {
        return contactList
    }

    override fun deleteContact(contact: Contact): Int {
        contactRtDbFbReference.child(contact.id.toString()).removeValue()
        return 1
    }
}