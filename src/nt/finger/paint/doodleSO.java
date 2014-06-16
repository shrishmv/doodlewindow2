package nt.finger.paint;

import java.util.ArrayList;
import java.util.List;

//import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import nt.finger.paint.R;
import android.ittiam.standout.StandOutWindow;
import android.ittiam.standout.StandOutWindow.LayoutParams;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
//import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
//import android.ittiam.standout.StandOutWindow.LayoutParams;
//import android.ittiam.standout.StandOutWindow.StandOutFlags;
//import android.ittiam.standout.StandOutWindow.Window;
//import android.ittiam.standout.StandOutWindow;

public class doodleSO extends StandOutWindow {

	public final static String TAG = "doodleStandOut";
	static SurfaceView selfViewSurface = null;
	static RelativeLayout rLayout;
	static View selfViewframeLayout;

	
	@Override
	protected String getAppName() {
		return "doodleStandOut";
	}
	
	@Override
	protected int getAppIcon() {
		return android.R.drawable.ic_menu_close_clear_cancel;
	}
	
	@Override
	protected void createAndAttachView(int id, FrameLayout frame) {
		Log.d(doodleSO.TAG, "createAndAttachView");
		LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		 
		if(null != selfViewSurface) {
			frame.addView(selfViewSurface);
			Log.d(doodleSO.TAG, "Added Self View to rlayout");
		}
	}

	@Override
	protected LayoutParams getParams(int id, Window window) {
		// TODO Auto-generated method stub
		return new LayoutParams(id, 250, 300, LayoutParams.CENTER,
				LayoutParams.CENTER);
	}
	
	@Override
	protected Intent getPersistentNotificationIntent(int id) {
		return StandOutWindow.getCloseIntent(this, doodleSO.class, id);
	}
	
	public static void passSurface(SurfaceView passedSurface)
	{
		Log.d(doodleSO.TAG, " Passed drawView Surface ");
			selfViewSurface = passedSurface;	
	}


	public static void resetSurface()
	{
		Log.d(doodleSO.TAG, "Resetting drawView Surface");
		rLayout.removeView(selfViewSurface);
		Log.d(doodleSO.TAG, "Removing drawView from rlayout");
		selfViewSurface = null;
		
	}

	public static void addBorder() {

		Log.d(TAG, " Setting Border");
		selfViewframeLayout.setBackgroundResource(R.drawable.border);
	}	
	
	// move the window by dragging the view
	@Override
	public int getFlags(int id) {
		/*
		return super.getFlags(id) | StandOutFlags.FLAG_BODY_MOVE_ENABLE
				| StandOutFlags.FLAG_WINDOW_FOCUSABLE_DISABLE;
		*/		
		
		return StandOutFlags.FLAG_DECORATION_SYSTEM
				| StandOutFlags.FLAG_BODY_MOVE_ENABLE
				| StandOutFlags.FLAG_WINDOW_HIDE_ENABLE
				| StandOutFlags.FLAG_WINDOW_BRING_TO_FRONT_ON_TAP
				| StandOutFlags.FLAG_WINDOW_EDGE_LIMITS_ENABLE
				| StandOutFlags.FLAG_WINDOW_PINCH_RESIZE_ENABLE;
			
	}
}