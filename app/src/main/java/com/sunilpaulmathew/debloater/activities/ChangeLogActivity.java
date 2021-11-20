package com.sunilpaulmathew.debloater.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;
import com.sunilpaulmathew.debloater.BuildConfig;
import com.sunilpaulmathew.debloater.R;
import com.sunilpaulmathew.debloater.utils.Utils;

import in.sunilpaulmathew.sCommon.Utils.sJSONUtils;
import in.sunilpaulmathew.sCommon.Utils.sUtils;

/*
 * Created by sunilpaulmathew <sunil.kde@gmail.com> on December 28, 2020
 */

public class ChangeLogActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changelog);

        MaterialTextView mChangeLog = findViewById(R.id.change_log);
        MaterialTextView mTitle = findViewById(R.id.app_title);
        MaterialTextView mCancel = findViewById(R.id.cancel_button);
        mTitle.setText(getString(R.string.app_name) + (Utils.isPlayStoreAvailable(this) ? " Pro " : " ") + BuildConfig.VERSION_NAME);
        mChangeLog.setText(sJSONUtils.getString(sJSONUtils.getJSONObject(sUtils.readAssetFile(
                "release.json", this)), "fullReleaseNotes"));
        mCancel.setOnClickListener(v -> finish());
    }

}