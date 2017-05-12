package org.androidtown.mobile_termproj_0408;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


public class BookListActivity extends AppCompatActivity {


    final static int NUM_PRODUCT_PER_SCREEN = 10;//한 화면에 출력될 제품수

    int nStartPosition = 1;//출력할 리스트의 시작 위치 지정

    ListView booklist;

    EditText et;

    BookListAdapter adapter;
    Button button;

    String bookName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        Intent intent = getIntent();

        booklist = (ListView) findViewById(R.id.book_search_list);
        adapter = new BookListAdapter();
        booklist.setAdapter(adapter);
        button = (Button) findViewById(R.id.search);
        et = (EditText) findViewById(R.id.search_book);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookName = et.getText().toString();
                NaverBookRequest request = new NaverBookRequest(bookName);//검색 리퀘스트 값들 지정
                NetworkManager.getInstance().getNetworkData(request, new NetworkManager.OnResultListener<NaverBooks>() {//새로운 네트워크메니저 생성하여 생성한 리퀘스트 넣어줌
                    @Override
                    public void onSuccess(NetworkRequest<NaverBooks> request, NaverBooks result) {
                        //                            for (MovieItem item : result.items) {
//                                mAdapter.add(item);
//                            }
                        adapter.addAll(result.items);//성공시에 받아온 아이템을 리스트에 넣어준다
                        booklist.setOnItemClickListener(itemClickListenerOfLanguageList);
                    }

                    @Override
                    public void onFailure(NetworkRequest<NaverBooks> request, int errorCode, int responseCode, String message, Throwable exception) {
                        Toast.makeText(BookListActivity.this, "찾으시는 항목이 없습니다.", Toast.LENGTH_SHORT).show();
                        Log.i("MainActivity", "responseCode : " + responseCode);

                    }
                });
            }
        });

    }

    private AdapterView.OnItemClickListener itemClickListenerOfLanguageList = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //Dialog에서 보여줄 입력화면 View 객체 생성 작업
//            //Layout xml 리소스 파일을 View 객체로 부불려 주는(inflate) LayoutInflater 객체 생성
            LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
//
//
//            //res폴더>>layout폴더>>dialog_addmember.xml 레이아웃 리소스 파일로 View 객체 생성
//            //Dialog의 listener에서 사용하기 위해 final로 참조변수 선언
             View dialogView= inflater.inflate(R.layout.pop_up_book_information, null);
            Bitmap savebit;//저장할 비트맵 파일
            savebit=getImageList.arrBit[position];
            String bookName=getImageList.name[position];

            AlertDialog.Builder builder = new AlertDialog.Builder(BookListActivity.this);     // 여기서 this는 Activity의 this
            builder.setView(dialogView); //위에서 inflater가 만든 dialogView 객체 세팅 (Customize)
//// 여기서 부터는 알림창의 속성 설정
          builder.setTitle("책 정보");       // 제목 설정
//            //밑은 이미지 설정
           // builder.setIcon(android.R.drawable.ic_popup_reminder); //제목옆의 아이콘 이미지(원하는 이미지 설정)
            ImageView bookImg=(ImageView)dialogView.findViewById(R.id.book_img);
            EditText nameView=(EditText)dialogView.findViewById(R.id.book_name);
            final EditText pageView=(EditText)dialogView.findViewById(R.id.page);

            nameView.setText(bookName);
            bookImg.setImageBitmap(savebit);
            builder.setPositiveButton("등록", new DialogInterface.OnClickListener() {

                //Dialog에 "Complite"라는 타이틀의 버튼을 설정

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    // TODO Auto-generated method stub
                    String page=pageView.getText().toString();
                    //멤버 정보의 입력을 완료하고 TextView에 추가 하도록 하는 작업 수행



                    //dialogView 객체 안에서 NAME을 입력받는 EditText 객체 찾아오기(주의: dialaogView에서 find 해야함)

//                    EditText edit_name= (EditText)dialogView.findViewById(R.id.dialog_edit);



                    //dialogView 객체 안에서 NATION을 입력받는 RadioGroup 객체 찾아오기

                    //RadioGroup rg= (RadioGroup)dialogView.findViewById(R.id.dialog_rg);



                    //EditText에 입력된 이름 얻어오기

                   // String name= edit_name.getText().toString();

                    //선택된 RadioButton의 ID를 RadioGroup에게 얻어오기

                 //   int checkedId= rg.getCheckedRadioButtonId();



                    //Check 된 RadioButton의 ID로 라디오버튼 객체 찾아오기

                 //   RadioButton rb= (RadioButton)rg.findViewById(checkedId);

                   // String nation= rb.getText().toString();//RadionButton의 Text 얻어오기



                    //TextView의 이전 Text에 새로 입력된 멤버의 데이터를 추가하기

                    //TextView로 멤버리스트를 보여주는 것은 바람직하지 않음.다음 포스트에서 ListView로 처리합니다.

//                    String s= name+"   "+nation+"\n";
//
//                    str+= s;
//
//                    text.setText(str);



                    //TextView에 추가작업을 완료 하였기에 '완료'했다는 메세지를 Toast로 출력

                    Toast.makeText(BookListActivity.this, "새로운 책을 추가했습니다", Toast.LENGTH_SHORT).show();

                }

            });

            builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {

                //Dialog에 "Cancel"이라는 타이틀의 버튼을 설정



                @Override
                public void onClick(DialogInterface dialog, int which) {

                    // TODO Auto-generated method stub

                    //멤버 정보의 입력을 취소하고 Dialog를 종료하는 작업

                    //취소하였기에 특별한 작업은 없고 '취소'했다는 메세지만 Toast로 출력

                    Toast.makeText(BookListActivity.this, "책 추가를 취소합니다", Toast.LENGTH_SHORT).show();

                }

            });

            AlertDialog dialog = builder.create();    // 알림창 객체 생성
//                //Dialog의 바깥쪽을 터치했을 때 Dialog를 없앨지 설정
//             //   dialog.setCanceledOnTouchOutside(false);//없어지지 않도록 설정
               dialog.show();
        }
    };
}
//    {
//        public void onItemClick(AdapterView<?> BookListAdapter, View clickedView, int pos, long id)
//        {
//          //  String toastMessage = ((TextView)clickedView).getText().toString() + " is selected.";
//            Toast.makeText(
//                    getApplicationContext(),
//                   "hi",
//                    // toastMessage,
//                    Toast.LENGTH_SHORT
//            ).show();
//
//            //Dialog에서 보여줄 입력화면 View 객체 생성 작업
//            //Layout xml 리소스 파일을 View 객체로 부불려 주는(inflate) LayoutInflater 객체 생성
//            //LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
//
//
//            //res폴더>>layout폴더>>dialog_addmember.xml 레이아웃 리소스 파일로 View 객체 생성
//            //Dialog의 listener에서 사용하기 위해 final로 참조변수 선언
//             //View dialogView= inflater.inflate(R.layout.pop_up_book_information, null);
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(BookListActivity.this);     // 여기서 this는 Activity의 this
//
//// 여기서 부터는 알림창의 속성 설정
//            builder.setTitle("책 정보");       // 제목 설정
//            //밑은 이미지 설정
//          //  builder.setIcon(android.R.drawable.popup_icon.png); //제목옆의 아이콘 이미지(원하는 이미지 설정)
//
//
//                AlertDialog dialog = builder.create();    // 알림창 객체 생성
//                //Dialog의 바깥쪽을 터치했을 때 Dialog를 없앨지 설정
//             //   dialog.setCanceledOnTouchOutside(false);//없어지지 않도록 설정
//                dialog.show();    // 알림창 띄우기
//    }
//};


