package com.activitytracker;

import com.activitytracker.model.Acceleration;
import com.activitytracker.model.Result;
import com.activitytracker.model.TrainingAcceleration;
import android.support.v7.util.SortedList.Callback;

import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
public interface CassandraRestApi {

        @Headers("Content-Type: application/json")
        @POST("/acceleration")


        public Response sendAccelerationValues(@Body Callback<Acceleration> accelerationCallback );


        @POST("/training")
        public Response sendTrainingAccelerationValues(@Body TrainingAcceleration trainingAcceleration,Callback<Response> callback);

        @POST("/training/result")
        public  Response sendpredictionValues(@Body Result predict);


}
