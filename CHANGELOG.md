Zao SDK for Android

# 2.4.1007
- Bỏ mã hoá aes trong App Tracker & Event Tracker
- Remove OpenAPIActivity khai báo trong file AndroidManifest

# 2.4.1002
- Wakeup: Hỗ trợ thêm param khi tạo intent mở app 

# 2.4.0920
- Remove WebLoginActivity khai báo trong file AndroidManifest
- Login browser. Cần thêm khai báo activity vào file manifest
```
<activity
android:name="com.zing.zalo.zalosdk.oauth.BrowserLoginActivity">
<intent-filter>
    <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        <data android:scheme="zalo-[appid]" />
    </intent-filter>
</activity>
```
Cần replace [appid] = zalo id của app
- Try catch SecurityExceptioni khi check login

# 2.4.0823.1
- Chuyển android support depedency từ lib core -> auth
- Gọi callback của getZaloLoginStatus trên main thread

# 2.4.0823
- Service map: tự cập nhật domain của các api 
- Thêm tính năng check zalo đã đăng nhập hay chưa (getZaloLoginStatus của ZaloSDK)
- Khi đăng nhập bằng cờ "LoginVia.APP_OR_WEB", nếu như app zalo chưa đăng nhập sẽ mở web view
- Optmize method ZaloSDKApplication.wrap, giảm thời gian exectute

# 2.4.0717
- Chuyển toàn bộ open api từ domain graph.zalo.me ->  graph.zaloapp.com

# 2.4.2501.1
- Hotfix: sửa lỗi share feed lên tường zalo bị lỗi phải nhấn 2 lần cho trường hợp chưa login Zalo

# 2.4.2501
- upload sdk to jcenter, groud is com.zing.zalo.zalosdk

# 2.4.0901
- Fix: can not dismiss dialog when login facebook

# 2.3.1225.1 (25/12/2018)
- Fix return callback for method: isPreload() 

# 2.3.1214.1 (14/12/2018)
- add method check preload for app

# 2.3.1203 (3/12/2018)
- Fix status bar color

# 2.3.1128 (28/11/2018)
- Fix return callback for open api service
- Apply preload

# 2.3.0528 (28/05/2018)
- Fix getprofile bug
- add method setAppID for game MTO

# 2.3.01.7 (21/05/2018)
- Fix bug update profile when register zalo account

# 2.3.01.6 (3/05/2018)
- Add function collect SSAID, MAC address, IMEI, etc

# 2.3.01.5 (27/04/2018)
- use https for all apis
- Disable function scan install app
- Remove function collect SSAID, MAC address, IMEI, etc

# 2.3.01.4 (19/04/2018)
- Change to https

# 2.3.0131
- Fix bug LoginForm

# 2.3.0111
- Fix version code

# 2.3.0108
- Fix bug login zalo by webview
- Fix bug log in

# 2.2.1228
- Apply new UI login zalo via web
- Fix bug getProfile

# 2.2.1130
- Update new open API for Eclipse project

# 2.2.1020
- improve performance getDeviceID method: affect on library: libZDK-core-v2.2.10.1.jar
- update plugin share with auto back to app: affect on library: libZDK-openApi-v2.2.816.jar
- Fix bug on QOS library, separate libZaloSDK-qos-v2.2.10.1.jar with libZaloSDK-v2.2.10.1.aar: copy file libZaloSDK-qos-v2.2.10.1.jar in to folder "libs" if use it.

# 2.2.0918
- Fix bug crash on android 8

# 2.2.0913
- Fix bug crash when login facebook

# 2.2.0901
Update demo for android studio

# 2.2.0816
Remove submit appuserData

# 2.2.0815
15-8-2017
-Release refactor module

# 2.2.0428
Update 28 April 2017:
- fix form protect account

# 2.2.0426
- update UI progress dialog

# 2.2.0419
Update 19 April 2017:
- update google login services

# 2.2.0321
Update 21 March 2017:
- change https for https://centralized.zaloapp.com
- change key name for appID in meta data: "com.zing.zalo.zalosdk.appID" or "appID"




