package com.example.readmypick;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ru.bartwell.exfilepicker.ExFilePicker;
import ru.bartwell.exfilepicker.data.ExFilePickerResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button browse_files = (Button) findViewById(R.id.browse_files);
        browse_files.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenFileManager();
            }
        });

    }
    public void OpenFileManager(){
        ExFilePicker exFilePicker = new ExFilePicker();
        exFilePicker.setCanChooseOnlyOneItem(true);
        exFilePicker.setShowOnlyExtensions("epub");
        exFilePicker.setQuitButtonEnabled(true);
        exFilePicker.setHideHiddenFilesEnabled(true);
        exFilePicker.setNewFolderButtonDisabled(true);
        exFilePicker.start(this, 1);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            ExFilePickerResult result = ExFilePickerResult.getFromIntent(data);
            if (result != null && result.getCount() > 0) {
                Intent I = new Intent(this,MainActivity.class);
                I.putExtra("epub_location",result.getPath()+result.getNames().get(0));
                startActivity(I);
            }
        }
    }
    @Override
    public void onResume(){
        super.onResume();
    }
}
