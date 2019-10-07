package com.zing.zalo.zalosdk.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.zing.zalo.zalosdk.oauth.ZaloSDK
import org.json.JSONObject

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var imgAvatar: ImageView? = null
    var txtUid: TextView? = null
    var txtName: TextView? = null
    var btnLogout: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgAvatar = findViewById(R.id.img_avatar)
        txtUid = findViewById(R.id.txt_uid)
        txtName = findViewById(R.id.txt_name)
        btnLogout = findViewById(R.id.btn_logout)
        btnLogout?.setOnClickListener(this)

        //Get Profile
        ZaloSDK.Instance.getProfile(this, {data: JSONObject ->
            txtUid?.text = data.optString("id")
            txtName?.text = data.optString("name")

            val pic = data.optJSONObject("picture")
            val picData = pic?.optJSONObject("data")
            val url = picData?.optString("url")
            if(!TextUtils.isEmpty(url)) {
                Picasso.get().load(url)
                    .placeholder(R.drawable.ic_account_box_white_24dp)
                    .into(imgAvatar)
            }

        }, arrayOf("id", "name", "picture"))
    }

    override fun onClick(p0: View?) {
        //Logout
        ZaloSDK.Instance.unauthenticate()
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
