/**
 * 
 */

var X=44.0250118122;
var Y=11.0250118122;
var mymap ;
var mymapR ;
var mymapI ;
var http, httpMpIds, httpI ;
var M1;
var M2;

var map = null;
var flowsLayer = null;
var countriesLayer = null;
//47.497090,19.033940
//7.0183488294 51.0250118122


//location.reload(false);
X=0.0000000;
Y=0.000000;

window.onbeforeunload = function() {
      console.log('onbeforeunload');
      document.getElementById("myBtn").disabled = false; 
      document.getElementById("myBtn").style.visibility = "visible"; 
      document.getElementById("myBtnI").disabled = false;
      document.getElementById("myBtnI").style.visibility = "visible"; 
      document.getElementById("myBtnX").disabled = false;
      document.getElementById("myBtnX").style.visibility = "visible"; 
     return "Dude, are you sure you want to refresh? Think of the kittens!";
    
}



var myObj=null;
var myObjR=null;

window.onload =  function(){
	
	//mapdr(Y, X);
	
	var node;
	var JSONM;
	var len;
	http =  new XMLHttpRequest();
	httpI =  new XMLHttpRequest();
	httpMpIds = new XMLHttpRequest();
	console.log('onload');
	document.getElementById("myBtn").disabled = true; 	
	document.getElementById("myBtn").style.visibchnrility = "hidden"; 
	document.getElementById("myBtnI").disabled = true; 	
	document.getElementById("myBtnI").style.visibchnrility = "hidden";
	document.getElementById("myBtnX").disabled = true; 	
	document.getElementById("myBtnX").style.visibchnrility = "hidden";  	


	console.log('myBtn  visibility hidden ');
	console.log('myBtnI  visibility hidden ');	
	console.log('myBtnX  visibility hidden ');		
	
	http.onreadystatechange  =  function( ){
		if (http.readyState == 4 && http.status == 200){
		     console.log( "http.response=>" + http.response);		
		//document.getElementById("resp").innerHTML = http.response;//.setSingleNode("//addxReturn").Text;
		     node = document.createElement("LI");
		     JSONL =http.response;

		    
		//myObjR =  JSON.parse(http.response);	
		JB= JSON.parse(JSONL);
		myObj =  JB[0];
		myObjR = JB[1];
			
		console.log("JSONL =>" + JSONL );
		console.log("myObj.length =>" + myObj.length );	
		console.log("myObjR.length =>" + myObjR.length );	
		     
			//document.getElementById("get").innerHTML = http.response;	
			//document.getElementById("resp").innerHTML = myObj[1];
		len  = myObj.length;
		lenR  = myObjR.length;
   
 	     	console.log('len='+len);
 	     	console.log('!!!!!!!!!!!!!MAPDR!!!!!!!!!!!!!!!!!!'+http);
 	     	
 	     	
 	     	//mapdr(myObj,myObjR,len,lenR,"mapid","mapidR","mapidI");
		mapdr(myObj,myObjR,null,len,lenR,0,"mapid","mapidI");
 	      ///mapdr(myObjR,myObjR,lenR,lenR,"mapidR");
 	     	
		}
                if (http.readyState == 4 ){
		   console.log('myBtn  enabled');
		   document.getElementById("myBtn").disabled = false;
		   console.log('myBtnI  enabled');
		   document.getElementById("myBtnI").disabled = false;
		   console.log('myBtnX  enabled');
		   document.getElementById("myBtnX").disabled = false;
		  
		    																																							
                }
		console.log('http+++++++http.readyState'+http.readyState);																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
			
	}


	httpI.onreadystatechange  =  function( ){
		if (httpI.readyState == 4 && httpI.status == 200){
		     console.log( "httpI.response=>" + httpI.response);		
		//document.getElementById("resp").innerHTML = httpI.response;//.setSingleNode("//addxReturn").Text;
		node = document.createElement("LI");
		JSONI =httpI.response;

		    
		//myObjR =  JSON.parse(httpI.response);	
		JB= JSON.parse(JSONI);
		myObj =  JB[0];
		myObjR = JB[1];
		myObjI = JB[2];		
		console.log("JSONI =>" + JSONI );
		var len  = myObj.length;
		var lenR  = myObjR.length;
   		var lenI  = myObjI.length;

		console.log("myObj.length =>" + myObj.length );	
		console.log("myObjR.length =>" + myObjR.length );			
		console.log("myObjI.length =>" + myObjI.length );	
		     
		//document.getElementById("get").innerHTML = httpI.response;	
		//document.getElementById("resp").innerHTML = myObj[1];

		console.log('httpI.readyState:' +httpI.readyState);
		
 	     	console.log('len='+len);
 	     	console.log('!!!!!!!!!!!!!MAPDR!!!!!!!!!!!!!!!!!!'+httpI);
 	     	
 	     	
 	     	mapdr(myObj,myObjR,myObjI,len,lenR,lenI,"mapid","mapidI");
 	      ///mapdr(myObjR,myObjR,lenR,lenR,"mapidR");
 	     	
		}
                if (httpI.readyState == 4 ){
		   console.log('myBtn  enabled');
		   document.getElementById("myBtn").disabled = false;
		   console.log('myBtnI  enabled');
		   document.getElementById("myBtnI").disabled = false;
		   console.log('myBtnX  enabled');
		   document.getElementById("myBtnX").disabled = false;
		  
		    																																							
                }
		console.log('httpI+++++++httpI.readyState'+httpI.readyState);																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
			
	}




	httpMpIds.onreadystatechange  =  function( ){
		select = document.getElementById('chnr');

		selectr = document.getElementById('chnrr');
		console.log('httpMpIds readyState_>' +    httpMpIds.readyState);

		if (httpMpIds.readyState == 4 && httpMpIds.status == 200){
			console.log('httpMpIds readyState  == 4 httpMpIds.status'  +    httpMpIds.status);			
		//	document.getElementById("resp").innerHTML = http.response;//.setSingleNode("//addxReturn").Text;
			 node = document.createElement("LI");
			 JSONM =httpMpIds.response;
		     myObj= JSON.parse(httpMpIds.response);
		     console.log("myObj =>" + myObj +  "httpMpIds.response=>" + httpMpIds.response);
		     
			//document.getElementById("get").innerHTML = httpMpIds.response;	
			//document.getElementById("resp").innerHTML = myObj[1];
		     len  = 0;
 	     	 for (i in  myObj) {
 	     		console.log(i);
 	     		console.log(myObj[i]);
 	     		len++;
	 	     	///if (i==0) {
 	     		    /* var textnode = document.createTextNode(myObj[i].X + " " + myObj[i].Y );
	 	     	    node.appendChild(textnode);
	 	     	    document.getElementById("resp").appendChild(node);
	 	     	    //no list  
	 	     	    */
	 	     	   MP_ID=  myObj[i]*1.00000;
			   var opt = document.createElement('option'); 
	 	     	   opt.value = MP_ID;
    	    	           opt.innerHTML = MP_ID;
	    	 	   select.appendChild(opt);
	    	 	   
			   var opt = document.createElement('option'); 
	 	     	   opt.value = MP_ID;
    	    	           opt.innerHTML = MP_ID;
	    	 	   selectr.appendChild(opt);	
	 	     	   console.log('MP_ID=' +  MP_ID);
	 	     	  
 	     		///}
		 } 
 	     	 console.log('len='+len);
 	     	 console.log('!!!!!!!!!!!!!MAPDR!!!!!!!!!!!!!!!!!!'+httpMpIds);
 	     	
		 if (httpMpIds.readyState == 4){
		   console.log('buttons  enabled');
		   document.getElementById("myBtn").disabled = false; 
		   document.getElementById("myBtn").style.visibility = "visible"; 
		   document.getElementById("myBtnI").disabled = false; 
		   document.getElementById("myBtnI").style.visibility = "visible"; 
		   document.getElementById("myBtnX").disabled = false; 
		   document.getElementById("myBtnX").style.visibility = "visible"; 

		 
                 }
 	     	
		}
		 
		console.log('httpMpIds+++++++http.readyState'+http.readyState);
			
	}




	document.getElementById("myBtn").addEventListener("click", function(){
		var chnr = document.getElementById("chnr").value;
		var chnrr = document.getElementById("chnrr").value;
		var data = 'chnr='+chnr + '&' + "chnrr=" + chnrr;
		//mapdr(myObj,0,Botton);
		myObj=null;	
		sendHttp(data);
		document.getElementById("myBtn").disabled = true; 
		console.log('send '+data);
		
	});

	document.getElementById("myBtnI").addEventListener("click", function(){
		var chnr = document.getElementById("chnr").value;
		var chnrr = document.getElementById("chnrr").value;
		var data = 'chnr='+chnr + '&' + "chnrr=" + chnrr;
		//mapdr(myObj,0,Botton);
		myObj=null;	
		sendHttpI(data);
		document.getElementById("myBtnI").disabled = true; 
		console.log('send '+data);
		
	});

        sendHttpMpIds();
	
	
};

/*
setTimeout(function() {
  map.setView([51.514613, -0.081019], 17, {headingDegrees: 204.374, tiltDegrees:15.0});
}, 10000);
*/

function mapdr(myObj , myObjR, myObjI,len, lenR,lenI, mapid,/*mapidR,*/mapidI) {
	
	var X=0.000;
	var Y=0.000;
	var ListXY=[];
        ///var myObj=myObj1[0];
	for (i in  myObj) {
		ListXY.push(myObj[i].X*1.00000,myObj[i].Y*1.00000); 
		
	}
	console.log('myObj =' +  myObj);	
	console.log('myObj len=' + len );
    
	var argvX=0.00000;
	var argvY=0.00000;
	var count=0.00000;
	
	for (i in  myObj) {
  		console.log(i);
  		console.log("------X:" + myObj[i].X*1.00000);
  		  		console.log("------Y	:" + myObj[i].Y*1.00000);
	     	///if (i==0) {
	     		X=  myObj[i].X*1.00000;
 	     	    	Y=  myObj[i].Y*1.00000;
			argvX=argvX*1.00000 + X ;
			argvY=argvY*1.00000 + Y;
			count=count*1.0000 + 1.00000;
	     	///}
	}
	if (count > 0.00000){
	 	argvX =argvX/(count*1.00000);
		argvY =argvY/(count*1.00000);

	}
 	if (  count == 0.00000){
		argvX=X;
		argvY=Y;
	}
	//argvX=X;
	//argvY=Y;
	console.log('Average  argvX=' +  argvX + ' Average argvY=' +argvY + ' count:' + count);
	
	RemoveExistingMap(mymap);
	mymap = L.map(mapid).setView([argvY, argvX], 15);

	L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
		maxZoom: 18,
		attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
			'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
			'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
		id: 'mapbox.streets'
	}).addTo(mymap);

	L.marker([ argvY *1.00000 , argvX*1.00000 ]).addTo(mymap)
		;//.bindPopup("<b>Hello world!</b><br />I am a popup.").openPopup();

	L.circle([ argvY , argvX  ], 20, {
		color: 'red',
		fillColor: '#f03',
		fillOpacity: 0.5
	}).addTo(mymap).bindPopup("I am a circle.");

	
	if (len > 0) {
	
	    var latlngs=[];
		
		for (i in  myObj) {
			var xy =[myObj[i].Y*1.00000, myObj[i].X*1.00000];
			//xy.push(xy);
			latlngs.push(xy);
		}
		
		//latlngs.push(']');
		console.log('' + latlngs);
		/*console.log("1..." +myObj[0].X*1.00000 + " " + myObj[0].Y*1.00000 );
		console.log("2..." +myObj[1].X*1.00000 + " " + myObj[1].Y*1.00000 );
		console.log("3..." +myObj[2].X*1.00000 + " " + myObj[2].Y*1.00000 );
		console.log("4..." +myObj[3].X*1.00000 + " " + myObj[3].Y*1.00000 );*/
		L.polygon(
		      latlngs
		      ,{color: 'green',fillColor: '#44ff55',
		  		fillOpacity: 0.05}
		).addTo(mymap).bindPopup("I am a polygon.");
		/////L.marker([ myObj[0].X*1.00000 , myObj[0].Y*1.00000 ]).addTo(mymap);
	}

	//////var popup = L.popup();




/////second map ob the left together with yhe first
	var XR=0.000;
	var YR=0.000;
	var ListXYR=[];
        ///var myObj=myObj1[0];
	for (i in  myObjR) {
		ListXYR.push(myObjR[i].X*1.00000,myObjR[i].Y*1.00000); 
		
	}
	console.log('myObjR =' +  myObjR);	
	console.log('myObjR lenR=' + lenR );
    
	var argvXR=0.00000;
	var argvYR=0.00000;
	var countR=0.00000;

	for (i in  myObjR) {
  		console.log(i);
  		console.log("------XR:" + myObjR[i].X*1.00000);
  		console.log("------YR	:" + myObjR[i].Y*1.00000);
	     	///if (i==0) {
	     		XR=  myObjR[i].X*1.00000;
 	     	    	YR=  myObjR[i].Y*1.00000;
			argvXR=argvXR*1.00000 + XR ;
			argvYR=argvYR*1.00000 + YR;
			countR=countR*1.0000 + 1.00000;
	     	///}
	}
	if (countR > 0.00000){
	 	argvXR =argvXR/(countR*1.00000);
		argvYR =argvYR/(countR*1.00000);

	}
 	if (  countR == 0.00000){
		argvXR=XR;
		argvYR=YR;
	}
	//argvX=X;
	//argvY=Y;
	console.log('Average  argvXR=' +  argvXR + ' Average argvYR=' +argvYR + ' count:' + countR);
	
	////////RemoveExistingMap(mymapR);
	//////mymapR = L.map(mapid).setView([argvYR, argvXR], 13);

	L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
		maxZoom: 18,
		attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
			'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
			'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
		id: 'mapbox.streets'
	}).addTo(mymap);

	L.marker([ argvYR *1.00000 , argvXR*1.00000 ]).addTo(mymap)
		;//.bindPopup("<b>Hello world!</b><br />I am a popup.").openPopup();


	L.circle([ argvYR , argvXR  ], 20, {
		color: 'red',
		fillColor: '#f03',
		fillOpacity: 0.5
	}).addTo(mymap).bindPopup("I am a circle.");

	
	if (lenR > 0) {
	
	    var latlngsR=[];
		
		for (i in  myObjR) {
			var xy =[myObjR[i].Y*1.00000, myObjR[i].X*1.00000];
			//xy.push(xy);
			latlngsR.push(xy);
		}
		
		//latlngs.push(']');
		console.log('' + latlngsR);
		console.log("1..." +myObjR[0].XR*1.00000 + " " + myObjR[0].Y*1.00000 );

		/*console.log("2..." +myObj[1].XR*1.00000 + " " + myObjR[1].Y*1.00000 );
		console.log("3..." +myObj[2].XR*1.00000 + " " + myObjR[2].Y*1.00000 );
		console.log("4..." +myObj[3].XR*1.00000 + " " + myObjR[3].Y*1.00000 );*/
		L.polygon(
		      latlngsR
		      ,{color: 'blue',fillColor: '#4455ff	',
		  		fillOpacity: 0.05}
		).addTo(mymap).bindPopup("I am a polygon.");
		/////L.marker([ myObj[0].X*1.00000 , myObj[0].Y*1.00000 ]).addTo(mymapR);
	}

	///////var popup = L.popup();


/////theard map I right
	console.log('part 3 start ');
        if (myObjI == null ||myObjI.length == 0  ){
		//if ( mymapI !== 'undefined' )
		 //  RemoveExistingMap(mymapI);
		////mymapI = L.map(mapidI).setView([argvYI, argvXI], 13);
		return;
	}
	
	console.log('part 3 -> myObjI =' +  myObjI +  ' myObjI.length= ' +  myObjI.length);
	var XI=0.000;
	var YI=0.000;
	var countI=0.00000;
	var ListXYI=[];

	for (i in  myObjI) {
		ListXYI.push(myObjI[i].X*1.00000,myObjI[i].Y*1.00000); 
		
	}
	console.log('myObjI =' +  myObjI);	
	console.log('myObjI lenI=' + lenI );
    
	var argvXI=0.00000;
	var argvYI=0.00000;
	var countI=0.00000;

	for (i in  myObjI) {
  		console.log(i);
  		console.log("------XI:" + myObjI[i].X*1.00000);
  		console.log("------YI:" + myObjI[i].Y*1.00000);
	     	///if (i==0) {
	     		XI=  myObjI[i].X*1.00000;
 	     	    	YI=  myObjI[i].Y*1.00000;
			argvXI=argvXI*1.00000 + XI ;
			argvYI=argvYI*1.00000 + YI;
			countI=countI*1.0000 + 1.00000;
	     	///}
	}
	if (countI > 0.00000){
	 	argvXI =argvXI/(countI*1.00000);
		argvYI =argvYI/(countI*1.00000);

	}
 	if (  countI == 0.00000){
		argvXI=XI;
		argvYI=YI;
	}
	//argvX=X;
	//argvY=Y;
	console.log('Average  argvXI=' +  argvXI+ ' Average argvYR=' +argvYI + ' count:' + countI);
	
	RemoveExistingMap(mymapI);
 	mymapI = L.map(mapidI).setView([argvYI, argvXI], 15);


	///var mymapI = L.eeGeo.map('mapidI', 'sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA==', {center: [51.517327, -0.120005],  zoom: 15 });


	/////mymapI = L.map(mapidI).setView([argvYI, argvXI],17,{headingDegrees: 204.374, tiltDegrees:15.0});}, 10000);
	


	L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
		maxZoom: 18,
		attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
			'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
			'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
		id: 'mapbox.streets'
	}).addTo(mymapI);

	console.log('argvYI => '  + argvYI + ' argvXR => ' +   argvXI + ' argvYR => ' + argvYR +  ' argvXR=> ' + argvXR );
   
/*
	L.marker([ argvYI *1.00000 , argvXI*1.00000 ]).addTo(mymapI)

*/
		;//.bindPopup("<b>Hello world!</b><br />I am a popup.").openPopup();

/*
	L.circle([ argvYI , argvXI  ], 20, {
		color: 'red',
		fillColor: '#f03',
		fillOpacity: 0.5

	}).addTo(mymapI).bindPopup("I am a circle.");

	console.log('myObjI.length->' +myObjI.length + ' lenI=>'+ lenI);
*/
		
        //search polygons 
	var mapFromTo = new Map();
	for (i=0; i <  myObjI.length; i++){
	   for (j=i+1; j <  myObjI.length; j++){
		if (myObjI[i].X ==  myObjI[j].X  &&  myObjI[i].Y ==  myObjI[j].Y){
			mapFromTo.set(i,j);
		}	
	   }
	}
	
	var mapFromToRest = new Map();
	for (  i=0; i <  myObjI.length; i++){
		var found = false;
		for (let pair  of mapFromTo) {
			if (i >=  pair[0] && i <= pair[1] ){
				found = true;
			}
				
		}

		if ( found ==  false){
			mapFromToRest.set(i,i);
		}

	}
	
	//conctenate rest 
	mapFromToRest.forEach(function(value, key){
		mapFromTo.set(key,value);	
	});
	console.log('mapFromToRest->' +mapFromToRest + ' lenI'+ lenI);
	console.log('mapFromTo->' +mapFromTo + ' mapFromTo.size=>'+ mapFromTo.size);

	if (myObjI.length == 2){
		myObjI[2]=myObjI[0];
		mapFromTo.clear();
		mapFromTo.set(0,2);
		
	}
	
	if (lenI > 0) {
		for (let pair  of mapFromTo) {	
		    var latlngsI=[];
			console.log(" pair[0] => " + pair[0] +  " pair[1] => " + pair[1]);
			for (i=pair[0]; i<=pair[1]; i++) {
				var xy =[myObjI[i].Y*1.00000, myObjI[i].X*1.00000];
				//xy.push(xy);
				console.log('xy=>' +xy);
				latlngsI.push(xy);
			}
			/*
			for (i in  myObjR) {
				var xy =[myObjR[i].Y*1.00000, myObjR[i].X*1.00000];
				//xy.push(xy);
				latlngsI.push(xy);
			}
			*/
			//latlngs.push(']');
			console.log('latlngsI' + latlngsI);
			console.log("1..." +myObjI[0].X*1.00000 + " " + myObjI[0].Y*1.00000 );
			var xy =  latlngsI[0];
			L.marker([ xy[0] *1.00000 , xy[1]*1.00000 ]).addTo(mymapI);
			
			L.polygon(
			      latlngsI
			      ,{color: 'red',fillColor: '#ff5533',
			  		fillOpacity: 0.3}
			).addTo(mymapI).bindPopup("I am a polygon.");
			/////L.marker([ myObj[0].X*1.00000 , myObj[0].Y*1.00000 ]).addTo(mymapI);
		}
	}

	var popup = L.popup();
}




function sendHttp(val){
	//M1= document.getElementById('M1').value;
	//M2= document.getElementById('M2').value;
	var msend="";
	
	http.open("POST","/websdo_geo/geo",true);
	//http.open("POST","/SoapDemo/services/DemoClass",true);
	///http.setRequestHeader("Content-Type", "text/html; charset=utf-8");
	//"application/json;charset=UTF-8"
	/////http.setRequestHeader("Content-Type","application/json;charset=UTF-8");
	http.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	//http.setRequestHeader("SOAPAction", "/websdo_geo/geo");
	//http.setRequestHeader("Access-Control-Allow-Origin","*");
	http.send(val);	
	console.log('sendHttp end!!!!!!');
	console.log('2.   sendHttp end!!!!!!');
}

function sendHttpI(val){
	//M1= document.getElementById('M1').value;
	//M2= document.getElementById('M2').value;
	var msend="";
	
	httpI.open("POST","/websdo_geo/inter",true);
	//httpI.open("POST","/SoapDemo/services/DemoClass",true);
	///httpI.setRequestHeader("Content-Type", "text/html; charset=utf-8");
	//"application/json;charset=UTF-8"
	/////httpI.setRequestHeader("Content-Type","application/json;charset=UTF-8");
	httpI.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	//httpI.setRequestHeader("SOAPAction", "/websdo_geo/geo");
	//httpI.setRequestHeader("Access-Control-Allow-Origin","*");
	httpI.send(val);	
	console.log('sendHttp end!!!!!!');
	console.log('2.   sendHttp end!!!!!!');
}



function sendHttpMpIds(){
	//M1= document.getElementById('M1').value;
	//M2= document.getElementById('M2').value;
	var msend="";
	document.getElementById("myBtn").disabled = true;
	document.getElementById("myBtn").style.visibility = "hidden"; 
	document.getElementById("myBtnI").disabled = true;
	document.getElementById("myBtnI").style.visibility = "hidden"; 
	document.getElementById("myBtnX").disabled = true;
	document.getElementById("myBtnX").style.visibility = "hidden"; 	

	httpMpIds.open("POST","/websdo_geo/mpid",true);
       
	//httpMpIds.open("POST","/SoapDemo/services/DemoClass",true);
	///httpMpIds.setRequestHeader("Content-Type", "text/html; charset=utf-8");
	//"application/json;charset=UTF-8"
	/////httpMpIds.setRequestHeader("Content-Type","application/json;charset=UTF-8");
	httpMpIds.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	//httpMpIds.setRequestHeader("SOAPAction", "/websdo_geo/geo2");
	//httpMpIds.setRequestHeader("Access-Control-Allow-Origin","*");
	httpMpIds.send();	
	console.log('sendHttpMpIds end');
}




function RemoveExistingMap(map) {
    if (map != null) {
        map.remove();
        map = null;
    }
}



