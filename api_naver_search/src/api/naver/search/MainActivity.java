package api.naver.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView productTV;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // 검색 레이아웃를 출력한다.
        setContentView(R.layout.serch);        
        
        // 검색어 에디트박스와 연결시킨다.
        productTV = (TextView)findViewById(R.id.ProductEdit);
        
        // "검색" 버튼과 연결시킨다.
        Button searchBtn = (Button)findViewById(R.id.SearchButton);
        
        // "검색" 버튼을 눌르면 실행된다.
        searchBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String productName = productTV.getText().toString();
				
				// 입력된 문자열이 있으면 검색을 실시한다.
				if( productName.length() > 0 ) {
					Intent intent = new Intent(MainActivity.this, PriceListActivity.class);						
					Bundle myData = new Bundle();				
		            myData.putString("PRODUCT_NAME", productName);	           
		            intent.putExtras(myData);							
					startActivity(intent);
				}
			}
		});
    }
}