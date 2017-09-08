package www.yckj.com.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import www.yckj.com.myapplication.R;
import www.yckj.com.myapplication.presenter.WeatherImp;

public class WeatherActivity extends AppCompatActivity implements WeatherView{

    private TextView content;
    private WeatherImp weatherImp;
    private EditText et_cityName;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        weatherImp = new WeatherImp(this);
        initView();
    }

    private void initView() {
        content = ((TextView) findViewById(R.id.tv_content));
        et_cityName = ((EditText) findViewById(R.id.et_cityName));
        button = ((Button) findViewById(R.id.button));
        et_cityName.setText("北京");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(et_cityName.getText().toString())){
                    Toast.makeText(WeatherActivity.this, "请输入城市名称", Toast.LENGTH_SHORT).show();
                    return;
                }
                weatherImp.requestWeatherData(et_cityName.getText().toString().trim());
            }
        });
    }

    @Override
    public void setData(String data) {
        content.setText(data);
    }
}
