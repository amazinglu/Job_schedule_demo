package com.example.amazinglu.job_scheduler_demo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

/**
 * the job the job scheduler is going to do
 * */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class TestJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        /**
         * the actual things we need to do
         * */
        Toast.makeText(getApplicationContext(), "doing some thing", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }


}
