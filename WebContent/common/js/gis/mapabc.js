/* Common JS Utils */
(function(){
    /*
       Ajax Map API : http://app.mapabc.com/apis?&t=ajaxmap&v=2.1.2
       Flash Map API: http://app.mapabc.com/apis?&t=flashmap&v=2.2
    */
    var mapKey = "62fe3d14ea426b905bd8e3e397d976261006bbe86f68081eb646f8f329bfab3a1fd0255cca54ce16";
    var mapUrl = "http://app.mapabc.com/apis?&t=ajaxmap&v=2.1.2&key=" + mapKey;
    
    if(!window.LoadJS){
        window.LoadJS = function(url, call){
            var doc = document.createElement("script");
            doc.type= "text/javascript";
            doc.src = url;
            
            doc.onload = doc.onreadystatechange = call;
            
            document.getElementsByTagName("head")[0].appendChild(doc);
        }
    }
    window.loadJS = function(src) {
        document.write('<' + 'script src="' + src + '"' + ' type="text/javascript"><' + '/script>');
    };
    
    loadJS(mapUrl);
    
    /**
     * 定义公共函数，非空默认取值
     */
    if(!window.nvl){
        window.nvl = function()
        {
            return arguments[0] == null ? arguments[1] : arguments[0];
        };
    }
    
    /**
     * 定义公共函数，判断对象是否为空
     */
    if(!window.isNull)
    {
        window.isNull = function(obj)
        {
            if(obj == null || typeof(obj) == 'undefined' || obj == '')
            {
                return true;
            } else
            {
                return false;
            }
        };
    }
    
    if(!window.isNotNull)
    {
        window.isNotNull = function(obj)
        {
            return !isNull(obj);
        };
    }
    /* String 对象转换为JSON对象 */
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
    /* 检查经纬度合法性 */
    window.checkLonlat = function(point)
    {
       var lat = point.lat;
       var lon = point.lon;
       try
       {
           if(isNull(lon) || isNull(lat))
           {
               return false;
           } else if(parseFloat(lat) == 0 || parseFloat(lat) > 180)
           {
               return false;
           } else if(parseFloat(lon) == 0 || parseFloat(lon) > 180)
           {
               return false;
           }
           return true;
       } catch(e)
       {
           return false;
       }
    };
    
    /**
     * 将数组中的公共接口坐标，批量转换为地图坐标
     */
    window.conver = function(lonlats)
    {
        var iMPoints = new Array();
        if(lonlats != null && lonlats.length > 0)
        {
            var len = lonlats.length;
            for(var i = 0; i < len; i++)
            {
                iMPoints.push(lonlats[i].toMap());
            }
        }
        return iMPoints;
    };
    /**
     * 计算两点之间距离
     */
    window.distance = function(x1,y1,x2,y2)
    {
        //x = Math.cos(3 * Math.PI) + Math.sin(Math.LN10) y = Math.tan(14 * Math.E)
        var radY1 = y1 * Math.PI / 180;
        var radY2 = y2 * Math.PI / 180;
        var a = radY1 - radY2;
        var b = x1 * Math.PI / 180 - x2 * Math.PI / 180;
        var s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radY1) * Math.cos(radY2)
            * Math.pow(Math.sin(b / 2), 2)));
        s = s * 6378137.0;  // 取WGS84标准参考椭球中的地球长半径(单位:m)
        s = Math.round(s * 10000) / 10000;
        return s;
    };
    
    /**
     * 计算某一条覆盖线和12点钟方向直线之间的夹角
     */
    window.angs = function(x2,y2,x3,y3)
    {
        var a = distance(x2,y3,x2,y2);
        var b = distance(x2,y2,x3,y3);
        var c = distance(x2,y3,x3,y3);
        var cos = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);
        var ang = Math.acos(cos) / Math.PI * 180;
        return ang;
    };
    
    window.angs360 = function(x2,y2,x3,y3)
    {
        var ang = angs(x2,y2,x3,y3);
        var ang360 = 0;
        if(x2 == x3)
        {
            if(y2 <= y3 )
            {
                ang360 = 0;
            } else
            {
                ang360 = 180;
            }
        } else if(x2 < x3)
        {
            if(y2 == y3)
            {
                ang360 = 90;
            } else if(y2 < y3)
            {
                ang360 = ang;
            } else
            {
                ang360 = 180 - ang;
            }
        }
        else
        {
            if(y2 == y3)
            {
                ang360 = 270;
            } else if(y2 < y3)
            {
                ang360 = 360 - ang;
            } else
            {
                ang360 = 180 + ang;
            }
        }
        //alert(ang360);
        return ang360;
    };
    /**
     * 将字符串坐标转换为标准坐标
     */
    window.s2pt = function(sLonlat)
    {
        var ll = sLonlat.split(",");
        return new IMPoint(ll[0], ll[1]);
    };
    /** 用这个类来表示经纬度， 以隔离GMap和mapabc的类耦合 */
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
})();

/* Map Object Common interface */
(function(){
	/**
	 * 这里扩展FLatLng类，便于其跟图吧的MPoint之间 的相互转换。
	 * 
	 * @return
	 */
	window.FLatLng.prototype.toMPoint = function()
	{
		return new MLngLat(this.lng(), this.lat());
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
    /* IMPoint to Map Point*/
    window.FLatLng.prototype.toMap = function()
    {
    	return new MLngLat(this.lon, this.lat);
    };
   /**
     * 定义标准接口坐标对象
     */
    if(!window.IMPoint)
    {
        window.IMPoint = function(lon,lat){this.lon = lon; this.lat = lat;};
        /* Longitude Jing du*/
        window.IMPoint.prototype.lon = function(){
            return this.lon;
        };
        /* Latitude Wei du*/
        window.IMPoint.prototype.lat = function(){
            return this.lat;
        };
        window.IMPoint.prototype.toString = function(){
            return this.lon + "," + this.lat;
        };
        /* IMPoint to Map Point*/
        window.IMPoint.prototype.toMap = function()
        {
        	return new MLngLat(this.lon, this.lat);
        };
    }
    /**
     * 定义点覆盖物对象
     */
    if(!window.IMMarker)
    {
        window.IMMarker = function(id,lonlat,image,x,y,w,h,route,label,title,html)
        {
            this.id = id;
            this.lonlat = lonlat;
            this.image = image;
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.route = route;
            this.label = label;
            this.title = title;
            this.html = html;
        };
        /* id */
        window.IMMarker.prototype.id = function(){
            return this.id;
        };
        /* Latitude Wei du*/
        window.IMMarker.prototype.lonlat = function(){
            return this.lonlat;
        };
        window.IMMarker.prototype.image = function(){
            return this.image;
        };
        window.IMMarker.prototype.x = function(){
            return this.x;
        };
        window.IMMarker.prototype.y = function(){
            return this.y;
        };
        window.IMMarker.prototype.w = function(){
            return this.w;
        };
        window.IMMarker.prototype.h = function(){
            return this.h;
        };
        window.IMMarker.prototype.route = function(){
            return this.route;
        };
        window.IMMarker.prototype.label = function(){
            return this.label;
        };
        window.IMMarker.prototype.title = function(){
            return this.title;
        };
        window.IMMarker.prototype.html = function(){
            return this.html;
        };
        window.IMMarker.prototype.toString = function()
        {
            return  "{id:" + this.id 
                    + ",lonlat:" + this.lonlat
                    + ",image:" + this.image
                    + ",x:" + this.x
                    + ",y:" + this.y
                    + ",w:" + this.w
                    + ",h:" + this.h
                    + ",route:" + this.route
                    + ",label:" + this.label
                    + ",title:" + this.title
                    + ",html:" + this.html+"}";
        };
        window.IMMarker.prototype.clone = function()
        {
            return new IMMarker(this.id
                                ,this.lonlat
                                ,this.image
                                ,this.x
                                ,this.y
                                ,this.w
                                ,this.h
                                ,this.route
                                ,this.label
                                ,this.title
                                ,this.html);
        };
    }
    
    if(!window.IMConfig)
    {
        window.IMConfig = function(drawType, weight, color, type, opacity, fillColor, fillOpacity, label, title, html)
        {
            this.drawType = drawType;
            this.weight = weight;
            this.color = color;
            this.type = type;
            this.opacity = opacity;
            this.fillColor = fillColor;
            this.fillOpacity = fillOpacity;
            this.label = label;
            this.title = title;
            this.html  = html;
        };
        window.IMConfig.prototype.drawType = function(){
            return this.drawType;
        };
        window.IMConfig.prototype.weight = function(){
            return this.weight;
        };
        window.IMConfig.prototype.color = function(){
            return this.color;
        };
        window.IMConfig.prototype.type = function(){
            return this.type;
        };
        window.IMConfig.prototype.opacity = function(){
            return this.opacity;
        };
        window.IMConfig.prototype.fillColor = function(){
            return this.fillColor;
        };
        window.IMConfig.prototype.fillOpacity = function(){
            return this.fillOpacity;
        };
        window.IMConfig.prototype.label = function(){
            return this.label;
        };
        window.IMConfig.prototype.title = function(){
            return this.title;
        };
        window.IMConfig.prototype.html = function(){
            return this.html;
        };
    }
    /**
     * 地图初始化接口
     */
	window.FMap = function(id, latlng, zoom,mapType)
	{
        /* 初始化地图 */
        var defaultZoom    = zoom || 10;
        var defaultWeight  = 3;
        var defaultColor   = 0x000000;
        var defaultOpacity = 0.6;
        var defaultDiv     = id || 'mapObj';
        if(window.mapLocation){
		    var flags = window.mapLocation.split(',');
		    latlng = nvl(latlng, new FLatLng(flags[0],flags[1]));
		}else{
		    latlng = nvl(latlng, new FLatLng(31.99527,118.73444));
		}
        var mapOptions = new MMapOptions();
        /* zoom */
        mapOptions.zoom   = defaultZoom;
        /* center */
        mapOptions.center = latlng.toMPoint();
        /* toolbar */
        mapOptions.toolbar = DEFAULT;
        /* overview */
        mapOptions.overviewMap = MINIMIZE;
        /* scale*/
        mapOptions.scale = SHOW;
        /* lon,lat is number*/
        mapOptions.returnCoordType = COORD_TYPE_OFFSET;
        /* show right menu*/
        mapOptions.hasDefaultMenu = false; 
        
        mapOptions.zoomBox = true;
        var map = new MMap(defaultDiv, mapOptions);
        window.maplet = map
        window.wayArray = new Array();
        var hashmap = new FHashMap();
        /*****************************************************************************************/
        /* 设置工具栏 */
        this.ctrlbar = function(showBar,overView,scale)
        {
            if(showBar)
            {
                map.setCtrlPanelState(TOOLBAR_CTRL,SHOW);
            } else
            {
                map.setCtrlPanelState(TOOLBAR_CTRL,HIDE);
            }
            if(overView)
            {
                map.setCtrlPanelState(OVERVIEW_CTRL,SHOW);
            } else
            {
                map.setCtrlPanelState(OVERVIEW_CTRL,MINIMIZE);
            }
            if(scale)
            {
                map.setCtrlPanelState(SCALE_CTRL ,SHOW);
            } else
            {
                map.setCtrlPanelState(SCALE_CTRL ,HIDE);
            }
        };
        /* 用户自定义控件 */
        this.addPanel = function(div)
        {
            map.addControl(div);
        };
        this.mouseDistance = function()
        {
            var option={};  
            option.hasCircle=true; 
            option.hasPrompt=false;
            map.setCurrentMouseTool(RULER,option);
        };
        this.mouseMove = function()
        {
            map.setCurrentMouseTool(PAN_WHEELZOOM);
        };
        /* 移到中心点 */
        this.to = function(lonlat)
        {
            map.setCenter(lonlat.toMPoint());
        };
        /* 根据经纬度移动到中心点 */
        this.moveTo = function(lon,lat)
        {
            this.to(new FLatLng(lon,lat));
        };
        /* 地图缩放到某一级别 */
        this.zoomTo = function(zoom)
        {
            map.setZoomLevel(nvl(zoom,defaultZoom));
        };
        /*在某一级别下 以某一中心点缩放地图 */
        this.zoom = function(lonlat,zoom)
        {
            map.setZoomAndCenter(zoom,lonlat.toMPoint());
        };
        this.setZoomEnabled = function(isEnable)
        {
            map.setZoomEnabled(isEnable);
        };
        /* 获取比例尺 */
        this.getScale = function()
        {
            return map.getScale();
        };
        /* 经纬度转像素坐标 */
        this.toPixel = function(lonlat)
        {
            var xy = map.fromLngLatToContainerPixel(lonlat.toMap());
            return new IMPoint(xy.y,xy.x);
        };
        /* 像素转经纬度坐标 */
        this.toPoint = function(lonlat)
        {
            var ll = map.fromContainerPixelToLngLat(lonlat.toMap());
            return new IMPoint(ll.lngX,ll.latY);
        };
        
        /* 获取坐标间像素距离 */
        this.getZoomPixel = function(lonlat1,lonlat2)
        {
            var xy1 = this.toPixel(lonlat1);
            var xy2 = this.toPixel(lonlat2);
            return Math.sqrt(Math.pow(xy1.lon - xy2.lon, 2) + Math.pow(xy1.lat - xy2.lat, 2));
        };
        
        /* 逆地址解析 */
        this.getAddress = function(lonlat,callback)
        {
            var mls =new MReGeoCodeSearch(); 
            var opt= new MReGeoCodeSearchOptions(); 
            opt.poiNumber=10;;//返回周边的POI数量,默认10 
            opt.range=3000;   //限定周边热点POI和道路的距离范围 
            opt.pattern = 0;  //返回数据的模式,0表示返回地标性POI,1表示返回全部POI， 
            opt.exkey="";     //排除的关键字 
            mls.setCallbackFunction(callback); 
            mls.poiToAddress(lonlat.toMap(),opt); 
        };

        /* 添加覆盖物对象 */
        this.over = function(overlay)
        {
            map.addOverlay(overlay,true); 
        };
        
        // 根据覆盖物的ID删除覆盖物
        this.remove = function(id)
        {
            map.removeOverlayById(id);
        };
        // 清除地图上所有覆盖物
        this.clearOverlays = function()
        {
            map.clearMap();
            this.clearWay();
        };
        
        // 清除地图上所有覆盖物
        this.clearMap = function()
        {
            map.clearMap();
            this.clearWay();
        };
        
        //线点转换
        this.convertLineToMark =  function(lines) {
        	  var overlays = new Array();
			  for( var i = 0; i <lines.length ;i++)
              {
              	 var line = lines[i].lnglatArr;
              	 for(var j = 0; j<line.length;j++){
	                 var latlng = new MLngLat(line[j].lngX ,line[j].latY);
	　				 var mark = new MMarker(latlng);
	                 overlays.push(mark);
              	 }
              }
              return overlays;
        }
        
        this.setAutoZoom = function()
        {
            var lines = map.getOverlaysByType(MOverlay.TYPE_POLYLINE);
            var marks = map.getOverlaysByType(MOverlay.TYPE_MARKER);
            var ids = new Array();
            if(lines && lines.length > 0)
            {
                //for(var i = 0; i < lines.length; i++)
                //{
                    //ids.push(lines[i]);
               // }
                
                ids = ids.concat(this.convertLineToMark(lines));
            }
            
            if(marks && marks.length > 0)
            {
                for(var i = 0; i < marks.length; i++)
                {
                    ids.push(marks[i]);
                }
            }
            if(ids.length > 0)
            {
                map.setFitview(ids);
            } 
        };

        /* 添加标签对象 */
        this.label = function(label,x,y)
        {
            if(isNull(label)) 
            {
                return null;
            } else
            {
                var labelOption=new MLabelOptions();
                labelOption.content = '<div style="padding:2px 3px;">'+label+'</div>';
                labelOption.hasBorder = true;
                labelOption.hasBackground = true;
                labelOption.labelPosition = new MPoint(nvl(x,10) + 5,nvl(y,25) + 5);
                return labelOption;
            }
        };
        this.labelOnly = function(id, content, lon, lat)
        {
            if(isNotNull(content)) 
            {
                var labelOption=new MLabelOptions();
                labelOption.content = '<div style="padding:2px 3px;">' + content + '</div>';
                labelOption.hasBorder = true;
                labelOption.hasBackground = true;
                labelOption.labelPosition = new MPoint(5,5);
                var mLabel = new MLabel(new IMPoint(lon,lat).toMap(),labelOption);
                mLabel.id = id;
                map.addOverlay(mLabel,false); 
            }
        };
        /* 添加覆盖点 */
        this.mark = function(flatlng,html, cfg,tok, title, label,labelshow)
        {
        	// 数据初始化 兼容其他地图接口
			var focus = null;
			var tipWidth = null;
        	if(cfg){
	        	flatlng=nvl(cfg.lonlat,flatlng);
	        	html=nvl(cfg.html,html);
	        	tok=nvl(cfg.tok,tok);
	        	title=nvl(cfg.title,title);
	        	label=nvl(cfg.label,label);
	        	focus=nvl(cfg.focus,focus);
	        	labelshow=nvl(labelshow,true);
	            tipWidth  = nvl(cfg.tipWidth,454);
        	}
        	
        	// 方法实现
            var markerOption = new MMarkerOptions(); 
            //markerOption.imageUrl = cfg.image;
            markerOption.imageUrl = cfg.path;
            markerOption.picAgent=true; 
            markerOption.anchor = new MPoint(nvl(cfg.anchorX,0),nvl(cfg.anchorY,0));
            if(!isNull(cfg.width) && !isNull(cfg.height))
            {
                markerOption.imageSize = new MSize(cfg.width,cfg.height);
            }
            markerOption.imageAlign = BOTTOM_CENTER; 
            
            if(!isNull(label) && labelshow)
            {
                 markerOption.labelOption = this.label(label,cfg.anchorX,cfg.anchorY);
            }
            if(!isNull(title) || !isNull(html))
            {
                var tipOption = new MTipOptions();
                tipOption.tipWidth = tipWidth;
                tipOption.title  = title;
                tipOption.content = html;
                
                markerOption.tipOption = tipOption; 
            }
            markerOption.canShowTip = true;
           	var markv = new MMarker(flatlng.toMPoint(),markerOption); 
            if(cfg.id)
            {
                markv.id = cfg.id;
            } else
            {
                markv.id = "m_" + Math.random();
            }
            focus = nvl(focus, true);
            if(!focus || focus == 'false')
            {
                focus = false;
            }
            map.addOverlay(markv,focus); 
      
        };
        this.removeMark = function(obj){
			if(obj)
			{
				this.remove(obj);
			}
		};
        /* 获取经纬度坐标点 */
        this.getLatlng = function(latlng){
        	return latlng.eventY+","+latlng.eventX;
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
        /* 添加覆盖物*/
        this.addLine = function(lonlats, rgbstr, opacity, weight, tok,title,content, cfg)
        {
        	if(cfg){
	        	title = nvl(title,cfg.title);
	        	rgbstr = nvl(decodeRGBStr( rgbstr ),cfg.rgbstr);
	        	opacity = nvl(opacity,cfg.opacity);
	        	weight = nvl(weight,cfg.weight);
	        	tok = nvl(tok,cfg.tok);
	        	content = nvl(content,cfg.html);
        	}
            var linestyle = new MLineStyle();
            linestyle.thickness = nvl(weight,defaultWeight);
            linestyle.color     = nvl(decodeRGBStr( rgbstr ),defaultColor);
            if(cfg&&cfg.type){
	            linestyle.lineType  = nvl(cfg.type,LINE_SOLID);
            }else{
            	linestyle.lineType  = LINE_SOLID;
            }
            linestyle.alpha     = nvl(opacity,defaultOpacity);
            
            var lineopt = new MLineOptions();
            if(!isNull(title) || !isNull(content))
            {
                var tipOption=new MTipOptions();
                tipOption.title    = title;
                tipOption.content  = content;
                lineopt.tipOption  = tipOption;
                lineopt.canShowTip = true;
            }
            lineopt.lineStyle   = linestyle;        
            
            var lonlatsArr = new Array();
            for(var i=0;i<lonlats.length;i++){
            	lonlatsArr.push(lonlats[i].toMPoint());
            }
            
            var polyline = new MPolyline(lonlatsArr,lineopt);
            if(cfg&&cfg.id)
            {
                polyline.id = "l_" +  cfg.id;
            } else
            {
                polyline.id = "l_" + Math.random();
            }
            map.addOverlay(polyline,true);
        };
        /* 添加覆盖物，带箭头的线 */
        this.lineWay = function(markers, cfg)
        {
            //this.setZoomEnabled(false);
            var drawType = cfg.drawType || '1';
            var lonlats = new Array();
            var len = markers.length;
            //var lpx = map.getScale() / 9000.0;
            //var lpx = map.getScale() / 20000.0;
            /*
            if(lpx > 0.0035555555555555557)
            {
                lpx = 0.0035555555555555557;
            }*/
            var lpx = 0.0008;
            for(var i = 0; i < len; i++)
            {
                if(drawType != '2')
                {
                    lonlats.push(markers[i].lonlat);
                    if(i > 0 )
                    {
                        this.dir(markers[i-1].lonlat, markers[i].lonlat, cfg, lpx);
                    }
                }
                
                if(drawType == '3')
                {
                    continue;
                }
                markers[i].focus=false;
                this.mark(null,null,markers[i]);
            }
            
            if( drawType != '2')
            {
                this.addLine(lonlats, cfg);
            }
            //this.setZoomEnabled(true);
        };
        /* 调整箭头大小适配到不同缩放级别 */
        this.realWay = function()
        {
            this.setZoomEnabled(false);
            var lpx = map.getScale() / 9000.0;
            var len = wayArray.length;
            for(var i = 0; i < len; i++)
            {
                var way = wayArray[i];
                this.dir(way.s, way.e, way.cfg, lpx, way.id);
            }
            this.setZoomEnabled(true);
        };
        /* 清除绘制的箭头，以便重新绘制 */
        this.clearWay = function()
        {
            wayArray = [];
        };
        /* 添加覆盖物，多边形 */
        this.addPolygon = function(lonlats, cfg)
        {
            var linestyle = new MLineStyle(); 
            linestyle.thickness = cfg.weight || defaultWeight;
            linestyle.color     = cfg.color || defaultColor;
            linestyle.lineType  = cfg.type || LINE_SOLID;
            linestyle.alpha     = cfg.opacity || defaultOpacity;
            
            var fillstyle = new MFillStyle();
            fillstyle.color = cfg.fillColor || defaultColor; 
            fillstyle.alpha = cfg.fillOpacity || defaultOpacity;

            var areastyle = new MAreaStyle();
            areastyle.borderStyle = linestyle;
            areastyle.fillStyle   = fillstyle;
            
            var areaopt = new MAreaOptions(); 
            if(!isNull(cfg.label))
            {
                areaopt.labelOption = this.label(cfg.label,5,5);
            }
            
            if(!isNull(cfg.title) && !isNull(cfg.html))
            {
                var tipoption=new MTipOptions();
                tipoption.title   = cfg.title;
                tipoption.content = cfg.html;
                areaopt.tipOption = tipoption;
                areaopt.canShowTip= true;
            } else
            {
                areaopt.canShowTip= false;
            }
            
            areaopt.areaStyle = areastyle;
            var polygon = new MPolygon(conver(lonlats),areaopt); 
            if(cfg.id)
            {
                polygon.id = cfg.id;
            } else
            {
                polygon.id = "p_" + Math.random();
            }
            map.addOverlay(polygon,true);
        };
        
        this.ellipse = function(lonlat,width,height, cfg)
        {
        	var color = 0x0000ff;
        	var fillColor = 0x0000ff;
        	var fillOpacity = 0.2;
        	var id = "c_" + Math.random();
        	var radius = 1000;
        	
        	if(cfg){
	        	width=nvl(cfg.width,width);
	        	height=nvl(cfg.height,height);
	        	color=nvl(cfg.color,color);
	        	fillColor=nvl(cfg.fillColor,fillColor);
	        	fillOpacity=nvl(cfg.fillOpacity,fillOpacity);
	        	radius=nvl(cfg.radius,radius);
        	}
        	if(cfg.id){
        		id = "c_"+cfg.id;
        	}
            var areaopt = new MAreaOptions();　//构建一个名为areopt的面选项对象。 
            var areastyle=new MAreaStyle();//创建面样式对象 
        
            var linestyle = new MLineStyle();//创建线样式对象 
            linestyle.thickness = width || 1;//线的粗细度，默认为1 
            linestyle.color     = color || 0x0000ff;//线的颜色，16进制整数，默认为0x005890（蓝色） 
            areastyle.borderStyle = linestyle;//面的边框风格。 
            
            var fillstyle  =new MFillStyle();//创建填充样式对象 
            fillstyle.color = fillColor;//面的填充颜色，16进制整数。 
            fillstyle.alpha = fillOpacity;//填充面的透明度，范围0~1，0为透明，1为不透明（默认） 
            areastyle.fillStyle = fillstyle;//面的填充风格。 
            
            if(cfg && cfg.html)
            {
                var tipoption=new MTipOptions();//添加信息窗口 
                tipoption.title = cfg.title;//信息窗口标题 
                tipoption.content = cfg.html;//信息窗口内容
                areaopt.tipOption=tipoption;//设置面的信息窗口参数选项 
                areaopt.canShowTip = true;//设置面是否显示信息窗口 
            }
            if(cfg && cfg.label)
            {
                var labeloption=new MLabelOptions();//添加标注 
                labeloption.content= cfg.label;//标注的内容 
                labeloption.labelPosition=new MPoint(10,10); //设置标注左上角相对于面对象中心的锚点。标注左上角与面对象中心重合时，像素坐标原点(0,0) 
                areaopt.labelOption=labeloption;//设置面的标注选项参数 
            } 

            areaopt.areaStyle=areastyle;//设置面的风格 
            areaopt.isEditable = false;//设置面是否为可编辑状态，true，可编辑；false，不可编辑（默认） 

           
            var circle = new MCircle(lonlat.toMPoint(),radius,areaopt);//利用圆的中心点、圆半径及option选项来创建圆对象 
            circle.id = id;//对象编号，也是对象的唯一标识 
            map.addOverlay(circle,false);//向地图添加覆盖物 
            return id;
        };
        
        /**
         * 添加覆盖物，箭头多边形
         * cosA = (c^2 + b^2 - a^2) / (2*b*c)
         */
        this.dir = function(lonlat1, lonlat2, cfg, lpx, ids)
        {
            var wid = ids || "d_" + Math.random();
            var mdir = {id : wid, s : lonlat1, e : lonlat2, cfg : cfg};
            wayArray.push(mdir);
            // set direction length
            var l = lpx || (map.getScale() / 9000.0);
            // get start and end points
            var x0 = parseFloat(lonlat1.lon);
            var y0 = parseFloat(lonlat1.lat);
            var x1 = parseFloat(lonlat2.lon);
            var y1 = parseFloat(lonlat2.lat);
            
            if(x0 == x1 && y0 == y1)
            {
                return;
            }
            // get length between points
            var l0 = Math.sqrt(Math.pow(x0-x1,2) + Math.pow(y0-y1,2));
            var a = (x0 - x1)/l0,b = (y0 - y1)/l0,d = Math.PI * 1/12;
            // get two direction points at 20C
            var xx1 = x1 + l*(a*Math.cos(d) - b*Math.sin(d)); 
            var yy1 = y1 + l*(a*Math.sin(d) + b*Math.cos(d));
            var xx2 = x1 + l*(a*Math.cos(d) + b*Math.sin(d)); 
            var yy2 = y1 + l*(-a*Math.sin(d)+ b*Math.cos(d));
            // put points to arrays and draw direction polygon
            var dirLonlats = new Array();
            dirLonlats.push(new IMPoint(xx1,yy1));
            dirLonlats.push(lonlat2);
            dirLonlats.push(new IMPoint(xx2,yy2));
            
            var linestyle = new MLineStyle(); 
            linestyle.thickness = nvl(cfg.weight,defaultWeight);
            linestyle.color     = nvl(cfg.color,defaultColor);
            linestyle.lineType  = nvl(cfg.type,LINE_SOLID);
            linestyle.alpha     = nvl(cfg.opacity,defaultOpacity);
            
            var fillstyle = new MFillStyle();
            fillstyle.color = nvl(cfg.color,defaultColor); 
            fillstyle.alpha = 1;

            var areastyle = new MAreaStyle();
            areastyle.borderStyle = linestyle;
            areastyle.fillStyle   = fillstyle;
            
            var areaopt = new MAreaOptions(); 
            areaopt.canShowTip= false;
            areaopt.areaStyle = areastyle;
            var polygon = new MPolygon(conver(dirLonlats),areaopt);
            polygon.id  = wid ;
            map.addOverlay(polygon,false);
        };

        
        /*****************************************************************************************/
        /* 添加地图事件 */
        /**
         *  MOUSE_CLICK  点击事件
         *  MOUSE_OVER   鼠标移过事件
         *  ZOOM_END     缩放事件
         *  DRAG_END     拖拽事件
         */
        this.addObjListener = function(obj,event,callback,id)
        {
            map.addEventListener(obj, event, function(){
            	callback(null,id,obj)
            });
        };
        this.addListener = function(event,callback)
        {
        	 map.addEventListener(map, event,callback);
        };
        this.addClickListener = function(callback)
        {
            this.addListener(MOUSE_CLICK, callback);
        };
        
        this.addMarkMouseoverListener = function(obj, callback)
		{
			if(obj){
			   var overlay = map.getOverlayById(obj)
			}
			this.addObjListener(overlay,MOUSE_OVER,callback,obj);
		};
		this.addMarkMouseoutListener = function(obj, callback)
		{
			if(obj){
			   var overlay = map.getOverlayById(obj)
			}
			this.addObjListener(overlay,MOUSE_OUT, callback,obj);
		};
		
        this.removeObjListener = function(obj, event, callback)
        {
            this.removeEventListener(obj, event, callback);
        };
        this.removeListener = function(event,callback)
        {
            this.removeObjListener(map,event,callback);
        };
        
        /* 添加地图事件 */
        /**
         *  MOUSE_CLICK  点击事件
         *  MOUSE_OVER   鼠标移过事件
         *  ZOOM_END     缩放事件
         *  DRAG_END     拖拽事件
         */
        
        this.mapZoom = function(callback)
        {
            this.mapEvent(ZOOM_END, callback);
        };
        
        this.removeEvent = function(obj, event, callback)
        {
            map.removeEventListener(obj, event, callback);
        }
        this.removeMapEvent = function(event,callback)
        {
            this.removeEvent(map,event,callback);
        };
        this.removeMapZoom = function(callback)
        {
            this.removeMapEvent(ZOOM_END, callback);
        };
        
        /*****************************************************************************************/
        /* 设置属性 */
        //  移动地图到指定的中点
		this.setClickToCenter = function(flag)
		{
			//map.clickToCenter=flag;
		};
		//  设置窗口大小
		this.resize = function(width,height)
		{
		};
		
	   //  设置地图覆盖物显示or隐藏
		this.setLabelVisiable = function(id, flag, cfg)
        {
        	if(cfg){
	        	var id = nvl(cfg.id,id);
	        	var content = cfg.content;
	        	var lon = cfg.lon;
	        	var lat = cfg.lat;
        	}
        	if(flag){
	            if(isNotNull(content)) 
	            {
	        		var labelOption = this.label(content);
	                var mLabel = new MLabel(new IMPoint(lon,lat).toMap(),labelOption);
	                mLabel.id = "label_" + id;
	                map.addOverlay(mLabel,false); 
	
	            }
        	}else{
        		this.remove("label_" + id);
        	}
        };
        // 获取地图上点的图片路径
		this.getPath = function(id)
        {
        	if(id){
		        return $('img',$('#'+id)).attr('src');
        	}
        };
        
        // 修改地图上点的图片路径
		this.updateImage = function(id,path)
        {
        	if(id){
		        $('img',$('#'+id)).attr('src',path);
        	}
        };
        
       // 移除面
		this.removeOverlayMark = function(ellipse,id)
		{
			this.remove(id);
		};
    }
})();