(function(){
     
	var map = "http://api.mapbar.com/api/mapbarapi31.2.js";
	
	if(!window.LoadJS){
		window.LoadJS = function(url, call){
			var doc = document.createElement("script");
			doc.type= "text/javascript";
			doc.src = url;
			
			doc.onload = doc.onreadystatechange = call;
			
			document.getElementsByTagName("head")[0].appendChild(doc);
		}
	}
	
	window.LoadJS = function(src) {
	    document.write('<' + 'script src="' + src + '"' + ' type="text/javascript"><' + '/script>');
	}
	window.LoadJS(map);
	
	/** 当第一个参数不为空的时候返回第一个参数 ， 否则第二个 */
	if(!window.nvl){
		window.nvl = function(){
			return arguments[0] == null ? arguments[1] : arguments[0];
		}
	}
	
	/** 这个工具方法来加速循环 */
	if(!window.Array.forEach){
		window.Array.prototype.forEach = function(cb){
			for(var i=0;i<this.length;i++){
				cb(this[i], i);
			}
		}	
	}

	/** 用这个类来表示经纬度， 以隔离GMap和图吧的类耦合 */
	if(!window.FLatLng){
		window.FLatLng = function(lat, lng){this.latx = lat;this.lngy=lng;};
		window.FLatLng.prototype.lat = function(){
			return this.latx;
		};

		window.FLatLng.prototype.lng = function(){
			return this.lngy;
		};

		window.FLatLng.prototype.toString = function(){
			return this.latx + "," + this.lngy;
		};
	}
	
	if(!window.FHashMap){
		window.FHashMap = function(){
			this.count = 0;
		};
		window.FHashMap.prototype.put = function(obj){
			var c = this.count++;
			this[c] = obj;
			return c;
		};
		
		window.FHashMap.prototype.putAt = function(obj, token){
            //var c = this.count++;
            this[token] = obj;
            return token;
        };
        
		window.FHashMap.prototype.get = function(i){
			return  this[i];
		};
		window.FHashMap.prototype.getAndRemove = function(i){
			var obj = this[i];
			delete this[i];
			return obj;
		};
		window.FHashMap.prototype.remove = function(i){
			delete this[i];
		}
	}
	/* String 对象转换为JSON对象 */
    if(!window.s2j)
    {
        window.s2j = function(strObj)
        {
           if(strObj instanceof Object)
           {
               return strObj;
           }
           try{
               return eval('(' + strObj + ')');
           }catch(e){
               return strObj;
           }
        };
    }
})();

(function(){	
	var TYPE    = { TYPE_LINE:0, TYPE_MARK:1};
			
	/**
	 * 这里扩展FLatLng类，便于其跟图吧的MPoint之间 的相互转换。
	 * 
	 * @return
	 */
	window.FLatLng.prototype.toMPoint = function()
	{
		return new MPoint(this.lng(), this.lat());
	};

	window.FLatLng.fromMPoint = function(mptr)
	{
		if (typeof mptr == "string")
		{
			var ptr = cq.vp(mptr);
			return new FLatLng(ptr[1], ptr[0]);
		}
		return new FLatLng(mptr.lat, mptr.lon);
	};

	/**
	 * @param ne:FLatLng
	 *            表示东北点
	 * @Param se:FLatLng
	 *            表示西南点
	 */
	var FLatLngBounds = function(sw, ne)
	{
		if (sw == null || ne == null)
		{
			this.lx = this.ly = this.rx = this.ry = null;
			return;
		}
		this.lx = Math.min(sw.lat(), ne.lat());
		this.ly = Math.min(sw.lng(), ne.lng());
		this.rx = Math.max(sw.lat(), ne.lat());
		this.ry = Math.max(sw.lng(), ne.lng());
	}

	FLatLngBounds.prototype.contains = function(ll)
	{
		return ll.lat() >= this.lx && ll.lng() >= this.ly && ll.lat() <= this.rx && ll.lat() <= this.ry;
	}

	FLatLngBounds.prototype.extendTo = function(ll)
	{
		var x = ll.lat();
		var y = ll.lng();
		if (this.lx == null)
		{
			this.rx = this.lx = x;
			this.ry = this.ly = y;
			return;
		}
		if (x > this.rx)
		{
			this.rx = x
		}
		if (x < this.lx)
		{
			this.lx = x
		}
		if (y > this.ry)
		{
			this.ry = y
		}
		if (y < this.ly)
		{
			this.ly = y
		}
	}

	FLatLngBounds.prototype.getCenter = function()
	{
		return new FLatLng((this.rx + this.lx) / 2, (this.ry + this.ly) / 2);
	}

	FLatLngBounds.prototype.toString = function()
	{
		return [ this.lx, this.rx, this.ly, this.ry ].join(", ");
	}

	/**
	 * 工作类，必须一个html容器Id来初始化， 其余参数均可以使用默认值
	 * 
	 * 注意：Mapbar Api依赖全局变量maplet
	 */
	window.FMap = function(id, latlng, zoom, mapType)
	{
		var eventMap = new FHashMap();
	    //apiType = 1;
		// //////////////////////////////////
		var self = this;
		//latlng = nvl(latlng, new FLatLng(32.055809, 118.771391));
		if(window.mapLocation){
		    var flags = window.mapLocation.split(',');
		    latlng = nvl(latlng, new FLatLng(flags[0],flags[1]));
		}else{
		    latlng = nvl(latlng, new FLatLng(31.99527,118.73444));
		}
		zoom = nvl(zoom, 8);
		var hashmap = new FHashMap();
		// //////////////////////////////////
		// var env = new MEnvironmentInfo();
		// MSearch.init(env);

		// 使用GMap Api初始话地图
		var map = new Maplet(id);

		// Mapbar Api依赖全局变量maplet
		window.maplet = map;

		// 设置地图中点
		map.centerAndZoom(latlng.toMPoint(), zoom);
		var stdCtl = new MStandardControl();
		map.addControl(stdCtl);
		
		var setControlVisible = function(visible){
			map.controlCanvas.showCtlPan(visible)
			map.controlCanvas.showZOButton(visible)
			map.controlCanvas.showCtlRuler(visible)
			map.controlCanvas.showZIButton(visible)
		};
		
		var toMPointArray = function(flatlngs){
			var arr = [];
			flatlngs.forEach(function(data){
				arr.push(data.toMPoint());
			});
			return arr;
		};
		
		var addPolys = function(flatlngs, mbrush, tok,title,content){
			var mptrs = toMPointArray(flatlngs);
			var win = null ;
			if(title&&content){
				win = new MInfoWindow(title,content);
			}
			var  mpl = new MPolyline(mptrs, mbrush,win);
			if(mbrush.arrow)
			{
                for(var i = 0; i < (mptrs.length - 1); i++)
                {
                   map.addOverlay(new MPolyline([mptrs[i],mptrs[i+1]], mbrush,win));
                }
			} else
			{
			    map.addOverlay(mpl);
			}
			
			if(tok)
			{
			   hashmap.putAt(mpl, tok);
			   return tok;
			}
			return hashmap.put(mpl);
		};
		
		map.showOverview(true);
        this.isGoogle = function(){
            return false;
        }
        
		// 公有方法， 移动地图到指定的中点
		this.to = function(flatlng)
		{
			map.setCenter(flatlng.toMPoint());
		};
		
		this.zoom = function(flatlng,zoom)
        {
            map.centerAndZoom(flatlng.toMPoint(),zoom);
        };

		// 公有方法， 将地图移动到若干个点的中点
		this.display = function(flatlngs, needMarker)
		{
			var bounds = new FLatLngBounds();
			flatlngs.forEach(function(data)
			{
				bounds.extendTo(data);

				if (needMarker)
				{
					self.mark(data);
				}
			});
			var latlng = bounds.getCenter();

			self.to(latlng);
		};
		
		var markBuf = {};

		// 公有方法，指定经纬度和html文本，向地图上添加一个标注
		this.mark = function(flatlng, html, cfg, tok, title, label)
		{
			// 数据初始化 兼容其他地图接口
        	if(cfg){
	        	flatlng=nvl(cfg.lonlat,flatlng);
	        	html=nvl(cfg.html,html);
	        	tok=nvl(cfg.tok,tok);
	        	title=nvl(cfg.title,title);
	        	label=nvl(cfg.label,label);
        	}
			var mTitle = (title == null || title == undefined)?"":title;
			var mLabel = null ;
			if(label == null || label == undefined || label == ""){
			}else {
			  label = "<div style='padding:3px;border:1px solid red;background:#ffff99;font:12px 宋体;color:red'>"+label+"</div>";
			  mLabel = new MLabel(label,{xoffset: 20,yoffset: 22,opacity: 100,enableStyle: false,visible: true});
			}
			cfg = (cfg == null? {} : cfg);
			var icon = new MIcon(
					(cfg.path == null ? "marker.png" : cfg.path),
					(cfg.width == null ? 20 : cfg.width),
					(cfg.height == null ? 34 : cfg.height),
                    (cfg.anchorX == null ? 10 : cfg.anchorX),
                    (cfg.anchorY == null ? 34 : cfg.anchorY)
			);
			
			var infoWindow ;
			if(html == null){
			   infoWindow = null;
			}else{
			   infoWindow = new MInfoWindow(mTitle, html);
			}
			var mm = new MMarker(flatlng.toMPoint(), icon,infoWindow,mLabel);
			map.addOverlay(mm);

			var token = null;
			
			if(tok)
			{
			   token = tok;
			   hashmap.putAt(mm, tok);
			}else
			{
			   token = hashmap.put(mm);
			}
			
			markBuf[token] = {
			   flatlng: flatlng,
			   html   : html,
			   cfg    : cfg,
			   type   : TYPE.TYPE_MARK
			};
			
			return token;
		};
		/* 获取经纬度坐标点 */
        this.getLatlng = function(latlng){
        	return latlng ;
        }
		this.openMarkerInfoWindow = function(flatlng, html)
		{
			var obj = self.mark(flatlng, html, {path:'blank.png'});
			var mk = hashmap.get(obj);
			mk.openInfoWindow();
		};
		
		this.moveMark   = function(obj, flatlng){
			var mk = hashmap.get(obj);
			if(mk)
			{
				mk.setPoint(flatlng.toMPoint());
			}
		}
		
		this.removeMark = function(obj){
			var mm = hashmap.getAndRemove(obj);
			
			if(mm)
			{
				map.removeOverlay(mm);
			}
		};
		
		this.getBounds = function(){
			var bds = map.getViewBound();
			return [
			    FLatLng.fromMPoint(bds.LeftUp),
			    FLatLng.fromMPoint(bds.RightUp),
			    FLatLng.fromMPoint(bds.RightDown),
			    FLatLng.fromMPoint(bds.LeftDown)
			];
		}
		this.ellipse = function(lonlat,width,height, cfg)
        {
        	var brush = new MBrush();  
	        brush.color = "blue";  
	        brush.bgcolor = "blue"; 
        	if(cfg){
	        	width=nvl(cfg.weight,width);
	        	height=nvl(cfg.height,height);
	        	brush.color=nvl(cfg.color,brush.color);
	        	brush.bgcolor=nvl(cfg.bgcolor,brush.bgcolor);
        	}
	        brush.fill = true;  
	        brush.transparency = 50;  
	        brush.bgtransparency = 20; 
	        brush.stroke = 1;
	        var ellipse = new MEllipse(latlng.toMPoint(), width, height, brush);
	        maplet.addOverlay(ellipse);
	        return ellipse;
        }
		// 清空地图上的叠加层，包括了添加的所有的标注，绘制的线等。
		this.clearOverlays = function()
		{
			map.clearOverlays(true);
		}
		
		var lpad = function(str)
		{
		    if(str == null)
		    {
		        return "00";
		    }
		    if(str.length < 2)
		    {
		        return "0" + str;
		    }
		    
		    return str;
		}

        var decodeRGBStr = function(str)
        {
            str += "";
            
            if(str == null)
            {
                return "#FF0000";
            }
            
            else if(str.toLowerCase().indexOf("rgb") >= 0)
            {
                str =  str.toLowerCase();
                var s = str.replace("rgb(", "").replace(")", "");
                s = s.split(",");
				var cstr = ["#", lpad(Number(s[0]).toString(16)), 
				                 lpad(Number(s[1]).toString(16)), 
				                 lpad(Number(s[2]).toString(16)) 
				            ].join("");
                return cstr.toUpperCase();
            }
            return str;
        }

		// 根据传入的坐标点，绘制一条折线，指定颜色的字符串格式是 #FFFFF 这种。
		this.addLine = function(flatlngs, rgbstr, opacity, weight, tok,title,content, cfg)
		{
			if(cfg){
	        	title = nvl(title,cfg.title);
	        	rgbstr = nvl(decodeRGBStr( rgbstr ),cfg.rgbstr);
	        	opacity = nvl(title,cfg.opacity);
	        	weight = nvl(title,cfg.weight);
	        	tok = nvl(title,cfg.tok);
	        	content = nvl(title,cfg.html);
        	}
			var brush = new MBrush();
			var color =  decodeRGBStr( rgbstr );
			brush.color = color;
            brush.transparency =  opacity * 100;
            brush.stroke = weight ? weight : 2;
            brush.arrow = true;
			
			/*
			 * var mptrs = toMPointArray(flatlngs);
			 * 
			 * var mpl = new MPolyline(mptrs, brush);
			 * map.addOverlay(mpl); return hashmap.put(mpl);
			 */
			var token = addPolys(flatlngs, brush, tok,title,content);
			markBuf[token] = {type: TYPE.TYPE_LINE, 
			                  flatlngs: flatlngs,
			                  opacity : opacity,
			                  weight  : weight, 
			                  color   : color,
							  title : title,
				              content : content};
			return token;
		}
		
		this.extendLine = function(obj, flatlng)
		{
			var line = hashmap.get(obj);
			if(line)
			{
				line.appendPoint(flatlng.toMPoint(), true);
			}
		};
		// 公有方法，用来添加一个地图的点击监听器。这里返回一个令牌，作为删除该次注册的监听器之用。
		this.addListener = function(evn,cb)
		{
			var lsnr = MEvent.addListener(map, evn, function(evt, mptr)
			{
				try
				{
					var latlng = window.FLatLng.fromMPoint(mptr);
					cb.call(window, latlng);
				} catch (e)
				{
					alert(e);
				}
			});
			var evnIds = eventMap.get(evn);
			if(!evnIds){
				evnIds = new Array();
			}
			var len = evnIds.length;
			evnIds[len]=lsnr;
			eventMap.putAt(evn,evnIds);
			return lsnr;
		};
		this.addClickListener = function(cb)
		{
			return this.addListener("click",cb);
		};
		// evn：mouseout，mouseover，click等
		this.addObjListener = function(obj,evn, cb)
		{
			var mk = hashmap.get(obj)
			if(mk)
			{
				return MEvent.addListener(mk, evn, function(mk){
					cb(FLatLng.fromMPoint(mk.pt),obj);
				});
			}
		};
		this.addMarkMouseoverListener = function(obj, cb)
		{
			return this.addObjListener(obj,"mouseover", cb);
		};
		
		this.addMarkMouseoutListener = function(obj, cb)
		{
			return this.addObjListener(obj,"mouseout", cb);
		};
		// 这里的参数就是Listener方法的返回值。
		this.removeListener = function(evn,cb)
		{
			var lsnrs = eventMap.getAndRemove(evn);
            if(lsnrs){
    			for(var i = lsnrs.length-1; i>= 0 ; i++)
         		{
    				MEvent.removeListener(lsnrs[i]);
          		}
            }
		}
		this.removeObjListener = function(obj, lsnr)
        {
            map.removeEventListener(obj, event, callback);
        }
		// 搜索某一位置，需要传入一个字符串和一个处理函数
		this.searchPosition = function(addr, cb)
		{
			/*
			 * var GeocodingRs = { name: '', keyword:
			 * '\u592B\u5B50\u5E99', city: '\u5357\u4EAC', strlatlon:
			 * 'IEGWWRXVGBVJU' }
			 */
			/*
			 * env.onGeocoding = function(data, extData){ var ll =
			 * cq.vp(data.strlatlon); cb(new FLatLng(ll[1], ll[0])); };
			 * 
			 * MSearch.getGeocoding(new MGeocodingInfo(addr, "南京"));
			 */
		};
		
		this.removeLine = function(obj)
		{
			var mpl = hashmap.getAndRemove(obj);
			if(mpl)
			{
				map.removeOverlay(mpl);
			}
		};
		
		this.setToDefaultUI = function()
		{
			
		};
		/**
		 * 向地图上添加鹰眼控件
		 * 
		 * @return
		 */
		this.addOverview      = function(){
			map.overview.open();
		};
		/**
		 * 删除地图上的鹰眼控件
		 * 
		 * @return
		 */
		this.removeOverview   = function(){
			map.overview.close();
		};
		
		/**
		 * 添加一个鱼骨控件
		 * 
		 * @return
		 */
		this.addMapControl    = function(){
			setControlVisible(true);
		};
		/**
		 * 删除地图上的鱼骨控件
		 * 
		 * @return
		 */
		this.removeMapControl = function(){
			setControlVisible(false);
		};
		
		/**
		 * 添加一个多边形
		 * 
		 * @param latlngs:FLatLng[]
		 *            多边形的各个顶点
		 * @param lineColor:string
		 *            CSS颜色字符串，线颜色
		 * @param fillColor:string
		 *            CSS颜色字符串，填充区颜色
		 * @return 返回一个令牌以支持对应点的删除操作
		 */
		this.addPolygon = function(flatlngs, lineColor, fillColor){
			var brush = new MBrush();
			
			brush.color = lineColor;
			brush.fill  = true;
			brush.bgcolor = fillColor;
			
			return addPolys(flatlngs, brush);
		};
		
		this.extendPolygon = function(obj, latlng)
		{
			extendLine(obj, flatlng);
		};
		
		/**
		 * 删除指定的多边形
		 * 
		 * @param obj
		 *            addPolygon的返回值
		 * @return
		 */
		this.removePolygon = function(obj){
			self.removeLine(obj);
		};
		
		/**
		 * 将地图上指定像素的点转换成经纬度描述的坐标。
		 * 
		 * @param x:int
		 *            指定点的x坐标
		 * @param y:int
		 *            指定点的y坐标
		 * @return FLatLng的实例
		 */
		this.pointToLatLng = function(x, y){
			return window.FLatLng.fromMPoint(map.toMapCoordinate(x, y));
		};
		
		this.hideMark = function(obj)
        {
            var mk = hashmap.getAndRemove(obj);
            
            if(mk)
            {
              map.removeOverlay(mk);
            }  
        };
        
        this.showMark = function(obj)
        {	
            var mcfg = markBuf[obj];
            if(mcfg.type == TYPE.TYPE_MARK)
            {
              return self.mark(mcfg.flatlng, mcfg.html, mcfg.cfg, obj);
            }
            else if( mcfg.type == TYPE.TYPE_LINE )
            { 
              return self.addLine(mcfg.flatlngs, mcfg.color, mcfg.opacity, mcfg.weight, obj,mcfg.title,mcfg.content);
            }
        };
         this.showLineInfoWindow = function(obj)
        {   
            var line = hashmap.get(obj);
            if(line)
            {
                line.openInfoWindow();
            }
        };
        /**
         * 计算出2点之间的距离
         * @param x:int 指定点的x坐标
         * @param y:int 指定点的y坐标
         * @param x2:int 指定另一点的x坐标
         * @param y2:int 指定另一点的y坐标
         * @return number 
         */
        this.distanceFrom = function(x, y, x2, y2){
          	var myDis = GetDistance(x, y, x2, y2) * 1000;
          	var mDis = map.measDistance([new MPoint(y,x ), new MPoint(y2, x2)]);
          
          	return mDis;   
        };
        
        this.setMarkContent = function(obj, content)
		{
		    var mk = hashmap.get(obj);
		    if(mk)
			{
			    if(mk.info)
				{
				    mk.info.setContent(content);
				}
			}
		};
		
		 this.setIcon = function(obj, cfg)
		{
		    var mk = hashmap.get(obj);
		    if(mk)
			{
				var icon = new MIcon(
					(cfg.path == null ? "marker.png" : cfg.path),
					(cfg.width == null ? 20 : cfg.width),
					(cfg.height == null ? 34 : cfg.height),
                    (cfg.anchorX == null ? 10 : cfg.anchorX),
                    (cfg.anchorY == null ? 34 : cfg.anchorY)
				);
				mk.setIcon(icon, true);
			}
		};
		
		 this.updateImage = function(obj,imgpath)
		{
		   var mk = hashmap.get(obj);
		    if(mk  && imgpath)
			{
				 $("#"+mk.id + " img").attr("src",imgpath);
			}
		};
		
		
		this.setLabelVisiable = function(obj, isVisiable)
		{
		    var mk = hashmap.get(obj);
		    if(mk && mk.label)
			{
				mk.label.setVisible(isVisiable);
			}
		};
		
		this.getPath = function(obj)
		{
		    var mk = hashmap.get(obj);
		    if(mk)
			{
				return mk.icon.getImgUrl();
			}
			return null;
		};
		
		this.getIcon = function(obj){
			var mk = hashmap.get(obj);
		    if(mk)
			{
				return mk.icon;
			}
			return null;
		};
		
		this.getMarkContent = function(obj)
        {
            var mk = hashmap.get(obj);
            if(mk)
            {
                if(mk.info&&mk.info.content)
                {
                    return mk.info.content;
                }
            }
        };
        
        var EARTH_RADIUS = 6378.137;

		var rad = function(d)
		{
		 	return d * Math.PI / 180.0;
		}
		
		var GetDistance = function(lat1, lng1, lat2, lng2)
		{
		
		   var radLat1 = rad(lat1);
		   var radLat2 = rad(lat2);
		   var a = radLat1 - radLat2;
		   var b = rad(lng1) - rad(lng2);
		   var s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
		    Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
		   s = s * EARTH_RADIUS;
		   s = Math.round(s * 10000) / 10000;
		   return s;
		}
		this.setAutoZoom = function()
        {
            map.setAutoZoom();
        };
        this.addPanel = function(pin,zindex,content,mousewheel,locationType,x,y) {
        	var loc;
        	if(locationType == 1){
        	    loc = {   
                    type: "xy",   
                    x: x,   
                    // Int类型，屏幕y坐标。   
                    y: y,   
                    // MPoint类型,地理坐标点。   
                    pt: null  
                }  
        	}else{
        	    loc = {   
                    type: "latlon",  
                    // MPoint类型,地理坐标点。   
                    pt: new MPoint(x,y)  
                }
        	}
            var doptions = {
                pin: pin,
                zindex: zindex,
                content: content,
                location: loc,
                mousewheel: mousewheel
            };
            p = new MPanel(doptions);
            map.addPanel(p);
        };
        /*****************************************************************************************/
        /* 设置属性 */
        //  移动地图到指定的中点
		this.setClickToCenter = function(flag)
		{
			map.clickToCenter=flag;
		};
		//  设置窗口大小
		this.resize = function(width,height)
		{
			map.resize(width, height);
		};
		// 移除面
		this.removeOverlayMark = function(ellipse)
		{
			map.removeOverlay(ellipse);
		};
	}
	
	window.FMap.isMMap = true;
})();