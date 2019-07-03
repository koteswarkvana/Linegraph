/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package io.cordova.hellocordova;

import android.os.Bundle;
import android.util.Log;

import org.apache.cordova.*;

public class MainActivity extends CordovaActivity
{

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: >>> ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: >>> ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: >>> ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: >>> ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: >>> ");
        // By calling the below line we are restarting the loadUrl once again.
        // loadUrl(launchUrl);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: called >> " );
        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
            Log.e(TAG, "moveTaskToBack: called >> " );
        }

        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
        Log.e(TAG, "loadUrl: called >> " );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: >>> ");
    }

}
