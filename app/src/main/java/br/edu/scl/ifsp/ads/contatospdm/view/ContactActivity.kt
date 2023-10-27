package br.edu.scl.ifsp.ads.contatospdm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.edu.scl.ifsp.ads.contatospdm.databinding.ActivityContactBinding
import br.edu.scl.ifsp.ads.contatospdm.model.Constant.EXTRA_CONTACT
import br.edu.scl.ifsp.ads.contatospdm.model.Constant.INVALID_CONTACT_ID
import br.edu.scl.ifsp.ads.contatospdm.model.Constant.VIEW_CONTACT
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
            val viewContact: Boolean = intent.getBooleanExtra(VIEW_CONTACT, false)
            with(acb) ***REMOVED***
                if(viewContact) ***REMOVED***
                    nameEt.isEnabled = false
                    addressEt.isEnabled = false
                    phoneEt.isEnabled = false
                    emailEt.isEnabled = false
                    saveBt.visibility = View.GONE
        ***REMOVED***
                nameEt.setText(_receivedContact.name)
                addressEt.setText(_receivedContact.address)
                phoneEt.setText(_receivedContact.phone)
                emailEt.setText(_receivedContact.email)
    ***REMOVED***
***REMOVED***

        with(acb) ***REMOVED***
            saveBt.setOnClickListener ***REMOVED***
                val contact = Contact(
                    id = receivedContact?.id,
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

/* we don't do that here
    private fun generateId(): Int***REMOVED***
        return Random(System.currentTimeMillis()).nextInt()
***REMOVED***
 */
***REMOVED***