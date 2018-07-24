package com.example.amazinglu.job_scheduler_demo;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class Util {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void scheduleJob(Context context) {
        ComponentName serviceComponent = new ComponentName(context, TestJobService.class);
        JobInfo.Builder builder = new JobInfo.Builder(0, serviceComponent);

        /**
         * when the job will be activated
         * */
        builder.setMinimumLatency(1 * 1000);
        builder.setOverrideDeadline(3 * 1000);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            JobScheduler jobScheduler = context.getSystemService(JobScheduler.class);
            jobScheduler.schedule(builder.build());
        }
    }

}
