# AnimationCheckBox

*有点击动画的CheckBox*

*初始设置有两个动画，旋转和放大，可以通过xml配置或java自定义动画*

*适合收藏和点击弹出下拉窗口*

![Screencapture GIF](http://file.baixing.net/201509/a103bcc04c4e2a257fbd3b18ecbd784d.gif)

-----------
## 配置指南  

*只要加入AnimationCheckBox类，并在attr.xml里加入如下说明*
```
<attr name="animation_type">
        <enum name="scale" value="2"></enum>
        <enum name="rotation" value="1"></enum>
    </attr>
    <declare-styleable name="AnimationCheckBox">
        <attr name="duration" format="integer"></attr>
        <attr name="animation_check" format="reference"></attr>
        <attr name="animation_uncheck" format="reference"></attr>
        <attr name="scale_size" format="float"></attr>
        <attr name="animation_type"></attr>>
    </declare-styleable>
    
```

--------

## 使用指南


- 旋转动画配置

*animation_type为rotation,可设置动画时长*
```
<bxapp.baixing.com.bxwidget.AnimationCheckBox
        android:id="@+id/arrow_down"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:duration="500"
        android:layout_marginRight="180dp"
        app:animation_type="rotation"
        android:layout_gravity="center"
        android:button="@drawable/arrow_checkbox"
        />

```

- 放大动画配置

*animation_type为scale,可设置动画时长,放大或缩小的系数*
```
<bxapp.baixing.com.bxwidget.AnimationCheckBox
        android:id="@+id/scale"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="20dp"
        app:scale_size="1.2"
        app:duration="800"
        android:layout_marginLeft="30dp"
        app:animation_type="scale"
        android:layout_gravity="center"
        android:button="@drawable/heart_check_selector"
        />

```

- 自定义动画xml配置

*animation_check为check动作的动画*
*animation_uncheck为uncheck动作的动画*
```
<bxapp.baixing.com.bxwidget.AnimationCheckBox
        android:id="@+id/anim"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:checked="true"
        android:padding="20dp"
        android:layout_marginLeft="200dp"
        app:animation_check="@anim/checkbox_anim"
        app:animation_uncheck="@anim/checkbox_anim"
        android:layout_gravity="center"
        android:button="@drawable/heart_check_selector"
        />

```

- 自定义动画java配置

*setAnimationCheck为check动作的动画*
*setAnimationUnCheck为uncheck动作的动画*
```
animationCheckBox.setAnimationCheck(new RotateAnimation(0f,180f, Animation.RELATIVE_TO_SELF,
    			0.5f,Animation.RELATIVE_TO_SELF,0.5f));

