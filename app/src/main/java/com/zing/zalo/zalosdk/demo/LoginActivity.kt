package com.zing.zalo.zalosdk.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.zing.zalo.zalosdk.oauth.LoginVia
import com.zing.zalo.zalosdk.oauth.OAuthCompleteListener
import com.zing.zalo.zalosdk.oauth.OauthResponse
import com.zing.zalo.zalosdk.oauth.ZaloSDK

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    var btnLogin : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btn_login_zalo)
        btnLogin?.setOnClickListener(this)

        //check login
        if(ZaloSDK.Instance.isAuthenticate(null)) {
            onLoginSuccess()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        ZaloSDK.Instance.onActivityResult(this, requestCode, resultCode, data)
    }

    override fun onClick(p0: View?) {
        if(p0 == btnLogin) {
            loginZalo()
        }
    }
    
    private fun loginZalo() {
        ZaloSDK.Instance.authenticate(this, LoginVia.APP_OR_WEB, listener)
    }

    fun onLoginSuccess() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    fun onLoginError(code: Int, message: String) {
        Toast.makeText(this, "[$code] $message", Toast.LENGTH_LONG).show()
    }

    private val listener = object : OAuthCompleteListener() {
        override fun onGetOAuthComplete(response: OauthResponse?) {
            if(TextUtils.isEmpty(response?.oauthCode)) {
                onLoginError(response?.errorCode ?: -1, response?.errorMessage ?: "Unknown error")
            } else {
                onLoginSuccess()
            }
        }

        override fun onAuthenError(errorCode: Int, message: String?) {
            onLoginError(errorCode, message ?: "Unknown error")
        }
    }
}
