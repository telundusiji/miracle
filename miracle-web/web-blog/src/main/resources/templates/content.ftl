<#assign contextPath=request.contextPath />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
<head>
    <title>Miracle</title>
    <script type="application/javascript" src="${contextPath}/static/js/vue.js"></script>
    <script type="application/javascript" src="${contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script type="application/javascript" src="${contextPath}/static/showdown-1.9.0/dist/showdown.js"></script>
</head>
<body>
<h1>Miracle<span style="font-size: small;margin-left: 20px;">hope for a miracle</span></h1>
<hr></pre>
<ul>
    <li><a href="#">所有文章</a></li>
    <li><a href="#">分类</a></li>
    <li><a href="#">炫彩版</a></li>
</ul>
<hr></pre>
<div id="article">
<h2>{{article.name}}</h2>


<pre><a href="?C=M;O=A">{{article.createTime}}</a>      <a href="?C=S;O=A">{{article.category}}</a>      <a href="?C=D;O=A">{{article.tags}}</a>
    <hr>
    <span v-html="article.html"></span>

<hr></pre>
</div>

<p>这是一个简易版的Miracle，如需访问更多内容请转到  <a
        href="http://archive.apache.org/dist/">Miracle炫彩版</a>.</p>

<p>COPYRIGHT © 2019 - 特轮渡司机 | ALL RIGHTS RESERVED | 备案号：陕ICP备17020172号</p>
<p><a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="知识共享许可协议" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/80x15.png" /></a>本作品采用<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">知识共享署名-相同方式共享 4.0 国际许可协议</a>进行许可。</p>
</body>
<script type="application/javascript">
    var app = new Vue({
        el: '#article',
        data: {
            article: {}
        }

    })

    $(function () {
        loadData();
        
    })
    function loadData() {
        $.ajax({
            type: 'get',
            url: 'http://127.0.0.1:8080/blog/article/'+getQueryString("articleKey"),
            dataType: 'JSON',
            contentType: 'application/json',
            success: function (data) {
                //alert(data[0])
                var converter = new showdown.Converter();
                data.html=converter.makeHtml(data.content);
                app.article=data;
            },
            error: function (data) {
                //alert("failed")
            }
        })
    }


    function getQueryString(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }
</script>


</html>
