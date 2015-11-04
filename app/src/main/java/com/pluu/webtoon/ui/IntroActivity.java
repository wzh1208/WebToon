package com.pluu.webtoon.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.pluu.webtoon.R;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 인트로 화면 Activity
 * Created by nohhs on 15. 3. 25.
 */
public class IntroActivity extends Activity {
	private final String TAG = IntroActivity.class.getSimpleName();

	@Bind(R.id.tvMsg)
	TextView tvMsg;
	@Bind(R.id.progressBar)
	ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		ButterKnife.bind(this);

		initWork();
	}

	private void initWork() {
		Observable
			.empty().delay(1, TimeUnit.SECONDS)
			.subscribeOn(Schedulers.newThread())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(new Subscriber<Object>() {
				@Override
				public void onCompleted() {
					Log.i(TAG, "Login Process Complete");
					tvMsg.setText("다됐어.. 이제 갈거야...");
					progressBar.setVisibility(View.INVISIBLE);

					startActivity(new Intent(IntroActivity.this, MainActivity.class));
					finish();
				}

				@Override
				public void onError(Throwable e) { }

				@Override
				public void onNext(Object o) { }
			});
	}

}