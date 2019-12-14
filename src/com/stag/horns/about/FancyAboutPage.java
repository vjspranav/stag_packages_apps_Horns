/*
 * Copyright (C) 2018 StagOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stag.horns.about;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.stag.horns.R;
import com.stag.horns.about.DiagonalView;

import com.android.settings.R;

public class FancyAboutPage extends RelativeLayout {
    private TextView l1,l2,phenomname,vjsname,pritishname,rakeshname,abhimanyuname,vinothname,debjitname,phenomdescription,vjsdescription,pritishdescription,rakeshdescription,abhimanyudescription,vinothdescription,debjitdescription;
    DiagonalView diagonalView;
    CircularImageView phenom,vjs,pritish,rakesh,abhimanyu,vinoth,debjit;
    ImageView gg,tl,tw,git;
    String twitterurl,ggurl,tlurl,githuburl;
    private void init(Context context) {
        //do stuff that was in your original constructor...
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        inflater.inflate(R.layout.activity_fancy_about_page, this, true);
        l1= findViewById(R.id.name);
        l2= findViewById(R.id.description);
        phenomname= findViewById(R.id.phenomname);
        vjsname= findViewById(R.id.vjsname);
        pritishname= findViewById(R.id.pritishname);
        rakeshname= findViewById(R.id.shekhawatname);
        abhimanyuname= findViewById(R.id.abhimanyuname);
        vinothname= findViewById(R.id.vinothname);
        debjitname= findViewById(R.id.debjitname);
        phenomdescription= findViewById(R.id.phenomdescription);
        vjsdescription= findViewById(R.id.vjsdescription);
        pritishdescription= findViewById(R.id.pritishdescription);
        rakeshdescription= findViewById(R.id.shekhawatdescription);
        abhimanyudescription= findViewById(R.id.abhimanyudescription);
        vinothdescription= findViewById(R.id.vinothdescription);
        debjitdescription= findViewById(R.id.debjitdescription);
        phenom= findViewById(R.id.phenom);
        vjs= findViewById(R.id.vjs);
        pritish= findViewById(R.id.pritish);
        rakesh= findViewById(R.id.shekhawat);
        abhimanyu = findViewById(R.id.abhimanyu);
        vinoth= findViewById(R.id.vinoth);
        debjit = findViewById(R.id.debjit);
        tw= findViewById(R.id.twitter);
        gg= findViewById(R.id.google);
        tl= findViewById(R.id.telegram);
        git= findViewById(R.id.github);
        diagonalView = findViewById(R.id.background);
    }
    public FancyAboutPage(Context context) {
        super(context);
        init(context);
    }
    public FancyAboutPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    public FancyAboutPage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs,defStyle);
        init(context);
    }
    public void setName(String name){
       l1.setText(name);
    }
    public void setDescription(String description){
       l2.setText(description);
    }
    public void setCoverTintColor(int color){
        diagonalView.setTintColor(color);
    }
    public void setCover(int drawable){
        diagonalView.setImageResource(drawable);
    }

    public void addTwitterLink(String twitterAddress){
        tw.setVisibility(VISIBLE);
        twitterurl=twitterAddress;
        tw.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!twitterurl.startsWith("http://") && !twitterurl.startsWith("https://"))
                    twitterurl = "http://" + twitterurl;
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterurl));
                getContext().startActivity(browserIntent);
            }
        });
    }
    public void addGoogleLink(String googleAddress){
        gg.setVisibility(VISIBLE);
        ggurl=googleAddress;
        gg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ggurl.startsWith("http://") && !ggurl.startsWith("https://")) {
                    ggurl = "http://" + ggurl;
                }
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ggurl));
                getContext().startActivity(browserIntent);
            }
        });

    }
    public void addTelegramLink(String telegramAddress){
        tl.setVisibility(VISIBLE);
        tlurl=telegramAddress;
        tl.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tlurl.startsWith("http://") && !tlurl.startsWith("https://")) {
                    tlurl = "http://" + tlurl;
                }
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tlurl));
                getContext().startActivity(browserIntent);
            }
        });

    }
    public void addGitHubLink(String githubAddress){
        git.setVisibility(VISIBLE);
        githuburl=githubAddress;
        git.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!githuburl.startsWith("http://") && !githuburl.startsWith("https://"))
                    githuburl = "http://" + githuburl;
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(githuburl));
                getContext().startActivity(browserIntent);
            }
        });

    }
    public void setAppIcon(int Icon){
       phenom.setImageResource(Icon);
       vjs.setImageResource(Icon);
       pritish.setImageResource(Icon);
       rakesh.setImageResource(Icon);
       abhimanyu.setImageResource(Icon);
       vinoth.setImageResource(Icon);
       debjit.setImageResource(Icon);
    }
    public void setAppName(String AppName){
       phenomname.setText(AppName);
       vjsname.setText(AppName);
       pritishname.setText(AppName);
       rakeshname.setText(AppName);
       abhimanyuname.setText(AppName);
       vinothname.setText(AppName);
       debjitname.setText(AppName);
    }
    public void setAppDescription(String AppDescription){
        phenomdescription.setText(AppDescription);
        vjsdescription.setText(AppDescription);
        pritishdescription.setText(AppDescription);
        rakeshdescription.setText(AppDescription);
        abhimanyudescription.setText(AppDescription);
        vinothdescription.setText(AppDescription);
        debjitdescription.setText(AppDescription);
    }

}