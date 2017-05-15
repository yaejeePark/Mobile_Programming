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

    String bookName=null;

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

                    }

                    @Override
                    public void onFailure(NetworkRequest<NaverBooks> request, int errorCode, int responseCode, String message, Throwable exception) {
                        Toast.makeText(BookListActivity.this, "찾으시는 항목이 없습니다.", Toast.LENGTH_SHORT).show();
                        Log.i("MainActivity", "responseCode : " + responseCode);

                    }
                });
            }
        });


        booklist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View clickedView,int position, long id) {


                Bitmap savebit;//저장할 비트맵 파일
                savebit=getImageList.arrBit[position];

                String bookName=getImageList.name[position];

                //책 등록 팝업창 띄우기

                LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View dialogView= inflater.inflate(R.layout.pop_up_book_information, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(BookListActivity.this);     // 여기서 this는 Activity의 this
                builder.setView(dialogView); //위에서 inflater가 만든 dialogView 객체 세팅 (Customize)

                ImageView bookImg=(ImageView)dialogView.findViewById(R.id.book_img);
                EditText nameView=(EditText)dialogView.findViewById(R.id.book_name);
                final EditText pageView=(EditText)dialogView.findViewById(R.id.page);

                nameView.setText(bookName);
                bookImg.setImageBitmap(savebit);

                builder.setTitle("책 등록");       // 제목 설정
                builder.setPositiveButton("등록", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String page=pageView.getText().toString();
                        //page,이미지,책이름,장르 db저장!!
                        Toast.makeText(BookListActivity.this, "등록되었습니다.", Toast.LENGTH_SHORT).show();



                    }


                });

                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(BookListActivity.this, "취소되었습니다.", Toast.LENGTH_SHORT).show();

                        // TODO Auto-generated method stub
                        dialog.dismiss();//팝업창 끄기
                    }

                });

                AlertDialog dialog = builder.create();    // 알림창 객체 생성
                dialog.setCanceledOnTouchOutside(false);//없어지지 않도록 설정
                dialog.show();


            }
        });

    }

}