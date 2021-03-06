/*
 * Copyright (C) 2017 StagOS Project
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
package com.stag.settings.fragments;
 import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
 import com.android.settings.R;
 import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
 public class Maintainers extends Fragment {
     private static final String MAINTAINERS_PATH = "/system/etc/Maintainers.txt";
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        InputStreamReader inputReader = null;
        String text = null;
 	setHasOptionsMenu(true);
         try {
            StringBuilder data = new StringBuilder();
            char tmp[] = new char[2048];
            int numRead;
             inputReader = new FileReader(MAINTAINERS_PATH);
            while ((numRead = inputReader.read(tmp)) >= 0) {
                data.append(tmp, 0, numRead);
            }
            text = data.toString();
        } catch (IOException e) {
            text = getString(R.string.maintainers_stag_error);
        } finally {
            try {
                if (inputReader != null) {
                    inputReader.close();
                }
            } catch (IOException e) {
            }
        }
         final TextView textView = new TextView(getActivity());
        textView.setText(text);
         final ScrollView scrollView = new ScrollView(getActivity());
        scrollView.addView(textView);
         return scrollView;
    }
 	@Override
       public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
           getActivity().onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
 }
