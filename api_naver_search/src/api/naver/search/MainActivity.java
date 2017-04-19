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
        
        // �˻� ���̾ƿ��� ����Ѵ�.
        setContentView(R.layout.serch);        
        
        // �˻��� ����Ʈ�ڽ��� �����Ų��.
        productTV = (TextView)findViewById(R.id.ProductEdit);
        
        // "�˻�" ��ư�� �����Ų��.
        Button searchBtn = (Button)findViewById(R.id.SearchButton);
        
        // "�˻�" ��ư�� ������ ����ȴ�.
        searchBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String productName = productTV.getText().toString();
				
				// �Էµ� ���ڿ��� ������ �˻��� �ǽ��Ѵ�.
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