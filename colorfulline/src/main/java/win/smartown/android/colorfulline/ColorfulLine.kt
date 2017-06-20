package win.smartown.android.colorfulline

import android.annotation.TargetApi
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.View

/**
 * Created by smartown on 2017/6/20 15:14.
 * Description:
 */
class ColorfulLine : View {

    var colors: List<Int> = listOf()
    var colorSizes: List<Int> = listOf()
    /**
     * 1:--- 2:|
     */
    var direction: Int = 1
    val paint: Paint by lazy { Paint() }

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        if (attrs != null) {
            val typedArray: TypedArray = resources.obtainAttributes(attrs, R.styleable.ColorfulLine)
            val colorsString = typedArray.getString(R.styleable.ColorfulLine_colors)
            colors = colorsString.split(",").map { Color.parseColor(it) }
            //1:px 2:dp
            val colorSizeUnit = typedArray.getInt(R.styleable.ColorfulLine_colorSizeUnit, 1)
            val colorSizesString = typedArray.getString(R.styleable.ColorfulLine_colorSizes)
            colorSizes = colorSizesString.split(",").map {
                when (colorSizeUnit) {
                    2 -> dp2px(it.toInt())
                    else -> it.toInt()
                }
            }
            direction = typedArray.getInt(R.styleable.ColorfulLine_direction, 1)
            typedArray.recycle()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var drawnSize = 0
        when (direction) {
            1 -> {
                while (drawnSize < width) {
                    for ((index, color) in colors.withIndex()) {
                        paint.color = color
                        canvas?.drawRect(drawnSize.toFloat(), 0F, (drawnSize + colorSizes[index]).toFloat(), height.toFloat(), paint)
                        drawnSize += colorSizes[index]
                    }
                }
            }
            2 -> {
                while (drawnSize < height) {
                    for ((index, color) in colors.withIndex()) {
                        paint.color = color
                        canvas?.drawRect(0F, drawnSize.toFloat(), width.toFloat(), (drawnSize + colorSizes[index]).toFloat(), paint)
                        drawnSize += colorSizes[index]
                    }
                }
            }
        }
    }

    private fun dp2px(dpSize: Int): Int {
        return (resources.displayMetrics.density * dpSize).toInt()
    }

}
