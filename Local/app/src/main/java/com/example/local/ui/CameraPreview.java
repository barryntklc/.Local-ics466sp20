package com.example.local.ui;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;

//public class CameraPreview extends ViewGroup implements SurfaceHolder.Callback {
//    SurfaceView surfaceView;
//    SurfaceHolder holder;
//
//    CameraPreview(Context context) {
//        super(context);
//
//        surfaceView = new SurfaceView(context);
//        addView(surfaceView);
//
//        // Install a SurfaceHolder.Callback so we get notified when the
//        // underlying surface is created and destroyed.
//        holder = surfaceView.getHolder();
//        holder.addCallback(this);
//        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//
//    }
//
//
//    @Override
//    public void surfaceCreated(SurfaceHolder holder) {
//
//    }
//
//    @Override
//    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
//        // Now that the size is known, set up the camera parameters and begin
//        // the preview.
//        Camera.Parameters parameters = mCamera.getParameters();
//        parameters.setPreviewSize(previewSize.width, previewSize.height);
//        requestLayout();
//        mCamera.setParameters(parameters);
//
//        // Important: Call startPreview() to start updating the preview surface.
//        // Preview must be started before you can take a picture.
//        mCamera.startPreview();
//    }
//
//    @Override
//    public void surfaceDestroyed(SurfaceHolder holder) {
//        // Surface will be destroyed when we return, so stop the preview.
//        if (mCamera != null) {
//            // Call stopPreview() to stop updating the preview surface.
//            mCamera.stopPreview();
//        }
//    }
//}
