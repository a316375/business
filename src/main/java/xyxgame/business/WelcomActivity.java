package xyxgame.business;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mob.MobSDK;
import com.mob.imsdk.MobIM;
import com.mob.imsdk.MobIMCallback;
import com.mob.imsdk.MobIMMessageReceiver;
import com.mob.imsdk.model.IMConversation;
import com.mob.imsdk.model.IMMessage;

import java.util.ArrayList;
import java.util.List;

public class WelcomActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);

        MobSDK.init(this);

        findViewById(R.id.b1).setOnClickListener(this);
        findViewById(R.id.b2).setOnClickListener(this);
        findViewById(R.id.b3).setOnClickListener(this);
        findViewById(R.id.b4).setOnClickListener(this);
        textView = findViewById(R.id.tv);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.b1:
                MobSDK.setUser("001", "AB", null, null);

                IMMessage msg = MobIM.getChatManager().createTextMessage("002", "你好呀,大师兄", 2);

                MobIM.getChatManager().sendMessage(msg, new MobIMCallback<Void>() {
                    public void onSuccess(Void result) {
                        Log.d("TAG", "发送成功" + result);
                        Toast.makeText(getApplicationContext(), "发送成功", Toast.LENGTH_LONG).show();
                    }

                    public void onError(int code, String message) {
                        // TODO 根据错误码（code）处理错误返回
                        Log.d("TAG", "onError: " + code + "发送失败" + message);
                        Toast.makeText(getApplicationContext(), code + "发送失败" + message, Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case R.id.b2:

                MobSDK.setUser("002", "AB", null, null);

                MobIM.getChatManager().getMessageList("001", IMConversation.TYPE_USER, 200, 1, new MobIMCallback<List<IMMessage>>() {
                    @Override
                    public void onSuccess(List<IMMessage> imMessages) {
                        ArrayList<String> strings=new ArrayList<>();
                        for (int i = 0; i < imMessages.size(); i++) {
                            strings.add(i+imMessages.get(i).getBody());
                        }

                        Toast.makeText(getApplicationContext(), "收到消息"+strings, Toast.LENGTH_LONG).show();
                        textView.setText(" 收到消息 "+ strings);
                    }

                    @Override
                    public void onError(int i, String s) {

                    }
                });


                break;
            case R.id.b3:
                startActivity(new Intent(getApplicationContext(), com.mob.tools.MobUIShell.class));
                break;
            case R.id.b4:
                break;
        }

    }
}
