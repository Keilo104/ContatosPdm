package br.edu.scl.ifsp.ads.contatospdm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.scl.ifsp.ads.contatospdm.databinding.ActivityContactBinding
import br.edu.scl.ifsp.ads.contatospdm.model.Constant.EXTRA_CONTACT
import br.edu.scl.ifsp.ads.contatospdm.model.Contact
import java.util.Random

class ContactActivity : AppCompatActivity() ***REMOVED***
    private val acb: ActivityContactBinding by lazy ***REMOVED***
        ActivityContactBinding.inflate(layoutInflater)
***REMOVED***

    override fun onCreate(savedInstanceState: Bundle?) ***REMOVED***
        super.onCreate(savedInstanceState)
        setContentView(acb.root)

        setSupportActionBar(acb.toolbarIn.toolbar)
        supportActionBar?.subtitle = "Contact details"

        val receivedContact = intent.getParcelableExtra<Contact>(EXTRA_CONTACT)
        receivedContact?.let ***REMOVED*** _receivedContact ->
            with(acb) ***REMOVED***
                nameEt.setText(_receivedContact.name)
                addressEt.setText(_receivedContact.address)
                phoneEt.setText(_receivedContact.phone)
                emailEt.setText(_receivedContact.email)
    ***REMOVED***
***REMOVED***

        with(acb) ***REMOVED***
            saveBt.setOnClickListener ***REMOVED***
                val contact: Contact = Contact(
                    id = receivedContact?.id?:generateId(),
                    name = nameEt.text.toString(),
                    address = addressEt.text.toString(),
                    phone = phoneEt.text.toString(),
                    email = emailEt.text.toString()
                )

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_CONTACT, contact)
                setResult(RESULT_OK, resultIntent)
                finish()
    ***REMOVED***
***REMOVED***
***REMOVED***

    private fun generateId(): Int = Random(System.currentTimeMillis()).nextInt()
***REMOVED***