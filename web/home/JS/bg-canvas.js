/**
 * Created by WHY on 2016/12/5.
 */
function bg_canvas() {
    //获取窗口宽高
    var w = 400;
    var h = 608;
    var canvas = document.getElementById("myCanvas");
    var ctx = canvas.getContext("2d");
//设置画布宽高与窗口宽高一样
    canvas.width = w+80;
    canvas.height = h+80;
//随机数函数
    function fnRandom(min,max){
        return parseInt((max-min)*Math.random()+min+1)
    }
    function Round(){
        this.r = fnRandom(5,15);
        //随机位置
        var x = fnRandom(0,canvas.width - this.r);
        this.x = x<this.r?this.r:x;
        var y = fnRandom(0,canvas.height-this.r);
        this.y = y<this.r?this.r:y
        //随机速度
        var speed = fnRandom(2,4)/10;
        this.speedX = fnRandom(0,4)>2?speed:-speed;
        this.speedY = fnRandom(0,4)>2?speed:-speed;
        //颜色
        var col=new Array ("#a7a9ed","#a7c3f3","#cbccf6","#8097ec","#c7b4fd");
        this.color = col[fnRandom(-1,4)];
    }
    Round.prototype.draw = function(){
        //绘制函数
        ctx.fillStyle = this.color;
        ctx.beginPath()
        ctx.arc(this.x,this.y,this.r,0,Math.PI*2,true);
        ctx.closePath();
        ctx.fill();
    }
    Round.prototype.move = function(){
        this.x+=this.speedX;
        if(this.x>canvas.width-this.r){
//				this.speedX*=-1;
            this.x=this.r

        }else if(this.x<this.r){
            this.x=canvas.width-this.r
        }
        this.y+=this.speedY;
        if(this.y>canvas.height-this.r){
//				this.speedY*=-1;
            this.y=this.r
        }else if(this.y<this.r){
            this.y=canvas.height-this.r
        }
    }
//使用Round
    var allRound = [];
    function initRound(){
        //初始化30个圆形对象,放到数组中
       /* var mount =parseInt(window.innerWidth)/35;*/
        for(var i = 0 ; i<15;i++){
            var obj = new Round();
            obj.draw();
            obj.move();
            allRound.push(obj);
        }
    }
    initRound();
    var dxdy = []
    function roundMove(){
        ctx.clearRect(0,0,canvas.width,canvas.height);
        //遍历所有的圆形对象,让对象自己重绘,移动
        for (var i = 0 ;i <allRound.length;i++) {
            var round = allRound[i];
            round.draw();
            round.move();
            dxdy[i]={
                dx:round.x,
                dy:round.y
            };
            var dx = dxdy[i].dx;
            var dy =dxdy[i].dy;
            for (var j=0;j<i;j++) {
                var sx = dxdy[j].dx;
                var sy = dxdy[j].dy;
                l = Math.sqrt((dx-sx)*(dx-sx)+(dy-sy)*(dy-sy));
                var C = 1/l*7-0.009;
                var o = C > 0.03 ? 0.03 : C;
                ctx.strokeStyle = 'rgba(0,0,0,'+ o +')'
                ctx.beginPath()
                ctx.lineWidth=3;
                ctx.moveTo(dxdy[i].dx,dxdy[i].dy)
                ctx.lineTo(dxdy[j].dx,dxdy[j].dy);
                ctx.closePath()
                ctx.stroke()
            }
        }
        window.requestAnimationFrame(roundMove)
    }
    roundMove();
}
$(window).ready(function () {
    bg_canvas();
})
$(window).resize(function () {
    bg_canvas();
})