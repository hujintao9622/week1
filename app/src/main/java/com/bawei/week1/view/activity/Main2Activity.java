package com.bawei.week1.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.week1.R;
import com.bawei.week1.base.BaseActivity;
import com.bawei.week1.base.BasePresenter;
import com.bawei.week1.widget.Myclaass;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends BaseActivity {
    @BindView(R.id.tx)
    TextView tx;
    @BindView(R.id.bt)
    Button bt;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.bt_camera)
    Button btcamera;
    @BindView(R.id.bt_photos)
    Button btphotos;
    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        CodeUtils.init(this);
        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(img, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(Main2Activity.this, ""+result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(Main2Activity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tx, R.id.bt,R.id.bt_photos,R.id.bt_camera})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tx:
                String string = tx.getText().toString();
                Bitmap image = CodeUtils.createImage(string, 400, 400, null);
                img.setImageBitmap(image);
                break;
            case R.id.bt:
                 EventBus.getDefault().post(new Myclaass("小白","19"));
                break;
            case R.id.bt_camera:
                CodeUtils.analyzeByCamera(this);
                break;
            case R.id.bt_photos:
                CodeUtils.analyzeByPhotos(this);
                break;
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void EventF(Myclaass s){
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CodeUtils.onActivityResult(this, requestCode, resultCode, data, new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                Toast.makeText(Main2Activity.this, ""+result, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAnalyzeFailed() {
                Toast.makeText(Main2Activity.this, "失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
