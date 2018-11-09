var data=new Array();


    $(gen_btn).click(function(){
    	data=JSON.parse(localStorage.getItem("storeddata"));
        JSONToCSVConvertor(data, "Submitted Details");   
    });

function JSONToCSVConvertor(JSONData, ReportTitle) {
    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;
    
    var CSV = '';    
    
    CSV += ReportTitle + '\r\n\n';

    
        var row = "";
        
        for (var index in arrData[0]) {
            
            row += index + ',';
        }

        row = row.slice(0, -1);
        
        CSV += row + '\r\n';
    
    if(arrData.length>0){
    for (var i = 0; i < arrData.length; i++) {
        var row = "";
        
        for (var index in arrData[i]) {
            row += '"' + arrData[i][index] + '",';
        }

        row.slice(0, row.length - 1);
        
        CSV += row + '\r\n';
    }

    if (CSV == '') {        
        alert("Invalid data");
        return;
    }   
    
    var fileName = ReportTitle.replace(/ /g,"_");   
    
    var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);

    var link = document.createElement("a");    
    link.href = uri;
    
    link.style = "visibility:hidden";
    link.download = fileName + ".csv";
    
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
    }
    else{
        $("#dwntxt").css("color","red");
        $("#dwntxt").html("No Data found to download!!");
    }
}