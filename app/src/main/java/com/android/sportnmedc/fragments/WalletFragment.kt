package com.android.sportnmedc.fragments

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.android.sportnmedc.*
import com.android.sportnmedc.helpers.Utils
import kotlinx.android.synthetic.main.wallet_fragment.*

class WalletFragment :BaseFragment(R.layout.wallet_fragment){

    data class Transaction(val name: String,val date:String,val type:String,val amount:Int)

    private val data = arrayListOf(
        Transaction("Kata","19 Mar 2019,2:15 pm","receive",50),
        Transaction("Watcharapong","19 Mar 2019,2:15 pm","send",15),
        Transaction("Thomson","19 Mar 2019,2:15 pm","receive",8),
        Transaction("Watcharapong","19 Mar 2019,2:15 pm","send",15),
        Transaction("EXS","19 Mar 2019,2:15 pm","buy",99),
        Transaction("Card","19 Mar 2019,2:15 pm","card",60)

    )


    override fun startView(view: View) {
        setupTransactionList()
        receive_btn.setOnClickListener { startActivity(ReceiveActivity.newIntent(mActivity)) }
        send_btn.setOnClickListener { startActivity(SendActivity.newIntent(mActivity)) }
        buy_btn.setOnClickListener {  startActivityForResult(PaymentActivity.newIntent(mActivity), Utils.REQUEST_CODE_ADD_COIN) }

        redeem_btn.setOnClickListener { startActivity(RedemptionCenterActivity.newIntent(mActivity)) }

    }

    private fun setupTransactionList(){
        if (transaction_container.childCount > 0) transaction_container.removeAllViews()
        for (i in 0 until data.size){
            val v = LayoutInflater.from(mActivity).inflate(R.layout.item_wallet_transaction,transaction_container,false)
            val typeImg:ImageView = v.findViewById(R.id.type_img)
            val messageTxt:TextView = v.findViewById(R.id.message_txt)
            val amountTxt:TextView = v.findViewById(R.id.amount_txt)
            val dateTxt:TextView = v.findViewById(R.id.date_txt)
            data[i].let { transaction ->
                dateTxt.text = transaction.date
                when(transaction.type){
                    "receive"->{
                        typeImg.setImageResource(R.drawable.img_type_receive)
                        messageTxt.text = "Receive from ${transaction.name}"
                        amountTxt.text = "+${transaction.amount}"
                        amountTxt.setTextColor(ActivityCompat.getColor(mActivity,R.color.green))
                    }
                    "send"->{
                        typeImg.setImageResource(R.drawable.img_type_send)
                        messageTxt.text = "Send to ${transaction.name}"
                        amountTxt.text = "-${transaction.amount}"
                        amountTxt.setTextColor(ActivityCompat.getColor(mActivity,R.color.red_indicator))
                    }
                    "buy"->{
                        typeImg.setImageResource(R.drawable.img_type_buy)
                        messageTxt.text = "Buy ${transaction.name}"
                        amountTxt.text = "+${transaction.amount}"
                        amountTxt.setTextColor(ActivityCompat.getColor(mActivity,R.color.green))
                    }
                    "card"->{
                        typeImg.setImageResource(R.drawable.img_type_send)
                        messageTxt.text = "Buy ${transaction.name}"
                        amountTxt.text = "-${transaction.amount}"
                        amountTxt.setTextColor(ActivityCompat.getColor(mActivity,R.color.red_indicator))
                    }
                }

            }
            v.setOnClickListener {
                startActivity(TransactionDetailActivity.newIntent(mActivity, amountTxt.text.toString() ))
            }

            transaction_container.addView(v)
        }
    }


}