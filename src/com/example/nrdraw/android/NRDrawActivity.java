package com.example.nrdraw.android;

import com.example.nrdraw.R;
import com.example.nrdraw.android.view.DrawView;
import com.example.nrdraw.model.Drawing;
import com.example.nrdraw.model.Line;
import com.example.nrdraw.model.Point;

import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class NRDrawActivity extends Activity {
	
	private class ClickBehaviour implements OnClickListener{
		@Override
		public void onClick(View v) {
			if(v == btSave){
				System.out.println("Save");
			}
			else if(v == btLoad){
				System.out.println("Load");
			}
			else if(v == btClear){
				drawing = new Drawing();
				drawView.setDraw(drawing);
				drawView.invalidate();
			}
		}
	}
	
	private class TouchBehaviour implements OnTouchListener{
		private Line l;
		
		private void createLine(Point p){
			drawing.add(l = new Line(p));
		}
		
		private void clearLine(){
			l = null;
		}
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					createLine(new Point(event.getX(0), event.getY(0)));
					drawView.invalidate();
					break;
				case MotionEvent.ACTION_MOVE:
					/**
					 * We choose to crate a new line when finger moves out of 
					 * drawView, and continue draw lines when finger moves in
					 */
					if(event.getX(0) < 0 || event.getY(0) < 0){
						clearLine();
					}
					else{
						if(l == null){
							createLine(new Point(event.getX(0), event.getY(0)));
						}
						else{
							l.add(new Point(event.getX(0), event.getY(0)));
						}
						drawView.invalidate();
					}
					break;
				default:
					break;
			}
			return true;
		}
	}
	
	private Button btSave, btLoad, btClear;
	private DrawView drawView;
	private ClickBehaviour clickBehaviour;
	private Drawing drawing;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nrdraw);
		
		clickBehaviour = new ClickBehaviour();
		drawing = new Drawing();
		
		btSave = (Button)findViewById(R.id.btSave);
		btSave.setOnClickListener(clickBehaviour);
		
		btLoad = (Button)findViewById(R.id.btLoad);
		btLoad.setOnClickListener(clickBehaviour);
		
		btClear = (Button)findViewById(R.id.btClear);
		btClear.setOnClickListener(clickBehaviour);
		
		drawView = (DrawView)findViewById(R.id.drawView);
		drawView.setDraw(drawing);
		drawView.setOnTouchListener(new TouchBehaviour());
	}
	
}
