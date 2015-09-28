package bxapp.baixing.com.bxwidget;

/**
 * Created by shaoting on 15/9/25.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.CheckBox;

/**
 * Created by shaoting on 15/9/25.
 */
public class AnimationCheckBox extends CheckBox {
	private static final int TYPE_ROTATION = 1;
	private static final int TYPE_SCALE = 2;
	private Animation animationCheck;
	private Animation animationUnCheck;
	private int defaultType=0;
	private float defaultScaleSize=1.2f;
	private int defaultDuration=500;
	private int duration;

	public AnimationCheckBox(Context context) {
		super(context);
	}

	public AnimationCheckBox(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public AnimationCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context, attrs);
	}

	private void init(Context context, AttributeSet attrs) {
		TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.AnimationCheckBox);
		int type=mTypedArray.getInt(R.styleable.AnimationCheckBox_animation_type, defaultType);
		int animitionCheckId=mTypedArray.getResourceId(R.styleable.AnimationCheckBox_animation_check, 0);
		if(animitionCheckId!=0){
			setAnimationUnCheck(AnimationUtils.loadAnimation(context, animitionCheckId));
		}
		int animitionUnCheckId=mTypedArray.getResourceId(R.styleable.AnimationCheckBox_animation_uncheck, 0);
		if(animitionUnCheckId!=0){
			setAnimationUnCheck(AnimationUtils.loadAnimation(context,animitionUnCheckId));
		}
		duration=mTypedArray.getInt(R.styleable.AnimationCheckBox_duration, defaultDuration);
		float scaleSize=mTypedArray.getFloat(R.styleable.AnimationCheckBox_scale_size, defaultScaleSize);
		switch (type){
			case TYPE_ROTATION:
				setDefaultRotateAnimation(duration);
				break;
			case TYPE_SCALE:
				setDefaultScaleAnimation(scaleSize,duration);
				break;
		}
	}


	private void setDefaultScaleAnimation(float scaleSize,int duration) {
		ScaleAnimation enlarge = new ScaleAnimation(1.0f, scaleSize, 1.0f, scaleSize,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		final ScaleAnimation reduce = new ScaleAnimation(scaleSize, 1.0f, scaleSize, 1.0f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		enlarge.setDuration(duration/2);
		reduce.setDuration(duration/2);
		enlarge.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				startAnimation(reduce);
			}

			@Override
			public void onAnimationEnd(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		reduce.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				superSetChecked(!isChecked());
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		animationCheck=enlarge;
		animationUnCheck=enlarge;
	}

	public void setAnimationCheck(Animation animationCheck){
		this.animationCheck=animationCheck;
		animationCheck.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				superSetChecked(true);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
	}

	public void setAnimationUnCheck(Animation animationUnCheck){
		this.animationUnCheck=animationUnCheck;
		animationUnCheck.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				superSetChecked(false);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
	}

	private void setDefaultRotateAnimation(int duration){

		animationCheck =new RotateAnimation(0f,180f, Animation.RELATIVE_TO_SELF,
				0.5f,Animation.RELATIVE_TO_SELF,0.5f);
		animationCheck.setDuration(duration);
		animationCheck.setFillAfter(false);
		animationCheck.setFillEnabled(true);
		animationCheck.setFillBefore(false);
		animationUnCheck =new RotateAnimation(0f,180f, Animation.RELATIVE_TO_SELF,
				0.5f,Animation.RELATIVE_TO_SELF,0.5f);
		animationUnCheck.setDuration(duration);
		animationUnCheck.setFillBefore(false);
		animationUnCheck.setFillEnabled(true);
		animationUnCheck.setFillAfter(false);
		setAnimationCheck(animationCheck);
		setAnimationUnCheck(animationUnCheck);
	}

	@Override
	public void setChecked(final boolean checked){
		if(checked==isChecked()){
			return;
		}
		if(checked){
			if(animationCheck !=null){
				showCheckAnimation();
			}
			else{
				superSetChecked(checked);
			}
		}else {
			if(animationUnCheck != null)
				showUnCheckAnimation();
			else{
				superSetChecked(checked);
			}
		}
	}
	
	public void superSetChecked(boolean checked){
		super.setChecked(checked);
	}

	private void showUnCheckAnimation() {
		this.startAnimation(animationUnCheck);
	}

	private void showCheckAnimation() {
		this.startAnimation(animationCheck);
	}

	;
}
