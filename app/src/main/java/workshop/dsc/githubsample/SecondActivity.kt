package workshop.dsc.githubsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*
import com.androidnetworking.error.ANError
import org.json.JSONArray
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.androidnetworking.interfaces.ParsedRequestListener
import org.json.JSONObject


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val coinName = intent.getStringExtra("username")

        /*AndroidNetworking.get("https://coinbin.org/{coinName}")
                .addPathParameter("coinName", coinName)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(object: JSONObjectRequestListener{

                    override fun onResponse(response: JSONObject?) {
                        Log.d("RESPONSE", response.toString())
                        if(response != null) {
                            val coin = response.getJSONObject("coin")
                            if(coin != null) {
                                val name = coin.getString("name")
                                val usdPrice = coin.getDouble("usd")

                                infoTextView.text = "The Price of $name today is $usdPrice"
                            }
                        }
                    }

                    override fun onError(anError: ANError?) {
                        Log.e("RESPONSE", anError.toString())
                    }

                })*/


        AndroidNetworking.get("https://coinbin.org/{coinName}")
                .addPathParameter("coinName", coinName)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(Coin::class.java, object : ParsedRequestListener<Coin> {
                    override fun onResponse(coin: Coin?) {
                        coin?.coin?.apply {
                            infoTextView.text = "The price of $name is $usd"
                        }
                    }

                    override fun onError(anError: ANError?) {

                    }
                })
    }
}
