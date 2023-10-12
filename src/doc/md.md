前言
本文是基于有道云笔记md文档编写和测试，如有部分不兼容现象，请在有道云笔记进行测试。

1. 标题
   Markdown 标题有两种格式

1.1 使用 = 和 - 标记一级和二级标题

一级标题
===
二级标题
---
1.2 使用#号标记

# 这是一级标题
## 这是二级标题
### 这是三级标题
#### 这是四级标题
##### 这是五级标题
###### 这是六级标题
2 段落格式  
2.1 段落

Markdown 段落的几种形式    
2.1.1 末尾添加两个空格  
2.1.2 使用空行换行 

2.1.3 使用四个空格 

    使用四个空格

2.1.4 使用```的段落(也叫代码块)
```
echo "hello world";
```
2.2 字体

星号与下划线都可以，单是斜体，双是粗体，符号可跨行

斜体 *斜体*
斜体 _斜体_
粗体 **粗体**
粗体 __粗体__
斜体加粗 ***斜体加粗***
斜体加粗 ___斜体加粗___

*这是一个跨行的  
斜体语句*

2.3 分割线

三个或更多-_*，必须单独一行，可含空格

- - -
___
***
2.4 删除线

删除线 ~~删除线~~  
2.5 下划线

带下划线文本 <u>带下划线文本</u>  
2.6 脚注

上标：X<sup>2</sup>，下标：O<sub>2</sub>  

3 列表  
3.1 无序列表

语法：无序列表用 - + * 任何一种都可以

- git
+ svn
* jenkis

注意：- + * 跟内容之间都要有一个空格

3.2 有序列表

语法：数字加点

1. linux
2. mac
3. win

注意：序号跟内容之间要有空格；

3.3 嵌套列表

列表嵌套上一级和下一级之前敲三个空格；

示例1：

1. go
    - gin
    - iris
    - echo
    - beego
2. python
    - django
3. php
    - laravel
    - lumen
    - hyperf
    - thinkphp

- db
    - es
    - redis
    - mysql
    - clickhouse
- script luanguage
    1. shell
    2. lua
- linux
    - docker
    - k8s
- nginx

3.4 checkbox列表

- [x] huawei
- [x] xiaomi
- [x] apple
    - [ ] iphone
    - [x] ipad
- [ ] vivo
- [ ] oppo
4 引用

4.1 引用是在段落开头使用 > 符号 ，然后后面紧跟一个空格符号
<blockquote>121212
<blockquote>121212</blockquote>
</blockquote>

> 引用1  
>> 翻译成html就是<blockquote>121212</blockquote>
> 引用2
>> 注意：后面用两个空格来换行

> 这是一段引用
>> 这是一段引用 
>>> 这是一段引用

4.2 引用与列表的嵌套

这是> * 的引用1，空间有个空格
> * 空间有个空格
> * > * 空间有个空格

5 图片
   语法：

![图片alt](图片地址 "图片title")

> 图片alt就是显示在图片下面的文字，相当于对图片内容的解释。
> 图片title是图片的标题，当鼠标移到图片上时显示的内容。title可加可不加

示例:

Markdown 还没有办法指定图片的高度与宽度，如果你需要的话，你可以使用普通的 <img> 标签

<img src="https://img1.baidu.com/it/u=567960093,2203968979&fm=253&fmt=auto&app=138&f=PNG?w=608&h=500" width="90%"/>


6 超链接

6.1 基本用法

    [超链接名](超链接地址 "超链接title")
    or
    <链接地址>

[mailto:glsn@gmail.com](mailto:glsn@gmail.com "链接地址")

<mailto:glsn@gmail.com>

title可加可不加
示例:

6.2 引用用法

    这个链接用 1 作为网址变量 [google][1]  
    这个链接用 2 作为网址变量 [baidu][2]  
    然后在文档的结尾为变量赋值
    
    [1]: http://www.google.com/
    [2]: http://www.baidu.com/

这个链接用 1 作为网址变量 [google][1]  
这个链接用 2 作为网址变量 [baidu][2]  
然后在文档的结尾为变量赋值

[1]: http://www.google.com/
[2]: http://www.baidu.com/

6.3 锚点用法
```
- [10. 流程图](#10-流程图)
- [12. 公式](#11-公式)
注意：-是空格，没有空格就不用-，英文首字母要小写。
```

- [10. 流程图](#10-流程图)
- [12. 公式](#11-公式)

7 表格

| 机型 |  存储   |    价格 |
| ---- |:-----:|-----:|
| ipadpro 2020 | 128GB |  6229 |
| ipadpro 2020 | 256GB |  7029 |
| ipadpro 2020 | 512GB |  8629 |
| ipadpro 2020 |  1TB  | 10229 |

第二行分割表头和内容

文字默认居左
两边加：表示文字居中
右边加：表示文字居右
注：原生的语法两边都要用 | 包起来，这样兼容性会好一些，不包起来也行

| header 1 | header 3 |
| -------- | -------- |
| cell 1   | cell 2   |
| cell 3   | cell 4   |
| cell 5   | cell 6   |

8 代码
   单行代码：代码之间分别用一个反引号包起来

`代码内容`

```go
package main

import (
    "fmt"
)

func main() {
    fmt.Println("Hello Markdown!")
}
```
```js
const a = 1;
```
```java
package java.lang.annotation;
```

```html
<div>
    <textarea/>
</div>
<script !src=""></script>
```
注意：如果在 ```后面跟随语言名称，可以语法高亮
注意：上面的 ```是怎么打出来的？外面包4个反引号即可；同理类推，可以包5个

9 HTML相关

9.1 支持的 HTML 元素

    不在 Markdown 涵盖范围之内的标签，都可以直接在文档里面用 HTML 撰写。
    目前支持的 HTML 元素有：<kbd> <b> <i> <em> <sup> <sub> <br>等 ，如：
    使用 Ctrl+Alt+Del 重启电脑

9.2 转义

    Markdown中的转义字符为\，转义的有：
    \\ 反斜杠
    \` 反引号
    \* 星号
    \_ 下划线
    \{\} 大括号
    \[\] 中括号
    \(\) 小括号
    \# 井号
    \+ 加号
    \- 减号
    \. 英文句号
    \! 感叹号
9.3 缩写(同HTML的abbr标签)

即更长的单词或短语的缩写形式，前提是开启识别HTML标签时，已默认开启

The <abbr title="Hyper Text Markup Language">HTML</abbr> specification is maintained by the <abbr title="World Wide Web Consortium">W3C</abbr>.

    输入： The <abbr title="Hyper Text Markup Language">HTML</abbr> specification is maintained by the <abbr title="World Wide Web Consortium">W3C</abbr>.
    结果：The HTML specification is maintained by the W3C.

9.4 特殊符号 HTML Entities Codes

    输入：
    &copy; & &uml; &trade; &iexcl; &pound;  
    &amp; &lt; &gt; &yen; &euro; &reg; &plusmn;  
    &para; &sect; &brvbar; &macr; &laquo; &middot;
    X&sup2; Y&sup3; &frac34; &frac14; &times; &divide; &raquo;
    
    结果：
    © & ¨ ™ ¡ £
    & < > ¥ € ® ±
    ¶ § ¦ ¯ « ·
    X² Y³ ¾ ¼ × ÷ »
    18ºC " ' © & ¨ ™ ¡ £ & < > ¥ € ® ± ¶ § ¦ ¯ « ·
    X² Y³ ¾ ¼ × ÷ »

&copy; & &uml; &trade; &iexcl; &pound;  
&amp; &lt; &gt; &yen; &euro; &reg; &plusmn;  
&para; &sect; &brvbar; &macr; &laquo; &middot;
X&sup2; Y&sup3; &frac34; &frac14; &times; &divide; &raquo;
18&ordm;C &quot; &apos;

10 流程图
    每个编辑器可能最终呈现会不一样，这里是用的有道云笔记;

流程图
```
graph LR
A-->B
```
graph LR
A-->B
序列图
```
sequenceDiagram
A->>B: How are you?
B->>A: Great!
```
sequenceDiagram
A->>B: How are you?
B->>A: Great!
甘特图
```
gantt
dateFormat YYYY-MM-DD
section S1
T1: 2014-01-01, 9d
section S2
T2: 2014-01-11, 9d
section S3
T3: 2014-01-02, 9d
```
gantt
dateFormat YYYY-MM-DD
section S1
T1: 2014-01-01, 9d
section S2
T2: 2014-01-11, 9d
section S3
T3: 2014-01-02, 9d
11 公式
```math
E = mc^2
```

```math
\displaystyle
\left( \sum\_{k=1}^n a\_k b\_k \right)^2
\leq
\left( \sum\_{k=1}^n a\_k^2 \right)
\left( \sum\_{k=1}^n b\_k^2 \right)
```

注意：不同的平台可能表现不一样，这里是有道云笔记展示
E = mc^2  
\displaystyle  
\left( \sum\_{k=1}^n a\_k b\_k \right)^2  
\leq  
\left( \sum\_{k=1}^n a\_k^2 \right)   
\left( \sum\_{k=1}^n b\_k^2 \right)  

12. Test anchor


