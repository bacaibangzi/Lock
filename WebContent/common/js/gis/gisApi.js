/*
 * 地图实现类 API 作为开发参考用
 */
(function(){
	/**
	 * 工作类 必须一个html容器Id来初始化， 其余参数均可以使用默认值
	 * @param id:html容器
	 * @param latlng:经纬度
	 * @param zoom:层级
	 * @param mapType:类型 保留字段
	 */
	window.FMap = function(id, latlng, zoom, mapType){
		/**
		 * 公有方法， 移动地图到指定的中点
		 * 
		 * @param flatlng:FLatLng 表示位置
		 */
		this.to = function(flatlng){};
		/**
		 * 设置地图到指定的缩放等级
		 * 
		 * @param lvl {int} 指定的缩放等级 
		 */
		this.zoom = function(lvl){};
		
		/**
		 * 公有方法， 将地图移动到若干个点的中点
		 * 
		 * @param flatlngs:FLatLng[] 若干个点
		 * @param needMarker:boolean 是否需要标记点
		 */
		this.display = function(flatlngs, needMarker){
		};

		/**
		 * 添加覆盖点，指定经纬度和html文本，向地图上添加一个标注
		 * 
		 * @param flatlng:FLatLng 指定一个点
		 * @param html:加入信息串口的html内容
		 * @param cfg : 配置对象 
		 * {
		 * path: "http://xx.com/xx.png",
		 * width: 12,
		 * height: 12,
		 * anchorX: 0,
		 * anchorY: 0, 
		 * shadowPath: "",
		 * sWidth: 12,
		 * sHeight: 12,
		 * infoWindowAnchorX: 0,      //注意一下，图吧的地图不支持这个选项，因为提示窗是自动定位的，指定这个参数似乎没有必要
		 * infoWindowAnchorY: 0,
		 * html: 
		 * tok: 
		 * title: 
		 * label:
		 * focus:boolean
		 * } 
		 * @return obj:Object 用来删除该标点的令牌
		 */
		this.mark = function(flatlng, html, cfg, tok, title, label){};
		/**
		 * 获取经纬度坐标点。
		 * @param flatlng
		 * @return 返回格式：latx,lngy，如"31.9758,118.75105" 江苏省南京市雨花台区
		 */
        this.getLatlng = function(latlng){};
		/**
		 * 在指定点上打开一个信息窗口。
		 * @param flatlng
		 * @param html
		 */
		this.openInfoWindow = function(flatlng, html){};
		
		/**
		 * 删除指定的标点
		 * 
		 * @param obj:Object mark方法的返回值
		 */
		this.removeMark = function(obj){};
		
		/**
		 * 移动指定的标记到新的坐标上
		 * 
		 * @param obj mark方法的返回值
		 * @param flatlng 新的坐标
		 * @return
		 */
		this.moveMark   = function(obj, flatlng){};
		
		/**
		 * 返回当前地图显示的四个边角的坐标数组，顺序是从西北顺时针旋转。
		 * @return
		 */
		this.getBounds = function(){};

		/**
		 * 清空地图上的叠加层，包括了添加的所有的标注，绘制的线等。
		 */
		this.clearOverlays = function(){};
		/**
		 * 根据传入的坐标点，绘制一条折线，指定颜色的字符串格式是 #FFFFF 这种。
		 * 
		 * @param flatlngs:FLatLng[] 折线的数组
		 * @param rgbstr:string CSS颜色字符串
		 * @param opacity: number (0-1) 1表示完全不透明
		 * @param weight:  number 表示线的粗细。
		 * @param cfg：地图间的兼容性
		 * @return obj 一个令牌，用来支持后续的删除等操作。 
		 */
		this.addLine   = function(flatlngs, rgbstr, opacity, weight, tok,title,content, cfg){};
		
		/**
		 * 延伸指定的折线
		 * 
		 * @param addLine的返回值 
		 * @param flatlng 要延伸至的点
		 * @return
		 */
		this.extendLine = function(obj, flatlng){};
		/**
		 * 延伸指定的折线
		 * 
		 * @param lonlat:原点 
		 * @param width
		 * @param height
		 * @param cfg 多地图兼容
		 * @return
		 */
		this.ellipse = function(lonlat,width,height, cfg){};
		/**
		 * 用来删除addLine添加的线
		 * @param obj addLine调用的返回值
		 * @return
		 */
		this.removeLine = function(obj){}
		
		/**
		 * 公有方法，用来添加地图监听器。
		 * 
		 * @param evn:String 事件名称
		 * @param cb:function(FLatLng) 回调函数，有一个FLatLng描述的
		 * 经纬度作为参数
		 * 
		 * @return 对象，只能用来进行对应的删除监听器操作。
		 */
		this.addListener = function(evn,cb){};
		/**
		 * 公有方法，用来添加一个地图的点击监听器。
		 * 
		 * @param evn:String 事件名称
		 * @param cb:function(FLatLng) 回调函数，有一个FLatLng描述的
		 * 经纬度作为参数
		 * 
		 * @return 对象，只能用来进行对应的删除监听器操作。
		 */
		this.addClickListener = function(cb){};
		/**
		 * 这里的参数就是addClickListener方法的返回值。
		 * 
		 * @param lsnr:Object addClickListener的返回值
		 */
		this.removeListener = function(lsnr){};
		/**
		 * 给指定的标记添加点击监听器.
		 * @param obj mark函数的返回值
		 * @param cb 回调函数，拥有的参数(FLatLng);
		 * @return 用来删除的令牌
		 */
		this.addObjListener = function(obj,evn, cb){};
		
        /**
		 * 给指定的标记去掉监听器.
		 * @param obj mark函数的返回值
		 * @param evn 事件
		 * @param cb 回调函数，拥有的参数(FLatLng);
		 * @return 用来删除的令牌
		 */
        this.removeObjListener = function(obj, evn, cb){};
        /**
		 * 给指定的标记添加鼠标移进事件.
		 * @param obj mark函数的返回值
		 * @param cb 回调函数，拥有的参数(FLatLng);
		 * @return 用来删除的令牌
		 */
 		this.addMarkMouseoverListener = function(obj, cb){};
		/**
		 * 给指定的标记添加鼠标移出事件.
		 * @param obj mark函数的返回值
		 * @param cb 回调函数，拥有的参数(FLatLng);
		 * @return 用来删除的令牌
		 */
		this.addMarkMouseoutListener = function(obj, cb){};
		/**
		 * 搜索某一位置，需要传入一个字符串和一个处理函数
		 * 
		 * @param city:string 目标城市
		 * @param addr:string 搜索关键字
		 * @param cb:function 回调函数，参数待定
		 */
		this.searchPosition   = function(city, addr, cb){};
		
		/**
		 * 加入地图的默认控件。
		 * @return
		 */
		this.setToDefaultUI = function(){};
		/**
		 * 向地图上添加鹰眼控件
		 * @return
		 */
		this.addOverview      = function(){};
		/**
		 * 删除地图上的鹰眼控件
		 * @return
		 */
		this.removeOverview   = function(){};
		
		/**
		 * 添加一个鱼骨控件
		 * @return
		 */
		this.addMapControl    = function(){};
		/**
		 * 删除地图上的鱼骨控件
		 * @return
		 */
		this.removeMapControl = function(){};
		
		/**
		 * 添加一个多边形
		 * @param latlngs:FLatLng[] 多边形的各个顶点
		 * @param lineColor:string  CSS颜色字符串，线颜色
		 * @param fillColor:string  CSS颜色字符串，填充区颜色
		 * @return 返回一个令牌以支持对应点的删除操作
		 */
		this.addPolygon = function(latlngs, lineColor, fillColor){};
		
		/**
		 * 延展指定的多边形到指定的点
		 * 
		 * @param obj
		 * @param latlng
		 * @return
		 */
		this.extendPolygon = function(obj, latlng){};
		
		/**
		 * 删除指定的多边形
		 * @param obj addPolygon的返回值
		 * @return 
		 */
		this.removePolygon = function(obj){};
		
		/**
		 * 将地图上指定像素的点转换成经纬度描述的坐标。
		 * @param x:int 指定点的x坐标
		 * @param y:int 指定点的y坐标
		 * @return FLatLng的实例
		 */
		this.pointToLatLng = function(x, y){};
		/**
		 * 用户自定义控件 mapabc支持 其他暂不支持
		 */
		this.addPanel = function(div){};
		/**
		 * 鼠标经过 mapabc支持 其他暂不支持
		 */
		this.mouseDistance = function(){};
        /**
		 * 鼠标移动 mapabc支持 其他暂不支持
		 */
        this.mouseMove = function(){};
        /**
		 * 根据经纬度移动到中心点 mapabc支持 其他暂不支持
		 * @param lon:经度
		 * @param lat:维度
		 */
        this.moveTo = function(lon,lat){};
        /**
		 * 以某一中心点缩放地图 mapabc支持 其他暂不支持
		 * @param zoom:图层
		 * @param lonlat:经纬度
		 */
        this.zoomTo = function(zoom,lonlat){};
        /**
		 *  mapabc支持 其他暂不支持
		 * @param isEnable:图层
		 */
        this.setZoomEnabled = function(isEnable){};
        /**
		 * 获取比例尺 mapabc支持 其他暂不支持
		 * @param isEnable:图层
		 */
        this.getScale = function(){};
        /**
		 * 经纬度转像素坐标 mapabc支持 其他暂不支持
		 * @param lonlat:经纬度
		 */
        this.toPixel = function(lonlat){};
        /**
		 * 像素转经纬度坐标 mapabc支持 其他暂不支持
		 * @param lonlat:像素
		 */
        this.toPoint = function(lonlat){};
        /**
		 * 获取坐标间像素距离 mapabc支持 其他暂不支持
		 * @param lonlat1:
		 * @param lonlat2:
		 */
        this.getZoomPixel = function(lonlat1,lonlat2){};
        /**
		 * 逆地址解析 mapabc支持 其他暂不支持
		 * @param lonlat:
		 * @param callback:
		 */
        this.getAddress = function(lonlat,callback){};
        /**
		 * 添加覆盖物对象 mapabc支持 其他暂不支持
		 * @param overlay:
		 */
        this.over = function(overlay){};
        /**
		 * 根据覆盖物的ID删除覆盖物 mapabc支持 其他暂不支持
		 * @param id:覆盖物的ID
		 */
        this.remove = function(id){};
        /**
		 * 清除地图上所有覆盖物 mapabc支持 其他暂不支持
		 * @param id:覆盖物的ID
		 */
        this.clean = function(){};
        /**
		 *  mapabc支持
		 */
        this.setAutoZoom = function(){};
        
        /**
		 * 添加标签对象 mapabc支持 其他暂不支持
		 * @param label:标签
		 * @param x y 坐标
		 */
        this.label = function(label,x,y){};
        /**
		 * 公有属性， 设置点击地图是不移动到中心点
		 * 
		 * @param flatlng:FLatLng 表示位置
		 */
		this.setClickToCenter = function(flag){};
        /**
		 * 公有属性， 设置点击地图是不移动到中心点
		 * 
		 * @param width:string 窗口宽
		 * @param height:string 窗口高
		 */
		this.resize = function(width,height){};
	}
})();