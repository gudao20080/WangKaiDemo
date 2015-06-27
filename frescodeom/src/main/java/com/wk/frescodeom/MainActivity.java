package com.wk.frescodeom;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

//        Uri uri = Uri.parse("http://frescolib.org/static/fresco-logo.png");
        Uri uri = Uri.parse("http://e.hiphotos.baidu.com/image/pic/item/7dd98d1001e93901fd74263e79ec54e736d196b8.jpg");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setImageURI(uri);
        DraweeController controller = draweeView.getController();
        GenericDraweeHierarchyBuilder builder = GenericDraweeHierarchyBuilder.newInstance(getResources())
                .setProgressBarImage(getResources().getDrawable(R.mipmap.ic_launcher));
        GenericDraweeHierarchy build = builder.build();
        draweeView.setHierarchy(build);

    }
}
