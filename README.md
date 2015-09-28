# AnimationCheckBox

*有点击动画的CheckBox,
*初始设置有两个动画，旋转和放大，可以通过xml配置或java自定义动画
适合收藏和点击弹出下拉窗口
![Screencapture GIF](http://file.baixing.net/201509/f8984d692ad89aa5e247029aa817a30e.gif)

## 使用指南

＊旋转动画配置，
＊animation_type为rotation,可设置动画时长
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



