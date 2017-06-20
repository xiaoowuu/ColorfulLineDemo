> 对于一个常年混迹于UC的屌丝，我可谓得到了UC震惊部的真传，所以今天标题标题显得有些夸张，大家娱乐娱乐即可。

#### 进入正题
虚线，想必在不少APP中都有用到。最近项目中正好也有这样的设计，所以就诞生了今天我要分享给大家的这个自定义View，我将它命名为ColorfulLine（多彩线条），之所以多彩，是因为它不仅仅能实现常规印象中的灰色虚线，也可以实现更多彩的其他效果，具体见效果图。
#### 效果图
![ColorfulLine](http://upload-images.jianshu.io/upload_images/1951791-df4abcf0f4a91a84.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
#### 使用方法
从效果图中的xml代码片段可以看出，使用起来也是很简单的，只需要设置`colors,colorSizes,colorSizeUnit,direction`这几个属性就可以了，下面对这些属性做一说明:

|属性|含义|值|
|:-:|:-:|:-:|
|colors|颜色数组，用逗号分隔的16进制RGB颜色值|"#ffffff,#00ff00"|
|colorSizes|colors对应的颜色绘制长度，数组大小应和colors相同|"16,16"|
|colorSizeUnit|colorSizes的单位|dp/px|
|direction|方向|vertical纵向/horizontal横向|

#### 源码（觉得对你有用就star一下吧）
https://github.com/smartown/ColorfulLineDemo