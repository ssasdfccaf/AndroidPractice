package com.example.myapp_test6

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp_test6.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    // 뷰바인딩 순서1
    // 이름은 고정 : 예를 들어 , 레이아웃 이름 :activity_test
    // 이름 이 자동으로 생성 : ActivityTestBinding . 캐멀케이스 표기법에 뒤에 + binding 추가.
    lateinit var activityTestBinding: ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // R.layout 버전으로 출력을 하는 형식.
        setContentView(R.layout.activity_test)
        // 뷰바인딩 순서2
        activityTestBinding = ActivityTestBinding.inflate(layoutInflater)
        // // 뷰바인딩 순서3 , 전체 레이아웃, 바인딩으로 출력을 해야함.
        //setContentView(activityMainBinding.root)

        //showBtn -> 클릭시 , 프로필 이미지 profileImg , 보이게
        // 특정 뷰를 선택하는 방법 2가지.
        // 1)-1 findViewById<>() 를 이용하는 방법
        val showBtn:Button = findViewById(R.id.showBtn)
        // 2)-1 viewBinding 를 이용하는 방법
        val showBtn2 = activityTestBinding.showBtn

        // 선택한 뷰를 클릭 이벤트 핸들러를 추가.
        //1)-2
        showBtn.setOnClickListener {
            val profilImg : ImageView = findViewById(R.id.profileImg)
            profilImg.visibility = View.VISIBLE
        }

        // hideBtn -> 클릭시 , 프로필 이미지 profileImg , 사라짐.
        //1)-3
        // 특정 뷰를 선택하는 방법 2가지.
        // 1)-1 findViewById<>() 를 이용하는 방법
        val hideBtn:Button = findViewById(R.id.hideBtn)

        hideBtn.setOnClickListener {
            val profilImg : ImageView = findViewById(R.id.profileImg)
            profilImg.visibility = View.INVISIBLE
        }

        // 2)-1 viewBinding 를 이용하는 방법
        val hideBtn2 = activityTestBinding.hideBtn

        val profileImgView : ImageView = findViewById(R.id.profileImg)
        profileImgView.setOnClickListener {
            // 매개변수 1번: 현재 컨텍스트 : 액티비티, 2번 : 메세지 내용 , 3번: 메세지 출력 시간, 숏:3초, 롱:5초 정도
            Toast.makeText(this@TestActivity,"이미지 클릭했음.!!",Toast.LENGTH_SHORT).show()
        }
    }
}